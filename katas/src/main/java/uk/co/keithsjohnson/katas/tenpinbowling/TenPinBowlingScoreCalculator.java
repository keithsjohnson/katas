package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculator {

	public int score(Round[] rounds) {
		int score = 0;
		for (Round round : rounds) {
			if (round != null) {
				score += round.getFirst();
				score += round.getSecond();
			}
		}
		return score;
	}

}
