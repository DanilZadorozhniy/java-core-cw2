package cinema_cw;

import cinema_cw.parser.BookingParser;
import cinema_cw.parser.FilmParser;
import cinema_cw.parser.FilmScheduleParser;

import java.util.Scanner;

public class Main {
    private static BookingParser bookingParser = new BookingParser();
    private static FilmParser filmParser = new FilmParser();
    private static FilmScheduleParser filmScheduleParser = new FilmScheduleParser();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Available films: ");
        for (Film film : filmParser.getFilms()) {
            System.out.println(film.getName());
        }

    }
}
