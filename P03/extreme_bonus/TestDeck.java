public class TestDeck 
{
    public static void main(String[] args) 
    {
        // Test shuffle with 2 decks
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck1.shuffle();
        deck2.shuffle();
        String matchString1 = new String("");
        String matchString2 = new String("");
        while(!(deck1.isEmpty() || deck2.isEmpty()))
        {
            matchString1 = matchString1 + deck1.deal().toString();
            matchString2 = matchString2 + deck2.deal().toString();
        }
        if(matchString1.equals(matchString2))
            System.err.println("ERROR : Shuffle works poorly");
        
        // Test if every card is popped in the expected order
        // Expected order - 9A9T9U8A8T8U7A7T7U6A6T6U5A5T5U4A4T4U3A3T3U2A2T2U1A1T1U0A0T0U
        String toMatchString1 = new String("9A9T9U8A8T8U7A7T7U6A6T6U5A5T5U4A4T4U3A3T3U2A2T2U1A1T1U0A0T0U");
        String matchString3 = new String("");
        Deck deck3 = new Deck();
        while(!deck3.isEmpty())
        {
            matchString3 = matchString3 + deck3.deal().toString();
        }
        if(!matchString3.equals(toMatchString1))
            System.err.println("ERROR!\nExpected: " + toMatchString1 +"\nbut got: " + matchString3);
        
        // Testing isEmpty and DeckEmpty exception
        Deck deck4 = new Deck();
        int i = 0;
        while(i < 29 && !deck4.isEmpty())
        {
            deck4.deal();
            i++;
        }
        if(i < 29 && deck4.isEmpty())
            System.err.println("ERROR : The deck was empty before 29 cards could be dealt");
        deck4.deal();
        if(!deck4.isEmpty())
            System.err.println("ERROR : Expected an empty deck after dealing 30 cards but the deck is not empty");
        try 
        {
            deck4.deal();
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }

}
