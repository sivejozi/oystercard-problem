package com.sive.oystercard_problem.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Journey implements Serializable {

	private static final long serialVersionUID = 1L;
	private Station startStation;
	private Station endStation;
	private TransportationType transportationType;

	public Journey(Station startStation, Station endStation, TransportationType transportationType) {
		super();
		this.startStation = startStation;
		this.endStation = endStation;
		this.transportationType = transportationType;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}

	public Station getEndStation() {
		return endStation;
	}

	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}

	public TransportationType getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(TransportationType transportationType) {
		this.transportationType = transportationType;
	}

	public Integer getCommonZone() {
		Integer commonZone = null;
		if (hasCrossedZones()) {
			List<Integer> common = startStation.getZones().stream().filter(endStation.getZones()::contains)
					.collect(Collectors.toList());
			commonZone = common.get(0);
		}
		return commonZone;
	}

	public boolean hasCrossedZones() {
		return !(this.transportationType.equals(TransportationType.BUS)) && startStation.getZones().size() > 1
				|| endStation.getZones().size() > 1;
	}
}
