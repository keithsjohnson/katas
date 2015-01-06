package uk.co.keithsjohnson.katas.potter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotterPriceCalculatorImpl {

	public double price(int... books) {

		double finalPrice = -1.0D;

		// Vary Max Book Set Size by 5 and 4 because this can have different
		// prices (Set of 5 Books and Set of 3 books cost more than two sets 4
		// Books). Pick Lowest Price.
		for (int maxBookSetSize = 5; maxBookSetSize >= 4; maxBookSetSize--) {

			// Vary Max Sets of 5 Books between 3 and 4 because three sets of 5
			// and two sets of 4 is cheaper than four sets of 5 and one set of
			// three.
			for (int maxNumberOf5Sets = 3; maxNumberOf5Sets < 5; maxNumberOf5Sets++) {
				// Group Books {0=[0, 0, 0, 0, 0], 1=[1, 1, 1, 1, 1], 2=[3, 3,
				// 3, 3, 3], 3=[2, 2, 2, 2], 4=[4, 4, 4, 4]}
				Map<Integer, List<Integer>> booksByBookMap = Arrays.stream(books).parallel().boxed().collect(Collectors.groupingBy(book -> book));

				Collection<List<Integer>> booksCollection = booksByBookMap.values();
				List<List<Integer>> booksList = new ArrayList<List<Integer>>();
				booksList.addAll(booksCollection);

				// Sort Books by Group Size [[0, 0, 0, 0, 0], [1, 1, 1, 1, 1],
				// [3, 3, 3, 3, 3], [2, 2, 2, 2], [4, 4, 4, 4]]
				Collections.sort(booksList, comparitor);
				System.out.println("booksList: " + booksList.toString());

				// Add Books back to Map but now sorted by Group Size.
				booksByBookMap.clear();
				int mapIndex = 0;
				for (List<Integer> bookListItem : booksList) {
					booksByBookMap.put(mapIndex, bookListItem);
					mapIndex++;
				}

				// Calculate Price of Books for Max Set Size and Max number of 5
				// Sets
				double price = calculatePrice(booksByBookMap, maxBookSetSize, maxNumberOf5Sets);

				// If this price is cheapest found then save as the final price.
				if (finalPrice == -1.0D || price < finalPrice) {
					finalPrice = price;
				}
			}
		}

		return finalPrice;
	}

	private double calculatePrice(Map<Integer, List<Integer>> booksByBookMap, final int maxBookSetSize, final int maxNumberOf5Sets) {

		int useMaxBookSetSize = maxBookSetSize;
		int countOf5BookSets = 0;

		System.out.println("___________________________");
		System.out.println("Start: " + booksByBookMap.toString());
		System.out.println("maxBookSetSize: " + maxBookSetSize);
		System.out.println("maxNumberOf5Sets: " + maxNumberOf5Sets);

		double totalPrice = 0;
		int bookSetCount = 0;
		do {
			// When count of 5 Book Sets is equal to maximum number of 5 Book
			// Sets then reduce the Max Book Set Size by 1 to 4 books in a set.
			if (countOf5BookSets == maxNumberOf5Sets && useMaxBookSetSize == maxBookSetSize) {
				useMaxBookSetSize--;
			}
			// Count and remove book one from each Book List until no more
			// books.
			bookSetCount = countAndRemoveOneBookFromEachList(booksByBookMap, useMaxBookSetSize);

			// Count number if 5 Sets.
			if (bookSetCount == 5) {
				countOf5BookSets++;
			}

			// Calculate bookSetPrice dependent on the number of books in set
			// and the appropriate discount.
			double bookSetPrice = 0D;
			switch (bookSetCount) {
			case 1: // No discount.
				bookSetPrice = bookSetCount * 8D;
				break;
			case 2: // 5% discount.
				bookSetPrice = bookSetCount * 8D * 0.95;
				break;
			case 3:// 10% discount.
				bookSetPrice = bookSetCount * 8D * 0.90;
				break;
			case 4:// 20% discount.
				bookSetPrice = bookSetCount * 8D * 0.80;
				break;
			case 5:// 25% discount.
				bookSetPrice = bookSetCount * 8D * 0.75;
				break;
			}
			System.out.println("Book Set Price=" + bookSetPrice);
			System.out.println("------");

			// Add book Set Price to total Price.
			totalPrice += bookSetPrice;
		} while (bookSetCount > 0);

		System.out.println("Total Price=" + totalPrice);
		return totalPrice;
	}

	private int countAndRemoveOneBookFromEachList(Map<Integer, List<Integer>> booksByBookMap, int maxBookSetSize) {
		final AtomicInteger count = new AtomicInteger();

		// Count and remove book one from each Book List.
		booksByBookMap.keySet().stream().parallel().forEach(key -> {
			if (booksByBookMap.get(key).size() > 0 && count.get() <= maxBookSetSize - 1) {
				booksByBookMap.get(key).remove(0);
				count.incrementAndGet();
			}
		});
		System.out.println(booksByBookMap.toString());
		System.out.println("Count=" + count.get());

		return count.get();

	}

	private final Comparator<List<Integer>> comparitor = new Comparator<List<Integer>>() {
		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {

			return Integer.valueOf(o2.size()).compareTo(Integer.valueOf(o1.size()));
		}
	};

}
