package uk.co.keithsjohnson.katas.tenpinbowling;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.katas.tenpinbowling.model.LastRoundImpl;
import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;
import uk.co.keithsjohnson.katas.tenpinbowling.model.RoundImpl;

public class TenPinBowlingScorePrinterImplJUnitTest {

	private TenPinBowlingScorePrinter testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScorePrinterImpl();
	}

	@Test
	public void shouldPrintScoreFor10StrikeRounds() {
		System.out.println("shouldPrintScoreFor10StrikeRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(10);
		rounds[1] = new RoundImpl(10);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(10);
		rounds[5] = new RoundImpl(10);
		rounds[6] = new RoundImpl(10);
		rounds[7] = new RoundImpl(10);
		rounds[8] = new RoundImpl(10);
		rounds[9] = new LastRoundImpl(10, 10, 10);

		int[] results = { 30, 60, 90, 120, 150, 180, 210, 240, 270, 300 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

	@Test
	public void shouldPrintScoreFor10Rounds() {
		System.out.println("shouldPrintScoreFor10StrikeRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(0, 0);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(2, 2);
		rounds[3] = new RoundImpl(3, 3);
		rounds[4] = new RoundImpl(4, 4);
		rounds[5] = new RoundImpl(5, 5);
		rounds[6] = new RoundImpl(6, 6);
		rounds[7] = new RoundImpl(7, 7);
		rounds[8] = new RoundImpl(8, 8);
		rounds[9] = new RoundImpl(9, 9);

		int[] results = { 0, 2, 6, 12, 20, 36, 48, 62, 78, 96 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

}
