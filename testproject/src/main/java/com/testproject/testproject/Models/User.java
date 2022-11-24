package com.testproject.testproject.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String login;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Email(regexp = ".+[@].+[\\.].+",
            message = "E-mail некорректен. Проверить наличие символа @ и домена почты")
    private String email;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 5, max = 50, message="Длина пароля должна быть в диапозоне от 5 до 50")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{5,}$", message = "Проверьте пароль " +
            "на соответствие требованиям: \n1) Наличие хотя бы одной цифры" +
            "\n2) Наличие хотя бы одной строчной буквы" +
            "\n3) Наличие хотя бы одной заглавной буквы" +
            "\n4) Наличие спец. символа - @#$%^&+=" +
            "\n5) Длина - от 5 до 50 символов")
    private String password;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String name;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String surname;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfTheBirth;
    @Null
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="passport_id")
    private Passport passport;

    public User() {
    }

    public User(String login, String email, String password, String name, String surname, Passport pasport, Date date) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.passport = pasport;
        this.dateOfTheBirth = date;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport pasport) {
        this.passport = pasport;
    }

    public Date getDateOfTheBirth() {
        return dateOfTheBirth;
    }

    public void setDateOfTheBirth(Date dateOfTheBirth) {
        this.dateOfTheBirth = dateOfTheBirth;
    }
}
