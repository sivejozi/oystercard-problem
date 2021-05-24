package com.sive.oystercard.model;


import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.sive.oystercard.controller.CardController;

public class BalanceCalculatorTest {

	private BalanceCalculator refundCalculator;

	@Before
	public void setUp() {
		
	}

	@Test
	public void testExpect27_5BalanceFromHolbornToEarlsCourtByTube() {
		Card card = new Card();
		CardController cardController = new CardController(card);
		cardController.addAmountToCard(30);
		Set<Integer> zones1 = new HashSet<Integer>();
		zones1.add(1);
		Set<Integer> zones2 = new HashSet<Integer>();
		zones2.add(1);
		zones2.add(2);
		Station startStation = new Station("Holborn", zones1);
		Station endStation = new Station("Earl’s Court", zones2);
		Journey journey = new Journey(startStation, endStation, TransportationType.TUBE);
		refundCalculator = new BalanceCalculator(card, journey);
		refundCalculator.calculateBalance();
		assertEquals(27.5, cardController.viewBalance(), 0);
	}

	@Test
	public void testExpect28_2BalanceFromEarlsCourtToChelseaByBus() {
		Card card = new Card();
		CardController cardController = new CardController(card);
		cardController.addAmountToCard(30);

		Set<Integer> zones1 = new HashSet<Integer>();
		zones1.add(1);
		zones1.add(2);
		
		Set<Integer> zones2 = new HashSet<Integer>();
		zones2.add(3);
		Station startStation = new Station("Earl’s Court", zones1);
		Station endStation = new Station("Wimbledon", zones2);

		Journey journey = new Journey(startStation, endStation, TransportationType.BUS);
		refundCalculator = new BalanceCalculator(card, journey);
		refundCalculator.calculateBalance();
		assertEquals(28.2, cardController.viewBalance(), 0);
	}
	
	@Test
	public void testExpect27_5BalanceFromChelseaToHammersmithByTube() {
		Card card = new Card();
		CardController cardController = new CardController(card);
		cardController.addAmountToCard(30);

		Set<Integer> zones1 = new HashSet<Integer>();
		zones1.add(3);
		
		Set<Integer> zones2 = new HashSet<Integer>();
		zones2.add(2);
		Station startStation = new Station("Chelsea", zones1);
		Station endStation = new Station("Hammersmith", zones2);

		Journey journey = new Journey(startStation, endStation, TransportationType.TUBE);
		refundCalculator = new BalanceCalculator(card, journey);
		refundCalculator.calculateBalance();
		assertEquals(27.75, cardController.viewBalance(), 0);
	}
	
	@Test
	public void testExpect28BalanceFromEarlsCourtToHammersmithByTube() {
		Card card = new Card();
		CardController cardController = new CardController(card);
		cardController.addAmountToCard(30);

		Set<Integer> zones1 = new HashSet<Integer>();
		zones1.add(1);
		zones1.add(2);
		
		Set<Integer> zones2 = new HashSet<Integer>();
		zones2.add(2);
		Station startStation = new Station("Earl’s Court", zones1);
		Station endStation = new Station("Hammersmith", zones2);

		Journey journey = new Journey(startStation, endStation, TransportationType.TUBE);
		refundCalculator = new BalanceCalculator(card, journey);
		refundCalculator.calculateBalance();
		assertEquals(28.0, cardController.viewBalance(), 0);
	}
	

	@Test
	public void testExpect27BalanceFromHolbornToHammersmithByTube() {
		Card card = new Card();
		CardController cardController = new CardController(card);
		cardController.addAmountToCard(30);
		Set<Integer> zones1 = new HashSet<Integer>();
		zones1.add(1);
		Set<Integer> zones2 = new HashSet<Integer>();
		zones2.add(2);
		Station startStation = new Station("Holborn", zones1);
		Station endStation = new Station("Hammersmith", zones2);
		Journey journey = new Journey(startStation, endStation, TransportationType.TUBE);
		refundCalculator = new BalanceCalculator(card, journey);
		refundCalculator.calculateBalance();
		assertEquals(27.0, cardController.viewBalance(), 0);
	}
	
}
