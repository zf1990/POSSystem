package App_Interface.Users;

import App_Interface.LoginandHomeScreen.HomeScreenController;
import App_Interface.Main;
import Java.Login;
import Java.User;
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
import java.util.ResourceBundle;

public class UserMainController implements Initializable {

    private static String _pathToStorageFile = "src/App_Interface/Data/UserData.txt";


    @FXML
    private Button Logout;

    @FXML
    private Button POS_button;

    @FXML
    private Button Home_Button;

    @FXML
    private Button Item_button;

    @FXML
    private Button Sales_Button;

    @FXML
    private Button Inventory_Button;

    @FXML
    private Label localDateTime;

    @FXML
    private Button AddUser_Button;


    @FXML
    private Button deleteButton;


    @FXML
    private TableView<User> tableView;

    public TableColumn<User, String> columnUsername;
    public TableColumn<User, String> columnPassword;
    public TableColumn<User, String> columnFirstname;
    public TableColumn<User, String> columnLastname;
    public TableColumn<User, String> columnEmail;
    public TableColumn<User, String> columnPhone;
    public TableColumn<User, String> columnRole;
    public TableColumn<User, Number> columnUserID;

    @FXML
    private TextField Username_Textfield;
    @FXML
    private PasswordField Password_Textfield;
    @FXML
    private TextField Firstname_Textfield;
    @FXML
    private TextField Lastname_Textfield;
    @FXML
    private TextField Email_Textfield;
    @FXML
    private TextField Phone_Textfield;
    @FXML
    private TextField Role_Textfield;
    @FXML
    private TextField UserID_Textfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTime();

        columnUsername.setCellValueFactory( new PropertyValueFactory<>( "UserName" ) );
        columnPassword.setCellValueFactory( new PropertyValueFactory<>( "Password" ) );
        columnFirstname.setCellValueFactory( new PropertyValueFactory<>( "FirstName" ) );
        columnLastname.setCellValueFactory( new PropertyValueFactory<>( "LastName" ) );
        columnEmail.setCellValueFactory( new PropertyValueFactory<>( "EmailAddress" ) );
        columnPhone.setCellValueFactory( new PropertyValueFactory<>( "PhoneNumber" ) );
        columnRole.setCellValueFactory( new PropertyValueFactory<>( "Role" ) );
        columnUserID.setCellValueFactory( new PropertyValueFactory<>( "UserID" ) );
        tableView = new TableView<>(  );
        loadTable();

    }



    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent actionEvent) {
        if (actionEvent.getSource() == Home_Button) {
            loadStages( "/App_Interface/LoginandHomeScreen/HomeScreen.fxml" );
        }
        if (actionEvent.getSource() == POS_button) {
            loadStages( "/App_Interface/POS/NewSales.fxml" );
        }

        if (actionEvent.getSource() == Item_button) {
            loadStages( "/App_Interface/Item/ItemsList.fxml" );
        }

        if (actionEvent.getSource() == Sales_Button) {
            loadStages( "/App_Interface/POS/Sales.fxml" );
        }

        if (actionEvent.getSource() == Inventory_Button) {
            loadStages( "/App_Interface/Inventory/InventoryReport.fxml" );
        }
//==================================================================================================

        if (actionEvent.getSource() == AddUser_Button) {

            String userName = Username_Textfield.getText();
            String password = Password_Textfield.getText();
            String firstName = Firstname_Textfield.getText();
            String lastName = Lastname_Textfield.getText();
            String emailAddress = Email_Textfield.getText();
            String phoneNumber = Phone_Textfield.getText();
            String role =  Role_Textfield.getText();
            int UserID = Integer.parseInt( UserID_Textfield.getText() );

            User newUser = new User(userName,password,firstName, lastName, emailAddress,
                    phoneNumber, role,UserID);
            tableView.getItems().add( newUser );

            Username_Textfield.clear( );
            Password_Textfield.clear( );
            Firstname_Textfield.clear( );
            Lastname_Textfield.clear( );
            Email_Textfield.clear( );
            Phone_Textfield.clear();
            Role_Textfield.clear( );
            UserID_Textfield.clear( );

        }

//        else if ( actionEvent.getSource() == deleteButton) {
//            String employeeID = JOptionPane.showInputDialog( "Enter employee ID" );
//            if (!management.delete( employeeID ))
//                JOptionPane.showMessageDialog( null, "No employee with such ID" );
//            else {
//                updateTextArea();
//            }
//        }

        else if (actionEvent.getSource() == Logout) {
            loadStages( "/App_Interface/LoginandHomeScreen/Login.fxml" );
        }


    }


    private void initTime() {
        HomeScreenController.initTime( localDateTime );
    }

    private void loadTable() {
        Login userLogin = new Login();
        userLogin.getUserList();
    }


    private void loadStages(String fxml) {
        Parent window1;
        try {
            window1 = FXMLLoader.load( getClass().getResource( fxml ) );
            Stage homeScreenStage;
            Scene homeScreenScene = new Scene( window1 );
            homeScreenStage = Main.mainStage;
            homeScreenStage.setScene( homeScreenScene );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
