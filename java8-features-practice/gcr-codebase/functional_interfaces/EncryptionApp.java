package functional_interfaces;

interface SensitiveData {
}

class UserCredentials implements SensitiveData {
	String username;
	String password;

	UserCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

class BankAccount implements SensitiveData {
	String accountNumber;

	BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}

class PublicProfile {
	String name;

	PublicProfile(String name) {
		this.name = name;
	}
}

public class EncryptionApp {

	static void processData(Object obj) {

		if (obj instanceof SensitiveData) {
			System.out.println(obj.getClass().getSimpleName() + " → Encrypt before storage");
		} else {
			System.out.println(obj.getClass().getSimpleName() + " → No encryption needed");
		}
	}

	public static void main(String[] args) {

		UserCredentials user = new UserCredentials("admin", "pass123");
		BankAccount account = new BankAccount("1234567890");
		PublicProfile profile = new PublicProfile("Amit");

		processData(user);
		processData(account);
		processData(profile);
	}
}
