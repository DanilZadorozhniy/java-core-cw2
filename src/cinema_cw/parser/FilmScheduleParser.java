package cinema_cw.parser;

import cinema_cw.FilmSchedule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmScheduleParser {
    private final String PATH_TO_FILE = "film-schedule.json";
    private final static Gson gson = new GsonBuilder()
            .setPrettyPrinting().create();

    public void saveFilmSchedule(FilmSchedule filmSchedule) {
        List<FilmSchedule> checks = getFilmSchedule();
        checks.add(filmSchedule);
        try (FileWriter writer = new FileWriter(PATH_TO_FILE)) {
            gson.toJson(checks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<FilmSchedule> getFilmSchedule() {
        List<FilmSchedule> checks = new ArrayList<>();
        try {
            checks = gson.fromJson(new FileReader(PATH_TO_FILE), new TypeToken<List<FilmSchedule>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return checks;
    }

}
