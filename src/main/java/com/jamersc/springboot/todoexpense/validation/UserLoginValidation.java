package com.jamersc.springboot.todoexpense.validation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginValidation {

    @NotNull(message = "Username is required!")
    @Size(min = 1, message = "Username is required!")
    private String loginUsername;

    @NotNull(message = "Password is required!")
    @Size(min = 1, message = "Password is required!")
    private String loginPassword;

    public UserLoginValidation() {
    }

    public UserLoginValidation(String loginUsername, String loginPassword) {
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String   toString() {
        return "LoginValidation{" +
                "loginUsername='" + loginUsername + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
