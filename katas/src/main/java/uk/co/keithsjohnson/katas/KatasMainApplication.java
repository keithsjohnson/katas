package uk.co.keithsjohnson.katas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KatasMainApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("KatasMainApplication START");

		tenPinBowlingKata();

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

}
