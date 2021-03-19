package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.VisiteDao;
import application.dal.model.Client;
import application.dal.model.RendezVous;
import application.dal.model.Visite;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private Visite visite;
    private RendezVous rdv;
    private Alert message, confirmer;
    private boolean b;
    private Date dateRdv ;
    private ClientDao clientDao=Main.getDaos().getClientDao();
    private VisiteDao visiteDao=Main.getDaos().getVisiteDao();
    private String role=ControllerLogin.getRole();
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
    private boolean isTraitement;

    @FXML
    private DatePicker txtRdv;


    @FXML
    private JFXTextArea txtTraitement;

    @FXML
    private JFXTextField txtRemarque;

    @FXML
    private JFXButton btnAjouterTraitement;

     @FXML
    private Label lblName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client=ControllerOperationClient.getClient();
        isAjout = btnAjouter != null;
        isTraitement= btnAjouterTraitement!=null ;
        if(role.equals("infermier")) {
            if (!isAjout && !isTraitement) {
                txtFullName.setText(client.getFullName());
                txtTele.setText(client.getTele());
                txtAdresse.setText(client.getAddress());
                txtCin.setText(client.getCin());
                txtEmail.setText(client.getEmail());
            }
        }
        if(lblName!=null){
            lblName.setText(client.getCin() + " " + client.getFullName());
        }
//        if(role.equals("dentiste") && !isAjout) {
//            if (!isAjout) {
//
//            }
//        }
    }



    public void btnannulerOnAction(ActionEvent event){
        close();
    }
    public void btnajouterOnAction() throws IOException {
        if(role.equals("infermier")) {
            client = new Client(null, txtFullName.getText() + "", txtCin.getText() + "", txtTele.getText() + "", txtAdresse.getText() + "", txtEmail.getText() + "");
            b = clientDao.insert(client);
            if (b) {
                message("/resource/Icons/success.png", "SUCCESS", "Le Cient " + txtFullName.getText() + " Est Ajouter");
                close();

            } else {
                message("/resource/Icons/failed.png", "ERROR", "Le Cient " + txtFullName.getText() + " n\'est pas  Ajouter");
            }
        }
         else{
            visite=new Visite(2L,client.getId(),1,null,txtTraitement.getText(),txtRemarque.getText());
            b=visiteDao.insert(visite);
            if (b) {
                message("/resource/Icons/success.png","SUCCESS","Traitement ajouter avec success");
                close();
            }
            else{
                message("/resource/Icons/failed.png","ERROR","Echec !!!!");

            }

        }

    }
    public void btnmodifierOnAction(){
        if(role.equals("infermier")) {
        client =new Client(ControllerOperationClient.getClient().getId(),txtFullName.getText()+"",txtCin.getText()+"",txtTele.getText()+"",txtAdresse.getText()+"",txtEmail.getText()+"");
        alertConfirmation("Voulez vous vraiment Modifier le client : ");
        if(b){
            message("/resource/Icons/success.png","SUCCESS","Le Cient "+txtFullName.getText()+" Est Modifier");
            close();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Le Cient "+txtFullName.getText()+" n\'est pas  Modifier");
        }}
        else{
            visite=new Visite(2L,client.getId(),1,null,txtTraitement.getText(),txtRemarque.getText());
            b=visiteDao.update(visite);
            if (b) {
                message("/resource/Icons/success.png","SUCCESS","Traitement Modifier avec success");
                close();
            }
            else{
                message("/resource/Icons/failed.png","ERROR","Echec de Modification !!!!");

            }
        }
    }

    public void btnrendezvoudOnAction() throws ParseException {
        if(role.equals("infermier")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            dateRdv = sdf.parse(txtRdv.getValue().toString());
            rdv = new RendezVous(null, 1, ControllerOperationClient.getClient().getId(), dateRdv);
            b = Main.getDaos().getRdvDao().insert(rdv);
            if (b) {
                message("/resource/Icons/success.png","SUCCESS","Le Client  "+txtFullName.getText()+" est prend un rendez-vous");
                close();
            }
            else{
                message("/resource/Icons/failed.png","ERROR","Echec !!!!");

            }
        }
        else{
            visite=new Visite(2L,client.getId(),1,null,txtTraitement.getText(),txtRemarque.getText());
            b=visiteDao.insert(visite);
            if (b) {
                message("/resource/Icons/success.png","SUCCESS","Traitement ajouter avec success");
                close();
            }
            else{
                message("/resource/Icons/failed.png","ERROR","Echec !!!!");

            }

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

}
