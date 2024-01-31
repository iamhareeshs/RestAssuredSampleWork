package apitest.response.objects;

import java.util.Map;

public class ResponseObjects {
	private Links links;
	private long element_count;
	private Map<String, NearEarthObject[]> near_earth_objects;

	/**
	 * @return
	 */
	public Links getLinks() {
		return links;
	}

	/**
	 * @param value
	 */
	public void setLinks(Links value) {
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
	public Map<String, NearEarthObject[]> getNearEarthObjects() {
		return near_earth_objects;
	}

	/**
	 * @param value
	 */
	public void setNearEarthObjects(Map<String, NearEarthObject[]> value) {
		this.near_earth_objects = value;
	}

}