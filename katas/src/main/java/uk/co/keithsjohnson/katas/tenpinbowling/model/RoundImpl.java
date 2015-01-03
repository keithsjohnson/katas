package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class RoundImpl {

	private final int first;
	private final int second;
	private final int third;

	private final boolean strike;
	private final boolean spare;
	private final boolean normal;

	private final boolean lastRound;

	public RoundImpl(int first) {
		this(first, 0, 0, false);
	}

	public RoundImpl(int first, int second) {
		this(first, second, 0, false);
	}

	public RoundImpl(int first, int second, int third) {
		this(first, second, third, true);
	}

	private RoundImpl(int first, int second, int third, boolean lastRound) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.strike = first == 10 ? true : false;
		this.spare = (!this.strike && first + second == 10) ? true : false;
		this.normal = (!this.strike && !this.spare) ? true : false;
		this.lastRound = lastRound;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
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

	public boolean isLastRound() {
		return lastRound;
	}

	public int score() {
		return first + second;
	}

	public String firstScore() {
		if (first == 10) {
			return "X";
		} else {
			return String.format("%d", first);
		}
	}

	public String secondScore() {
		if (first == 10) {
			return " ";
		} else if (score() == 10) {
			return "/";
		} else if (second == 0) {
			return " ";
		} else {
			return String.format("%d", second);
		}
	}

	public String thirdScore() {
		if (third == 10) {
			return "X";
		} else if (third == 0) {
			return " ";
		} else {
			return String.format("%d", third);
		}
	}

	@Override
	public String toString() {
		return "Round [first=" + first + ", second=" + second + ", third=" + third + ", strike=" + strike + ", spare=" + spare + ", normal=" + normal
		        + ", lastRound=" + lastRound + "]";
	}
}
