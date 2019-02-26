package com.codecool.series_mini_project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Transient
    private double length;

    @ElementCollection
    @Singular
    private List<Double> ratings;

    @ManyToOne
    private Season season;

}
