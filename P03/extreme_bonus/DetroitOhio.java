import java.util.Scanner;

import javax.security.auth.callback.ChoiceCallback;

import java.io.Console; 

public class DetroitOhio 
{
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        Scanner sc = new Scanner(System.in);
        Console console = System.console(); 
        String nameToPass;
        // char[] passwordCharArray;
        String passwordToPass = new String("");
        String checkPasswordToPass = new String("");
        System.out.println("Welcome Player 1");
        System.out.print("Enter your name : ");
        nameToPass = sc.nextLine();
        while(nameToPass == "")
        {
            System.out.print("Your name cannot be empty. Please enter a name again : ");
            nameToPass = sc.nextLine();
        }
        System.out.println("NOTE : You won't be able to see your password when you type it; like bash or ZShell");
        System.out.print("Enter your password (you will need this to see your score and hand every time) : ");
        passwordToPass = new String(console.readPassword());
        while(passwordToPass == "")
        {
            System.out.print("Passwords are important! You can't not have a password. Please enter a password : ");
            passwordToPass = sc.nextLine();
        }
        System.out.print("Confirm you password : ");
        checkPasswordToPass = String.valueOf(console.readPassword());
        while(!passwordToPass.equals(checkPasswordToPass))
        {
            System.out.print("The passwords do not match. Please re-confirm your password : ");
            checkPasswordToPass = String.valueOf(console.readPassword());
        }
        Player player1 = new Player(nameToPass, passwordToPass);

        System.out.println("Welcome Player 2");
        System.out.print("Enter your name : ");
        nameToPass = sc.nextLine();
        while(nameToPass == "")
        {
            System.out.print("Your name cannot be empty. Please enter a name again : ");
            nameToPass = sc.nextLine();
        }
        System.out.println("NOTE : You won't be able to see your password when you type it; like bash or ZShell");
        System.out.print("Enter your password (you will need this to see your score and hand every time) : ");
        passwordToPass = String.valueOf(console.readPassword());
        while(passwordToPass == "")
        {
            System.out.print("Passwords are important! You can't not have a password. Please enter a password : ");
            passwordToPass = sc.nextLine();
        }
        System.out.print("Confirm you password : ");
        checkPasswordToPass = String.valueOf(console.readPassword());
        while(!passwordToPass.equals(checkPasswordToPass))
        {
            System.out.print("The passwords do not match. Please re-confirm your password : ");
            checkPasswordToPass = String.valueOf(console.readPassword());
        }
        Player player2 = new Player(nameToPass, passwordToPass);

        System.out.println("Dealing 4 cards to Player 1");
        for(int i = 0 ; i < 4 ; i++)
            player1.addToCurrentDeck(deck.deal(), i);
        System.out.println("Dealing 4 cards to Player 2");
        for(int i = 0 ; i < 4 ; i++)
            player2.addToCurrentDeck(deck.deal(), i);
        
        // Game loop
        boolean player1Ended = false;
        boolean player2Ended = false;
        int choice = 0;
        String passwordToMatch = new String("");
        int turn1Or2 = -1; // This variable is -1 when its the turn of Player 1 and 1 for Player 2
        while(!(player1Ended && player2Ended))
        {
            if(turn1Or2 == -1)
            {
                System.out.println("Player 1 goes");
            }
            else
            {
                System.out.println("Player 2 goes");
            }
            System.out.println("1. See your cards and total score");
            System.out.println("2. Swap one of your cards for a new card");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :
                    if(turn1Or2 == -1)
                    {
                        System.out.print("Enter password : ");
                        passwordToMatch = sc.nextLine();

                    }
            }
        }
    }
}