package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public BookModel createBookObject(double ISBN, AuthorModel author, String title, PublisherModel publisher,
                                      int publicationYear, double price, BookType type) {
        return new BookModel(ISBN, author, title, publisher, publicationYear, price, type);
    }

    public void saveNewBook(BookModel book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books VALUES ?,?,?,?,?,?,? ");
            preparedStatement.setDouble(1, book.getISBN());
            preparedStatement.setInt(2, book.getAuthor().getId());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4, book.getPublisher().getId());
            preparedStatement.setInt(5, book.getPublicationYear());
            preparedStatement.setDouble(6, book.getPrice());
            preparedStatement.setInt(7, book.getType().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private BookModel createBookFromResult(ResultSet result) throws SQLException {
        double ISBN = result.getDouble("ISBN");
        int authorId = result.getInt("author");
        String title = result.getString("title");
        String publisherId = result.getString("publisher");
        int publicationYear = result.getInt("publication_year");
        int price = result.getInt("price");
        int typeId = result.getInt("type");

        AuthorDao authorDao = new AuthorDao();
        AuthorModel author = authorDao.findAuthorById(authorId);
        PublisherDao publisherDao = new PublisherDao();
        PublisherModel publisher = publisherDao.findPublisherById(publisherId);
        TypeDao typeDao = new TypeDao();
        BookType type = typeDao.findBookTypeById(typeId);

        return new BookModel(ISBN, author, title, publisher, publicationYear, price, type);
    }

    public List<BookModel> getAllBooks() {
        List<BookModel> allBooks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Books");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                BookModel book = createBookFromResult(result);
                allBooks.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBooks;
    }

    public void updateBookData(BookModel book, Double savedISBN) {
        try {
            PreparedStatement preparedUpdate = connection.prepareStatement("UPDATE Books SET (?,?,?,?,?,?,?) WHERE ISBN =?");
            preparedUpdate.setDouble(1, book.getISBN());
            preparedUpdate.setInt(2, book.getAuthor().getId());
            preparedUpdate.setString(3, book.getTitle());
            preparedUpdate.setString(4, book.getPublisher().getId());
            preparedUpdate.setInt(5, book.getPublicationYear());
            preparedUpdate.setDouble(6, book.getPrice());
            preparedUpdate.setInt(7, book.getType().getId());
            preparedUpdate.setDouble(8, savedISBN );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
