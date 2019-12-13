import java.util.*;

public class Login {
	private ArrayList<User> userList;
	private HashMap<String, String> loginInfo;
	private HashMap<String, User> userLookup;
	private User loggedInUser;
	private boolean loggedIn;
	
	public Login() {
		
		loginInfo = new HashMap<String, String>();
		userLookup = new HashMap<String, User>();
		populateDictionaries();
		loggedInUser = null;
	}
	private void populateDictionaries() {
		for (User person: userList) {
			loginInfo.put(person.GetUserName(),person.GetPassword());
			userLookup.put(person.GetUserName(),person);
		}
	}
	
	
	public String checkLogin(String _userName, String _password) {
		userList = User.getUserList();
		String message = "";
		loggedIn = false;
			if (loginInfo.containsKey(_userName)) {
				if (loginInfo.get(_userName).equals(_password)) {
					message = "login successful";
					loggedInUser = userLookup.get(_userName);
					loggedIn = true;
				}
			} else {
				message = "UserName or password is incorrect, please try again";
				loggedIn = false;
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
