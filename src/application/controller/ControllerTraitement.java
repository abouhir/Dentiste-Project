package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.VisiteDao;
import application.dal.model.Client;
import application.dal.model.Visite;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerTraitement implements Initializable {
    private ClientDao clientDao= Main.getDaos().getClientDao();
    private VisiteDao visiteDao=Main.getDaos().getVisiteDao();

    private static Client  client;
    private Visite visite;

    private Alert message, confirmer;

    private String role=ControllerLogin.getRole();

    private boolean b;

    private static Visite visiteSelected;

    @FXML
    private JFXButton btnAnnuler;

    @FXML
    private TableView<Visite> tableVisite;

    @FXML
    private javafx.scene.control.TableColumn<Visite, Date> coloneDateVisite;

    @FXML
    private TableColumn<Visite, String> coloneTraitement;

    private ObservableList<Visite> list;

    private Vector<Visite> visiteVector;

    @FXML
    private Label lblName;

    @FXML
    private JFXButton btnAjouter;

    @FXML
    private JFXButton btnDelete;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client=ControllerOperationClient.getClient();
        visiteVector=visiteDao.findByCli(client.getId());
        remplirTable(visiteVector);
        lblName.setText(client.getCin() + " " + client.getFullName());
        btnDelete.setDisable(true);
        tableVisite.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Visite>() {
            @Override
            public void changed(ObservableValue<? extends Visite> observableValue, Visite visite, Visite t1) {
                btnDelete.setDisable(t1 == null);
            }
        });
    }



    @FXML
    void ajouterOnAction(ActionEvent event) throws IOException {
        switchStage("/resource/fxml/AjouterVisiteDocument.fxml");
    }
    public void supprimerOnAction(ActionEvent event) throws IOException{
        alertConfirmation("Voulez vous vraiment supprimer le Traitement : ");
        if (b) {
            message("/resource/Icons/success.png","SUCCESS","Traitement Supprimer avec success");
            tableVisite.getItems().removeAll(visiteSelected);
            tableVisite.refresh();
            visiteSelected=tableVisite.getSelectionModel().getSelectedItem();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Echec !!!!");

        }
    }
    public void visitetableOnMousePresseed(MouseEvent event) throws IOException {
        visiteSelected=tableVisite.getSelectionModel().getSelectedItem();
    }
    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void remplirTable(Vector<Visite> visiteVector) {
        list = FXCollections.observableArrayList(visiteVector);
        coloneDateVisite.setCellValueFactory(new PropertyValueFactory<>("dateVisite"));
        coloneTraitement.setCellValueFactory(new PropertyValueFactory<>("trait"));
        tableVisite.setItems(list);
    }
    public void refreshTable(Vector<Visite> visiteVector){
        tableVisite.getItems().setAll(visiteVector);
    }
    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }
    public void switchStage(String name ) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 600, 550));

        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDDEN, windowEvent -> {
            visiteDao.refresh();
            if(client!=null){
            visiteVector = visiteDao.findByCli(client.getId());
            refreshTable(visiteVector);
            }
        });
        primaryStage.showAndWait();
    }
    public void alertConfirmation(String information)
    {
        confirmer = new Alert(Alert.AlertType.CONFIRMATION);
        confirmer.setTitle("Confirmation Dialog");
        confirmer.setHeaderText(null);
        confirmer.setContentText(information+" "+client.getFullName());
        Optional<ButtonType> result = confirmer.showAndWait();
        if (result.get() == ButtonType.OK) {
                b = visiteDao.delete(visiteSelected.getId());
        } else {
            b = false;
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
}
