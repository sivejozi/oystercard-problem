package com.sive.oystercard_problem.model;

public class BalanceCalculator {

	private Card card;
	private Journey journey;

	public BalanceCalculator(Card card, Journey journey) {
		super();
		this.card = card;
		this.journey = journey;
	}

	public void calculateBalance() {
		Integer startStationZone = null;
		Integer endStationZone = null;

		if (journey.hasCrossedZones()) {
			startStationZone = journey.getCommonZone();
			endStationZone = journey.getCommonZone();
		} else {
			startStationZone = journey.getStartStation().getZones().stream().findFirst().get();
			endStationZone = journey.getEndStation().getZones().stream().findFirst().get();
		}

		// Any bus journey
		if (journey.getTransportationType().equals(TransportationType.BUS)) {
			card.setAmount(card.getAmount() - 1.80);
		}
		// Anywhere in Zone 1
		else if (startStationZone == 1 && endStationZone == 1) {
			card.setAmount(card.getAmount() - 2.50);
		}
		// Any one zone outside zone 1
		else if ((startStationZone != 1 && endStationZone != 1) && (startStationZone == endStationZone)) {
			card.setAmount(card.getAmount() - 2.00);
		}
		// Any two zones including zone 1
		else if ((startStationZone == 1 || endStationZone == 1) && (startStationZone != endStationZone)) {
			card.setAmount(card.getAmount() - 3.00);
		}
		// Any two zones excluding zone 1
		else if ((startStationZone != 1 && endStationZone != 1) && (startStationZone != endStationZone)) {
			card.setAmount(card.getAmount() - 2.25);
		}
		else {
		// Any three zones
		card.setAmount(card.getAmount() - 3.20);
		}
	}
}
