package uk.co.keithsjohnson.katas.tenpinbowling;

import java.util.List;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculator {

	public int score(List<Round> rounds) {
		int score = 0;
		for (Round round : rounds) {
			score += round.getFirst();
			score += round.getSecond();
		}
		return score;
	}

}
