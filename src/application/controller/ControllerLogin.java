package application.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
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
    private JFXButton btnRefresh;

    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void btnauthOnAction(ActionEvent event ) throws IOException {
            switchStage();
            close();
//        Alert c = new Alert(Alert.AlertType.ERROR);
//        c.setContentText("Nom d'utilisateur ou Mot de passe Incorrecte");
//        c.initStyle(StageStyle.UTILITY);
//        c.showAndWait();

    }
    public void btnrefreshOnAction(ActionEvent event){
        textLogin.setText("");
        textPwd.setText("");
    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnminusOnMouseEvent(MouseEvent event){
        reduce();
    }
    public void switchStage() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/resource/fxml/DashboardInfirmier.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 948, 687));
        primaryStage.show();
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