import java.util.Scanner;
import java.util.Random;

public class SnakeRaceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int position = 0;       
        int winPosition = 25;

        int snake1 = 10;
        int snake2 = 20;

        System.out.println(" Welcome to Snake Race Game!");
        System.out.println("Reach position 25 to win.\n");

        while (position < winPosition) {          
            System.out.print("Press Enter to roll dice...");
            sc.nextLine();

            int dice = random.nextInt(6) + 1;    
            System.out.println("You rolled: " + dice);

            position += dice;                   
            System.out.println("Current Position: " + position);

                        if (position == snake1) {
                System.out.println(" Snake bite! Go back 3 steps!");
                position -= 3;                  
            } else if (position == snake2) {
                System.out.println(" Big Snake bite! Go back 5 steps!");
                position -= 5;
            }
          
            if (position < 0) {
                position = 0;
            }

            System.out.println("Updated Position: " + position + "\n");
        }

        System.out.println(" Congratulations! You reached 25 and won the game!");
}
}
