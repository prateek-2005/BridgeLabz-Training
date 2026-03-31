import java.util.*;

class StageNode{
	String stage;
	StageNode next;
	
	StageNode(String stage){
		this.stage=stage;
	}
}

class Tracker{
	private StageNode head;
	private StageNode current;
	
	public Tracker() {
		addStage("Packed");
		addStage("Shipped");
		addStage("In Transit");
		addStage("Out for Delivery");
		addStage("Delivered");
		current=head;
	}
	
	private void addStage(String stage) {
		StageNode newNode=new StageNode(stage);
		if(head==null) {
			head=newNode;
			return;
		}
		StageNode temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
	
	public void trackParcel() {
		if(current==null) {
			System.out.println("Parcel Lost");
		}
		else {
			System.out.println("Current Status: "+current.stage);
		}
	}
	
	public void moveNext() {
		if(current==null) {
			System.out.println("Parcel already lost.");
		}
		else if(current.next==null) {
			System.out.println("Parcel already Delivered.");
		}
		else {
			current=current.next;
			System.out.println("Parcel moved to next stage.");
		}
	}
	public void addCheckpoint(String afterStage,String newStage) {
		StageNode temp=head;
		while(temp!=null && !temp.stage.equalsIgnoreCase(afterStage)){
			temp=temp.next;
		}
		if(temp==null) {
			System.out.print("Stage not found");
			return;
		}
		StageNode node=new StageNode(newStage);
		node.next=temp.next;
		temp.next=node;
		System.out.println("Checkpoint added successfully.");
	}
	
	public void markLost() {
		current=null;
		System.out.println("Parcel Marked as Lost.");
	}
}
public class ParcelTracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Tracker tracker = new Tracker();
        while (true) {
            System.out.println("\n====== Parcel Tracking System ======");
            System.out.println("1. Track Parcel Status");
            System.out.println("2. Move to Next Stage");
            System.out.println("3. Add Custom Checkpoint");
            System.out.println("4. Mark Parcel as Lost");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    tracker.trackParcel();
                    break;
                case 2:
                    tracker.moveNext();
                    break;
                case 3:
                    System.out.print("Add after which stage? ");
                    String after = sc.nextLine();
                    System.out.print("Enter new checkpoint name: ");
                    String newStage = sc.nextLine();
                    tracker.addCheckpoint(after, newStage);
                    break;
                case 4:
                    tracker.markLost();
                    break;
                case 5:
                    System.out.println("System Closed");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
	}

}
