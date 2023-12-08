package service;

import payload.GenreDTO;

import java.util.List;

public interface GenreService {
    List<GenreDTO>genreShowAll();
    GenreDTO genreAdd(GenreDTO genreDTO);
    GenreDTO genreEdite(Integer genreID,GenreDTO genreDTO);
    boolean genreDelete(Integer genreID);
    GenreDTO genreFind(Integer genreID);
}
