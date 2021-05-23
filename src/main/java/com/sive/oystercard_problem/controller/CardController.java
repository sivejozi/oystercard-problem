package com.sive.oystercard_problem.controller;

import com.sive.oystercard_problem.model.Card;

public class CardController {

	private Card card;
	
	public CardController(Card card) {
		super();
		this.card = card;
	}

	public void addAmountToCard(double amount) {
		card.setAmount(amount);
	}
	
	public double viewBalance() {
		return card.getAmount();
	}
}
