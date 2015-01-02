package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculator {

	public int score(Round[] rounds) {
		int score = 0;
		for (int roundIndex = 0; roundIndex < 10; roundIndex++) {
			if (rounds[roundIndex] != null) {
				score += calculateRoundScore(rounds[roundIndex], (roundIndex) == 9 ? null : rounds[roundIndex + 1]);
			}
		}
		return score;
	}

	private int calculateRoundScore(Round round, Round nextRound) {
		int roundScore = 0;

		if (nextRound == null) {
			// No Spare or Strike
			roundScore += round.getFirst();
			roundScore += round.getSecond();

			if (roundScore < 10) {
				return roundScore;
			} else {
				return 0;
			}

		}

		// Spare or Strike
		roundScore += round.getFirst();
		roundScore += round.getSecond();
		if (roundScore == 10) {
			return roundScore += nextRound.getFirst();
		}

		return roundScore;
	}
}
