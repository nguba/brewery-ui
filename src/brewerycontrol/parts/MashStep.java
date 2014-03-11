package brewerycontrol.parts;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashStep {

	private int temp;
	private int rest;
	private String phase;

	/**
	 * 
	 */
	public MashStep() {
	}

	public MashStep(int temp, int rest, String phase) {
		this.temp = temp;
		this.rest = rest;
		this.phase = phase;
	}

	/**
	 * @return the phase
	 */
	public final String getPhase() {
		return phase;
	}

	/**
	 * @return the rest
	 */
	public final int getRest() {
		return rest;
	}

	/**
	 * @return the temp
	 */
	public final int getTemp() {
		return temp;
	}

	/**
	 * @param phase
	 *            the phase to set
	 */
	public final void setPhase(String phase) {
		this.phase = phase;
	}

	/**
	 * @param rest
	 *            the rest to set
	 */
	public final void setRest(int rest) {
		this.rest = rest;
	}

	/**
	 * @param temp
	 *            the temp to set
	 */
	public final void setTemp(int temp) {
		this.temp = temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("MashStep [temp=");
		builder.append(temp);
		builder.append(", rest=");
		builder.append(rest);
		builder.append(", phase=");
		builder.append(phase);
		builder.append("]");
		return builder.toString();
	}

}
