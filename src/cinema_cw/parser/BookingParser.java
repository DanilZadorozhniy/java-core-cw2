package cinema_cw.parser;

import cinema_cw.Booking;
import cinema_cw.constant.HallSize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingParser {
    private final String PATH_TO_FILE = "bookings.json";
    private final static Gson gson = new GsonBuilder()
            .setPrettyPrinting().create();

    public void saveBooking(Booking booking) {
        List<Booking> bookings = getBooking();
        bookings.add(booking);
        try (FileWriter writer = new FileWriter(PATH_TO_FILE)) {
            gson.toJson(bookings, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getBooking() {
        List<Booking> bookings = new ArrayList<>();
        try {
            bookings = gson.fromJson(new FileReader(PATH_TO_FILE), new TypeToken<List<Booking>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public List<Booking> getBookingsByFilmId(Long filmId) {
        return getBooking().stream()
                .filter(booking -> booking.getFilmId().equals(filmId))
                .collect(Collectors.toList());
    }

    public List<Integer> getFreePlaces(Long filmId, HallSize hallSize, LocalDate date, LocalTime time) {
        Integer seatsNumber;
        List<Integer> freePlaces = new ArrayList<>();
        List<Integer> bookedPlaces = getBookingsByFilmId(filmId).stream()
                .filter(booking -> booking.getHallSize().equals(hallSize))
                .filter(booking -> booking.getDate().equals(date) || booking.getTime().equals(time))
                .map(Booking::getPlaceNumber)
                .collect(Collectors.toList());

        if (hallSize.equals(HallSize.BIG)) {
            seatsNumber = 20;
        } else {
            seatsNumber = 10;
        }

        for (int i = 0; i < seatsNumber; i++) {
            if (!bookedPlaces.contains(i)) {
                freePlaces.add(i);
            }
        }
        return freePlaces;
    }

}