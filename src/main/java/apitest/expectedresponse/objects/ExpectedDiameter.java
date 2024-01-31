package apitest.expectedresponse.objects;

public class ExpectedDiameter {
	private double estimated_diameter_min;
	private double estimated_diameter_max;

	/**
	 * @return
	 */
	public double getEstimatedDiameterMin() {
		return estimated_diameter_min;
	}

	/**
	 * @param value
	 */
	public void setEstimatedDiameterMin(double value) {
		this.estimated_diameter_min = value;
	}

	/**
	 * @return
	 */
	public double getEstimatedDiameterMax() {
		return estimated_diameter_max;
	}

	/**
	 * @param value
	 */
	public void setEstimatedDiameterMax(double value) {
		this.estimated_diameter_max = value;
	}
}
