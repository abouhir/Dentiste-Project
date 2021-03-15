package application.controller;

import application.dal.model.Client;
import application.main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerSupprimerClient implements Initializable {
    private Client client;
    private boolean b;
    private Alert message;
    private Alert confirmer;
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
    private JFXButton btnAnnuler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        disable(txtFullName);
        disable(txtCin);
        disable(txtAdresse);
        disable(txtTele);
        disable(txtEmail);
        client = ControllerOperationClient.getClient();
        txtFullName.setText(client.getFullName());
        txtTele.setText(client.getTele());
        txtAdresse.setText(client.getAddress());
        txtCin.setText(client.getCin());
        txtEmail.setText(client.getEmail());
    }

    public void btnannulerOnAction(ActionEvent event) {
        close();
    }

    public void btnsupprimerOnAction() {
        client = new Client(ControllerOperationClient.getClient().getId(), txtFullName.getText() + "", txtCin.getText() + "", txtTele.getText() + "", txtAdresse.getText() + "", txtEmail.getText() + "");
        alertConfirmation("Voulez vous vraiment supprimer le client : ");
        if (b) {
            message("/resource/Icons/success.png", "SUCCESS", "Le Cient " + txtFullName.getText() + " Est supprimer");
            close();
        } else {
            message("/resource/Icons/failed.png", "ERROR", "Le Cient " + txtFullName.getText() + " n\'est pas  supprimer");
        }

    }

    public void message(String img, String alertType, String msg) {
        message = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) message.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource(img).toString()));
        message.setGraphic(new ImageView(this.getClass().getResource(img).toString()));
        message.setTitle(alertType);
        message.setHeaderText(null);
        message.setContentText(msg);
        message.showAndWait();
    }

    public void close() {
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }

    public void disable(JFXTextField txt) {
        txt.setDisable(true);

    }

    public void alertConfirmation(String information)
    {
        confirmer = new Alert(Alert.AlertType.CONFIRMATION);
        confirmer.setTitle("Confirmation Dialog");
        confirmer.setHeaderText(null);
        confirmer.setContentText(information+" "+txtFullName.getText());

        Optional<ButtonType> result = confirmer.showAndWait();
        if (result.get() == ButtonType.OK) {
            b = Main.getDaos().getClientDao().delete(client.getId());
        } else {
            b = false;
        }
    }

}
