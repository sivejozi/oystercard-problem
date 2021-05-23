package com.sive.oystercard_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sive.oystercard_problem.controller.CardController;
import com.sive.oystercard_problem.model.Card;
import com.sive.oystercard_problem.model.Journey;
import com.sive.oystercard_problem.model.BalanceCalculator;
import com.sive.oystercard_problem.model.Station;
import com.sive.oystercard_problem.model.TransportationType;

public class App {
	public static void main(String[] args) {
		Card card = new Card();
		CardController controller = new CardController(card);

		controller.addAmountToCard(30);
		System.out.println("Card has been loaded with " + controller.viewBalance() + " Pounds");
		
		Set<Integer> holbornZones = new HashSet<>(Arrays.asList(1));
		Set<Integer> earlsCourtZones = new HashSet<>(Arrays.asList(1, 2));
		Set<Integer> chelseaZones = new HashSet<>(Arrays.asList(1, 3));
		Set<Integer> hammersmithZones = new HashSet<>(Arrays.asList(2));
		
		// Tube Holborn to Earl’s Court
		Station startStation = new Station("Holborn", holbornZones);
		Station endStation = new Station("EarlsCourt", earlsCourtZones);
		Journey holBornToEarlsCourt = new Journey(startStation, endStation, TransportationType.TUBE);
		BalanceCalculator calculator = new BalanceCalculator(card, holBornToEarlsCourt);
		calculator.calculateBalance();
		System.out.println("Balance after Holborn to Earl’s Court " + controller.viewBalance() + " Pounds");

		// 328 bus from Earl’s Court to Chelsea
		Station startStation2 = new Station("EarlsCourt", earlsCourtZones);
		Station endStation2 = new Station("Chelsea", chelseaZones);
		Journey earlsCourtToChelsea = new Journey(startStation2, endStation2, TransportationType.BUS);
		calculator = new BalanceCalculator(card, earlsCourtToChelsea);
		calculator.calculateBalance();
		System.out.println("Balance after 328 bus from Earl’s Court to Chelsea " + controller.viewBalance() + " Pounds");
		
		// Tube Earl’s court to Hammersmith
		Station startStation3 = new Station("EarlsCourt", earlsCourtZones);
		Station endStation3 = new Station("Hammersmith", hammersmithZones);
		Journey earlscourtToHammersmith = new Journey(startStation3, endStation3, TransportationType.TUBE);
		calculator = new BalanceCalculator(card, earlscourtToHammersmith);
		calculator.calculateBalance();
		System.out.println("Balance after Earl’s court to Hammersmith " + controller.viewBalance() + " Pounds");
	}
}
