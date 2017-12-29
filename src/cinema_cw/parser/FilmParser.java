package cinema_cw.parser;

import cinema_cw.Film;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmParser {
    private final String PATH_TO_FILE = "film-details.json";
    private final static Gson gson = new GsonBuilder()
            .setPrettyPrinting().create();

    public void saveFilm(Film film) {
        List<Film> films = getFilms();
        films.add(film);
        try (FileWriter writer = new FileWriter(PATH_TO_FILE)) {
            gson.toJson(films, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getFilms() {
        List<Film> films = new ArrayList<>();
        try {
            films = gson.fromJson(new FileReader(PATH_TO_FILE), new TypeToken<List<Film>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return films;
    }

    public Film getFilmByName(String name) {
        for (Film film : getFilms()) {
            if (film.getName().equals(name)) {
                return film;
            }
        }
        return null;
    }

    public Film getFilmById(Long id) {
        for (Film film : getFilms()) {
            if (film.getId().equals(id)) {
                return film;
            }
        }
        return null;
    }

}
