package application.controller;

import application.dal.model.TvRdvClient;
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
        coloneCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<>("tele"));
        coloneDateRendezVous.setCellValueFactory(new PropertyValueFactory<>("DateRdv"));
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