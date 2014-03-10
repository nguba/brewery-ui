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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MashStep [temp=");
		builder.append(temp);
		builder.append(", rest=");
		builder.append(rest);
		builder.append(", phase=");
		builder.append(phase);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the temp
	 */
	public final int getTemp() {
		return temp;
	}

	/**
	 * @param temp
	 *            the temp to set
	 */
	public final void setTemp(int temp) {
		this.temp = temp;
	}

	/**
	 * @return the rest
	 */
	public final int getRest() {
		return rest;
	}

	/**
	 * @param rest
	 *            the rest to set
	 */
	public final void setRest(int rest) {
		this.rest = rest;
	}

	/**
	 * @return the phase
	 */
	public final String getPhase() {
		return phase;
	}

	/**
	 * @param phase
	 *            the phase to set
	 */
	public final void setPhase(String phase) {
		this.phase = phase;
	}

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

}
