package view;

import model.BookType;

import java.util.List;


public class RootView {

    public void displayMessage(String text) {
        System.out.println(text);
    }

    public <T> void displayListCollection(List<T> collection) {
        for (T element: collection) {
            System.out.println(element);
        }
    }

    public void displayAvailableTypes(List<BookType> availableTypes) {
        System.out.println("\nAVAILABLE TYPES: ");
        for (BookType type: availableTypes) {
            System.out.println(type.getId() + ". " + type.getTypeName());
        }
    }
}




