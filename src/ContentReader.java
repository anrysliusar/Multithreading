import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContentReader implements Runnable{
    private LineStorage lineStorage;
    private BufferedReader bufferedReader;
    private AtomicBoolean isLinePrinted;


    public ContentReader(LineStorage lineStorage, BufferedReader bufferedReader, AtomicBoolean isLinePrinted) {
        this.lineStorage = lineStorage;
        this.bufferedReader = bufferedReader;
        this.isLinePrinted = isLinePrinted;
    }

    @Override
    public void run() {
        String line;
        synchronized (lineStorage){
            try {

                while ((line = bufferedReader.readLine()) != null){
                    lineStorage.setLine(line);
                    lineStorage.notifyAll();
                    System.out.println("1");
                    try {
                        lineStorage.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        lineStorage.isFinished().set(true);
        isLinePrinted.set(false);
        lineStorage.notifyAll();
    }
}
