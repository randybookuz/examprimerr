package service;

import payload.BookDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.*;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService{

    //1) Kiruvchi parameter sifatida kitob janri id si kelsa shu janrga tegishli kitoblarni
//ko’rsatuvchi method yozilsin.
//2) Kiruvchi parameter sifatida kitob id si berilsa shu id li kitob qaytarilsin
//3) Yangi kitob qo’shish uchun method yozilsin (yangi kitob qo’shilayotgan paytda
//race condition yuzaga kelmasligi uchun kitoblar turgan list sinxron qilinsin)
//4) Id va kitob haqida ma’lumotlar berilsa berilgan id li kitobni o’zgartiruvchi method
//yozilsin
//5) Id berilsa shu id li kitobni o’chiruvchi method yozilsin
//6) Id berilsa shu id li kitobni filedan o’qib text ko’rinishida qaytaruvchi method
//yozilsin
//7) Shunday bir method bo’lsinki shu method chaqirilganda listda yig’ilib turgan
//barcha kitoblarni serialize qilib file ga yozib qo’ysin
//8) Dastur yonganda kitoblar ro’yxatini avval yozilgan fayldan o’qisin (7-topshiriqda
//yozilgan joydan)
//9) Barcha methodlarga kirishda faylga log yozilsin
//10) Dastur gitlabga yuklansin

  private static Lock lock=new ReentrantLock();
  private Logger logger;
  private BookServiceImpl(){
      logger=Logger.getLogger("logger ");
      try {
          Handler handler=new FileHandler("ttt.txt",true);
          handler.setFormatter(new SimpleFormatter());
          logger.addHandler(handler);
      }catch (Exception e){
         throw  new RuntimeException(e);
      }
  }

  private  static  BookServiceImpl instance;

    public static BookServiceImpl getInstance() {
        if (instance==null){
            lock.lock();
            if(instance==null)instance=new BookServiceImpl();
            lock.unlock();
        }return instance;
    }
List<BookDTO>list= Collections.synchronizedList(new ArrayList<>());
    @Override
    public List<BookDTO> getListByGenre(Integer genreId) {
        logger.log(Level.INFO,"getListByGenre ishladi");
       return list.stream()
                .filter(s->s.getBookGenre_DTO().getGenreID().equals(genreId))
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO getBookByID(Integer bookID) {
        logger.log(Level.INFO,"getBookByID ishladi");
        return findBookOrThrow(bookID);
    }

    @Override
    public boolean addBook(BookDTO bookDTO) {
        logger.log(Level.INFO,"addBook ishladi");
        bookDTO.setBookID_DTO(list.size()+1);
        list.add(bookDTO);
        return true;
    }

    @Override
    public BookDTO editeBook(Integer bookID, BookDTO bookDTO) {
        logger.log(Level.INFO,"editeBook ishladi");
       BookDTO bookNew=findBookOrThrow(bookID);
       bookNew.setBookName_DTO(bookDTO.getBookName_DTO());
       bookNew.setBookAuthor_DTO(bookDTO.getBookAuthor_DTO());
       bookNew.setBookID_DTO(bookDTO.getBookID_DTO());
       bookNew.setBookGenre_DTO(bookDTO.getBookGenre_DTO());
       bookNew.setBookPageCount_DTO(bookDTO.getBookPageCount_DTO());
       bookNew.setBookFilePath_DTO(bookDTO.getBookFilePath_DTO());
       bookNew.setBookWrittenDate_DTO(bookDTO.getBookWrittenDate_DTO());
       return  bookDTO;
    }

    @Override
    public boolean delete(Integer bookID) {
        logger.log(Level.INFO,"delete ishladi");
    return   list.remove(findBookOrThrow(bookID));

    }

    @Override
    public String read(Integer bookID) {
        BookDTO book=findBookOrThrow(bookID);
        try (InputStream input =new FileInputStream(book.getBookFilePath_DTO())){
            logger.log(Level.INFO,"read ishladi");
            byte[]bytes=input.readAllBytes();
            return new String(bytes);
        }catch (Exception e){
            logger.log(Level.INFO,"read ishlamadi");
            throw  new RuntimeException(e);
        }

    }

    @Override
    public boolean serialize() {
        try (ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("tt.txt"))){
            output.writeObject(list);
            logger.log(Level.INFO,"serialize ishladi");
            return  true;
        }catch (Exception e){
            logger.log(Level.INFO,"serialize ishlamadi");
            throw  new RuntimeException(e);
        }

    }

    @Override
    public boolean deserialize() {
        try (ObjectInputStream input =new ObjectInputStream(new FileInputStream("tt.txt"))){
            list=(List<BookDTO>)input.readObject();
            logger.log(Level.INFO,"deserialize ishladi");
            return  true;
        }catch (Exception e){
            logger.log(Level.INFO,"deserialize ishlamadi");
            throw  new RuntimeException(e);
        }
    }
    private BookDTO findBookOrThrow(Integer bookID){
      return   list.stream()
                .filter(s->s.getBookID_DTO().equals(bookID))
                .findFirst()
                .orElseThrow();
    }
}
