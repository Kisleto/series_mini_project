package com.codecool.series_mini_project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Singular
    @OneToMany(mappedBy = "season", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;

}
