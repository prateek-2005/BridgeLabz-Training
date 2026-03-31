package filebackupscheduler;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== File Backup Scheduler =====");
            System.out.println("1. Schedule Backup");
            System.out.println("2. Execute Backups");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter folder path: ");
                        String path = sc.nextLine();
                        System.out.print("Enter priority (1=Low, 2=Medium, 3=High): ");
                        int priority = sc.nextInt();
                        sc.nextLine();
                        scheduler.scheduleBackup(path, priority);
                    } catch (InvalidBackupPathException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    scheduler.executeBackups();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
