package cinema_cw;

import cinema_cw.constant.HallSize;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cinema {
    private parser.BookingParser bookingParser = new parser.BookingParser();
    private parser.FilmParser filmParser = new parser.FilmParser();
    private parser.FilmScheduleParser filmScheduleParser = new parser.FilmScheduleParser();

    public void bookFilm(String filmName,
                         LocalDate data,
                         LocalTime time,
                         Integer place,
                         HallSize hallSize) {
        Film film = filmParser.getFilmByName(filmName);

        if (isSeatFree(film.getId(), data, time, place, hallSize)) {
            List<Booking> bookings = bookingParser.getBooking();
            Booking booking = new Booking();
            booking.setId(bookings.get(bookings.size() - 1).getId() - 1);
            booking.setDate(data);
            booking.setTime(time);
            booking.setPlaceNumber(place);
            booking.setHallSize(hallSize);
            booking.setBookingDateTime(LocalDateTime.now());
            booking.setFilmId(film.getId());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your first name");
            booking.setFirstName(scanner.nextLine());
            System.out.println("Input your second name");
            booking.setFirstName(scanner.nextLine());
            System.out.println("Input your email name");
            booking.setFirstName(scanner.nextLine());
            System.out.println("Input your mobile name");
            booking.setFirstName(scanner.nextLine());

            bookingParser.saveBooking(booking);

            try (PrintWriter writer = new PrintWriter("resources/succesfull-booking.txt", "UTF-8")) {
                writer.write("cinema_cw.Booking id: " + booking.getId() +
                        " date:" + booking.getDate() +
                        " time: " + booking.getTime() +
                        " film: " + filmName +
                        " hall size: " + booking.getHallSize().toString().toLowerCase());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("All places are booked");
        }

    }

    public void filmsInfo(LocalDate data, LocalTime time, Integer place) {
        List<Booking> booked = bookingParser.getBooking()
                .stream()
                .filter(booking -> booking.getDate().equals(data) || booking.getTime().equals(time))
                .collect(Collectors.toList());

        List<FilmSchedule> films = filmScheduleParser.getFilmSchedule().stream()
                .filter(filmSchedule -> filmSchedule.getDate().equals(data))
                .filter(filmSchedule -> filmSchedule.getTime().contains(time))
                .collect(Collectors.toList());

        for (FilmSchedule filmSchedule : films) {
            Film film = filmParser.getFilmById(filmSchedule.getId_film());
            System.out.println("cinema_cw.Film: " + film.getName());
            System.out.println("Beginning: " + filmSchedule.getTime());
            System.out.println("Hall size: " + filmSchedule.getHallSize());
            System.out.println("Free places: " + bookingParser.getFreePlaces(film.getId(),
                    filmSchedule.getHallSize(), data, time));
        }
    }

    public void showFreePlaces(String filmName, LocalDate date, LocalTime time) {
        Film film = filmParser.getFilmByName(filmName);
        System.out.println("Big hall, free places: " +
                bookingParser.getFreePlaces(film.getId(), HallSize.BIG, date, time));
        System.out.println("Small hall, free places: " +
                bookingParser.getFreePlaces(film.getId(), HallSize.SMALL, date, time));

    }

    public boolean isSeatFree(Long filmId,
                              LocalDate data,
                              LocalTime time,
                              Integer place,
                              HallSize hallSize) {
        if (bookingParser.getFreePlaces(filmId, hallSize, data, time).contains(place)) return true;
        return false;
    }


}
