package com.sive.oystercard_problem.model;

import java.io.Serializable;

public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cardId;
	private double amount;

	public Card(double amount) {
		super();
		this.amount = amount;
	}

	public Card() {
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
