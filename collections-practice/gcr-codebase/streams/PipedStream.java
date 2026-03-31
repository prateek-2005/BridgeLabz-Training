import java.io.*;
public class PipedStream {
    public static void main(String[] args) {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();
            pos.connect(pis);
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!";
                    pos.write(message.getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Pipe connection error: " + e.getMessage());
        }
    }
}
