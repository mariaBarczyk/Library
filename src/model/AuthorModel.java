package model;

import dao.AuthorDao;

public class AuthorModel extends PersonModel {

    private String surname;
    private int birthDate;

    public AuthorModel(int id, String name, String city, String country, String surname, int birthDate) {
        super(id, name, city, country);
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
