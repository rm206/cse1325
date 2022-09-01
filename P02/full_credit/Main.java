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
        System.out.println("The time is "+clock.toString());
    }
}
