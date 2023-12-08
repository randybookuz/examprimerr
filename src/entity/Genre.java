package entity;

import java.io.Serializable;

public class Genre implements Serializable {
    private Integer genreID;
    private  String genreName;

    public Genre(Integer genreID, String genreName) {
        this.genreID = genreID;
        this.genreName = genreName;
    }

    public Integer getGenreID() {
        return genreID;
    }

    public void setGenreID(Integer genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
