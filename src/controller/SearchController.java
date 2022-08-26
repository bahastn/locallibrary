package controller;

import entities.BookList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import services.BookListSearch;
import services.ListFields;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchController  implements Initializable {


    public TextField subjectFieldSearch;
    public TextField yearFieldSearch;
    public TextField authorFieldSearch;
    public TextField languageFieldSearch;
    public TextField titleFieldSearch;

    public TableColumn<BookList, String> languageColumn;
    public TableColumn<BookList, String> locationColumn;
    public TableColumn<BookList, String> author2Column;
    public TableColumn<BookList, String> authorColumn;
    public TableColumn<BookList, Integer> dateColumn;
    public TableColumn<BookList, String> subjectColumn;
    public TableColumn<BookList, String> titleColumn;
    public TableView<BookList> table;


    public void searchButton(ActionEvent actionEvent) throws Exception {
        setTable();

    }

    void setTable() throws Exception {
        Integer year = validYear(yearFieldSearch.getText().trim());
        BookListSearch bookListSearch = new BookListSearch();
        this.languageColumn.setCellValueFactory(new PropertyValueFactory("language"));
        this.locationColumn.setCellValueFactory(new PropertyValueFactory("location"));
        this.author2Column.setCellValueFactory(new PropertyValueFactory("author2"));
        this.authorColumn.setCellValueFactory(new PropertyValueFactory("author"));
        this.dateColumn.setCellValueFactory(new PropertyValueFactory("yearOfPublish"));
        this.subjectColumn.setCellValueFactory(new PropertyValueFactory("bookSubject"));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory("bookTitle"));
        this.table.setItems(bookListSearch.getListItems(titleFieldSearch.getText().trim(), subjectFieldSearch.getText().trim(), year, authorFieldSearch.getText().trim(), languageFieldSearch.getText().trim()));


    }

    private Integer validYear(String text) throws Exception {
        if (!text.isEmpty()) {
            Integer min = 0;
            Integer max = LocalDate.now().getYear() + 1;
            try {
                Integer year = Integer.valueOf(text);
                if (year > min && year < max) {
                    return year;
                } else {
                    String massage = "ساڵ دەبێت لە نێوان " + min + " و" + max;
                    AlertBox.massage("Valid year", massage);
                }
            } catch (Exception e) {
                AlertBox.massage("Valid year", "ساڵ دەبێت ژمارە بێت و لە چوار دیجیت کەمتر نەبێت");
            }
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListFields listFields = new ListFields();
        TextFields.bindAutoCompletion(subjectFieldSearch, listFields.listOfSubjects());
        TextFields.bindAutoCompletion(languageFieldSearch, listFields.listOfLanguages());
    }

    public void exportButton(ActionEvent actionEvent) {
    }
}
