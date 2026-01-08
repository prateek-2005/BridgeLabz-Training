class MovieNode {
	String title;
	String director;
	int year;
	double rating;
	MovieNode next;
	MovieNode prev;

	MovieNode(String title, String director, int year, double rating) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
	}
}

public class MovieManagementSystem {
	MovieNode head = null;
	MovieNode tail = null;
	int size = 0;

	public void addAtBeginning(MovieNode node) {
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	public void addAtEnd(MovieNode node) {
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	public void addAtSpecificPosition(MovieNode node, int position) {
		if (position <= 1) {
			addAtBeginning(node);
			return;
		}
		MovieNode temp = head;
		for (int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null || temp.next == null) {
			addAtEnd(node);
		} else {
			node.next = temp.next;
			node.prev = temp;
			temp.next.prev = node;
			temp.next = node;
		}
	}

	public void deleteByTitle(String title) {
		MovieNode temp = head;
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				if (temp == head) {
					head = head.next;
					if (head != null) {
						head.prev = null;
					}
				} else if (temp == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				System.out.println("MovieNode deleted successfully");
				return;
			}
			temp = temp.next;
		}
	}

	public void searchByDirector(String director) {
		MovieNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.director.equalsIgnoreCase(director)) {
				System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year
						+ ", Rating: " + temp.rating);
				found = true;
			}
			temp = temp.next;
		}

		if (!found) {
			System.out.println("No movie is directed by the director.");
		}
	}

	public void searchByRating(double rating) {
		MovieNode temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.rating == rating) {
				System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year
						+ ", Rating: " + temp.rating);
				found = true;
			}
			temp = temp.next;
		}

		if (!found) {
			System.out.println("No movies found with this rating.");
		}
	}

	public void updateRating(String title, double newRating) {
		MovieNode temp = head;
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				temp.rating = newRating;
				System.out.println("Rating updated successfully.");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Movie not found.");
	}

	public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = head;
        while (temp != null) {
        	System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year
					+ ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }
	public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = tail;
        while (temp != null) {
        	System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year
					+ ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
	public static void main(String[] args) {
		MovieManagementSystem movie=new MovieManagementSystem();
		movie.addAtBeginning(new MovieNode("Kesari","Karan",2025,7.8));
		movie.addAtEnd(new MovieNode("Dhundhar","Aditya",2025,8.5));
		movie.addAtSpecificPosition(new MovieNode("Kantara","Rishab",2025,8.2),2);
		movie.addAtBeginning(new MovieNode("Avatar", "Cameron", 2009, 7.8));
		movie.deleteByTitle("Kantara");
		movie.searchByDirector("Aditya");
		movie.searchByRating(7.8);
		movie.displayForward();
		movie.displayReverse();
		movie.updateRating("Kesari",8.0);
	}

}
