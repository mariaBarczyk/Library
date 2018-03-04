package model;

public class BookModel {

    private double ISBN;
    private AuthorModel author;
    private String title;
    private PublisherModel publisher;
    private int publicationYear;
    private double price;
    private BookType type;

    public BookModel(double ISBN, AuthorModel author, String title, PublisherModel publisher, int publicationYear, double price, BookType type) {
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

    public AuthorModel getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public PublisherModel getPublisher() {
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

    public void setISBN(double ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(BookType type) {
        this.type = type;
    }
}
