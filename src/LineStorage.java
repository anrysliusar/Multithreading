import java.util.concurrent.atomic.AtomicBoolean;

public class LineStorage {
    private String line = "";
    private AtomicBoolean finished = new AtomicBoolean(false);

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public AtomicBoolean isFinished() {
        return finished;
    }

}
