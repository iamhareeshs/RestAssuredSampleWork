package apitest.expectedresponse.objects;

import java.time.LocalDate;

public class ExpectedCloseApproachData {
	private LocalDate close_approach_date;
	private String close_approach_date_full;
	private long epoch_date_close_approach;
	private ExpectedRelativeVelocity relative_velocity;
	private ExpectedMissDistance miss_distance;
	private String orbiting_body;

	/**
	 * @return
	 */

	public LocalDate getCloseApproachDate() {
		return close_approach_date;
	}

	/**
	 * @param value
	 */
	public void setCloseApproachDate(LocalDate value) {
		this.close_approach_date = value;
	}

	/**
	 * @return
	 */
	public String getCloseApproachDateFull() {
		return close_approach_date_full;
	}

	/**
	 * @param value
	 */
	public void setCloseApproachDateFull(String value) {
		this.close_approach_date_full = value;
	}

	/**
	 * @return
	 */
	public long getEpochDateCloseApproach() {
		return epoch_date_close_approach;
	}

	/**
	 * @param value
	 */
	public void setEpochDateCloseApproach(long value) {
		this.epoch_date_close_approach = value;
	}

	/**
	 * @return
	 */
	public ExpectedRelativeVelocity getRelativeVelocity() {
		return relative_velocity;
	}

	/**
	 * @param value
	 */
	public void setRelativeVelocity(ExpectedRelativeVelocity value) {
		this.relative_velocity = value;
	}

	/**
	 * @return
	 */
	public ExpectedMissDistance getMissDistance() {
		return miss_distance;
	}

	/**
	 * @param value
	 */
	public void setMissDistance(ExpectedMissDistance value) {
		this.miss_distance = value;
	}

	/**
	 * @return
	 */
	public String getOrbitingBody() {
		return orbiting_body;
	}

	/**
	 * @param value
	 */
	public void setOrbitingBody(String value) {
		this.orbiting_body = value;
	}
}
