package com.sive.oystercard.controller;

import com.sive.oystercard.model.Card;

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
