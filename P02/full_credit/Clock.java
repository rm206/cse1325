public class Clock 
{
    public Clock(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString()
    {
        return twoDigit(this.hours)+":"+twoDigit(this.minutes)+":"+twoDigit(this.seconds);
    }

    private String twoDigit(int i)
    {
        if(i<10)
        {
            return "0"+String.valueOf(i);
        }

        return String.valueOf(i);
    }
    
    private int hours;
    private int minutes;
    private int seconds;
}