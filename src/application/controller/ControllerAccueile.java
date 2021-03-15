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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAccueile implements Initializable {

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
    private ImageView close;

    @FXML
    private ImageView reduce;

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

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){ reduce(); }

    public void close(){
        Stage stage =(Stage)close.getScene().getWindow();
        stage.close();
    }
    public void reduce(){
        Stage stage =(Stage)reduce.getScene().getWindow();
        stage.toBack();
    }
}