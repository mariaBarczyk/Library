package model;

public class PublisherModel extends PersonModel {

    private String id;

    public PublisherModel(String id, String name, String city, String country) {
        super(name, city, country);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
