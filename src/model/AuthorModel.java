package model;


public class AuthorModel extends PersonModel {

    private int id;
    private String surname;
    private int birthDate;

    public AuthorModel(int id, String name, String city, String country, String surname, int birthDate) {
        super(name, city, country);
        this.id = id;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }
}
