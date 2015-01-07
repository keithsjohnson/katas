package uk.co.keithsjohnson.katas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uk.co.keithsjohnson.katas.calcstats.CalcStats;
import uk.co.keithsjohnson.katas.potter.PotterPriceCalculator;
import uk.co.keithsjohnson.katas.tenpinbowling.TenPinBowlingScoreCalculator;
import uk.co.keithsjohnson.katas.tenpinbowling.TenPinBowlingScorePrinter;
import uk.co.keithsjohnson.katas.tenpinbowling.model.LastRoundImpl;
import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;
import uk.co.keithsjohnson.katas.tenpinbowling.model.RoundImpl;

@SpringBootApplication
public class KatasMainApplication implements CommandLineRunner {

	@Autowired
	TenPinBowlingScoreCalculator tenPinBowlingScoreCalculator;

	@Autowired
	TenPinBowlingScorePrinter tenPinBowlingScorePrinter;

	@Autowired
	PotterPriceCalculator potterPriceCalculator;

	@Autowired
	CalcStats calcStats;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KatasMainApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("KatasMainApplication START");

		tenPinBowlingKata();

		potterKata();

		calcStatsKata();

		System.out.println("KatasMainApplication END");
	}

	private void tenPinBowlingKata() {
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

		int[] results = tenPinBowlingScoreCalculator.score(rounds);
	}

	private void potterKata() {
		// Given
		int[] books = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4 };

		// When
		double price = potterPriceCalculator.price(books);
	}

	private void calcStatsKata() {
		int value1 = calcStats.minimumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });
		int value2 = calcStats.minimumValue(new Integer[] { 6, 9, 15, 1, 92, 11 });
		int value3 = calcStats.maximumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });
		int value4 = calcStats.maximumValue(new Integer[] { 6, 9, 15, 1, 12, 11 });
		int count1 = calcStats.count(new Integer[] { 6, 9, 15, -2, 92, 11 });
		int count2 = calcStats.count(new Integer[] { 6, 9, 15 });
		double average1 = calcStats.averageValue(new double[] { 6D, 9D, 15D, -2D, 92D, 11D });
		double average2 = calcStats.averageValue(new double[] { 6, 9, 15 });
	}

}
