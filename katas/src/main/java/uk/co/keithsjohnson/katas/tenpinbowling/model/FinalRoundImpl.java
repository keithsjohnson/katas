package uk.co.keithsjohnson.katas.tenpinbowling.model;

public class FinalRoundImpl extends RoundImpl implements Round {

	private final int third;

	public FinalRoundImpl(int first, int second, int third) {
		super(first, second);
		this.third = third;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.co.keithsjohnson.katas.tenpinbowling.model.Round#thirdScore()
	 */
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
