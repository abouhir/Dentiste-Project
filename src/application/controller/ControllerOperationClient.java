package application.controller;

import application.dal.dao.ClientDao;
import application.dal.dao.VisiteDao;
import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerOperationClient implements Initializable {
    private ClientDao cliDao;
    private static Client clientSelected;
    private Client client;
    private Alert message, confirmer;
    private boolean b;
    private String role=ControllerLogin.getRole();
    private VisiteDao visiteDao=Main.getDaos().getVisiteDao();
    private Vector<Client> clientVector;

    @FXML
    TableView<Client> tableClient;

    @FXML
    private TableColumn<Client, String> coloneCin;

    @FXML
    private TableColumn<Client, String> coloneFullName;

    @FXML
    private TableColumn<Client, String> coloneAdresse;

    @FXML
    private TableColumn<Client, String> coloneTele;

    @FXML
    private TableColumn<Client, String> coloneEmail;

    @FXML
    private Label lblAction;

    private ObservableList<Client> list;


    @FXML
    private ImageView reduce;

    @FXML
    private JFXTextField txtRecherche;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnAction;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnAjouter;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            cliDao = Main.getDaos().getClientDao();
            clientVector = cliDao.selectAll();
            remplirTable(clientVector);
            ControllerOperationClient.clientSelected = tableClient.getSelectionModel().getSelectedItem();


            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            if(role.equals("dentiste")){
                btnAjouter.setVisible(false);
                btnAction.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
            }

            tableClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {
            @Override
            public void changed(ObservableValue<? extends Client> observableValue, Client client, Client t1) {

                btnAction.setDisable(t1 == null);
                btnUpdate.setDisable(t1 == null);
                btnDelete.setDisable(t1 == null);

            }
        });

            if(role.equals("dentiste")){
               lblAction.setText("\t    Visite du client");
            }

    }


    public void ajouterOnAction(ActionEvent event) throws IOException {
        if(role.equals("infermier"))
             switchStage("/resource/fxml/AjouterClientDocument.fxml",600,607);

        }

    public void modifierOnAction(ActionEvent event) throws IOException {
            switchStage("/resource/fxml/ModifierClientDcument.fxml",600,607);
    }

    public void actionOnAction(ActionEvent event) throws IOException {
            switchStage("/resource/fxml/RendezVousClientDocument.fxml",600,607);
        }

    public void supprimerOnAction(ActionEvent event) throws IOException {
        client = ControllerOperationClient.getClient();

            alertConfirmation("Voulez vous vraiment supprimer le client : ");
            if (b) {
                message("/resource/Icons/success.png", "SUCCESS", "Le Cient " + client.getFullName() + " Est supprimer");
                tableClient.getItems().removeAll(client);
                tableClient.refresh(); }
            else {
                message("/resource/Icons/failed.png", "ERROR", "Le Cient " + client.getFullName() + " n\'est pas  supprimer");
            }


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
        confirmer.setContentText(information+" "+clientSelected.getFullName());
        Optional<ButtonType> result = confirmer.showAndWait();
        if (result.get() == ButtonType.OK) {
            if(role.equals("infermier"))
                b = cliDao.delete(client.getId());
            else
                b=visiteDao.delete(client.getId());
            System.out.println();
        } else {
            b = false;
        }
    }


    @FXML
    void searchEvent() {
        String key = txtRecherche.getText();
        Vector<Client> clients = new Vector<>();
        try {
            clients = cliDao.findThatContains(key);
        } catch (Exception e) {
            e.printStackTrace();

        }
        refreshTable(clients);
    }

    public void btncloseOnMouseEvent(MouseEvent event){
        close(event);
    }
    public void btnreduceOnMouseEvent(MouseEvent event){reduce();}

    public void remplirTable(Vector<Client> clientVector){
        list = FXCollections.observableArrayList(clientVector);
        coloneCin.setCellValueFactory(new PropertyValueFactory<Client, String>("Cin"));
        coloneFullName.setCellValueFactory(new PropertyValueFactory<Client, String>("FullName"));
        coloneAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("Address"));
        coloneTele.setCellValueFactory(new PropertyValueFactory<Client, String>("Tele"));
        coloneEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("Email"));
        tableClient.setItems(list);
    }

    public void refreshTable(Vector<Client> clientVector){
        tableClient.getItems().setAll(clientVector);
    }
    public void tableOnMousePresseed(MouseEvent event) throws IOException {
        ControllerOperationClient.clientSelected=tableClient.getSelectionModel().getSelectedItem();
        if(role.equals("dentiste"))
            switchStage("/resource/fxml/TraitementClientDocument.fxml",600,712);
    }

    public static Client getClient(){
        return clientSelected;
    }
    public void switchStage(String name ,double width , double height ) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, width, height));

        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDDEN, windowEvent -> {
            cliDao.refresh();
            clientVector = cliDao.findAll();
            refreshTable(clientVector);
        });
        primaryStage.showAndWait();
    }
    public void close(Event event){
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void reduce(){
        Stage stage =(Stage)reduce.getScene().getWindow();
        stage.toBack();
    }

}
