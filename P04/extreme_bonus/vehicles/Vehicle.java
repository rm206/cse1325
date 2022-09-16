package vehicles;

/*
 * Vehicle is the interface for all types of Vehicle classes
 * @author             Rishabh Mediratta
 * @version            1.0
 * @since              1.0
 * @license.agreement  GNU General Public License 3.0
 */

public interface Vehicle 
{
    /**
     * Abstract method to return the range of the vehicle
     */
    public abstract double range();

    /**
     * Abstract method to return the fuel consumed to travel given miles
     * 
     * @param miles             the miles to be covered
     * @since              1.0
     */
    public abstract double fuelConsumed(double miles);

    /**
     * Abstract method to return the dollars requried to travel given miles
     * 
     * @param miles             the miles to be covered
     * @since              1.0
     */
    public abstract double dollarsToTravel(double miles); 
}
