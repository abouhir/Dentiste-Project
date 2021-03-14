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
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class ControllerAjouterClient implements Initializable {
    private Client client;
   // private DbConnection cnx = new DbConnection();

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
        System.out.println("click");
        client =new Client(null,txtFullName+"",txtCin+"",txtTele+"",txtAdresse+"",txtEmail+"");
        boolean b= Main.getDaos().getClientDao().insert(client);
        if(b){
            System.out.println("ajouter");
        }
        else{
            System.out.println(" not ajouter");

        }

    }

    public void close(){
        Stage stage =(Stage)btnAnnuler.getScene().getWindow();
        stage.close();
    }
}
