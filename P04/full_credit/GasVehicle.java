public class GasVehicle extends Vehicle
{
    public static double dollarsPerGallonsOfGas;

    public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon, double gallonsInTank)
    {
        super(year, make, model, bodyStyle);
        this.milesPerGallon = milesPerGallon;
        this.gallonsInTank = gallonsInTank;
        this.dollarsPerGallonsOfGas = Double.NaN;
    }

    @Override
    public double range()
    {
        return this.gallonsInTank * this.milesPerGallon;
    }

    @Override
    public double fuelConsumed(double miles)
    {
        double temp = miles/this.milesPerGallon;
        if(temp > this.gallonsInTank)
            throw new ArithmeticException("More fuel required than available");
        else
            return temp;
    }

    @Override
    public double dollarsToTravel(double miles)
    {
        return fuelConsumed(miles) * this.dollarsPerGallonsOfGas;
    }

    private double milesPerGallon;
    private double gallonsInTank;

}
