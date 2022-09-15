package vehicles;

/*
 * Models a Gas Vehicle
 * 
 * @author             Rishabh Mediratta
 * @version            1.0
 * @since              1.0
 * @license.agreement  GNU General Public License 3.0
 */

public class GasVehicle extends Vehicle
{   
    /**
     * The price of 1 gallon of gas in dollars
     */
    public static double dollarsPerGallonsOfGas= Double.NaN;

    /**
     * Creates an GasVehicle instance.
     *
     * <p>See {@link BodyStyle} for valid bodyStyles
     * 
     * @param year            the year of manufacturing
     * @param make            the make of the vehicle
     * @param model           the model of the vehicle
     * @param bodyStyle       bodyStyle of the vehicle
     * @param milesPerGallon  miles travelled per gallon for the vehicle
     * @param gallonsInTank   gallons of gas in tank of the gas vehicle
     * @since              1.0
     */
    public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon, double gallonsInTank)
    {
        super(year, make, model, bodyStyle);
        this.milesPerGallon = milesPerGallon;
        this.gallonsInTank = gallonsInTank;
    }

    /**
     * Overriden range function to return the range of the gas vehicle in miles
     */
    @Override
    public double range()
    {
        return this.gallonsInTank * this.milesPerGallon;
    }

    /**
     * Overriden fuelConsumed function to return the gas consumed in gallons to travel given miles
     * 
     * @param miles            miles to travel
     */
    @Override
    public double fuelConsumed(double miles)
    {
        double temp = miles/this.milesPerGallon;
        if(temp > this.gallonsInTank)
            throw new ArithmeticException("More fuel required than available");
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
        return fuelConsumed(miles) * dollarsPerGallonsOfGas;
    }

    private double milesPerGallon;
    private double gallonsInTank;

}
