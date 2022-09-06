import java.util.Stack;
import java.util.Collections;

public class Deck 
{
    public class DeckEmpty extends IndexOutOfBoundsException
    {
        public DeckEmpty(String errorMessage)
        {
            super(errorMessage);
        }
    }
    
    public Deck()
    {
        deck = new Stack<Card>();
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

    public Card deal()
    {
        if(deck.isEmpty())
        {
            throw new DeckEmpty("DeckEmptyException : The deck is empty!");
        }
        return deck.pop();
    }

    public boolean isEmpty()
    {
        return (this.deck).empty();
    }

    private Stack<Card> deck;
}
