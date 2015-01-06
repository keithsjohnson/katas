package uk.co.keithsjohnson.katas.potter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotterPriceCalculatorImpl {

	public double price(int... books) {

		Map<Integer, List<Integer>> booksByBookMap = Arrays.stream(books).parallel().boxed().collect(Collectors.groupingBy(book -> book));

		System.out.println("___________________________");
		System.out.println("Start: " + booksByBookMap.toString());

		double price = 0;
		int bookCount = 0;
		do {
			bookCount = countAndRemoveOneBookFromEachList(booksByBookMap);
			double setPrice = 0D;
			switch (bookCount) {
			case 1:
				setPrice = bookCount * 8D;
				break;
			case 2:
				setPrice = bookCount * 8D * 0.95;
				break;
			case 3:
				setPrice = bookCount * 8D * 0.90;
				break;
			case 4:
				setPrice = bookCount * 8D * 0.80;
				break;
			case 5:
				setPrice = bookCount * 8D * 0.75;
				break;
			}
			System.out.println("Set Price=" + setPrice);
			System.out.println("------");
			price += setPrice;
		} while (bookCount > 0);

		System.out.println("Total Price=" + price);
		return price;
	}

	private int countAndRemoveOneBookFromEachList(Map<Integer, List<Integer>> booksByBookMap) {
		final AtomicInteger count = new AtomicInteger();

		booksByBookMap.keySet().stream().parallel().forEach(key -> {
			if (booksByBookMap.get(key).size() > 0) {
				booksByBookMap.get(key).remove(0);
				count.incrementAndGet();
			}
		});
		System.out.println(booksByBookMap.toString());
		System.out.println("Count=" + count.get());

		return count.get();

	}
}
