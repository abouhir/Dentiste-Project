package application.controller;

import application.dal.model.Dentiste;
import application.dal.model.User;
import application.main.Main;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ControllerLogin implements Initializable {
    private Alert message;
    private User user;
    private Dentiste dentist;
    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXButton btnAuth;

    @FXML
    private JFXPasswordField txtPwd;

    @FXML
    private JFXButton btnRefresh;

    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void btnauthOnAction(ActionEvent event ) throws IOException, SQLException {
        //dentist = Main.getDaos().getUserDao().checkDentistLogin(txtLogin.getText()+"",txtPwd.getText()+"");
        switchStage();
         close();
        //       if(dentist!=null) {
//            switchStage();
//            close();
//        }
//        else{
//            System.out.println("error");
//        }
    }
    public void btnrefreshOnAction(ActionEvent event){
        txtLogin.setText("");
        txtPwd.setText("");
    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnminusOnMouseEvent(MouseEvent event){
        reduce();
    }
    public void switchStage() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashboardInfirmierDocument.fxml"));
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