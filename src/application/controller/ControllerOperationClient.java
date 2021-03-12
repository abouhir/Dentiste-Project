package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOperationClient implements Initializable {
    @FXML
    private ImageView close;

    @FXML
    private ImageView reduce;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void btncloseOnMouseEvent(MouseEvent event){
        close();
    }
    public void btnreduceOnMouseEvent(MouseEvent event){reduce();}

    public void close(){
        Stage stage =(Stage)close.getScene().getWindow();
        stage.close();
    }
    public void reduce(){
        Stage stage =(Stage)reduce.getScene().getWindow();
        stage.toBack();
    }
}
