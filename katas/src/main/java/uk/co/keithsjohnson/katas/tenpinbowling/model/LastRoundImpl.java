package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class LastRoundImpl extends RoundImpl implements Round {

	private final int third;

	private final boolean lastRound;

	public LastRoundImpl(int first, int second, int third) {
		super(first, second);
		this.third = third;
		this.lastRound = true;
	}

	@Override
	public boolean isLastRound() {
		return lastRound;
	}

	@Override
	public int getThird() {
		return third;
	}

	@Override
	public String thirdScore() {
		if (third == 10) {
			return "X";
		} else if (third == 0) {
			return " ";
		} else {
			return String.format("%d", third);
		}
	}

}
