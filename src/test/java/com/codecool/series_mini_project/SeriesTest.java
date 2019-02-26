package com.codecool.series_mini_project;

import com.codecool.series_mini_project.entity.Series;
import com.codecool.series_mini_project.repository.SeriesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeriesTest {
    @Autowired
    private SeriesRepository seriesRepository;

    @Test
    public void saveOneToDb(){
        Series game_of_thrones = Series.builder()
                .name("Game of Thrones")
                .build();
        seriesRepository.save(game_of_thrones);
        List<Series> seriesList = seriesRepository.findAll();
        assertThat(seriesList).hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveUniqueFieldTwice(){
        Series game_of_thrones = Series.builder()
                .name("Game of Thrones")
                .build();
        seriesRepository.save(game_of_thrones);

        Series game_of_thrones2 = Series.builder()
                .name("Game of Thrones")
                .build();

        seriesRepository.saveAndFlush(game_of_thrones2);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void titleShouldNotBeNull(){
        Series game_of_thrones = Series.builder()
                .releaseDate(LocalDate.of(1999,10,10))
                .build();
        seriesRepository.save(game_of_thrones);

    }
}
