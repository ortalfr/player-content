package com.player.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LifeEventDate {
    private Integer year;
    private Integer month;
    private Integer day;

    public Integer getYear() {
        return year != null ? year : 0;
    }

    public Integer getMonth() {
        return month != null ? month : 0;
    }

    public Integer getDay() {
        return day != null ? day : 0;
    }
}
