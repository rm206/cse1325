package vehicles;

/*
 * Models an Electric Vehicle
 * 
 * @author             Rishabh Mediratta
 * @version            1.0
 * @since              1.0
 * @license.agreement  GNU General Public License 3.0
 */

public class ElectricVehicle extends Vehicle
{
    
    /**
     * The price of 1 KwH on energy in cents
     */
    public static double centsPerKwhOfElectricity = Double.NaN;

    /**
     * Creates an ElectricVehicle instance.
     *
     * <p>See {@link BodyStyle} for valid bodyStyles
     * 
     * @param year            the year of manufacturing
     * @param make            the make of the vehicle
     * @param model           the model of the vehicle
     * @param bodyStyle       bodyStyle of the vehicle
     * @param whPerMile       amount of energy in wH to travel one mile
     * @param kwhInBattery    energy in electric vehicle in kwH
     * @since              1.0
     */
    public ElectricVehicle(int year, String make, String model, BodyStyle bodyStyle, double whPerMile, double kwhInBattery)
    {
        super(year, make, model, bodyStyle);
        this.whPerMile = whPerMile;
        this.kwhInBattery = kwhInBattery;
    }

    /**
     * Overriden range function to return the range of the electric vehicle in miles
     */
    @Override
    public double range()
    {
        return kwhInBattery/(whPerMile/1000);
    }

    /**
     * Overriden fuelConsumed function to return the energy consumed in kwH to travel given miles
     * 
     * @param miles            miles to travel
     */
    @Override
    public double fuelConsumed(double miles)
    {
        double temp = miles * (whPerMile/1000);
        if(temp > kwhInBattery)
            throw new ArithmeticException("More energy required than available");
        else
            return temp;
    }

    /**
     * Overriden function to return the amount (in dollars) required to travel given miles
     * 
     * @param miles             miles to travel
     */
    @Override
    public double dollarsToTravel(double miles)
    {
        return fuelConsumed(miles) * (centsPerKwhOfElectricity/100);
    }

    private double whPerMile;
    private double kwhInBattery;
}
