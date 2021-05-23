package com.sive.oystercard_problem.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sive.oystercard_problem.model.Card;

public class CardControllerTest {

	private Card card;
	private CardController cardController;

	@Before
	public void setUp() {
		card = new Card();
		cardController = new CardController(card);
	}
	
	@Test
	public void testAddAmountToCard() {
		cardController.addAmountToCard(30);
		assertEquals(30, cardController.viewBalance(),0);
	}

}
