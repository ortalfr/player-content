package com.player.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LifeEventLocation {
    private String country;
    private String state;
    private String city;

    public String getCountry() {
        return country != null ? country : "";
    }

    public String getState() {
        return state != null ? state : "";
    }

    public String getCity() {
        return city != null ? city : "";
    }
}
