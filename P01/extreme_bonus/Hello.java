public class Hello
{
    public static void main(String[] args) 
    {
        String userName = System.getProperty("user.name");
        System.out.println("Hello, " + userName);
    }
}