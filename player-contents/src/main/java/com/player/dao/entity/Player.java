package com.player.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "player_id")
    private String playerID;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "birth_month")
    private Integer birthMonth;
    @Column(name = "birth_day")
    private Integer birthDay;
    @Column(name = "birth_country")
    private String birthCountry;
    @Column(name = "birth_state")
    private String birthState;
    @Column(name = "birth_city")
    private String birthCity;
    @Column(name = "death_year")
    private Integer deathYear;
    @Column(name = "death_month")
    private Integer deathMonth;
    @Column(name = "death_day")
    private Integer deathDay;
    @Column(name = "death_country")
    private String deathCountry;
    @Column(name = "death_state")
    private String deathState;
    @Column(name = "death_city")
    private String deathCity;
    @Column(name = "name_first")
    private String nameFirst;
    @Column(name = "name_last")
    private String nameLast;
    @Column(name = "name_given")
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private String bats;
    @Column(name = "throws")
    private String throwsPlayer;
    private Timestamp debut;
    private Timestamp finalGame;
    private String retroID;
    private String bbrefID;
}
