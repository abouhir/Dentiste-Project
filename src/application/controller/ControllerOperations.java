package application.controller;

import application.dal.model.Client;
import application.dal.model.RendezVous;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

public class ControllerOperations implements Initializable {

    private Client client;
    private RendezVous Rdv;
    private Alert message, confirmer;
    private boolean b;
    private Date dateRdv ;

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

    @FXML
    private JFXButton btnAjouter;

    private boolean isAjout;

    @FXML
    private DatePicker txtRdv;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isAjout = btnAjouter != null;
        if (!isAjout) {
            client=ControllerOperationClient.getClient();
            txtFullName.setText(client.getFullName());
            txtTele.setText(client.getTele());
            txtAdresse.setText(client.getAddress());
            txtCin.setText(client.getCin());
            txtEmail.setText(client.getEmail());
        }
    }



    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnajouterOnAction() throws IOException {
        client =new Client(null,txtFullName.getText()+"",txtCin.getText()+"",txtTele.getText()+"",txtAdresse.getText()+"",txtEmail.getText()+"");
        b= Main.getDaos().getClientDao().insert(client);
        if(b){
            message("/resource/Icons/success.png","SUCCESS","Le Cient "+txtFullName.getText()+" Est Ajouter");
            //ctc.refreshUpdate(null,client);
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

    public void btnrendezvoudOnAction() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        dateRdv=sdf.parse(txtRdv.getValue().toString());
        Rdv=new RendezVous(null,2, ControllerOperationClient.getClient().getId(),dateRdv);
        //b=Main.getDaos().
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

}
