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

public class ControllerAccueile implements Initializable {
    @FXML
    private JFXButton btnAccueile;

    @FXML
    private TableView<Model> tableRendez;

    @FXML
    private TableColumn<Model,String> coloneCin;

    @FXML
    private TableColumn<Model,String> coloneNom;

    @FXML
    private TableColumn<Model,String> colonePrenom;

    @FXML
    private TableColumn<Model,String> coloneDate;

    @FXML
    private JFXButton btnClient;

    @FXML
    private AnchorPane content;
    String str="Accueile";

    ObservableList<Model> list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        list = FXCollections.observableArrayList(
                new Model("BL1555900","Bouhir","Abderrahmane","2020/10/1"),
                new Model("BL1555900","Bouhir","Abderrahmane","2020/10/1"),
                new Model("BL1555900","Bouhir","Abderrahmane","2020/10/1"),
                new Model("BL1555900","Bouhir","Abderrahmane","2020/10/1")
        );
        coloneCin.setCellValueFactory(new PropertyValueFactory<Model, String>("Cin"));
        coloneNom.setCellValueFactory(new PropertyValueFactory<Model, String>("Nom"));
        colonePrenom.setCellValueFactory(new PropertyValueFactory<Model, String>("Prenom"));
        coloneDate.setCellValueFactory(new PropertyValueFactory<Model, String>("Date"));
        tableRendez.setItems(list);

    }
}