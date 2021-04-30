import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LineStorage lineStorage = new LineStorage();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/lines.txt"));

        AtomicBoolean isLinePrinted = new AtomicBoolean(false);

        ContentPrinter contentPrinter = new ContentPrinter(lineStorage, isLinePrinted);
        ContentReader contentReader = new ContentReader(lineStorage, bufferedReader, isLinePrinted);

        Thread reader = new Thread(contentReader);
        Thread printer = new Thread(contentPrinter);

        reader.start();
        printer.start();
    }
}
