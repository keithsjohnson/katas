package uk.co.keithsjohnson.katas.potter;

public class PotterPriceCalculatorImpl {

	public double price(int... books) {
		if (books == null || books.length == 0) {
			return 0D;
		} else if (books.length == 1) {
			return 8D;
		}

		double price = books.length * 8D;

		return price;
	}

}
