package cinema_cw;

import cinema_cw.constant.HallSize;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FilmSchedule {
    private Long id;
    private Long id_film;
    private HallSize hallSize;
    private Integer price;
    private LocalDate date;
    private List<LocalTime> time;
    private String format;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public HallSize getHallSize() {
        return hallSize;
    }

    public void setHallSize(HallSize hallSize) {
        this.hallSize = hallSize;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<LocalTime> getTime() {
        return time;
    }

    public void setTime(List<LocalTime> time) {
        this.time = time;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
