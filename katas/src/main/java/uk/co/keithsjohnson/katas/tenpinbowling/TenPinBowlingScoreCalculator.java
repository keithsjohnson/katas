package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public interface TenPinBowlingScoreCalculator {

	public abstract int[] score(Round[] rounds);

}