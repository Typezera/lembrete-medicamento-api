package com.LembreteMedicamento.lembretemedicamento.dto;

public class LoginResponse {
    String token;
    String email;

    public LoginResponse(String token, String email){
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
