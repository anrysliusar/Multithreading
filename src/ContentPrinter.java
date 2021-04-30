import java.util.concurrent.atomic.AtomicBoolean;

public class ContentPrinter implements Runnable{
    private LineStorage lineStorage;
    private AtomicBoolean isLinePrinted;

    public ContentPrinter(LineStorage lineStorage, AtomicBoolean isLinePrinted) {
        this.lineStorage = lineStorage;
        this.isLinePrinted = isLinePrinted;
    }

    @Override
    public void run() {
        synchronized (lineStorage){
            while (!lineStorage.isFinished().get()){
                System.out.println("2");
                while (isLinePrinted.get()){
                    try{
                        System.out.println("3");

                        lineStorage.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(lineStorage.getLine());
                isLinePrinted.set(true);
                lineStorage.notifyAll();
            }
        }
        System.out.println("Printer finished");

    }
}
