public class Clock 
{
    public Clock(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.rationalize();
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

    private void rationalize()
    {
        if(this.seconds < 0 || this.seconds > 59)
        {
            while(this.seconds < 0)
            {
                this.seconds += 60;
                this.minutes--;
            }
            while(this.seconds > 59)
            {
                this.seconds -= 60;
                this.minutes++;
            }
        }

        if(this.minutes < 0 || this.minutes > 59)
        {
            while(this.minutes < 0)
            {
                this.minutes += 60;
                this.hours--;
            }
            while(this.minutes > 59)
            {
                this.minutes -= 60;
                this.hours++;
            }
        }

        if(this.hours < 0 || this.hours > 23)
        {
            while(this.hours < 0)
                this.hours += 24;
            while(this.hours > 23)
                this.hours -= 24;
        }

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