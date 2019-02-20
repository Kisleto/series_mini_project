package com.codecool.series_mini_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private WatchedStatus watchedStatus;

    private String title;
    private double length;


    @ManyToOne
    private Season season;

}
