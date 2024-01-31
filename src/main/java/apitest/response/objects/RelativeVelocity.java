package apitest.response.objects;

public class RelativeVelocity {
	private String kilometers_per_second;
	private String kilometers_per_hour;
	private String miles_per_hour;

	/**
	 * @return
	 */
	public String getKilometersPerSecond() {
		return kilometers_per_second;
	}

	/**
	 * @param value
	 */
	public void setKilometersPerSecond(String value) {
		this.kilometers_per_second = value;
	}

	/**
	 * @return
	 */
	public String getKilometersPerHour() {
		return kilometers_per_hour;
	}

	/**
	 * @param value
	 */
	public void setKilometersPerHour(String value) {
		this.kilometers_per_hour = value;
	}

	/**
	 * @return
	 */
	public String getMilesPerHour() {
		return miles_per_hour;
	}

	/**
	 * @param value
	 */
	public void setMilesPerHour(String value) {
		this.miles_per_hour = value;
	}
}