package cinema_cw;

import cinema_cw.constant.HallSize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Booking {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Long filmId;
    private HallSize hallSize;
    private Integer placeNumber;
    private LocalDateTime bookingDateTime;
    private String firstName;
    private String secondName;
    private String email;
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getFilmId() {
        return filmId;
    }

    public HallSize getHallSize() {
        return hallSize;
    }

    public void setHallSize(HallSize hallSize) {
        this.hallSize = hallSize;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "cinema_cw.Booking{" +
                "id=" + id +
                ", data=" + date +
                ", time=" + time +
                ", filmId=" + filmId +
                ", placeNumber=" + placeNumber +
                ", bookingDateTime=" + bookingDateTime +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
