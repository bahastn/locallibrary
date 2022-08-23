package controller;

import entities.BookList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.BookListSearch;

public class SearchController {


    public TextField subjectFieldSearch;
    public TextField yearFieldSearch;
    public TextField authorFieldSearch;
    public TextField languageFieldSearch;
    public TextField titleFieldSearch;

    public TableColumn<BookList, String> languageColumn;
    public TableColumn<BookList, String> locationColumn;
    public TableColumn<BookList, String> author2Column;
    public TableColumn<BookList, String> authorColumn;
    public TableColumn<BookList, String> dateColumn;
    public TableColumn<BookList, String> subjectColumn;
    public TableColumn<BookList, String> titleColumn;
    public TableView<BookList> table;


    public void searchButton(ActionEvent actionEvent) {
        setTable();

    }

    void setTable() {
        BookListSearch bookListSearch = new BookListSearch();
        this.languageColumn.setCellValueFactory( new PropertyValueFactory( "language" ));
        this.locationColumn.setCellValueFactory( new PropertyValueFactory( "location" ));
        this.author2Column.setCellValueFactory( new PropertyValueFactory( "author2" ));
        this.authorColumn.setCellValueFactory( new PropertyValueFactory( "author" ));
        this.dateColumn.setCellValueFactory( new PropertyValueFactory( "yearOfPublish" ));
        this.subjectColumn.setCellValueFactory( new PropertyValueFactory( "bookSubject" ));
        this.titleColumn.setCellValueFactory( new PropertyValueFactory( "bookTitle" ));
        this.table.setItems(bookListSearch.getListItems());



    }
}
