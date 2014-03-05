/**
 * 
 */
package brewerycontrol.monitor;


/**
 * @author nguba_000
 *
 */
public class Pin {
	public int pin;
	public char type;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pin [pin=");
		builder.append(pin);
		builder.append(", type=");
		builder.append(type);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	public int value;
}
