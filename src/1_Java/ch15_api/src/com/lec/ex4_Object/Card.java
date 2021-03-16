package com.lec.ex4_Object;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Card {
	private char kind; // ♥ ◆ ♠ ♣
	private int num; // A(1), 2~10, King(11~13)

	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "카드 모양은  " + kind + " " + num;
	}

	@Override
	public boolean equals(Object obj) {
		// Card yours = new Card('♣', 8);
		// Card card = new Card('♣', 8);
		// yours.equals(card) -> this는 yours, obj는 card
		// this.kind와 obj.kind가 같고 this.num과 obj.num이 같으면 true
		if (obj != null && obj instanceof Card) {
			boolean kindChk = kind == ((Card) obj).kind;
			boolean numChk = num == ((Card) obj).num;
			return kindChk && numChk;
		}
		return false;
	}// equals
}