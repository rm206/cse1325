import java.util.Scanner;
import java.io.Console; 

public class DetroitOhio 
{
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        Scanner sc = new Scanner(System.in);
        Console console = System.console(); 

        Player player1 = new Player();
        System.out.println("Welcome Player 1");
        player1.setNameAndPassword();
        
        Player player2 = new Player();
        System.out.println("Welcome Player 2");
        player2.setNameAndPassword();

        for(int i = 0 ; i < 4 ; i++)
            player1.addToCurrentDeck(deck.deal(), i);
        for(int i = 0 ; i < 4 ; i++)
            player2.addToCurrentDeck(deck.deal(), i);
        
        System.out.println("\n\nThe following cards have been dealt to the 2 players");
        System.out.println("Player 1 : ");
        player1.showCardsAndPoints();
        System.out.println("\nPlayer 2 : ");
        player2.showCardsAndPoints();        
        System.out.println("\n");

        // Game loop
        boolean player1Ended = false;
        boolean player2Ended = false;
        int choice = 0;
        String passwordToMatch = new String("");
        int turn1Or2 = -1; // This variable is -1 when its the turn of Player 1 and 1 for Player 2
        while(!(player1Ended && player2Ended))
        {
            if(turn1Or2 == -1)
                System.out.println("Player 1 goes");    
            else
                System.out.println("Player 2 goes");
            
            System.out.print("Enter password : ");
            passwordToMatch = String.valueOf(console.readPassword());
            if(turn1Or2 == -1)
            {
                while(!player1.isPasswordCorrect(passwordToMatch))
                {
                    System.out.println("Incorrect password. Please try again.");
                    System.out.print("Enter password : ");
                    passwordToMatch = String.valueOf(console.readPassword());
                }
            }
            else
            {
                while(!player2.isPasswordCorrect(passwordToMatch))
                {
                    System.out.println("Incorrect password. Please try again.");
                    System.out.print("Enter password : ");
                    passwordToMatch = String.valueOf(console.readPassword());
                }
            }
            
            System.out.println("1. See your cards and total score");
            System.out.println("2. Swap one of your cards for a new card");
            System.out.println("3. Don't take any action and continue");
            System.out.println("4. Finalize deck (YOU WON'T BE ABLE TO SWAP YOUR CARDS AFTER THIS)");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :
                        {
                            if(turn1Or2 == -1)
                                player1.showCardsAndPoints();
                            else
                                player2.showCardsAndPoints();
                        }
                case 2 :
                        {
                            if(turn1Or2 == -1)
                        }
            }
        }
    }
}