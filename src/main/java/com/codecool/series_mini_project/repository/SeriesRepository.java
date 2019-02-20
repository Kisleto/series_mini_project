package com.codecool.series_mini_project.repository;

import com.codecool.series_mini_project.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
