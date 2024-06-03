package com.player.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class PlayerResponse {
    private String playerID;
    @JsonIgnore
    private LifeEventDate birthDate;
    @JsonIgnore
    private LifeEventLocation birthLocation;
    @JsonIgnore
    private LifeEventDate deathDate;
    @JsonIgnore
    private LifeEventLocation deathLocation;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private String bats;
    @JsonProperty("throws")
    private String throwsPlayer;
    private String debut;
    private String finalGame;
    private String retroID;
    private String bbrefID;

    @JsonProperty("birthYear")
    public int getBirthYear() {
        return birthDate != null ? birthDate.getYear() : 0;
    }

    @JsonProperty("birthMonth")
    public int getBirthMonth() {
        return birthDate != null ? birthDate.getMonth() : 0;
    }

    @JsonProperty("birthDay")
    public int getBirthDay() {
        return birthDate != null ? birthDate.getDay() : 0;
    }

    @JsonProperty("deathYear")
    public int getDeathYear() {
        return deathDate != null ? deathDate.getYear() : 0;
    }

    @JsonProperty("deathMonth")
    public int getDeathMonth() {
        return deathDate != null ? deathDate.getMonth() : 0;
    }

    @JsonProperty("deathDay")
    public int getDeathDay() {
        return deathDate != null ? deathDate.getDay() : 0;
    }

    public String getPlayerID() {
        return playerID;
    }

    public LifeEventDate getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthCountry")
    public String getBirthCountry() {
        return birthLocation != null ? birthLocation.getCountry() : "";
    }

    @JsonProperty("birthState")
    public String getBirthState() {
        return  birthLocation != null ? birthLocation.getState() : "";
    }
    @JsonProperty("birthCity")
    public String getBirthCity() {
        return  birthLocation != null ? birthLocation.getCity() : "";
    }

    public LifeEventDate getDeathDate() {
        return deathDate;
    }

    @JsonProperty("deathCountry")
    public String getDeathCountry() {
        return deathLocation != null ? deathLocation.getCountry() : "";
    }

    @JsonProperty("deathState")
    public String getDeathState() {
        return  deathLocation != null ? deathLocation.getState(): "";
    }
    @JsonProperty("deathCity")
    public String getDeathCity() {
        return deathLocation!=null? deathLocation.getCity() : "";
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public Integer getWeight() {
        return weight!=null? weight : 0;
    }

    public Integer getHeight() {
        return height != null ? height : 0;
    }

    public String getBats() {
        return bats;
    }

    public String getThrowsPlayer() {
        return throwsPlayer;
    }

    public String getDebut() {
        return debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }
}
