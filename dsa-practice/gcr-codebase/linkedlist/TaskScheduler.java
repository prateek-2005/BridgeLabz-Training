class TaskNode {
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	TaskNode next;

	TaskNode(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
	}
}

public class TaskScheduler {
	TaskNode head = null;
	TaskNode tail = null;
	TaskNode current = null;

	public void addAtBeginning(TaskNode node) {
		if (head == null) {
			head = tail = node;
			node.next = head;
			current = head;
		} else {
			node.next = head;
			head = node;
			tail.next = head;
		}
	}

	public void addAtEnd(TaskNode node) {
		if (head == null) {
			head = tail = node;
			node.next = head;
			current = head;
		} else {
			tail.next = node;
			tail = node;
			tail.next = head;
		}
	}

	public void addAtSpecificPosition(TaskNode node, int position) {
		if (position <= 1 || head == null) {
			addAtBeginning(node);
			return;
		}
		TaskNode temp = head;
		for (int i = 1; i < position - 1 && temp.next != head; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		if (temp == tail) {
			tail = node;
			tail.next = head;
		}
	}

	public void deleteByTaskId(int taskId) {
		if (head == null) {
			System.out.println("No tasks to delete.");
			return;
		}
		TaskNode temp = head;
		TaskNode prev = tail;
		while (true) {
			if (temp.taskId == taskId) {
				if (head == tail) {
					head = tail = null;
				} else if (temp == head) {
					head = head.next;
					tail.next = head;
				} else if (temp == tail) {
					tail = prev;
					tail.next = head;
				} else {
					prev.next = temp.next;
				}
				System.out.println("Task deleted successfully.");
				return;
			}
			prev = temp;
			temp = temp.next;
			if (temp == head) {
				break;
			}
		}
	}

	public void viewCurrent() {
		if (current == null) {
			System.out.println("No tasks available.");
			return;
		}

		System.out.println("Current Task:");
		System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: "
				+ current.priority + ", Due Date: " + current.dueDate);
		current = current.next;
	}
	public void displayAllTasks() {
	    if (head == null) {
	        System.out.println("No tasks");
	        return;
	    }
	    TaskNode temp = head;
	    while (true) {
	    	System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: "
					+ temp.priority + ", Due Date: " + temp.dueDate);
	        temp = temp.next;
	        if (temp == head) {
	            break;
	        }
	    }
	}
	public void searchByPriority(int priority) {
	    if (head == null) {
	        System.out.println("No tasks available.");
	        return;
	    }
	    TaskNode temp = head;
	    boolean found = false;
	    while (true) {
	        if (temp.priority == priority) {
	        	System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: "
						+ temp.priority + ", Due Date: " + temp.dueDate);
	            found = true;
	        }
	        temp = temp.next;
	        if (temp == head) {
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("No tasks found");
	    }
	}
	public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtBeginning(new TaskNode(1, "Design Module", 1, "2025-01-10"));
        scheduler.addAtEnd(new TaskNode(2, "Code Review", 2, "2025-01-12"));
        scheduler.addAtSpecificPosition(new TaskNode(3, "Testing", 1, "2025-01-15"), 2);
        scheduler.addAtEnd(new TaskNode(4, "Deployment", 3, "2025-01-20"));
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();
        System.out.println("Search by Priority 1:");
        scheduler.searchByPriority(1);
        System.out.println("\nView current task:");
        scheduler.viewCurrent();
        scheduler.viewCurrent();
        scheduler.deleteByTaskId(2);
        System.out.println("\nTasks after deletion:");
        scheduler.displayAllTasks();
    }

}
