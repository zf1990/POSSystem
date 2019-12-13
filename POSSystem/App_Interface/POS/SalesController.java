package App_Interface.POS;

import App_Interface.LoginandHomeScreen.HomeScreenController;
import App_Interface.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalesController implements Initializable {
    @FXML
    private Label localDateTime;

    @FXML
    private Button POS_Button;

    @FXML
    private Button Item_Button;

    @FXML
    private Button User_Button;

    @FXML
    private Button Home_Button;

    @FXML
    private Button Inventory_Button;

    @FXML
    private TextArea Textarea;

    @FXML
    private Button Logout;



    @FXML
    private void handleButtonClicks (ActionEvent actionEvent)
    {
        if ( actionEvent.getSource() == Home_Button)
        {
            loadStages( "/App_Interface/LoginandHomeScreen/HomeScreen.fxml" );
        }
        else if ( actionEvent.getSource() == POS_Button)
        {
            loadStages( "/App_Interface/POS/POS_main.fxml" );
        }
        else if ( actionEvent.getSource() == Item_Button)
        {
            loadStages( "/App_Interface/Item/ItemsList.fxml" );
        }
        else if ( actionEvent.getSource() == Inventory_Button)
        {
            loadStages( "/App_Interface/Inventory/InventoryReport.fxml" );
        }
        else if ( actionEvent.getSource() == User_Button)
        {
            loadStages( "/App_Interface/Users/UserMain.fxml" );
        }
        else if (actionEvent.getSource() == Logout)
        {
            loadStages( "/App_Interface/LoginandHomeScreen/Login.fxml" );
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTime();
    }


    private void initTime(){
        HomeScreenController.initTime( localDateTime );
    }

    private void updateTextArea(){
        Textarea.setText( null );
//        List<Item>

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
