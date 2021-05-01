import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LineStorage lineStorage = new LineStorage();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/lines.txt"));

        ContentPrinter contentPrinter = new ContentPrinter(lineStorage);
        ContentReader contentReader = new ContentReader(lineStorage, bufferedReader);

        Thread printer = new Thread(contentPrinter);
        Thread reader = new Thread(contentReader);

        reader.start();
        printer.start();
    }
}
