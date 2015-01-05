package uk.co.keithsjohnson.katas.potter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PotterPriceCalculatorImpl {

	public double price(int... books) {
		Integer[] bookIntegers = toBooksInteger(books);

		Map<Integer, List<Integer>> booksByBookMap = Arrays.stream(bookIntegers, 0, bookIntegers.length).collect(Collectors.groupingBy(book -> book));

		if (booksByBookMap.size() == 0) {
			return 0D;
		} else if (booksByBookMap.size() == 1) {
			List<Integer> list = booksByBookMap.values().iterator().next();
			return list.size() * 8D;
		}
		System.out.println(booksByBookMap.toString());

		double price = books.length * 8D;

		return price;
	}

	public static Integer[] toBooksInteger(int[] intBooks) {

		Integer[] result = new Integer[intBooks.length];
		for (int i = 0; i < intBooks.length; i++) {
			result[i] = Integer.valueOf(intBooks[i]);
		}
		return result;

	}
}
