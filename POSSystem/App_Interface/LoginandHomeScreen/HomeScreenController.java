package App_Interface.LoginandHomeScreen;

import App_Interface.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {

        @FXML
        private Button Logout;

        @FXML
        private Button POS_Button;

        @FXML
        private Button Item_Button;

        @FXML
        private Button User_Button;

        @FXML
        private Button Inventory_Button;

         @FXML
         private Label localDateTime;



    @FXML
        private void handleButtonClicks (ActionEvent actionEvent)
        {
            Object button = actionEvent.getSource();
            if ( button == POS_Button)
            {
                loadStages( "/App_Interface/POS/POS_main.fxml" );
            }
            else if ( button == Item_Button)
            {
               loadStages( "/App_Interface/Item/ItemsList.fxml" );
            }

            else if ( button == Inventory_Button)
            {
                loadStages( "/App_Interface/Inventory/InventoryReport.fxml" );
            }
            else if ( button == User_Button)
            {
                loadStages( "/App_Interface/Users/UserMain.fxml" );
            }

            else if(button == Logout)
            {
                loadStages( "/App_Interface/LoginandHomeScreen/Login.fxml" );
            }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTime();

    }

//===================================================================================================================================================

    private void initTime(){
        initTime( localDateTime );
    }

    public static void initTime(Label localDateTime) {
        Timeline clock = new Timeline(new KeyFrame( Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss");
            localDateTime.setText( LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount( Animation.INDEFINITE);
        clock.play();
    }


    private void loadStages(String fxml)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource(fxml));
            Stage homeScreenStage;
            Scene homeScreenScene = new Scene( window1 );
            homeScreenStage = Main.mainStage;
            homeScreenStage.setScene( homeScreenScene );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


