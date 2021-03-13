package application.controller;

import application.dal.model.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class ControllerAjouterClient implements Initializable {

    @FXML
    private JFXButton btnAnnuler;

    private Client client;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtCin;

    @FXML
    private JFXTextField txtTele;

    @FXML
    private JFXTextField txtAdresse;

    @FXML
    private JFXTextField txtEmail;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnajouterOnAction(){
        //client =new Client();
    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }
}
