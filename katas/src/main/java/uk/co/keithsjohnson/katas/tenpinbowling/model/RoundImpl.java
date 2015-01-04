package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class RoundImpl implements Round {

	private final int first;
	private final int second;

	private final boolean strike;
	private final boolean spare;
	private final boolean normal;

	public RoundImpl(int first) {
		this(first, 0);
	}

	public RoundImpl(int first, int second) {
		this.first = first;
		this.second = second;
		this.strike = first == 10 ? true : false;
		this.spare = (!this.strike && first + second == 10) ? true : false;
		this.normal = (!this.strike && !this.spare) ? true : false;
	}

	@Override
	public int getFirst() {
		return first;
	}

	@Override
	public int getSecond() {
		return second;
	}

	@Override
	public boolean isNormal() {
		return normal;
	}

	@Override
	public boolean isStrike() {
		return strike;
	}

	@Override
	public boolean isSpare() {
		return spare;
	}

	@Override
	public int score() {
		return first + second;
	}

	@Override
	public String firstScore() {
		if (first == 10) {
			return "X";
		} else {
			return String.format("%d", first);
		}
	}

	@Override
	public String secondScore() {
		if (first == 10) {
			return " ";
		} else if (score() == 10) {
			return "/";
		} else {
			return String.format("%d", second);
		}
	}

	@Override
	public String toString() {
		return "Round [first=" + first + ", second=" + second + ", strike=" + strike + ", spare=" + spare + ", normal=" + normal + "]";
	}
}
