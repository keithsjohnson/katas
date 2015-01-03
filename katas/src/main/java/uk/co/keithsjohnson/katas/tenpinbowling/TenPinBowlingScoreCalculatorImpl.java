package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.RoundImpl;

public class TenPinBowlingScoreCalculatorImpl {

	public int[] score(RoundImpl[] rounds) {
		int[] results = new int[rounds.length];
		if (rounds.length == 0) {
			return results;
		}
		int score = 0;
		for (int roundIndex = 0; roundIndex < 10; roundIndex++) {
			if (roundIndex < rounds.length) {
				RoundImpl nextRound = null;
				RoundImpl strikeRound = null;
				if (roundIndex + 1 < rounds.length) {
					nextRound = rounds[roundIndex + 1];
				}
				if (roundIndex + 2 < rounds.length) {
					strikeRound = rounds[roundIndex + 2];
				}
				score += calculateRoundScore(rounds[roundIndex], nextRound, strikeRound);
				// System.out.println("score[" + roundIndex + "]=" +
				// String.format("%3d", score));
				results[roundIndex] = score;
			}
		}
		new TenPinBowlingScorePrinterImpl().printScore(rounds, results);
		return results;
	}

	private int calculateRoundScore(RoundImpl round, RoundImpl nextRound, RoundImpl strikeRound) {
		if (round.isNormal()) {
			return calculateNormal(round);
		} else if (round.isSpare()) {
			return calculateSpare(round, nextRound);
		}
		return calculateStrike(round, nextRound, strikeRound);
	}

	private int calculateNormal(RoundImpl round) {
		return round.score();
	}

	private int calculateSpare(RoundImpl round, RoundImpl nextRound) {
		if (round.isLastRound()) {
			return round.score() + round.getThird();
		}
		return (nextRound == null ? 0 : round.score() + nextRound.getFirst());
	}

	private int calculateStrike(RoundImpl round, RoundImpl nextRound, RoundImpl strikeRound) {
		if (round.isLastRound()) {
			return round.score() + round.getThird();
		}
		if (nextRound == null || (!nextRound.isLastRound() && nextRound.isStrike() && strikeRound == null)) {
			return 0;
		}
		if (nextRound.isNormal() || nextRound.isSpare() || nextRound.isLastRound()) {
			return round.score() + nextRound.score();
		}
		return round.score() + nextRound.score() + strikeRound.getFirst();
	}
}
