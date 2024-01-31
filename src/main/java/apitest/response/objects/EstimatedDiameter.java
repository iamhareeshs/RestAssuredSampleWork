package apitest.response.objects;

public class EstimatedDiameter {
	private Diameter kilometers;
	private Diameter meters;
	private Diameter miles;
	private Diameter feet;

	/**
	 * @return
	 */
	public Diameter getKilometers() {
		return kilometers;
	}

	/**
	 * @param value
	 */
	public void setKilometers(Diameter value) {
		this.kilometers = value;
	}

	/**
	 * @return
	 */
	public Diameter getMeters() {
		return meters;
	}

	/**
	 * @param value
	 */
	public void setMeters(Diameter value) {
		this.meters = value;
	}

	/**
	 * @return
	 */
	public Diameter getMiles() {
		return miles;
	}

	/**
	 * @param value
	 */
	public void setMiles(Diameter value) {
		this.miles = value;
	}

	/**
	 * @return
	 */
	public Diameter getFeet() {
		return feet;
	}

	/**
	 * @param value
	 */
	public void setFeet(Diameter value) {
		this.feet = value;
	}
}
