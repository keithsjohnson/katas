package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public interface TenPinBowlingScorePrinter {

	public abstract void printScore(Round[] rounds, int[] results);

}