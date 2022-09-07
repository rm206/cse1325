public class DetroitOhio 
{
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        while(!deck.isEmpty())
            System.out.println(deck.deal());
    }
}