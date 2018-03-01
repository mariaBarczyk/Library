package view;


import java.util.List;

public class RootView {

    public void displayMessage(String text) {
        System.out.println(text);
    }

    public <T> void  displayCollection(List<T> collection) {
        for (T element: collection) {
            System.out.println(element);
        }


    }
}
