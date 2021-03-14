package application.main;

import application.DbConnection.DbConnection;
import application.dal.model.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static DbConnection daos;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginDocument.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 777, 559));
        primaryStage.show();

        daos = new DbConnection();

        boolean check = daos.getClientDao().insert(new Client(0l, "efsef", "dsfsdf", "dsfsdf", "dsfsdf", "dsfsdf"));
        if (check) {
            System.out.println("545774784797 successfuly");
        } else
            System.out.println("565464564sd6fv4s6d4fv4x6");
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static DbConnection getDaos() {
        return daos;
    }
}
