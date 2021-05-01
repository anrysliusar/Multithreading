import java.util.concurrent.atomic.AtomicBoolean;

public class ContentPrinter implements Runnable{
    private final LineStorage lineStorage;


    public ContentPrinter(LineStorage lineStorage) {
        this.lineStorage = lineStorage;

    }

    @Override
    public void run() {
        synchronized (lineStorage) {
            while (!lineStorage.isFinished().get()) {
                try {
                    System.out.println(lineStorage.getLine());
                    lineStorage.isFinished().set(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lineStorage.notify();

        }
    }
}
