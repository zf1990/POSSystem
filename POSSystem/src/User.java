
import java.util.ArrayList;
import java.util.HashMap;

public class User {

	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String PhoneNumber;
	private Roles role;
	public Login login;
	private int UserID;

	public User(String userName, String password, String firstName, String lastName, String emailAddress,
			String phoneNumber, Roles role, int UserID) {

		this.UserName = userName;
		this.Password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.EmailAddress = emailAddress;
		this.PhoneNumber = phoneNumber;
		this.role = role;
		this.UserID = UserID;
		login = new Login(); //Dummy line to make sure the class is initiated.
		
		addtoCollections();
		
	}
	private void addtoCollections() {
		Login.addUser(this);
	}
	public static void removeUser(int _UserID) {
		Login.removeUser(_UserID);
	}

//	public void UserDictionary() {
//		Dictionary<String, Integer> UserDictionary = new Hashtable<String, Integer>();
//
//		UserDictionary.put(UserName, UserId);
//		UserDictionary.put(Password, UserId);
//		UserDictionary.put(FirstName, UserId);
//		UserDictionary.put(LastName, UserId);
//		UserDictionary.put(PhoneNumber, UserId);
//		UserDictionary.put(EmailAddress, UserId);
//
//	}

	public int getUserID() {
		return this.UserID;
	}

	public String GetUserName() {
		return this.UserName;
	}

	public String GetPassword() {
		return this.Password;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}

	public String GetFirstName() {
		return this.FirstName;
	}

	public String GetLastName() {
		return this.LastName;
	}

	public String toString() {
		return FirstName + " " + LastName + " " + PhoneNumber + " " + EmailAddress;
	}
}
