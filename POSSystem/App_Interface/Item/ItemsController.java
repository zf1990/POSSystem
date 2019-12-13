package App_Interface.Item;

import App_Interface.LoginandHomeScreen.HomeScreenController;
import App_Interface.Main;
import Java.Inventory;
import Java.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ResourceBundle;

public class ItemsController implements Initializable {
    @FXML
    private Button Logout;

    @FXML
    private Button POS_Button;

    @FXML
    private Button Home_Button;

    @FXML
    private Button User_Button;

    @FXML
    private Button Sales_Button;

    @FXML
    private Button Inventory_Button;

    @FXML
    private Button AddUser_Button;

    @FXML
    private Label localDateTime;
    @FXML
    private TextField Name_T;

    @FXML
    private PasswordField Supplier_T;

    @FXML
    private TextField Quantity_Textfield;

    @FXML
    private TextField Thresshold_Textfield;

    @FXML
    private TextField Price_Textfield;

    @FXML
    private TextField ItemID_Textfield;

    @FXML
    private TextField OrderQuantity_Textfield;
    @FXML
    private TableView<Item> tableView;
//    String name, String supplier, Number Quantity, Number Threshhold, double pricePerUnit, int ItemID, Number orderQuantity
    public TableColumn<Item, String> columname;
    public TableColumn<Item, String> columnsupplier;
    public TableColumn<Item, Number> columnQuatity;
    public TableColumn<Item, Number> columnThreshold;
    public TableColumn<Item, Double> columnpricePerUnit;
    public TableColumn<Item, Integer> columnItemID;
    public TableColumn<Item, Number> columnorderQuantity;




    @FXML
    private void handleButtonClicks (javafx.event.ActionEvent actionEvent) throws ParseException {
        if ( actionEvent.getSource() == Home_Button)
        {
            loadStages( "/App_Interface/LoginandHomeScreen/HomeScreen.fxml" );
        }
        else if ( actionEvent.getSource() == POS_Button)
        {
            loadStages( "/App_Interface/POS/NewSales.fxml" );
        }
        else if ( actionEvent.getSource() == User_Button)
        {
            loadStages( "/App_Interface/Users/UserMain.fxml" );
        }
        else if ( actionEvent.getSource() == Sales_Button)
        {
            loadStages( "/App_Interface/POS/Sales.fxml" );
        }
        else if ( actionEvent.getSource() == Inventory_Button)
        {
            loadStages( "/App_Interface/Inventory/InventoryReport.fxml" );
        }
        else if (actionEvent.getSource() == Logout)
        {
            loadStages( "/App_Interface/LoginandHomeScreen/Login.fxml" );
        }
        if (actionEvent.getSource() == AddUser_Button) {
//            String name, String supplier, Number Quantity, Number Threshhold, double pricePerUnit, int ItemID, Number orderQuantity
            addItem();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTime();
        columname.setCellValueFactory( new PropertyValueFactory<>( "Name" ) );
        columnsupplier.setCellValueFactory( new PropertyValueFactory<>( "Supplier" ) );
        columnQuatity.setCellValueFactory( new PropertyValueFactory<>( "Quantity" ) );
        columnThreshold.setCellValueFactory( new PropertyValueFactory<>( "Threshold" ) );
        columnpricePerUnit.setCellValueFactory( new PropertyValueFactory<>( "Price per Unit" ) );
        columnItemID.setCellValueFactory( new PropertyValueFactory<>( "ItemID" ) );
        columnorderQuantity.setCellValueFactory( new PropertyValueFactory<>( "Order Quantity" ) );

    }


    private void initTime(){
        HomeScreenController.initTime( localDateTime );
    }

    private void addItem(){
        try{
            String name = Name_T.getText();
            String supplier = Supplier_T.getText();
            Number  Quantity = NumberFormat.getInstance().parse(Quantity_Textfield.getText());
            Number Threshhold = NumberFormat.getInstance().parse(Thresshold_Textfield.getText());
            double pricePerUnit = Double.valueOf( Price_Textfield.getText());
            int ItemID = Integer.parseInt( ItemID_Textfield.getText() );
            Number orderQuantity =  NumberFormat.getInstance().parse(OrderQuantity_Textfield.getText());


            Item newItem = new Item( name, supplier, Quantity, Threshhold, pricePerUnit,ItemID, orderQuantity);
            tableView.getItems().add( newItem );

            Name_T.clear( );
            Supplier_T.clear( );
            Quantity_Textfield.clear( );
            Thresshold_Textfield.clear( );
            Price_Textfield.clear( );
            ItemID_Textfield.clear();
            OrderQuantity_Textfield.clear( );

            Inventory.addToInventory( newItem );

        } catch (ParseException e) {
            e.printStackTrace();
        }

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
