package uk.co.keithsjohnson.katas.tenpinbowling;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScorePrinterImpl implements TenPinBowlingScorePrinter {

	@Override
	public void printScore(Round[] rounds, int[] results) {
		System.out.println("--------------------------");
		StringBuilder roundsLineBuilder = new StringBuilder(100);
		StringBuilder linesBuilder = new StringBuilder(100);
		StringBuilder scoresLineBuilder = new StringBuilder(100);
		StringBuilder pinsLineBuilder = new StringBuilder(100);
		for (int roundIndex = 0; roundIndex < 10; roundIndex++) {
			roundsLineBuilder.append("|");
			roundsLineBuilder.append(String.format(" %3d ", roundIndex + 1));
			linesBuilder.append("______");
			if (roundIndex < rounds.length) {
				scoresLineBuilder.append("| ");
				scoresLineBuilder.append(rounds[roundIndex].firstScore());
				scoresLineBuilder.append("| ");
				scoresLineBuilder.append(rounds[roundIndex].secondScore());
				pinsLineBuilder.append("|");
				pinsLineBuilder.append(String.format(" %3d ", results[roundIndex]));
				if (rounds[roundIndex].isLastRound()) {
					roundsLineBuilder.append("   ");
					linesBuilder.append("___");
					scoresLineBuilder.append("| ");
					scoresLineBuilder.append(rounds[roundIndex].thirdScore());
					pinsLineBuilder.append("   ");
				}
			} else {
				scoresLineBuilder.append("|  |  ");
				pinsLineBuilder.append("|     ");
			}
		}
		roundsLineBuilder.append("|");
		linesBuilder.append("_");
		scoresLineBuilder.append("|");
		pinsLineBuilder.append("|");

		System.out.println(linesBuilder.toString());
		System.out.println(roundsLineBuilder.toString());
		System.out.println(linesBuilder.toString());
		System.out.println(scoresLineBuilder.toString());
		System.out.println(pinsLineBuilder.toString());
		System.out.println(linesBuilder.toString());
	}
}
