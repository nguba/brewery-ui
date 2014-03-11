/**
 * 
 */
package brewerycontrol.parts;

import java.util.ArrayList;

/**
 * @author nguba_000
 * 
 */
public enum MashScheduleProvider {
	INSTANCE;
	private ArrayList<MashStep> steps = new ArrayList<>();

	/**
	 * @return the steps
	 */
	public ArrayList<MashStep> getSteps() {
		return steps;
	}

	/**
	 * @param steps
	 *            the steps to set
	 */
	public void setSteps(ArrayList<MashStep> steps) {
		this.steps = steps;
	}
}
