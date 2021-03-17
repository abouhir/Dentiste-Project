package application.controller;

import application.dal.model.RendezVous;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRendezVousClient implements Initializable {
    private RendezVous rdv;

    @FXML
    private JFXButton btnAnnuler;
    @FXML
    private DatePicker txtDateRdv;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void rendezvousOnAction(){

    }

    public void btnannulerOnAction(ActionEvent event){
        close();
    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }

}
