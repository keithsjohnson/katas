package uk.co.keithsjohnson.katas.tenpinbowling;

import org.junit.Before;
import org.junit.Test;

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
		rounds[9] = new RoundImpl(10, 10, 10);

		int[] results = { 30, 60, 90, 120, 150, 180, 210, 240, 270, 300 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

}
