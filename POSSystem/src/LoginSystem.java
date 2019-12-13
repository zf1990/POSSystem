//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class LoginSystem {
//	// private static File _storageFile;
//
//	private static String _pathToStorageFile = "C:\\Users\\fadib\\eclipse-workspace\\PSO\\src\\DataStorage.csv";
//
//	public LoginSystem() {
//		// _storageFile = new File(_pathToStorageFile);
//	}
//
//	public static void main(String[] args) throws IOException {
//		// create credentials storage file if does not exist
//		CreateStorageFile();
//
//		// register a new user
//		User newUser = GetTestUserData();
//		CreateUser(newUser);
//		CreateUser(newUser);
//
//		// login for an existing user
//		String[] existingUserCredentials = GetTestUserCredentials();
//		Boolean isUserAuthenticated = AuthenticateUser(existingUserCredentials[0], existingUserCredentials[1]);
//	}
//
//	private static ArrayList<User> ReadLoginData() throws IOException {
//		String row;
//
//		ArrayList<User> storedUsers = new ArrayList<User>();
//
//		BufferedReader csvReader = new BufferedReader(new FileReader(_pathToStorageFile));
//
//		while ((row = csvReader.readLine()) != null) {
//			String[] userData = row.split(",");
//
//			User rowUser = new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
//
//			storedUsers.add(rowUser);
//		}
//
//		csvReader.close();
//
//		return storedUsers;
//	}
//
//	private static void CreateStorageFile() throws IOException {
//		File storageFile = new File(_pathToStorageFile);
//
//		// Create the file
//		if (storageFile.createNewFile()) {
//			System.out.println("Storage File is created!");
//		} else {
//			System.out.println("Storage File already exists.");
//
//			return;
//		}
//
//		// Write Content
//		FileWriter storageFileWriter = new FileWriter(storageFile);
//		storageFileWriter.append("FirstName");
//		storageFileWriter.append(",");
//		storageFileWriter.append("LastName");
//		storageFileWriter.append(",");
//		storageFileWriter.append("UserName");
//		storageFileWriter.append(",");
//		storageFileWriter.append("Password");
//		storageFileWriter.append(",");
//		storageFileWriter.append("EmailAddress");
//		storageFileWriter.append(",");
//		storageFileWriter.append("PhoneNumber");
//		storageFileWriter.append("\n");
//
//		storageFileWriter.flush();
//		storageFileWriter.close();
//	}
//
//	private static void CreateUser(User user) throws IOException {
//
//		if (DoesUserExist(user).equals(true)) {
//			return;
//		}
//
//		String row;
//
//		ArrayList<User> storedUsers = new ArrayList<User>();
//
//		BufferedReader csvReader = new BufferedReader(new FileReader(_pathToStorageFile));
//
//		while ((row = csvReader.readLine()) != null) {
//			String[] userData = row.split(",");
//
//			User rowUser = new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
//
//			storedUsers.add(rowUser);
//		}
//
//		csvReader.close();
//
//		FileWriter userWriter = new FileWriter(_pathToStorageFile);
//
//		storedUsers.add(user);
//
//		for (User rowUser : storedUsers) {
//			ArrayList<String> userData = rowUser.ToArray();
//
//			userWriter.append(String.join(",", userData));
//			userWriter.append("\n");
//		}
//
//		userWriter.flush();
//		userWriter.close();
//
//		System.out.println("User has been registered!");
//	}
//
//	private static String[] GetTestUserCredentials() {
//		return new String[] { "username1", "password1" };
//	}
//
//	private static User GetTestUserData() {
//		return new User("userFirst1", "userLast1", "username1", "password1", "email1", "phone1");
//	}
//
//	private static Boolean DoesUserExist(User user) throws IOException {
//		Boolean exists = false;
//
//		BufferedReader csvReader = new BufferedReader(new FileReader(_pathToStorageFile));
//
//		String row;
//
//		while ((row = csvReader.readLine()) != null) {
//			String[] userData = row.split(",");
//
//			if (userData[2].equals(user.GetUserName())) {
//				System.out.println("Username already exists. Please use another Username!");
//
//				exists = true;
//
//				break;
//			}
//		}
//
//		csvReader.close();
//
//		return exists;
//	}
//
//	private static Boolean DoCredentialsMatch(String username, String password) throws IOException {
//		Boolean match = false;
//
//		BufferedReader csvReader = new BufferedReader(new FileReader(_pathToStorageFile));
//
//		String row;
//
//		while ((row = csvReader.readLine()) != null) {
//			String[] userData = row.split(",");
//
//			if (userData[0].equals(username) & userData[1].equals(password)) {
//				System.out.println("Welcome " + userData[2] + " " + userData[3] + "!");
//
//				match = true;
//
//				break;
//			}
//		}
//
//		csvReader.close();
//
//		return match;
//	}
//
//	private static Boolean AuthenticateUser(String username, String password) throws IOException {
//		Boolean authenticated = false;
//
//		if (DoCredentialsMatch(username, password)) {
//
//			authenticated = true;
//		} else {
//			System.out.println("companiation of UserName and Password is invalid ");
//		}
//
//		return authenticated;
//	}
//}
