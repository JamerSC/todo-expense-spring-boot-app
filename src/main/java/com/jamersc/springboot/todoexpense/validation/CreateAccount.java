package com.jamersc.springboot.todoexpense.validation;

import com.jamersc.springboot.todoexpense.entity.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAccount {

    @NotNull(message = "Firstname is required!")
    @Size(min = 1, message = "Firstname is required!")
    private String createFirstName;

    @NotNull(message = "Lastname is required!")
    @Size(min = 1, message = "Lastname is required!")
    private String createLastName;

    @NotNull(message = "Gender is required!")
    private Gender createGender;

    @NotNull(message = "Email is required!")
    @Email(message = "Invalid email format")
    private String createEmail;

    @NotNull(message = "Username is required!")
    @Size(min = 1, message = "Username is required!")
    private String createUsername;

    @NotNull(message = "Password is required!")
    @Size(min = 1, message = "Password is required!")
    private String createPassword;

    public CreateAccount() {
    }

    public CreateAccount(String createFirstName, String createLastName,
                         Gender createGender, String createEmail, String createUsername, String createPassword) {
        this.createFirstName = createFirstName;
        this.createLastName = createLastName;
        this.createGender = createGender;
        this.createEmail = createEmail;
        this.createUsername = createUsername;
        this.createPassword = createPassword;
    }

    public String getCreateFirstName() {
        return createFirstName;
    }

    public void setCreateFirstName(String createFirstName) {
        this.createFirstName = createFirstName;
    }

    public String getCreateLastName() {
        return createLastName;
    }

    public void setCreateLastName(String createLastName) {
        this.createLastName = createLastName;
    }

    public Gender getCreateGender() {
        return createGender;
    }

    public void setCreateGender(Gender createGender) {
        this.createGender = createGender;
    }

    public String getCreateEmail() {
        return createEmail;
    }

    public void setCreateEmail(String createEmail) {
        this.createEmail = createEmail;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getCreatePassword() {
        return createPassword;
    }

    public void setCreatePassword(String createPassword) {
        this.createPassword = createPassword;
    }

    @Override
    public String toString() {
        return "AccountCreationValidation{" +
                ", createFirstName='" + createFirstName + '\'' +
                ", createLastName='" + createLastName + '\'' +
                ", createGender=" + createGender +
                ", createEmail='" + createEmail + '\'' +
                ", createUsername='" + createUsername + '\'' +
                ", createPassword='" + createPassword + '\'' +
                '}';
    }
}
