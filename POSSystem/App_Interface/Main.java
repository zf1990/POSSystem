package App_Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mainStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        try {
            mainStage = primaryStage;
            Parent root = FXMLLoader.load( getClass().getResource( "/App_Interface/LoginandHomeScreen/Login.fxml" ) );
            primaryStage.setTitle( "6P0S2" );
            primaryStage.setScene( new Scene( root ) );
            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Stage getPrimaryStage() {
        return mainStage;
    }
}
