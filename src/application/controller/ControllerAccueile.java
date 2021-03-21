package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.RdvDao;
import application.dal.dao.VisiteDao;
import application.dal.model.*;
import application.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerAccueile implements Initializable {

    private Vector<TvRdvClient> vectorTvRdClients;
    private String role = ControllerLogin.getRole();
    private Vector<TvVstClient> vstClientVector;
    private RdvDao rdvDao = Main.getDaos().getRdvDao();
    private ClientDao clientDao = Main.getDaos().getClientDao();
    private VisiteDao visiteDao = Main.getDaos().getVisiteDao();
    private TvRdvClient clientRdv;
    private Client client;
    private RendezVous rdv;

    @FXML
    private TableView<TvRdvClient> tableRendez;

    @FXML
    private TableColumn<TvRdvClient, String> coloneCin;

    @FXML
    private TableColumn<TvRdvClient, String> coloneFullName;

    @FXML
    private TableColumn<TvRdvClient, String> coloneTele;

    @FXML
    private TableColumn<TvRdvClient, String> coloneDateRendezVous;

    @FXML
    private TableView<TvVstClient> tableViste;

    @FXML
    private TableColumn<TvVstClient, String> coloneCIN;

    @FXML
    private TableColumn<TvVstClient, String> coloneNAME;

    @FXML
    private TableColumn<TvVstClient, String> coloneDateVisite;

    @FXML
    private TableColumn<TvVstClient, String> coloneTraitement;

    @FXML
    private Label lblNbrRdv;

    @FXML
    private Label lblVisite;

    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;

    ObservableList<TvRdvClient> listRdv;
    ObservableList<TvVstClient> listVst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(role.equals("dentiste")){
            vstClientVector=visiteDao.findVstByClient();
            lblNbrRdv.setText(vstClientVector.size()+"");
            lblVisite.setText("Nombre de Visite");
            remplirTableVst(vstClientVector);

        }else{
            vectorTvRdClients=rdvDao.findRdvClientOfToday();
            lblNbrRdv.setText(vectorTvRdClients.size()+"");
            remplirTableRdv(vectorTvRdClients);
        }

    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){ reduce(); }

    public void remplirTableRdv(Vector<TvRdvClient> vector){
        listRdv = FXCollections.observableArrayList(vector);
        coloneCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<>("tele"));
        coloneDateRendezVous.setCellValueFactory(new PropertyValueFactory<>("dateRdv"));
        tableRendez.setItems(listRdv);
    }
    public void remplirTableVst(Vector<TvVstClient> vector){
        listVst = FXCollections.observableArrayList(vector);
        coloneCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
        coloneNAME.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        coloneDateVisite.setCellValueFactory(new PropertyValueFactory<>("tele"));
        coloneTraitement.setCellValueFactory(new PropertyValueFactory<>("trait"));
        tableViste.setItems(listVst);
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