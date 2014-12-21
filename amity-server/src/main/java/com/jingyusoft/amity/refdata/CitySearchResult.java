package com.jingyusoft.amity.refdata;

public class CitySearchResult {

	private final int id;

	private final String fullDisplayName;

	public CitySearchResult(int id, String fullDisplayName) {
		this.id = id;
		this.fullDisplayName = fullDisplayName;
	}

	public String getFullDisplayName() {
		return fullDisplayName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CitySearchResult [id=" + id + ", fullDisplayName=" + fullDisplayName + "]";
	}
}
