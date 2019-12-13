package App_Interface.POS;

import App_Interface.LoginandHomeScreen.HomeScreenController;
import App_Interface.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReturnSalesController implements Initializable {

//    @FXML
//    private TableView<?> productTableView;
//
//    @FXML
//    private TableColumn<?, ?> productColumn;
//
//    @FXML
//    private TableView<?> listTableView;
//
//    @FXML
//    private TableColumn<?, ?> itemColumn;
//
//    @FXML
//    private TableColumn<?, ?> priceColumn;
//
//    @FXML
//    private TableColumn<?, ?> quantityColumn;
//
//    @FXML
//    private TableColumn<?, ?> totalColumn;
//
//    @FXML
//    private Button addButton;
//
//    @FXML
//    private Button removeButton;
//
//    @FXML
//    private Button resetButton;
//
//    @FXML
//    private TextField productField;
//
//    @FXML
//    private TextField priceField;
//
//    @FXML
//    private TextArea descriptionArea;
//
//    @FXML
//    private TextField quantityField;
//
//    @FXML
//    private Label quantityLabel;
//
//    @FXML
//    private TextField subTotalField;
//
//    @FXML
//    private TextField vatField;
//
//    @FXML
//    private TextField netPayableField;
//
//    @FXML
//    private Button paymentButton;
//
//    @FXML
//    private Label Username_Label;
//
    @FXML
    private Label localDateTime;

//    @FXML
//    private Button Item_Button;
//
//    @FXML
//    private Button Sales_Button;
//
//    @FXML
//    private Button User_Button;
//
//    @FXML
//    private Button Home_Button;
//
//    @FXML
//    private Button Inventory_Button;

    @FXML
    private Button Logout;



    @FXML
   public void handleButtonClicks(ActionEvent actionEvent)
        {
//        if ( actionEvent.getSource() == Home_Button)
//        {
//            loadStages( "/Dashboard/HomeScreen.fxml" );
//        }
//        else if ( actionEvent.getSource() == Item_Button)
//        {
//            loadStages( "/Dashboard/Item/ItemsList.fxml" );
//        }
//        else if ( actionEvent.getSource() == User_Button)
//        {
//            loadStages( "/Dashboard/Users/UserMain.fxml" +
//                    ".fxml" );
//        }
//        else if ( actionEvent.getSource() == Sales_Button)
//        {
//            loadStages( "/Dashboard/POS/Sales.fxml" );
//        }
//        else if ( actionEvent.getSource() == Inventory_Button)
//        {
//            loadStages( "/Dashboard/Inventory/InventoryReport.fxml" );
//        }
            if (actionEvent.getSource() == Logout)
            {
                loadStages();
            }

        }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTime();
    }


    private void initTime(){
        HomeScreenController.initTime( localDateTime );
    }


    private void loadStages()
    {
        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource( "/App_Interface/LoginandHomeScreen/Login.fxml" ));
            Stage homeScreenStage;
            Scene homeScreenScene = new Scene( window1 );
            homeScreenStage = Main.mainStage;
            homeScreenStage.setScene( homeScreenScene );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
