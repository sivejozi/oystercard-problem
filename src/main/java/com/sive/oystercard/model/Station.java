package com.sive.oystercard.model;

import java.io.Serializable;
import java.util.Set;

public class Station implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Set<Integer> zones;

	public Station(String name, Set<Integer> zones) {
		super();
		this.name = name;
		this.zones = zones;
	}

	public Set<Integer> getZones() {
		return zones;
	}

	public void setZones(Set<Integer> zones) {
		this.zones = zones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
