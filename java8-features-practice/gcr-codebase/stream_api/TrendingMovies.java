package stream_api;
import java.util.*;
import java.util.stream.*;

public class TrendingMovies {

    static class Movie {
        String name;
        double rating;
        int releaseYear;

        Movie(String name, double rating, int releaseYear) {
            this.name = name;
            this.rating = rating;
            this.releaseYear = releaseYear;
        }

        @Override
        public String toString() {
            return name + " | Rating: " + rating + " | Year: " + releaseYear;
        }
    }

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.0, 2024),
            new Movie("Movie C", 8.7, 2022),
            new Movie("Movie D", 9.0, 2021),
            new Movie("Movie E", 8.9, 2024),
            new Movie("Movie F", 9.2, 2023),
            new Movie("Movie G", 8.3, 2020)
        );

        movies.stream()
              .filter(m -> m.rating >= 8.0)
              .sorted(Comparator
                      .comparing((Movie m) -> m.rating).reversed()
                      .thenComparing(m -> m.releaseYear, Comparator.reverseOrder()))
              .limit(5)
              .forEach(System.out::println);
    }
}
