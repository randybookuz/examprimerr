import entity.Genre;
import payload.BookDTO;
import service.BookService;
import service.BookServiceImpl;
import service.GenreServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static BookServiceImpl bookService=BookServiceImpl.getInstance();
    private  static GenreServiceImpl genreService=GenreServiceImpl.getInstance();
    public static void main(String[] args) {
        //

        bookService.addBook(new BookDTO(1,
                "au",
                "gf",
                LocalDate.now(),
                "tt1.txt",
                65,
                new Genre(2,
                        "bb")));
        System.out.println( bookService.getBookByID(1));
        System.out.println("ooo");
        System.out.println(bookService.serialize());
        System.out.println("vv");
        System.out.println(bookService.deserialize());
    }


}
