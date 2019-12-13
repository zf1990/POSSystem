package App_Interface.Inventory;

import App_Interface.LoginandHomeScreen.HomeScreenController;
import App_Interface.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    @FXML
    private Button Logout;

    @FXML
    private Button POS_Button;

    @FXML
    private Button Home_Button;

    @FXML
    private Button Item_Button;

    @FXML
    private Button Sales_Button;

    @FXML
    private Button User_Button;

    @FXML
    private Label localDateTime;



    @FXML
    private void handleButtonClicks (javafx.event.ActionEvent actionEvent)
    {
        if ( actionEvent.getSource() == Home_Button)
        {
            loadStages( "/App_Interface/LoginandHomeScreen/HomeScreen.fxml" );
        }
        else if ( actionEvent.getSource() == POS_Button)
        {
            loadStages( "/App_Interface/POS/NewSales.fxml" );
        }
        else if ( actionEvent.getSource() == Item_Button)
        {
            loadStages( "/App_Interface/Item/ItemsList.fxml" );
        }
        else if ( actionEvent.getSource() == Sales_Button)
        {
            loadStages( "/App_Interface/POS/Sales.fxml" );
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


    private void loadStages(String fxml)
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource(fxml));
            Stage homescreenStage;
            Scene homesreenScene = new Scene( window1 );
            homescreenStage = Main.mainStage;
            homescreenStage.setScene( homesreenScene );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
