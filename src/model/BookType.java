package model;

public class BookType {

    private int id;
    private String typeName;

    public BookType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getId() {
        return id;
    }
}
