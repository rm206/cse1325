import java.util.Stack;

public class Player 
{
    
    public Player(String name, String password)
    {
        this.password = password;
        this.name = name;
        this.currentScore = 0;
        this.currentDeck = new Card[4];
    }

    @Override
    public String toString()
    {
        return "Name : " + name + "\nNice try. This is the only information you get from the toString function for a player.";
    }
    
    public boolean isPasswordCorrect(String password)
    {
        return password.equals(this.password);

    }

    public void addToCurrentDeck(Card card, int i)
    {
        (this.currentDeck)[i] = card;
    }

    private String name;
    private String password;
    private int currentScore;
    private Card[] currentDeck;
}
