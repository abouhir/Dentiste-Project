package application.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSupprimerClient implements Initializable {

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



    @FXML
    private JFXButton btnAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        disable(txtFullName);
        disable(txtCin);
        disable(txtAdresse);
        disable(txtTele);
        disable(txtEmail);
    }

    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnsupprimerOnAction(){

    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }
    public void disable(JFXTextField txt){
        txt.setDisable(true);

    }
}
