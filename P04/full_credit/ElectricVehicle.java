public class ElectricVehicle extends Vehicle
{
    public static double centsPerKwhOfElectricity;

    public ElectricVehicle(int year, String make, String model, BodyStyle bodyStyle, double whPerMile, double kwhInBattery)
    {
        super(year, make, model, bodyStyle);
        this.whPerMile = whPerMile;
        this.kwhInBattery = kwhInBattery;
        this.centsPerKwhOfElectricity = Double.NaN;
    }

    @Override
    public double range()
    {
        return kwhInBattery/(whPerMile/1000);
    }

    @Override
    public double fuelConsumed(double miles)
    {
        double temp = miles * (whPerMile/1000);
        if(temp > kwhInBattery)
            throw new ArithmeticException("More energy required than available");
        else
            return temp;
    }

    @Override
    public double dollarsToTravel(double miles)
    {
        return fuelConsumed(miles) * (centsPerKwhOfElectricity/100);
    }

    private double whPerMile;
    private double kwhInBattery;
}
