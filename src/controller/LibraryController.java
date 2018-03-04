package controller;

import dao.AuthorDao;
import dao.BookDao;
import dao.PublisherDao;
import dao.TypeDao;
import model.AuthorModel;
import model.BookModel;
import model.BookType;
import model.PublisherModel;
import view.RootView;


import java.util.List;

public class LibraryController {

    private InputController inputController;
    private RootView rootView;

    public LibraryController() {
        this.inputController = new InputController();
        this.rootView = new RootView();
    }

    private AuthorModel selectAuthor() {
        AuthorDao authorDao = new AuthorDao();
        List<AuthorModel> authorsCollection = authorDao.getAllAuthors();
        rootView.displayListCollection(authorsCollection);
        int authorId = inputController.getIntInput("Select author id: ");
        return authorDao.findAuthorById(authorId);
    }

    private PublisherModel selectPublisher() {
        PublisherDao publisherDao = new PublisherDao();
        List<PublisherModel> publishersCollection = publisherDao.getAllPublishers();
        rootView.displayListCollection(publishersCollection);
        String authorId = inputController.getStringInput("Select author id: ");
        return publisherDao.findPublisherById(authorId);
    }

    private BookType selectType() {
        TypeDao typeDao = new TypeDao();
        List<BookType> availableTypes = typeDao.getAllTypes();
        rootView.displayAvailableTypes(availableTypes);
        int typeId = inputController.getIntInput("Enter id type: ");
        BookType bookType = typeDao.findBookTypeById(typeId);
        return bookType;
    }

    public void addNewBook() {
        double ISBN = inputController.getDoubleInput("Enter ISBN: ");
        AuthorModel author = selectAuthor();
        String title = inputController.getStringInput("Enter title: ");
        PublisherModel publisher = selectPublisher();
        int publicationYear = inputController.getIntInput("Enter publication year: ");
        double price = inputController.getDoubleInput("Enter price of book: ");
        BookType type = selectType();
        BookDao bookDao = new BookDao();
        BookModel newBook = bookDao.createBookObject(ISBN, author, title, publisher, publicationYear, price, type);
        bookDao.saveNewBook(newBook);

    }

    private BookModel selectBook() {
        BookDao bookDao = new BookDao();
        List<BookModel> allBooks = bookDao.getAllBooks();
        rootView.displayListCollection(allBooks);
        double ISBN = inputController.getDoubleInput("Enter ISBN: ");
        BookModel matchedBook = null;
        for (BookModel book : allBooks) {
            if (book.getISBN() == ISBN) {
                matchedBook = book;
            }
        }
        return matchedBook;
    }

    public void editBook() {
        BookModel bookToEdit = selectBook();
        Double savedISBN = bookToEdit.getISBN();
        int userChoice = 0;
        while (userChoice != 8) {
            rootView.displayEditBookMenu();
            userChoice = inputController.getIntInput("SELECT AN OPTION: ");
            switch (userChoice) {
                case 1:
                    String newTitle = inputController.getStringInput("Enter new title: ");
                    bookToEdit.setTitle(newTitle);
                    break;
                case 2:
                    AuthorModel newAuthor = selectAuthor();
                    bookToEdit.setAuthor(newAuthor);
                    break;
                case 3:
                    PublisherModel newPublisher = selectPublisher();
                    bookToEdit.setPublisher(newPublisher);
                    break;
                case 4:
                    int newPublicationYear = inputController.getIntInput("Enter publication year");
                    bookToEdit.setPublicationYear(newPublicationYear);
                    break;
                case 5:
                    double newISBN = inputController.getDoubleInput("Enter ISBN: ");
                    bookToEdit.setISBN(newISBN);
                    break;
                case 6:
                    BookType newType = selectType();
                    bookToEdit.setType(newType);
                    break;
                case 7:
                    double newPrice = inputController.getDoubleInput("Enter price: ");
                    bookToEdit.setPrice(newPrice);
                    break;
                case 8:
                    BookDao bookDao = new BookDao();
                    bookDao.updateBookData(bookToEdit, savedISBN);
                    rootView.displayMessage("Changes have benn saved.");
                    break;
                default:
                    rootView.displayMessage("Wrong number");
            }
        }
    }
}
