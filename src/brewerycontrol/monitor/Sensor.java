/**
 * 
 */
package brewerycontrol.monitor;

/**
 * @author nguba_000
 * 
 */
public class Sensor {

	private float value;
	private String id;

	/**
	 * 
	 * @param id
	 * @param value
	 */
	public Sensor(String id, float value) {
		super();
		this.id = id;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sensor [value=");
		builder.append(value);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the value
	 */
	public final float getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public Sensor() {
	}

}
