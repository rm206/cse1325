public class Rank 
{
    public static final int MIN = 0;
    public static final int MAX = 9;
    public Rank(int rank)
    {
        this.rank = rank;
        points = rank;
    }

    @Override
    public String toString()
    {
        return "" + this.rank;
    }

    public int returnPoints()
    {
        return this.points;
    }


    private int rank;
    private int points;
}
