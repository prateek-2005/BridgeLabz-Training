package Set1;
import java.util.*;

class FileVersion {
    private String version;
    private int size;
    private int uploadOrder;

    public FileVersion(String version, int size, int uploadOrder) {
        this.version = version;
        this.size = size;
        this.uploadOrder = uploadOrder;
    }

    public String getVersion() {
        return version;
    }

    public int getSize() {
        return size;
    }

    public int getUploadOrder() {
        return uploadOrder;
    }
}

class FileData {

    private String fileName;
    private List<FileVersion> versions;

    public FileData(String fileName) {
        this.fileName = fileName;
        versions = new ArrayList<>();
    }

    public void uploadVersion(String version, int size, int order) {

        for (FileVersion v : versions) {
            if (v.getVersion().equals(version))
                return; // ignore duplicate version
        }

        versions.add(new FileVersion(version, size, order));
    }

    public void fetchVersions() {

        List<FileVersion> list = new ArrayList<>(versions);

        Collections.sort(list, (a, b) -> {
            if (a.getSize() != b.getSize())
                return a.getSize() - b.getSize();
            return a.getVersion().compareTo(b.getVersion());
        });

        for (FileVersion v : list) {
            System.out.println(fileName + " " + v.getVersion() + " " + v.getSize());
        }
    }

    public void latestVersion() {

        FileVersion latest = null;

        for (FileVersion v : versions) {
            if (latest == null || v.getUploadOrder() > latest.getUploadOrder())
                latest = v;
        }

        System.out.println(fileName + " " + latest.getVersion() + " " + latest.getSize());
    }

    public void totalStorage() {

        int total = 0;

        for (FileVersion v : versions)
            total += v.getSize();

        System.out.println(fileName + " " + total);
    }
}

class FileStorageSystem {

    private Map<String, FileData> files = new HashMap<>();
    private int uploadCounter = 0;

    public void upload(String fileName, String version, int size) {

        files.putIfAbsent(fileName, new FileData(fileName));
        files.get(fileName).uploadVersion(version, size, uploadCounter++);
    }

    public void fetch(String fileName) {

        if (!files.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        files.get(fileName).fetchVersions();
    }

    public void latest(String fileName) {

        if (!files.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        files.get(fileName).latestVersion();
    }

    public void totalStorage(String fileName) {

        if (!files.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        files.get(fileName).totalStorage();
    }
}

public class VersionControlledStorageSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        FileStorageSystem system = new FileStorageSystem();

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();
            String[] parts = input.split(" ");

            String operation = parts[0];

            switch (operation) {

                case "UPLOAD":
                    system.upload(parts[1], parts[2], Integer.parseInt(parts[3]));
                    break;

                case "FETCH":
                    system.fetch(parts[1]);
                    break;

                case "LATEST":
                    system.latest(parts[1]);
                    break;

                case "TOTAL_STORAGE":
                    system.totalStorage(parts[1]);
                    break;
            }
        }
        sc.close();
    }
}