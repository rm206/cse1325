public class Card 
{
    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
        this.points = rank.retPoints() * suit.retPoints();
    }

    @Override
    public String toString()
    {
        return "" + this.rank + this.suit;
    }

    public int retPoints()
    {
        return this.points;
    }

    private Rank rank;
    private Suit suit;  
    private int points;
}
