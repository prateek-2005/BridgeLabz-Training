package filebackupscheduler;
import java.util.*;
class BackupScheduler {
    private PriorityQueue<BackupTask> queue = new PriorityQueue<>();
    public void scheduleBackup(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Backup path cannot be empty!");
        }
        queue.add(new BackupTask(path, priority));
        System.out.println("Backup scheduled for: " + path);
    }
    public void executeBackups() {
        if (queue.isEmpty()) {
            System.out.println("No backup tasks available.");
            return;
        }
        System.out.println("\nExecuting backups (priority order):");
        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Backing up: " + task.getFolderPath()
                    + " | Priority: " + task.getPriority());
        }
    }
}
