package application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerModifierClient implements Initializable {

    @FXML
    private JFXButton btnAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void btnannulerOnAction(ActionEvent event){
        close();
    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }
}
