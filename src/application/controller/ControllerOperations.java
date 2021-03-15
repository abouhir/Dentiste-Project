package application.controller;

import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerOperations implements Initializable {

    private Client client;
    private Alert message,confirmer;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       client=ControllerOperationClient.getClient();
       txtFullName.setText(client.getFullName());
       txtTele.setText(client.getTele());
       txtAdresse.setText(client.getAddress());
       txtCin.setText(client.getCin());
       txtEmail.setText(client.getEmail());
    }



    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnajouterOnAction(){
        client =new Client(null,txtFullName.getText()+"",txtCin.getText()+"",txtTele.getText()+"",txtAdresse.getText()+"",txtEmail.getText()+"");
        b= Main.getDaos().getClientDao().insert(client);
        if(b){
            message("/resource/Icons/success.png","SUCCESS","Le Cient "+txtFullName.getText()+" Est Ajouter");
            close();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Le Cient "+txtFullName.getText()+" n\'est pas  Ajouter");
        }

    }
    public void btnmodifierOnAction(){
        client =new Client(ControllerOperationClient.getClient().getId(),txtFullName.getText()+"",txtCin.getText()+"",txtTele.getText()+"",txtAdresse.getText()+"",txtEmail.getText()+"");
        alertConfirmation("Voulez vous vraiment Modifier le client : ");
        if(b){
            message("/resource/Icons/success.png","SUCCESS","Le Cient "+txtFullName.getText()+" Est Modifier");
            close();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Le Cient "+txtFullName.getText()+" n\'est pas  Modifier");
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
    public void alertConfirmation(String information)
    {
        confirmer = new Alert(Alert.AlertType.CONFIRMATION);
        confirmer.setTitle("Confirmation Dialog");
        confirmer.setHeaderText(null);
        confirmer.setContentText(information+" "+txtFullName.getText());
        Optional<ButtonType> result = confirmer.showAndWait();
        if (result.get() == ButtonType.OK) {
            b = Main.getDaos().getClientDao().update(client);
        } else {
            b = false;
        }
    }

    public void setClient(Client client){
        System.out.println("set :" +client.getFullName());
        this.client=client;
        System.out.println("obj : "+this.client.getFullName());

    }

}
