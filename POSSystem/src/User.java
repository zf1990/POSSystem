
import java.util.Dictionary;
import java.util.Hashtable;

public class User {

	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String PhoneNumber;
	private String ChangeUserName;
	private String ChangePassword;
	private int UserId;

	public User(String userName, String password, String firstName, String lastName, String emailAddress,
			String phoneNumber) {

		this.UserName = userName;
		this.Password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.EmailAddress = emailAddress;
		this.PhoneNumber = phoneNumber;
	}

	public void UserDictionary() {
		Dictionary<String, Integer> UserDictionary = new Hashtable<String, Integer>();

		UserDictionary.put(UserName, UserId);
		UserDictionary.put(Password, UserId);
		UserDictionary.put(FirstName, UserId);
		UserDictionary.put(LastName, UserId);
		UserDictionary.put(PhoneNumber, UserId);
		UserDictionary.put(EmailAddress, UserId);

	}

	public int UserId() {
		return this.UserId;
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

	public String toString() {
		return FirstName + " " + LastName + " " + PhoneNumber + " " + EmailAddress;
	}
}
