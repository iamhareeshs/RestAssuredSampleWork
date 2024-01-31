package apitest.expectedresponse.objects;

import java.util.Map;

public class ExpectedResponseObjects {
	private ExpectedLinks links;
	private long element_count;
	private Map<String, ExpectedNearEarthObject[]> near_earth_objects;

	/**
	 * @return
	 */
	public ExpectedLinks getLinks() {
		return links;
	}

	/**
	 * @param value
	 */
	public void setLinks(ExpectedLinks value) {
		this.links = value;
	}

	/**
	 * @return
	 */
	public long getElementCount() {
		return element_count;
	}

	/**
	 * @param value
	 */
	public void setElementCount(long value) {
		this.element_count = value;
	}

	/**
	 * @return
	 */
	public Map<String, ExpectedNearEarthObject[]> getNearEarthObjects() {
		return near_earth_objects;
	}

	/**
	 * @param value
	 */
	public void setNearEarthObjects(Map<String, ExpectedNearEarthObject[]> value) {
		this.near_earth_objects = value;
	}

}