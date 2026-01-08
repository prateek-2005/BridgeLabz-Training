import java.util.ArrayList;

class SocialUserNode {
	int userId;
	String name;
	int age;
	ArrayList<Integer> friends;
	SocialUserNode next;

	SocialUserNode(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.friends = new ArrayList<>();
		this.next = null;
	}
}

public class SocialMediaConnections {
	SocialUserNode head = null;
	SocialUserNode tail = null;

	public void addUser(SocialUserNode node) {
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public void addFriendConnection(int userId1, int userId2) {
		SocialUserNode u1 = findUser(userId1);
		SocialUserNode u2 = findUser(userId2);
		if (u1 == null || u2 == null) {
			System.out.println("One or both users not found");
			return;
		}
		if (!u1.friends.contains(userId2)) {
			u1.friends.add(userId2);
		}
		if (!u2.friends.contains(userId1)) {
			u2.friends.add(userId1);
		}
		System.out.println("Friend connection added successfully");
	}

	public void removeFriendConnection(int userId1, int userId2) {
		SocialUserNode u1 = findUser(userId1);
		SocialUserNode u2 = findUser(userId2);
		if (u1 == null || u2 == null) {
			System.out.println("One or both users not found");
			return;
		}
		u1.friends.remove(Integer.valueOf(userId2));
		u2.friends.remove(Integer.valueOf(userId1));
		System.out.println("Friend connection removed successfully");
	}

	public void findMutualFriends(int userId1, int userId2) {
		SocialUserNode u1 = findUser(userId1);
		SocialUserNode u2 = findUser(userId2);
		if (u1 == null || u2 == null) {
			System.out.println("One or both users not found");
			return;
		}
		boolean found = false;
		for (int id : u1.friends) {
			if (u2.friends.contains(id)) {
				System.out.println("Mutual Friend ID: " + id);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No mutual friends found");
		}
	}

	public void displayFriends(int userId) {
		SocialUserNode user = findUser(userId);
		if (user == null) {
			System.out.println("User not found");
			return;
		}
		System.out.println("Friends of " + user.name + ":");
		for (int id : user.friends) {
			System.out.println("Friend ID: " + id);
		}
	}

	public void searchByUserId(int userId) {
		SocialUserNode temp = head;
		while (temp != null) {
			if (temp.userId == userId) {
				System.out.println(temp.userId + "\t" + temp.name + "\t" + temp.age);
				return;
			}
			temp = temp.next;
		}
		System.out.println("User not found");
	}

	public void searchByName(String name) {
		SocialUserNode temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.name.equalsIgnoreCase(name)) {
				System.out.println(temp.userId + "\t" + temp.name + "\t" + temp.age);
				found = true;
			}
			temp = temp.next;
		}
		if (!found) {
			System.out.println("User not found");
		}
	}

	public void countFriends() {
		SocialUserNode temp = head;
		while (temp != null) {
			System.out.println(temp.name + " has " + temp.friends.size() + " friends");
			temp = temp.next;
		}
	}

	private SocialUserNode findUser(int userId) {
		SocialUserNode temp = head;
		while (temp != null) {
			if (temp.userId == userId) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {
		SocialMediaConnections media = new SocialMediaConnections();
		media.addUser(new SocialUserNode(1, "Prateek", 22));
		media.addUser(new SocialUserNode(2, "Dipanshu", 24));
		media.addUser(new SocialUserNode(3, "Ayush", 23));
		media.addUser(new SocialUserNode(4, "Hritik", 21));
		media.addFriendConnection(1, 2);
		media.addFriendConnection(1, 3);
		media.addFriendConnection(2, 3);
		media.addFriendConnection(2, 4);
		media.displayFriends(1);
		System.out.println("\nMutual friends between 1 and 2:");
		media.findMutualFriends(1, 2);
		System.out.println("\nSearch User:");
		media.searchByName("Bob");
		System.out.println("\nFriend Count:");
		media.countFriends();
		media.removeFriendConnection(1, 3);
		media.displayFriends(1);
	}
}