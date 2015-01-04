package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class RoundImpl implements Round {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#getFirst()
	 */
	public int getFirst() {
		return first;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#getSecond()
	 */
	public int getSecond() {
		return second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#getThird()
	 */
	public int getThird() {
		return third;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#isNormal()
	 */
	public boolean isNormal() {
		return normal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#isStrike()
	 */
	public boolean isStrike() {
		return strike;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#isSpare()
	 */
	public boolean isSpare() {
		return spare;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#isLastRound()
	 */
	public boolean isLastRound() {
		return lastRound;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#score()
	 */
	public int score() {
		return first + second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#firstScore()
	 */
	public String firstScore() {
		if (first == 10) {
			return "X";
		} else {
			return String.format("%d", first);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#secondScore()
	 */
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

	@Override
	public String toString() {
		return "Round [first=" + first + ", second=" + second + ", third=" + third + ", strike=" + strike + ", spare=" + spare + ", normal=" + normal
		        + ", lastRound=" + lastRound + "]";
	}
}
