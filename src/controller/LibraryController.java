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
        int authorId = inputController.getIntInput("Select author id: ");
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
}
