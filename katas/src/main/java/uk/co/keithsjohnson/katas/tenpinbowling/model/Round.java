package uk.co.keithsjohnson.katas.tenpinbowling.model;

public interface Round {

	public abstract int getFirst();

	public abstract int getSecond();

	public abstract boolean isNormal();

	public abstract boolean isStrike();

	public abstract boolean isSpare();

	public abstract int score();

	public abstract String firstScore();

	public abstract String secondScore();

	public default int getThird() {
		return 0;
	}

	public default boolean isLastRound() {
		return false;
	}

	public default String thirdScore() {
		return " ";
	}
}