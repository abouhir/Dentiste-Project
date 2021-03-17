package application.controller;

import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerOperationClient implements Initializable {
    private static Client clientSelected;
    private Client client;
    private Alert message, confirmer;
    private boolean b;

    private Vector<Client> clientVector,rechercheVector=new Vector<>();

    private boolean isAjout;
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
    private JFXTextField txtRecherche;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientVector= Main.getDaos().getClientDao().selectAll();
        updateTable(clientVector);
        tableClient.getSelectionModel().selectFirst();
        ControllerOperationClient.clientSelected=tableClient.getSelectionModel().getSelectedItem();

    }

    public void ajouterOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/AjouterClientDocument.fxml");

    }

    public void modifierOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/ModifierClientDcument.fxml");
    }

    public void supprimerOnAction(ActionEvent event) throws IOException {
      //  switchStage("/resource/fxml/SupprimerClientDocument.fxml");

       // client = new Client(ControllerOperationClient.getClient().getId(), txtFullName.getText() + "", txtCin.getText() + "", txtTele.getText() + "", txtAdresse.getText() + "", txtEmail.getText() + "");
        client=ControllerOperationClient.getClient();
        alertConfirmation("Voulez vous vraiment supprimer le client : ");
        if (b) {
            message("/resource/Icons/success.png", "SUCCESS", "Le Cient " + client.getFullName() + " Est supprimer");
            tableClient.getItems().removeAll(client);
            tableClient.refresh();
        } else {
            message("/resource/Icons/failed.png", "ERROR", "Le Cient " + client.getFullName() + " n\'est pas  supprimer");
        }
    }

    public void  message(String img,String alertType,String msg){
        message = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) message.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource(img).toString()));
        message.setGraphic(new ImageView(this.getClass().getResource(img).toString()));
        message.setTitle(alertType);
        message.setHeaderText(null);
        message.setContentText(msg);
        message.showAndWait();
    }

    public void alertConfirmation(String information)
    {
        confirmer = new Alert(Alert.AlertType.CONFIRMATION);
        confirmer.setTitle("Confirmation Dialog");
        confirmer.setHeaderText(null);
        confirmer.setContentText(information+" "+client.getFullName());
        Optional<ButtonType> result = confirmer.showAndWait();
        if (result.get() == ButtonType.OK) {
            b = Main.getDaos().getClientDao().delete(client.getId());
        } else {
            b = false;
        }
    }

    public void btnrechercheOnMouseEvent(MouseEvent event)  {
        rechercheVector.add(Main.getDaos().getClientDao().find(Long.parseLong(txtRecherche.getText())));
        updateTable(rechercheVector);
        rechercheVector.clear();

    }
    public void btncloseOnMouseEvent(MouseEvent event){
        close(event);
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
        ControllerOperationClient.clientSelected=tableClient.getSelectionModel().getSelectedItem();
    }
    public static Client getClient(){
        return clientSelected;
    }

    public void refreshOnAction(ActionEvent event) throws IOException {
        //updateTable(clientVector);
        switchStage("/resource/fxml/RendezVousClientDocument.fxml");
    }



    public void switchStage(String name ) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 600, 607));
        primaryStage.showAndWait();
    }


    public void  refreshUpdate(Client clientAn ,Client clientNv ){
        if(clientAn!=null)
        tableClient.getItems().removeAll(clientAn);
        tableClient.getItems().add(clientNv);
        tableClient.refresh();
    }



    public void close(Event event){
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void reduce(){
        Stage stage =(Stage)reduce.getScene().getWindow();
        stage.toBack();
    }

}
