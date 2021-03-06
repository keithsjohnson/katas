package uk.co.keithsjohnson.katas.tenpinbowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

@Component
public class TenPinBowlingScoreCalculatorImpl implements TenPinBowlingScoreCalculator {

	private final TenPinBowlingScorePrinter tenPinBowlingScorePrinter;

	@Autowired
	public TenPinBowlingScoreCalculatorImpl(TenPinBowlingScorePrinter tenPinBowlingScorePrinter) {
		this.tenPinBowlingScorePrinter = tenPinBowlingScorePrinter;
	}

	@Override
	public int[] score(Round[] rounds) {
		int[] results = new int[rounds.length];
		if (rounds.length == 0) {
			return results;
		}
		int score = 0;
		for (int roundIndex = 0; roundIndex < 10; roundIndex++) {
			if (roundIndex < rounds.length) {
				Round nextRound = null;
				Round strikeRound = null;
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
		tenPinBowlingScorePrinter.printScore(rounds, results);
		return results;
	}

	private int calculateRoundScore(Round round, Round nextRound, Round strikeRound) {
		if (round.isNormal()) {
			return calculateNormal(round);
		} else if (round.isSpare()) {
			return calculateSpare(round, nextRound);
		}
		return calculateStrike(round, nextRound, strikeRound);
	}

	private int calculateNormal(Round round) {
		return round.score();
	}

	private int calculateSpare(Round round, Round nextRound) {
		if (round.isLastRound()) {
			return round.score() + round.getThird();
		}
		return (nextRound == null ? 0 : round.score() + nextRound.getFirst());
	}

	private int calculateStrike(Round round, Round nextRound, Round strikeRound) {
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
