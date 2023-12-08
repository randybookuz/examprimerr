package service;

import payload.GenreDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.*;

public class GenreServiceImpl implements GenreService{
    private  static Lock lock=new ReentrantLock();
    private Logger logger;
    private  GenreServiceImpl(){
        logger=Logger.getLogger("loggerGenre");
        try {
            Handler handler=new FileHandler("ttt.txt",true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private  static  GenreServiceImpl instance;

    public static GenreServiceImpl getInstance() {
       if(instance==null){
           lock.lock();
           if (instance==null)instance=new GenreServiceImpl();
           lock.unlock();
       }return  instance;
    }
List<GenreDTO>list= Collections.synchronizedList(new ArrayList<>());
    @Override
    public List<GenreDTO> genreShowAll() {
        logger.log(Level.INFO,"genreShowAll ishladi");
        return list;
    }

    @Override
    public GenreDTO genreAdd(GenreDTO genreDTO) {
        logger.log(Level.INFO,"genreAdd ishladi");
       genreDTO.setGenreID_DTO(list.size()+1);
       list.add(genreDTO);
       return genreDTO;
    }

    @Override
    public GenreDTO genreEdite(Integer genreID, GenreDTO genreDTO) {
        logger.log(Level.INFO,"genreEdite ishladi");
        GenreDTO genreNew=genreFind(genreID);
        genreNew.setGenreName_DTO(genreDTO.getGenreName_DTO());
        return genreNew;
    }

    @Override
    public boolean genreDelete(Integer genreID) {
        logger.log(Level.INFO,"genreDelete ishladi");
        return list.remove(genreFind(genreID));
    }

    @Override
    public GenreDTO genreFind(Integer genreID) {
       return  list.stream()
               .filter(s->s.getGenreID_DTO().equals(genreID))
               .findFirst()
               .orElseThrow();
    }
}
