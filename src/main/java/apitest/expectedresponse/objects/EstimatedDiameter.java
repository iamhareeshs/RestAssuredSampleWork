package apitest.expectedresponse.objects;

public class EstimatedDiameter {
	private ExpectedDiameter kilometers;
	private ExpectedDiameter meters;
	private ExpectedDiameter miles;
	private ExpectedDiameter feet;

	/**
	 * @return
	 */
	public ExpectedDiameter getKilometers() {
		return kilometers;
	}

	/**
	 * @param value
	 */
	public void setKilometers(ExpectedDiameter value) {
		this.kilometers = value;
	}

	/**
	 * @return
	 */
	public ExpectedDiameter getMeters() {
		return meters;
	}

	/**
	 * @param value
	 */
	public void setMeters(ExpectedDiameter value) {
		this.meters = value;
	}

	/**
	 * @return
	 */
	public ExpectedDiameter getMiles() {
		return miles;
	}

	/**
	 * @param value
	 */
	public void setMiles(ExpectedDiameter value) {
		this.miles = value;
	}

	/**
	 * @return
	 */
	public ExpectedDiameter getFeet() {
		return feet;
	}

	/**
	 * @param value
	 */
	public void setFeet(ExpectedDiameter value) {
		this.feet = value;
	}
}
