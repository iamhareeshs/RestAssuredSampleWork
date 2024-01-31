package apitest.expectedresponse.objects;

public class ExpectedNearEarthObject {
	private ExpectedNearEarthObject links;
	private String id;
	private String neo_reference_id;
	private String name;
	private String nasa_jpl_url;
	private double absolute_magnitude_h;
	private EstimatedDiameter estimated_diameter;
	private boolean is_potentially_hazardous_asteroid;
	private ExpectedCloseApproachData[] close_approach_data;
	private boolean is_sentry_object;

	/**
	 * @return
	 */
	public ExpectedNearEarthObject getLinks() {
		return links;
	}

	/**
	 * @param value
	 */
	public void setLinks(ExpectedNearEarthObject value) {
		this.links = value;
	}

	/**
	 * @return
	 */
	public String getID() {
		return id;
	}

	/**
	 * @param value
	 */
	public void setID(String value) {
		this.id = value;
	}

	/**
	 * @return
	 */
	public String getNeoReferenceID() {
		return neo_reference_id;
	}

	/**
	 * @param value
	 */
	public void setNeoReferenceID(String value) {
		this.neo_reference_id = value;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param value
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * @return
	 */
	public String getNasaJplURL() {
		return nasa_jpl_url;
	}

	/**
	 * @param value
	 */
	public void setNasaJplURL(String value) {
		this.nasa_jpl_url = value;
	}

	/**
	 * @return
	 */
	public double getAbsoluteMagnitudeH() {
		return absolute_magnitude_h;
	}

	/**
	 * @param value
	 */
	public void setAbsoluteMagnitudeH(double value) {
		this.absolute_magnitude_h = value;
	}

	/**
	 * @return
	 */
	public EstimatedDiameter getEstimatedDiameter() {
		return estimated_diameter;
	}

	/**
	 * @param value
	 */
	public void setEstimatedDiameter(EstimatedDiameter value) {
		this.estimated_diameter = value;
	}

	/**
	 * @return
	 */
	public boolean getIsPotentiallyHazardousAsteroid() {
		return is_potentially_hazardous_asteroid;
	}

	/**
	 * @param value
	 */
	public void setIsPotentiallyHazardousAsteroid(boolean value) {
		this.is_potentially_hazardous_asteroid = value;
	}

	/**
	 * @return
	 */
	public ExpectedCloseApproachData[] getCloseApproachData() {
		return close_approach_data;
	}

	/**
	 * @param value
	 */
	public void setCloseApproachData(ExpectedCloseApproachData[] value) {
		this.close_approach_data = value;
	}

	/**
	 * @return
	 */
	public boolean getIsSentryObject() {
		return is_sentry_object;
	}

	/**
	 * @param value
	 */
	public void setIsSentryObject(boolean value) {
		this.is_sentry_object = value;
	}
}
