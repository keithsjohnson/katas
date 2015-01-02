package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculator {

	public int score(Round[] rounds) {
		int score = 0;
		for (int roundIndex = 0; roundIndex < 10; roundIndex++) {
			if (rounds[roundIndex] != null) {
				score += calculateRoundScore(rounds[roundIndex], (roundIndex) == 9 ? null : rounds[roundIndex + 1], (roundIndex) > 7 ? null
				        : rounds[roundIndex + 2]);
				System.out.println("score[" + roundIndex + "]=" + score);
			}
		}
		System.out.println("--------------------------");
		return score;
	}

	private int calculateRoundScore(Round round, Round nextRound, Round strikeRound) {
		if (round.isNormal()) {
			return calculateNormal(round);
		}
		if (round.isSpare()) {
			return calculateSpare(round, nextRound);
		}
		if (round.isStrike()) {
			return calculateStrike(round, nextRound, strikeRound);
		}
		return 0;
	}

	private int calculateNormal(Round round) {
		return round.score();
	}

	private int calculateSpare(Round round, Round nextRound) {
		return (nextRound == null ? 0 : round.score() + nextRound.getFirst());
	}

	private int calculateStrike(Round round, Round nextRound, Round strikeRound) {
		if (nextRound == null || (nextRound.isStrike() && strikeRound == null)) {
			return 0;
		}

		if (nextRound.isNormal() || nextRound.isSpare()) {
			return round.score() + nextRound.score();
		}
		return round.score() + nextRound.score() + strikeRound.getFirst();
	}
}
