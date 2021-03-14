package application.controller;

import application.DbConnection.DbConnection;
import application.dal.dao.ClientDao;
import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class ControllerAjouterClient implements Initializable {
    private Client client;
    private  Alert message;
    private boolean b;

    @FXML
    private JFXButton btnAnnuler;

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



    public ControllerAjouterClient() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnajouterOnAction(){
        client =new Client(3L,txtFullName.getText()+"",txtCin.getText()+"",txtTele.getText()+"",txtAdresse.getText()+"",txtEmail.getText()+"");
        b= Main.getDaos().getClientDao().insert(client);
        if(b){
            message("/resource/Icons/success.png","SUCCESS","Le Cient "+txtFullName.getText()+" Est Ajouter");
            close();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Le Cient "+txtFullName.getText()+" n\'est pas  Ajouter");
        }

    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
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
