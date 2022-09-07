public enum Suit 
{
    U (5),
    T (4),
    A (3);

    public int retPoints()
    {
        return suitID;
    }

    private final int suitID;
    
    private Suit(int suitID)
    {
        this.suitID = suitID;
    }
}
