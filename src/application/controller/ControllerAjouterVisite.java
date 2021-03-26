package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.MedicsDao;
import application.dal.dao.OrdonnanceDao;
import application.dal.dao.VisiteDao;
import application.dal.model.*;
import application.main.Main;
import application.pdf.PdfGenerator;
import com.itextpdf.text.BadElementException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerAjouterVisite implements Initializable {
    private MedicsDao medicsDao= Main.getDaos().getMedicsDao();
    private ClientDao clientDao=Main.getDaos().getClientDao();
    private VisiteDao visiteDao=Main.getDaos().getVisiteDao();
    private OrdonnanceDao ordonnanceDao=Main.getDaos().getOrdDao();
    private Dentiste d = Main.getDaos().getDentistDao().find(1);

    private Alert message;

    private Client client;
    private Visite visite;
    private Medicament medicament;
    private Ordonnance ordonnance;


    private static Medicament medicamentSelected;


    @FXML
    private ImageView imgAjouterMedicament;

    boolean b;

    @FXML
    private JFXTextArea txtTraitement;

    @FXML
    private JFXTextField txtRechercheMedica;
    @FXML
    private Label lblRecherche;

    @FXML
    private JFXButton btnAjouter;

    @FXML
    private JFXButton btnAnnuler;

    @FXML
    private Label lblName;
    @FXML
    private TableView<Medicament> tableMedicament;
    @FXML
    private TableColumn<Medicament, String> coloneNom;
    @FXML
    private TableColumn<Medicament, String> coloneDesc;
    private ObservableList<Medicament> list;
    private Vector<Medicament> medicamentVector;

    @FXML
    private CheckBox ordennace;
    @FXML
    private ImageView imgPrint;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client=ControllerOperationClient.getClient();
        medicamentVector=medicsDao.selectAll();
        remplirTable(medicamentVector);
        lblName.setText( client.getCin() + " " + client.getFullName());
        etat(false);
    }


    public void btnajouterOnAction(ActionEvent event) {
        visite=new Visite(20,client.getId(),1,null,txtTraitement.getText(),"txtRemarque.getText()");
        b=visiteDao.insert(visite);
        if (b) {
            message("/resource/Icons/success.png","SUCCESS","Traitement ajouter avec success");
            close();
        }
        else{
            message("/resource/Icons/failed.png","ERROR","Echec !!!!");
        }
    }

    public void btnajoutermedicamentOnMouseEvent(MouseEvent event){
        medicament=new Medicament(2L,txtRechercheMedica.getText(),"description");
        b=medicsDao.insert(medicament);
        if (b) {
            message("/resource/Icons/success.png","SUCCESS","Medicament"+medicament.getNom()+" ajouter avec success");
            medicsDao.refresh();
            medicamentVector = medicsDao.selectAll();
            refreshTable(medicamentVector);
            }

        else{
            message("/resource/Icons/failed.png","ERROR","Echec !!!!");
        }
    }

    public void visitetableOnMousePresseed(MouseEvent event) throws IOException {
        medicamentSelected=tableMedicament.getSelectionModel().getSelectedItem();
    }

    public void btnprintOnMouseEvent(MouseEvent event) throws IOException, BadElementException {
        Ordonnance o = new Ordonnance(1L,20L,null,medicsDao);
        ordonnanceDao.insertMedicsToOrd(o.getId(),medicamentSelected.getId());
        //PdfGenerator.GeneratePdf(client,d,ordonnance);
    }
    public void btnannulerOnAction(ActionEvent event) {
        close();
    }
    public void checkordonnance(){
        if(ordennace.isSelected()){
            etat(true);
        }
        else {
            etat(false);

        }
    }

    public void remplirTable(Vector<Medicament> medicamentVector) {
        list = FXCollections.observableArrayList(medicamentVector);
        coloneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        coloneDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableMedicament.setItems(list);
    }
    public void refreshTable(Vector<Medicament> medicamentVector){
        tableMedicament.getItems().setAll(medicamentVector);
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
    public void etat(boolean b){
        tableMedicament.setVisible(b);
        txtRechercheMedica.setVisible(b);
        lblRecherche.setVisible(b);
        imgAjouterMedicament.setVisible(b);
        imgPrint.setVisible(b);
    }
}
