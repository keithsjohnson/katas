package uk.co.keithsjohnson.katas.potter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotterPriceCalculatorImpl {

	public double price(int... books) {

		Map<Integer, List<Integer>> booksByBookMap = Arrays.stream(books).boxed().collect(Collectors.groupingBy(book -> book));

		if (booksByBookMap.size() == 0) {
			return 0D;
		} else if (booksByBookMap.size() == 1) {
			List<Integer> list = booksByBookMap.values().iterator().next();
			return list.size() * 8D;
		}
		System.out.println(booksByBookMap.toString());

		double price = 0;
		int bookCount = 0;
		do {
			bookCount = countAndRemoveOneBookFromEachList(booksByBookMap);
			switch (bookCount) {
			case 1:
				price += bookCount * 8D;
				break;
			case 2:
				price += bookCount * 8D * 0.95;
				break;
			case 3:
				price += bookCount * 8D * 0.90;
				break;
			case 4:
				price += bookCount * 8D * 0.80;
				break;
			case 5:
				price += bookCount * 8D * 0.75;
				break;
			}
		} while (bookCount > 0);

		return price;
	}

	private int countAndRemoveOneBookFromEachList(Map<Integer, List<Integer>> booksByBookMap) {
		final AtomicInteger count = new AtomicInteger();

		booksByBookMap.keySet().forEach(key -> {
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
