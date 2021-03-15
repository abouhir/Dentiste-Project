package application.controller;

import application.dal.model.Client;
import application.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerOperationClient implements Initializable {
    private Vector<Client> clientVector;
    @FXML
    TableView<Client> tableClient;

    @FXML
    private TableColumn<Client, String> coloneCin;

    @FXML
    private TableColumn<Client, String> coloneFullName;

    @FXML
    private TableColumn<Client, String> coloneAdresse;

    @FXML
    private TableColumn<Client, String> coloneTele;

    @FXML
    private TableColumn<Client, String> coloneEmail;

    ObservableList<Client> list;

    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientVector= Main.getDaos().getClientDao().selectAll();
        list = FXCollections.observableArrayList(clientVector);
        coloneCin.setCellValueFactory(new PropertyValueFactory<Client, String>("Cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<Client, String>("FullName"));
        coloneAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("Address"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<Client, String>("Tele"));
        coloneEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("Email"));
        tableClient.setItems(list);
    }

    public void ajouterOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/AjouterClientDocument.fxml");
    }

    public void modifierOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/ModifierClientDcument.fxml");
    }

    public void supprimerOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/SupprimerClientDocument.fxml");
    }


    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){reduce();}


    public void switchStage(String name ) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 600, 607));
        primaryStage.showAndWait();
    }
    public void close(){
        Stage stage =(Stage)close.getScene().getWindow();
        stage.close();
    }
    public void reduce(){
        Stage stage =(Stage)reduce.getScene().getWindow();
        stage.toBack();
    }
}
