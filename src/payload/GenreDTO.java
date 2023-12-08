package payload;

import java.io.Serializable;

public class GenreDTO implements Serializable {
    private Integer genreID_DTO;
    private  String genreName_DTO;

    public GenreDTO(Integer genreID_DTO, String genreName_DTO) {
        this.genreID_DTO = genreID_DTO;
        this.genreName_DTO = genreName_DTO;
    }

    public Integer getGenreID_DTO() {
        return genreID_DTO;
    }

    public void setGenreID_DTO(Integer genreID_DTO) {
        this.genreID_DTO = genreID_DTO;
    }

    public String getGenreName_DTO() {
        return genreName_DTO;
    }

    public void setGenreName_DTO(String genreName_DTO) {
        this.genreName_DTO = genreName_DTO;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID_DTO +
                ", genreName='" + genreName_DTO + '\'' +
                '}';
    }
}
