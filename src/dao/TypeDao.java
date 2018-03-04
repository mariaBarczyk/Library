package dao;

import model.BookModel;
import model.BookType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {

    private DatabaseConnection database;
    private Connection connection;
    private Statement statement;

    public TypeDao() {
        this.database = DatabaseConnection.getInstance();
        this.connection = database.getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

//    public int getIdByTypeName(String typeName) {
//        Integer typeId = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT type_id FROM TypeBooks WHERE type=?");
//            preparedStatement.setString(1, typeName);
//            ResultSet result = preparedStatement.executeQuery();
//            typeId = result.getInt("type_id");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return typeId;
//    }

    public BookType findBookTypeById(int id) {
        List<BookType> allTypes = getAllTypes();
        BookType matchedType = null;
        for (BookType type: allTypes) {
            if (type.getId() == id) {
                matchedType = type;
            }
        }
        return  matchedType;
    }

    private List<BookType> fillListWithTypes(ResultSet result) throws SQLException {
        List <BookType> availableTypes = new ArrayList();
        while (result.next()) {
            int id = result.getInt("type_id");
            String typeName = result.getString("type");
            BookType bookType = new BookType(id, typeName);
            availableTypes.add(bookType);
        }
        return availableTypes;
    }

    public List<BookType> getAllTypes() {
        List<BookType> availableTypes = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Types");
            fillListWithTypes(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableTypes;
    }
}
