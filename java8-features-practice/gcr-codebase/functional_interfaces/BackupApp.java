package functional_interfaces;

interface BackupSerializable {
}

class UserData implements BackupSerializable {
	String username;

	UserData(String username) {
		this.username = username;
	}
}

class TransactionData implements BackupSerializable {
	int transactionId;

	TransactionData(int transactionId) {
		this.transactionId = transactionId;
	}
}

class TempCache {
	String cacheData = "temp";
}

public class BackupApp {

	static void processBackup(Object obj) {
		if (obj instanceof BackupSerializable) {
			System.out.println(obj.getClass().getSimpleName() + " is eligible for backup");
		} else {
			System.out.println(obj.getClass().getSimpleName() + " is NOT eligible for backup");
		}
	}

	public static void main(String[] args) {

		UserData user = new UserData("Amit");
		TransactionData txn = new TransactionData(101);
		TempCache cache = new TempCache();

		processBackup(user);
		processBackup(txn);
		processBackup(cache);
	}
}
