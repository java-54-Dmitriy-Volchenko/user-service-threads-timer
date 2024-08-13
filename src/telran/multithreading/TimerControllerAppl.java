package telran.multithreading;

import java.util.Scanner;

public class TimerControllerAppl {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time format (for example - HH:mm:ss): ");
        String timeFormat = scanner.nextLine();
        System.out.print("Enter timer resolution in milliseconds: ");
        
        Timer timer = null;
        long resolutionMillis = 0;
        
        int counter = 3;
        boolean validInput = false;

        while (counter > 0 && validInput != true) {
            try {
                resolutionMillis = Long.parseLong(scanner.nextLine());
                timer = new Timer(timeFormat, resolutionMillis);
                validInput = true;
             
            } catch (NumberFormatException e) {
                System.out.println("Resolution must be a valid number. Try again!");
                counter--;
                if (counter == 0) {
                    System.out.println("You have exhausted all attempts. By-by!!!");
                    scanner.close();
                    return;
                }
            }
        }

        if (validInput && timer != null) {
            timer.start();

            Thread.sleep(5000);
            timer.interrupt(); 
        }

        String[] words = "I am working without timer!!!".split(" ");

        for (String word : words) {
            System.out.printf("%s ", word);
            Thread.sleep(1000); 
        }

        scanner.close();
    }
}

