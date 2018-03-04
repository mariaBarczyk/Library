package model;

public class BookModel {

    private double ISBN;
    private PersonModel author;
    private String title;
    private PersonModel publisher;
    private int publicationYear;
    private double price;
    private BookType type;

    public BookModel(double ISBN, PersonModel author, String title, PersonModel publisher, int publicationYear, double price, BookType type) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = type;
    }

    public double getISBN() {
        return ISBN;
    }

    public PersonModel getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public PersonModel getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public BookType getType() {
        return type;
    }
}
