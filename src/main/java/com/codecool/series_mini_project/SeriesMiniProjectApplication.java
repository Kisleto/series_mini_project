package com.codecool.series_mini_project;

import com.codecool.series_mini_project.entity.Episode;
import com.codecool.series_mini_project.entity.Season;
import com.codecool.series_mini_project.entity.Series;
import com.codecool.series_mini_project.entity.WatchedStatus;
import com.codecool.series_mini_project.repository.SeasonRepository;
import com.codecool.series_mini_project.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class SeriesMiniProjectApplication {
    @Autowired
    public SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesMiniProjectApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init (){
        return args -> {
            Episode episode = Episode.builder()
                    .title("The Red Wedding")
                    .watchedStatus(WatchedStatus.SEEN)
                    .length(20.12)
                    .rating(9.1)
                    .build();
            Season season = Season.builder()
                    .numberOfSeason(1)
                    .numberOfEpisodes(10)
                    .episode(episode)
                    .build();
            Series game_of_thrones = Series.builder()
                    .name("Game of Thrones")
                    .season(season)
                    .releaseDate(LocalDate.of(2010, 10, 10))
                    .build();
            episode.setSeason(season);
            season.setSeries(game_of_thrones);
            seriesRepository.save(game_of_thrones);
        };
    }
}
