package com.codecool.series_mini_project;

import com.codecool.series_mini_project.entity.Episode;
import com.codecool.series_mini_project.repository.EpisodeRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class EpisodeTest {
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void transientIsNotSaved(){
        Episode episode = Episode.builder()
                .title("Killer")
                .length(28.1)
                .rating(9.2)
                .build();
        episodeRepository.save(episode);
        entityManager.clear();

        List<Episode> episodes = episodeRepository.findAll();
        assertThat(episodes).allMatch(episode1 -> episode1.getLength() == 0L);
    }
}
