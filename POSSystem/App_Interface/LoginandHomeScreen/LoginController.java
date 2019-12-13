package App_Interface.LoginandHomeScreen;

import App_Interface.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;


public class LoginController implements Initializable {

//    Login loginToRegister = new Login();


    private static String _pathToStorageFile = "src/App_Interface/Data/UserData.txt";

    @FXML
    private TextField Username_Textfield;

    @FXML
    private PasswordField Password_Textfield;

    @FXML
    private Label OutputLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void handleLoginButton(ActionEvent event) throws IOException {
        
        String user = Username_Textfield.getText();      // String user pulls the username entered from the username field.
        String pass = Password_Textfield.getText();      // String pass pulls the username entered from the username field.
        
        if ((user.equals("") && pass.equals( "" ))) {
            OutputLabel.setText( "Please enter username and password" );       //Here the system tells the user that the information is incorrect by displaying on the output label in the UI.
        } else if (pass.equals("")){
            OutputLabel.setText( "Please enter password" );
        }else if (user.equals("")){
            OutputLabel.setText( "Please enter username" );
        }else{
//            User thisUser = new User(String user, String pass, String first, String last, String email, String phone, Role role, int iD);
//            loginToRegister.checkLogin(user, pass);
//            openWindow();
            loginMain();
         }
    }

//========================READ FILES===================================================
    public static boolean myHelper(String user, String password) {
        // This will reference one line at a time
        String line = null;
        boolean retVal= false;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(_pathToStorageFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //create a token based on
                String [] token=line.split(",");
                // because you know first and second word of each line in
                // given file is user and password
                if (token[0].equals(user) && token[1].equals(password)){
                    retVal=true;
                    return retVal;
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            _pathToStorageFile + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + _pathToStorageFile + "'");
        }
        return retVal;
    }


    private  void loginMain() throws IOException {

        String user = Username_Textfield.getText(); // String user pulls the username entered from the username field.
        String pass = Password_Textfield.getText(); // String user pulls the username entered from the username field.

        Scanner in = new Scanner( System.in );
        String [] log_in_array = new String[8];

        //Stores the ID and PASSWORD to the array. Now we will compare the array to the txt file to find a match
        //Must match FIELD_ONE;FIELD_TWO
        log_in_array [0] = user;
        log_in_array [1] = pass;

        // Here you can call your helper method.
        boolean foundMe = myHelper(log_in_array [0],log_in_array [1]);
        if (!foundMe){
            OutputLabel.setText( "Invalid Input" );
        }else {
            openWindow();
        }
        in.close();

    }

    private void openWindow()
    {
        System.out.println("Home Screen open");

        Parent window1;
        try {
            window1 = FXMLLoader.load(getClass().getResource( "/App_Interface/LoginandHomeScreen/HomeScreen.fxml" ));
            Stage homeScreenStage;
            Scene homeScreenScene = new Scene( window1 );
            homeScreenStage = Main.mainStage;
            homeScreenStage.setScene( homeScreenScene );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void createStorageFile() throws IOException {
        File storageFile = new File(_pathToStorageFile);

        // Create the file
        if (storageFile.createNewFile()) {
            System.out.println("Storage File is created!");
        } else {
            System.out.println("Storage File already exists.");

            return;
        }

        // Write Content
        FileWriter storageFileWriter = new FileWriter(storageFile);
        storageFileWriter.append("FirstName");
        storageFileWriter.append(",");
        storageFileWriter.append("LastName");
        storageFileWriter.append(",");
        storageFileWriter.append("UserName");
        storageFileWriter.append(",");
        storageFileWriter.append("Password");
        storageFileWriter.append(",");
        storageFileWriter.append("EmailAddress");
        storageFileWriter.append(",");
        storageFileWriter.append("PhoneNumber");
        storageFileWriter.append("\n");

        storageFileWriter.flush();
        storageFileWriter.close();
    }


}