package com.codecool.series_mini_project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private LocalDate releaseDate;


    @OneToMany(mappedBy = "series",
    cascade = CascadeType.PERSIST)
    private Set<Season> seasonSet;





}
