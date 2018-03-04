package dao;

import model.PublisherModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublisherDao {

    private DatabaseConnection database;
    private Connection connection;
    private Statement statement;

    public PublisherDao() {
        this.database = DatabaseConnection.getInstance();
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private PublisherModel createPublisherObject(ResultSet result) throws SQLException {
        String id = result.getString("publisher_id");
        String name = result.getString("name");
        String city = result.getString("city");
        String country = result.getString("country");
        return new PublisherModel(id, name, city, country);
    }


    public List<PublisherModel> getAllPublishers()  {
        List<PublisherModel> publishersCollection = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM Publishers");
            while (result.next()) {
                publishersCollection.add(createPublisherObject(result));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return publishersCollection;
    }

    public PublisherModel findPublisherById(String id) {
        List<PublisherModel> publishersCollection = getAllPublishers();
        PublisherModel matchedPublisher = null;
        for (PublisherModel publisher: publishersCollection) {
            if (publisher.getId().equals(id)) {
                matchedPublisher = publisher;
             }

        }
        return  matchedPublisher;
    }
}


