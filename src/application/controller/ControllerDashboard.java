package application.controller;

import application.dal.model.Client;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerDashboard implements Initializable {

    @FXML
    private AnchorPane content;

    @FXML
    private JFXButton btnDeconnecter;

    @FXML
    private ImageView img;

    private String role=ControllerLogin.getRole();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(role.equals("dentiste")){
            img.setImage(new Image(this.getClass().getResource("/resource/Icons/dentiste.png").toString()));
        }


        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/AccueileDocument.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnAccueileOnAction(ActionEvent event) throws IOException {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/AccueileDocument.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnclientOnAction(ActionEvent event) throws IOException {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("/resource/fxml/OperationClientDocument.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void btndeconnecterOnAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginDocument.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 777, 559));
        primaryStage.show();
        Stage stage =(Stage)btnDeconnecter.getScene().getWindow();
        stage.close();

    }
    }
