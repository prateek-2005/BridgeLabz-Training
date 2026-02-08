package multithreading;
import java.util.Random;

class FileDownloader extends Thread {
    private String fileName;
    private Random random = new Random();

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            for (int progress = 0; progress <= 100; progress += 25) {
                Thread.sleep(random.nextInt(500) + 200);
                System.out.println("[" + Thread.currentThread().getName() + 
                                   "] Downloading " + fileName + ": " + progress + "%");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        FileDownloader d1 = new FileDownloader("Document.pdf");
        FileDownloader d2 = new FileDownloader("Image.jpg");
        FileDownloader d3 = new FileDownloader("Video.mp4");

        d1.start();
        d2.start();
        d3.start();

        d1.join();
        d2.join();
        d3.join();

        System.out.println("All downloads complete!");
    }
}
