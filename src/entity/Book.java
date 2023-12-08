package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private  Integer bookID;
    private  String bookName;
    private  String bookAuthor;
    private LocalDate bookWrittenDate;
    private  String bookFilePath;
    private Integer bookPageCount;
    private  Genre bookGenre;

    public Book(Integer bookID, String bookName, String bookAuthor, LocalDate bookWrittenDate, String bookFilePath, Integer bookPageCount, Genre bookGenre) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookWrittenDate = bookWrittenDate;
        this.bookFilePath = bookFilePath;
        this.bookPageCount = bookPageCount;
        this.bookGenre = bookGenre;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public LocalDate getBookWrittenDate() {
        return bookWrittenDate;
    }

    public void setBookWrittenDate(LocalDate bookWrittenDate) {
        this.bookWrittenDate = bookWrittenDate;
    }

    public String getBookFilePath() {
        return bookFilePath;
    }

    public void setBookFilePath(String bookFilePath) {
        this.bookFilePath = bookFilePath;
    }

    public Integer getBookPageCount() {
        return bookPageCount;
    }

    public void setBookPageCount(Integer bookPageCount) {
        this.bookPageCount = bookPageCount;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookWrittenDate=" + bookWrittenDate +
                ", bookFilePath='" + bookFilePath + '\'' +
                ", bookPageCount=" + bookPageCount +
                ", bookGenre=" + bookGenre +
                '}';
    }
}
