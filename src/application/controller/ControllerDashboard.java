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
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/resource/fxml/Accueile.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnAccueileOnAction(ActionEvent event) throws IOException {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/resource/fxml/Accueile.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnclientOnAction(ActionEvent event) throws IOException {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/resource/fxml/OperationClientDocument.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
