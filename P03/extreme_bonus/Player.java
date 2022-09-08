import java.util.Scanner;
import java.util.Stack;
import java.io.Console;

public class Player {

    public Player() {
        this.password = "";
        this.name = "";
        this.currentScore = 0;
        this.currentDeck = new Card[4];
    }

    @Override
    public String toString() {
        return "Name : " + name
                + "\nNice try. This is the only information you get from the toString function for a player.";
    }

    public boolean isPasswordCorrect(String password) {
        return password.equals(this.password);

    }

    public void addToCurrentDeck(Card card, int i) {
        (this.currentDeck)[i] = card;
        this.currentScore += card.retPoints();
    }

    public void showCardsAndPoints() {
        for (Card i : currentDeck) {
            System.out.print(i.toString() + " ");
        }
        System.out.println("Total points = " + currentScore);
    }

    public void setNameAndPassword() 
    {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();
        String password = new String("");
        String checkPassword = new String("");
        String name = new String("");
        System.out.print("Enter your name : ");
        name = sc.nextLine();
        while (name == "") 
        {
            System.out.print("Your name cannot be empty. Please enter a name again : ");
            name = sc.nextLine();
        }
        System.out.println("NOTE : You won't be able to see your password when you type it; like bash or ZShell terminal");
        System.out.print("Enter your password (you will need this to see your score and hand every time) : ");
        password = String.valueOf(console.readPassword());
        while (password == "")
        {
            System.out.print("Passwords are important! You can't not have a password. Please enter a password : ");
            password = String.valueOf(console.readPassword());
        }
        System.out.print("Confirm you password : ");
        checkPassword = String.valueOf(console.readPassword());
        while (!password.equals(checkPassword)) 
        {
            System.out.print("The passwords do not match. Please re-confirm your password : ");
            checkPassword = String.valueOf(console.readPassword());
        }

        this.name = name;
        this.password = password;
    }

    private String name;
    private String password;
    private int currentScore;
    private Card[] currentDeck;
}
