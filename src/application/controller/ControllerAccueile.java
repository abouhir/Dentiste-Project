package application.controller;

import application.dal.model.Client;
import application.dal.model.RendezVous;
import application.dal.model.TvRdvClient;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerAccueile implements Initializable {

    private Vector<TvRdvClient> vectorTvRdClients;



    @FXML
    private TableView<TvRdvClient> tableRendez;

    @FXML
    private TableColumn<TvRdvClient,String> coloneCin;

    @FXML
    private TableColumn<TvRdvClient,String> coloneFullName;

    @FXML
    private TableColumn<TvRdvClient,String> coloneTele;

    @FXML
    private TableColumn<TvRdvClient,String> coloneDateRendezVous;

    @FXML
    private Label lblNbrRdv;


    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;

    ObservableList<TvRdvClient> list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remplirTable();
        lblNbrRdv.setText(vectorTvRdClients.size()+"");
    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){ reduce(); }

    public void remplirTable(){
        vectorTvRdClients=Main.getDaos().getRdvDao().findRdvClientOfToday();
        list = FXCollections.observableArrayList( vectorTvRdClients);
        coloneCin.setCellValueFactory(new PropertyValueFactory<TvRdvClient,String>("cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<TvRdvClient, String>("FullName"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<TvRdvClient, String>("tele"));
        coloneDateRendezVous.setCellValueFactory(new PropertyValueFactory<TvRdvClient, String>("DateRdv"));
        tableRendez.setItems(list);
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