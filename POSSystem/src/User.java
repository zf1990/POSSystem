
import java.util.ArrayList;
import java.util.HashMap;

public class User {

	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String PhoneNumber;
	private String ChangeUserName;
	private String ChangePassword;
	private Roles role;
	private int UserID;
	private static ArrayList<User> users = new ArrayList<User>();
	private static HashMap<Integer, User> userDict = new HashMap<Integer,User>();

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
		
		addtoCollections();
		
	}
	private void addtoCollections() {
		users.add(this);
		userDict.put(UserID, this);
	}
	public static void removeUser(int _UserID) {
		User person = userDict.get(_UserID);
		userDict.remove(person);
		users.remove(person);
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

	public int UserID() {
		return this.UserID;
	}

	public String GetUserName() {
		return this.UserName;
	}

	public String GetPassword() {
		return this.Password;
	}

	public String GetFirstName() {
		return this.FirstName;
	}

	public String GetLastName() {
		return this.LastName;
	}

	public String ChangeUserName(String UserName) {
		return this.ChangeUserName;
	}

	public String ChangePassword(String Password) {
		return this.ChangePassword;
	}
	
	public static ArrayList<User> getUserList() {
		return users;
	}

	public String toString() {
		return FirstName + " " + LastName + " " + PhoneNumber + " " + EmailAddress;
	}
}
