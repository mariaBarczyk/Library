package controller;

import view.RootView;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputController {

    private RootView view;

    public InputController() {
        this.view = new RootView();
    }

    public String getStringInput(String message) {
        view.displayMessage(message);
        boolean isInput = false;
        String input = null;
        while (!isInput) {
            try (Scanner scanner = new Scanner(System.in)) {
                input = scanner.nextLine();
            } catch (NoSuchElementException e) {
                e.getMessage();
            }
        }
    return input;
    }

    public Integer getIntInput(String message) {
        view.displayMessage(message);
        boolean isInput = false;
        Integer input = null;
        while (!isInput) {
            try (Scanner scanner = new Scanner(System.in)) {
                input = scanner.nextInt();
            } catch (NoSuchElementException e) {
                e.getMessage();
            }
        }
        return input;
    }

    public double getDoubleInput(String message) {
        view.displayMessage(message);
        boolean isInput = false;
        Double input = null;
        while (!isInput) {
            try (Scanner scanner = new Scanner(System.in)) {
                input = scanner.nextDouble();
            } catch (NoSuchElementException e) {
                e.getMessage();
            }
        }
            return input;
        }
}