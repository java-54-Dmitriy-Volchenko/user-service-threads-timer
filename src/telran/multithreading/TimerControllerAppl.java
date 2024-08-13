package telran.multithreading;

public class TimerControllerAppl {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer("HH:mm:ss", 1000);
        timer.start();

        Thread.sleep(5000);
        timer.interrupt();

        String[] words = "I am working without timer!".split(" ");

     
        for (String word : words) {
            System.out.printf("%s ", word);
            Thread.sleep(1000);
        }
    }
    
}
