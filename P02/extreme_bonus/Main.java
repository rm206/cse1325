import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        int hours, minutes, seconds;
        Scanner sc = new Scanner(System.in);

        System.out.print("Hour? ");
        hours = sc.nextInt();

        System.out.print("Minute? ");
        minutes = sc.nextInt();

        System.out.print("Second? ");
        seconds = sc.nextInt();

        Clock clock = new Clock(hours, minutes, seconds);
        System.out.println("The time is " + clock.toString());
        
        int wantToContinue = 1;
        int choice = 0;
        while(wantToContinue != 0)
        {
            System.out.println("Choose an option");
            System.out.println("1. Add seconds to existing clock");
            System.out.println("2. Add 2 clocks together");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                        {
                            int secondsToAdd;
                            System.out.println("Enter seconds to add");
                            secondsToAdd = sc.nextInt();
                            Clock newClock = clock.add(secondsToAdd);
                            System.out.println("The new clock is: " + newClock.toString());
                            break;
                        }
                case 2:
                        {
                            
                            System.out.print("New Hour? ");
                            hours = sc.nextInt();
                            
                            System.out.print("New Minute? ");
                            minutes = sc.nextInt();
                            
                            System.out.print("New Second? ");
                            seconds = sc.nextInt();

                            Clock newClock = new Clock(hours, minutes, seconds);
                            newClock = clock.add(newClock);
                            System.out.println("The new clock is : " + newClock.toString());
                            break;
                        }
                default:
                        {
                            System.out.println("Incorrect choice");
                            break;
                        }
            }
            System.out.println("Do you want to continue? (Enter 0 to end or any number to continue)");
            wantToContinue = sc.nextInt();
        }
    }
}
