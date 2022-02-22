package com.pointwest.capstone.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private String JwtToken;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken) {
        JwtToken = jwtToken;
    }

    public String getJwtToken() {
        return JwtToken;
    }
}
