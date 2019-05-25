package com.project.dto;

import com.project.dto.base.BaseDto;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto extends BaseDto {

    @Size(min = 2, message = "Invalid firstname!")
    private String name;


    @Size(min = 2, message = "Invalid firstname!")
    private String surname;

    @NotNull
    @Email(message = "Email should be valid!")
    private String email;

    @Size(min = 10, max = 10, message = "Phone number must be 10 characters!")
    @Pattern(regexp = "[0-9]+", message = "Phone number must contain digit.")
    private String msisdn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
