package com.player.controller.response;

import lombok.Data;

@Data
public class BasicResponse {
    protected int status;
    protected String message;

    public BasicResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
