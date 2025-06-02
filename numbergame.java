import java.util.Random;
import java. util.Scanner;

public class numbergame 
{ 
    public static final int Min_Number = 1 ;
    public static final int Max_Number = 10 ;
    public static final int total_attempts = 5;
    public static int totalscore = 0;
    public static String username ;
    

    public void playgame( Scanner sc) 
    {
        Random random = new Random();
        int randomnumber = random.nextInt(Max_Number - Min_Number +1) + Min_Number; //generates new number

        System.out.println("\nHello! "+ username + ",\nNumber between "+ Min_Number + " - " + Max_Number + " has been chosen . Try to guess it ");
       
        int attempts = 0;

         while(attempts <  total_attempts)
         {
            System.out.print("\nEnter your guess number : ");
            int userguessednumber = sc.nextInt();
            attempts++;
            
            if(userguessednumber == randomnumber)
            {
                System.out.println("\nCongrats," + username +" You have guessed right number in " + attempts + " attempts ");
                totalscore += 1; 
                return ; //loop exits if guessed right 
            }
            else if(userguessednumber < randomnumber)
            {
                System.out.println("Gussed number is greater than " + userguessednumber );
            }
            else
            {
                System.out.println("Gussed number is less than " + userguessednumber);
            }

        }
           
        System.out.println("\nSorry "+username+ ".You have used all attempts. The correct number is "+randomnumber);
    
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("     WELCOME TO NUMBER GAME !     ");
        System.out.print("Enter Your name : ");
        username = sc.nextLine();

        numbergame game = new numbergame();
        
        boolean playAgain;
        do {
            game.playgame(sc); // Play another round
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
           }
            while (playAgain);

        System.out.println("\n Game Over! Your Total Score: " + totalscore); //total score based on total number of correct guessed
        System.out.println("Thanks for playing, " + username + " ! ");
        
        sc.close();
    }
}

