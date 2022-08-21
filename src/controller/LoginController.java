package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoginController {
    public Button searchButton;
    public Pane homePan;

    public void openSearchPanel(ActionEvent actionEvent) throws IOException {
        Pane searchPan = null;
            searchPan = FXMLLoader.load(getClass().getResource("/ui/searchpanel.fxml"));
            homePan.getChildren().removeAll();
            homePan.getChildren().add(searchPan);
    }

    public void openInfoPanel(ActionEvent actionEvent) throws IOException {
        Pane searchPan = null;
        searchPan = FXMLLoader.load(getClass().getResource("/ui/info.fxml"));
        homePan.getChildren().removeAll();
        homePan.getChildren().add(searchPan);
    }

    public void openBookManagementPanel(ActionEvent actionEvent) throws IOException {
        Pane searchPan = null;
        searchPan = FXMLLoader.load(getClass().getResource("/ui/bookmanagement.fxml"));
        homePan.getChildren().removeAll();
        homePan.getChildren().add(searchPan);
    }

    public void openBookInfoPanel(ActionEvent actionEvent) throws IOException {
        Pane searchPan = null;
        searchPan = FXMLLoader.load(getClass().getResource("/ui/addbook.fxml"));
        homePan.getChildren().removeAll();
        homePan.getChildren().add(searchPan);
    }
}
