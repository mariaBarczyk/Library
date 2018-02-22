package model;

public class BookModel {

    private double ISBN;
    private Person author;
    private String title;
    private Person  publisher;
    private int publicationYear;
    private double price;
    private String typeName;

    public BookModel(double ISBN, Person author, String title, Person publisher, int publicationYear, double price, String typeName) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.typeName = typeName;
    }
}
