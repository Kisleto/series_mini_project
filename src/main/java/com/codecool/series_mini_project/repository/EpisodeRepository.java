package com.codecool.series_mini_project.repository;

import com.codecool.series_mini_project.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
