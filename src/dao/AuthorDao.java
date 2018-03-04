package dao;

import model.AuthorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    private DatabaseConnection database;
    private Connection connection;
    private Statement statement;

    public AuthorDao() {
        this.database = DatabaseConnection.getInstance();
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private AuthorModel createAuthorObject(ResultSet result) throws SQLException {
        int id = result.getInt("author_id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        int birthYear = result.getInt("birth_year");
        String city = result.getString("city");
        String country = result.getString("country");
        return new AuthorModel(id, name, city, country, surname, birthYear);
    }


    public  List<AuthorModel>  getAllAuthors()  {
        List<AuthorModel> authorCollection = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM Authors");
            while (result.next()) {
                authorCollection.add(createAuthorObject(result));
            }
        } catch (SQLException e) {
          e.getMessage();
            }
        return authorCollection;
    }

    public AuthorModel findAuthorById(int id) {
        List<AuthorModel> authorsCollection = getAllAuthors();
        AuthorModel matchedAuthor = null;
        for (AuthorModel author: authorsCollection) {
            if (author.getId() == id) {
                matchedAuthor = author;
            }
        }
        return  matchedAuthor;
    }
}
