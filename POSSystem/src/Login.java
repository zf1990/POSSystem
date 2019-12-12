import java.util.*;

public class Login {
	private ArrayList<User> userList;
	private HashMap<String, String> loginInfo;
	private HashMap<String, User> userLookup;
	public Login(ArrayList<User> users) {
		userList = users;
		loginInfo = new HashMap<String, String>();
		userLookup = new HashMap<String, User>();
		populateDictionaries();
	}
	private void populateDictionaries() {
		for (User person: userList) {
			loginInfo.put(person.GetUserName(),person.GetPassword());
			userLookup.put(person.GetUserName(),person);
		}
	}
	
	public String checkLogin(String _userName, String _password) {
		String message = "";
		boolean loginSuccessful = false;
		while (loginSuccessful == false) {
			if (loginInfo.containsKey(_userName)) {
				if (loginInfo.get(_userName).equals(_password)) {
					loginSuccessful = true;
					message = "login successful";
				}
			} else {
				message = "UserName or password is incorrect, please try again";
			}
		}
		return message;
	}
	
	public String resetPassword(String _userName, String resetPassword, String resetPassword_1) {
		String message = "";
		if (loginInfo.containsKey(_userName) && resetPassword.equals(resetPassword_1)) {
			userLookup.get(_userName).ChangePassword(resetPassword);
			message = "Password set successfully.";
		} else {
			message = "Password reset failed!";
		}
		
		return message;
	}
	
	public User getLoggedInUser(String _userName) {
		return userLookup.get(_userName);
	}

}
