package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
    private DateTimeFormatter formatter;
    private long resolution;

    public Timer(String timeFormat, long resolutionMillis) {
        this.formatter = DateTimeFormatter.ofPattern(timeFormat);
        this.resolution = resolutionMillis;
        setDaemon(true);
    }

    public void run() {
        while (!isInterrupted()) {
            System.out.println(LocalTime.now().format(formatter));
            try {
                sleep(resolution);
            } catch (InterruptedException e) {
                interrupt(); 
            }
        }
    }
}
