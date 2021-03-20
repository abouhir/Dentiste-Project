package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.VisiteDao;
import application.dal.model.Client;
import application.dal.model.RendezVous;
import application.dal.model.TvRdvClient;
import application.dal.model.TvVstClient;
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
    private String role=ControllerLogin.getRole();
    private  Vector<TvVstClient> vstClientVector;
    private ClientDao clientDao=Main.getDaos().getClientDao();
    private VisiteDao visiteDao=Main.getDaos().getVisiteDao();
    private TvRdvClient clientRdv;
    private Client client;
    private RendezVous rdv;

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
        vectorTvRdClients=Main.getDaos().getRdvDao().findRdvClientOfToday();
       //int size;
        if(role.equals("dentiste")){
            coloneDateRendezVous.setText("Traitement");
            vectorTvRdClients.clear();
            vstClientVector=visiteDao.findVstByClient();
            vstClientVector.forEach(v-> System.out.println(v.getTrait()));
            vstClientVector.forEach(vst-> {client=new Client(vst.getIdClient(),vst.getFullName(),vst.getCin(),vst.getTele(),vst.getAddress(),vst.getEmail());
                rdv=null;
                clientRdv=new TvRdvClient(client,rdv);
                vectorTvRdClients.add(clientRdv);
            });
        }else{
            lblNbrRdv.setText(vectorTvRdClients.size()+"");
        }
        remplirTable(vectorTvRdClients);
    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){ reduce(); }

    public void remplirTable(Vector<TvRdvClient> vector){
        list = FXCollections.observableArrayList(vector);
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