package payload;

import entity.Genre;

import java.io.Serializable;
import java.time.LocalDate;

public class BookDTO implements Serializable {
    private  Integer bookID_DTO;
    private  String bookName_DTO;
    private  String bookAuthor_DTO;
    private LocalDate bookWrittenDate_DTO;
    private  String bookFilePath_DTO;
    private Integer bookPageCount_DTO;
    private Genre bookGenre_DTO;

    public BookDTO(Integer bookID_DTO, String bookName_DTO, String bookAuthor_DTO, LocalDate bookWrittenDate_DTO, String bookFilePath_DTO, Integer bookPageCount_DTO, Genre bookGenre_DTO) {
        this.bookID_DTO = bookID_DTO;
        this.bookName_DTO = bookName_DTO;
        this.bookAuthor_DTO = bookAuthor_DTO;
        this.bookWrittenDate_DTO = bookWrittenDate_DTO;
        this.bookFilePath_DTO = bookFilePath_DTO;
        this.bookPageCount_DTO = bookPageCount_DTO;
        this.bookGenre_DTO = bookGenre_DTO;
    }

    public Integer getBookID_DTO() {
        return bookID_DTO;
    }

    public void setBookID_DTO(Integer bookID_DTO) {
        this.bookID_DTO = bookID_DTO;
    }

    public String getBookName_DTO() {
        return bookName_DTO;
    }

    public void setBookName_DTO(String bookName_DTO) {
        this.bookName_DTO = bookName_DTO;
    }

    public String getBookAuthor_DTO() {
        return bookAuthor_DTO;
    }

    public void setBookAuthor_DTO(String bookAuthor_DTO) {
        this.bookAuthor_DTO = bookAuthor_DTO;
    }

    public LocalDate getBookWrittenDate_DTO() {
        return bookWrittenDate_DTO;
    }

    public void setBookWrittenDate_DTO(LocalDate bookWrittenDate_DTO) {
        this.bookWrittenDate_DTO = bookWrittenDate_DTO;
    }

    public String getBookFilePath_DTO() {
        return bookFilePath_DTO;
    }

    public void setBookFilePath_DTO(String bookFilePath_DTO) {
        this.bookFilePath_DTO = bookFilePath_DTO;
    }

    public Integer getBookPageCount_DTO() {
        return bookPageCount_DTO;
    }

    public void setBookPageCount_DTO(Integer bookPageCount_DTO) {
        this.bookPageCount_DTO = bookPageCount_DTO;
    }

    public Genre getBookGenre_DTO() {
        return bookGenre_DTO;
    }

    public void setBookGenre_DTO(Genre bookGenre_DTO) {
        this.bookGenre_DTO = bookGenre_DTO;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID_DTO +
                ", bookName='" + bookName_DTO + '\'' +
                ", bookAuthor='" + bookAuthor_DTO + '\'' +
                ", bookWrittenDate=" + bookWrittenDate_DTO +
                ", bookFilePath='" + bookFilePath_DTO + '\'' +
                ", bookPageCount=" + bookPageCount_DTO +
                ", bookGenre=" + bookGenre_DTO +
                '}';
    }
}
