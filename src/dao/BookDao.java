package dao;

import model.AuthorModel;
import model.BookModel;
import model.BookType;
import model.PersonModel;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class BookDao {

    private DatabaseConnection database;
    private Connection connection;
    private Statement statement;

    public BookDao() {
        this.database = DatabaseConnection.getInstance();
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public BookModel createBookObject(double ISBN, AuthorModel author, String title, PersonModel publisher,
                                      int publicationYear, double price, BookType type) {
        return new BookModel(ISBN, author, title, publisher, publicationYear, price, type);
    }

    public void saveNewBook(BookModel book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books VALUES ?,?,?,?,?,?,? ");
            preparedStatement.setDouble(1, book.getISBN());
            preparedStatement.setInt(2, book.getAuthor().getId());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setInt(4, book.getPublisher().getId());
            preparedStatement.setInt(5, book.getPublicationYear());
            preparedStatement.setDouble(6, book.getPrice());
            preparedStatement.setInt(7, book.getType().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
