import java.util.Stack;
import java.util.Collections;

public class Deck 
{
    public Deck()
    {
        for(int rankIter = Rank.MIN ; rankIter <= Rank.MAX ; rankIter++)
        {
            for(Suit suitIter : Suit.values())
            {
                deck.push(new Card(new Rank(rankIter), suitIter));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(this.deck);
    }

    public boolean isEmpty()
    {
        return (this.deck).empty();
    }

    private Stack<Card> deck;
}
