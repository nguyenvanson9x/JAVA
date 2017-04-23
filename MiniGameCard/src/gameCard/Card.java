package gameCard;

public class Card implements Comparable<Card> {
	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public String suitToString(int i) {

		if (i == 1)
			return "diamond";
		if (i == 2)
			return "heart";
		if (i == 3)
			return "spade";
		if (i == 4)
			return "club";
		
		return "";

	}

	public String rankToString(int j) {
		String s = "";

		if (j == 1)
			return "A";
		if (j == 11)
			return "J";
		if (j == 12)
			return "Q";
		if (j == 13)
			return "K";

		return s + rank;
	}

	public String toString() {
		return rankToString(rank) + "-" + suitToString(suit);
	}

	@Override
	public int compareTo(Card o) {
		if (rank != o.rank)
			return rank - o.rank;
		else
			return o.suit - suit;
	}
}
