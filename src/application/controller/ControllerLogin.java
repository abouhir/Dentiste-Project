package application.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerLogin implements Initializable {
    @FXML
    private JFXTextField textLogin;

    @FXML
    private JFXButton btnAuth;

    @FXML
    private JFXPasswordField textPwd;

    @FXML
    private JFXButton btnOb;

    @FXML
    private ImageView close;

    @FXML
    private ImageView minus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void btnauthOnAction(ActionEvent event ){
        Alert c = new Alert(Alert.AlertType.INFORMATION);
        c.setContentText("Nom d'utilisateur ou Mot de passe Incorrecte");
        c.initStyle(StageStyle.UTILITY);
        c.showAndWait();

    }
    public void btnobOnAction(ActionEvent event){
        textLogin.setText("");
        textPwd.setText("");
    }

    public void btncloseOnAction(ActionEvent event){

       // System.exit(0);
    }
}