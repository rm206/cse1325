public class Clock 
{
    public Clock(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Clock add(int seconds)
    {
        Clock clock = new Clock(this.hours, this.minutes, this.seconds+seconds);
        return clock;
    }

    public Clock add(Clock clock)
    {
        Clock newClock = new Clock(this.hours+clock.hours, this.minutes+clock.minutes, this.seconds+clock.seconds);
        return newClock;
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