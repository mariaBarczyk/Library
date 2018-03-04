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

    public void displayMainMenu() {
        System.out.println("What would you like to do?\n" +
                "1. Add new book\n" +
                "2. Edit book data\n" +
                "3. Search book\n" +
                "4. Display books\n" +
                "5. Display books of author\n" +
                "5. Delete book\n" +
                "6. Exit\n");
    }

    public void displayEditBookMenu() {
        System.out.println("What would you like to edit?\n" +
                "1. Title\n" +
                "2. Author\n" +
                "3. Publisher\n" +
                "4. Publication year\n" +
                "5. ISBN\n" +
                "6. type\n" +
                "7. price\n" +
                "8. exit\n");
    }

}




