package vehicles;

public abstract class Vehicle 
{
    public Vehicle(int year, String make, String model, BodyStyle bodyStyle)
    {
        this.year = year;
        this.make = make;
        this.model = model;
        this.bodyStyle = bodyStyle;
    }

    public abstract double range();
    public abstract double fuelConsumed(double miles);
    public abstract double dollarsToTravel(double miles);
    
    @Override
    public String toString()
    {
        return "" + this.year + " " + this.make + " " + this.model + " " + this.bodyStyle;
    }
    
    private int year;
    private String make;
    private String model;
    private BodyStyle bodyStyle; 
}
