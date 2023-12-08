package service;

import payload.BookDTO;

import java.util.List;

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
public interface BookService {
List<BookDTO>getListByGenre(Integer genreId);

BookDTO getBookByID(Integer bookID);

boolean addBook(BookDTO bookDTO);

BookDTO editeBook(Integer bookID,BookDTO bookDTO);

boolean delete(Integer bookID);

String read(Integer bookID);

boolean serialize();

boolean deserialize();
}
