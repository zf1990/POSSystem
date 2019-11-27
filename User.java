import java.util.ArrayList;

public class User {

	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	private String EmailAddress;
	private String PhoneNumber;

	public User(String userName, String password, String firstName, String lastName, String emailAddress,
			String phoneNumber) {

		this.UserName = userName;
		this.Password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.EmailAddress = emailAddress;
		this.PhoneNumber = phoneNumber;

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
	
	public ArrayList<String> ToArray() {
		ArrayList<String> propertyArray = new ArrayList<String>();
		propertyArray.add(this.FirstName);
		propertyArray.add(this.LastName);
		propertyArray.add(this.UserName);
		propertyArray.add(this.Password);
		propertyArray.add(this.EmailAddress);
		propertyArray.add(this.PhoneNumber);

		return propertyArray;
	}
}