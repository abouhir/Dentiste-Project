package application.controller;

import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerOperationClient implements Initializable {
    private static Client client;

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

    @FXML
    private ImageView imgRecherche;

    @FXML
    private JFXTextField txtRecherche;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientVector= Main.getDaos().getClientDao().selectAll();
        updateTable(clientVector);
        tableClient.getSelectionModel().selectFirst();
        ControllerOperationClient.client=tableClient.getSelectionModel().getSelectedItem();
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

    public void btnrechercheOnMouseEvent(MouseEvent event){
        clientVector.clear();
        clientVector.add(Main.getDaos().getClientDao().find(Long.parseLong(txtRecherche.getText())));
        updateTable(clientVector);

    }


    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){reduce();}

    public void updateTable(Vector<Client> clientVector){
        list = FXCollections.observableArrayList(clientVector);
        coloneCin.setCellValueFactory(new PropertyValueFactory<Client, String>("Cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<Client, String>("FullName"));
        coloneAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("Address"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<Client, String>("Tele"));
        coloneEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("Email"));
        tableClient.setItems(list);
    }
    public void tableOnMousePresseed(MouseEvent event){
        ControllerOperationClient.client=tableClient.getSelectionModel().getSelectedItem();
    }
    public static Client getClient(){
        return client;
    }

    public void refreshOnAction(ActionEvent event){
        updateTable(clientVector);
    }


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
