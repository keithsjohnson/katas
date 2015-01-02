package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class Round {

	private final int first;
	private final int second;

	private final boolean strike;
	private final boolean spare;
	private final boolean normal;

	public Round(int first, int second) {
		this.first = first;
		this.second = second;
		this.strike = first == 10 ? true : false;
		this.spare = (!this.strike && first + second == 10) ? true : false;
		this.normal = (!this.strike && !this.spare) ? true : false;
	}

	public Round(int first) {
		this.first = first;
		this.second = 0;
		this.strike = first == 10 ? true : false;
		this.spare = (!this.strike && first + second == 10) ? true : false;
		this.normal = (!this.strike && !this.spare) ? true : false;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public boolean isNormal() {
		return normal;
	}

	public boolean isStrike() {
		return strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public int score() {
		return first + second;
	}

}
