package application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDashboard implements Initializable {
    @FXML
    private JFXButton btnAccueile;


    @FXML
    private JFXButton btnClient;

    @FXML
    private AnchorPane content;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        content.getChildren().clear();
//        content.getChildren().add(new FXMLLoader(getClass().getResource("Accueile.fxml")));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueile.fxml"));
       // AnchorPane registerPane = (AnchorPane) fxmlLoader.load();
        try {
            AnchorPane registerPane = (AnchorPane) fxmlLoader.load();
            content.getChildren().clear();
            content.getChildren().add(registerPane);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnclientOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueile.fxml"));
        AnchorPane registerPane = (AnchorPane) fxmlLoader.load();
        try {
            content.getChildren().clear();
            content.getChildren().add(registerPane);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void btnAccueileOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperationClientDocument.fxml"));
        AnchorPane registerPane = (AnchorPane) fxmlLoader.load();
        try {
            content.getChildren().clear();
            content.getChildren().add(registerPane);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
