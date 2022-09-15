package vehicles;

/*
 * Vehicle is the base abstract class for all types of Vehicle classes
 * @author             Rishabh Mediratta
 * @version            1.0
 * @since              1.0
 * @license.agreement  GNU General Public License 3.0
 */

public abstract class Vehicle 
{
    /**
     * Creates a Vehicle instance.
     *
     * <p>See {@link BodyStyle} for valid bodyStyles
     * 
     * @param year            the year of manufacturing
     * @param make            the make of the vehicle
     * @param model           the model of the vehicle
     * @param bodyStyle       bodyStyle of the vehicle
     * @since              1.0
     */
    public Vehicle(int year, String make, String model, BodyStyle bodyStyle)
    {
        this.year = year;
        this.make = make;
        this.model = model;
        this.bodyStyle = bodyStyle;
    }

    /**
     * Abstract method to return the range of the vehicle when implemented in subclass
     */
    public abstract double range();

    /**
     * Abstract method to return the fuel consumed to travel given miles when implemented in subclass
     * 
     * @param miles             the miles to be covered
     * @since              1.0
     */
    public abstract double fuelConsumed(double miles);

    /**
     * Abstract method to return the dollars requried to travel given miles when implemented in subclass
     * 
     * @param miles             the miles to be covered
     * @since              1.0
     */
    public abstract double dollarsToTravel(double miles);
    
    /**
     * Overriden toString function to return instance in a String representation
     * 
     * <p> See {@link String} for String
     * @since              1.0
     */
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
