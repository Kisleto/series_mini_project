package com.codecool.series_mini_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private long id;
    private Integer numberOfSeason;
    private Integer numberOfEpisodes;

    @ManyToOne
    private Series series;
}
