package uk.co.keithsjohnson.katas.potter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PotterPriceCalculatorImplJUnitTest {

	private PotterPriceCalculatorImpl potterPriceCalculatorImpl;

	@Before
	public void setUp() {
		potterPriceCalculatorImpl = new PotterPriceCalculatorImpl();
	}

	@Test
	public void shouldCalculatePriceFor0Books() {
		// Given
		int[] books = {};

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(0D, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor1Book() {
		// Given
		int[] books = { 0 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(1 * 8D, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor2SameBook() {
		// Given
		int[] books = { 0, 0 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(books.length * 8D, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor3SameBook() {
		// Given
		int[] books = { 1, 1, 1 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(books.length * 8D, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor2DifferentBooks() {
		// Given
		int[] books = { 0, 1 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8D * 2 * 0.95, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor3DifferentBooks() {
		// Given
		int[] books = { 0, 2, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8D * 3 * 0.9, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor4DifferentBooks() {
		// Given
		int[] books = { 0, 1, 2, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8D * 4 * 0.8, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor5DifferentBooks() {
		// Given
		int[] books = { 0, 1, 2, 3, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8D * 5 * 0.75, price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor3Books() {
		// Given
		int[] books = { 0, 0, 1 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8D + (8D * 2 * 0.95), price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor4Books() {
		// Given
		int[] books = { 0, 0, 1, 1 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(2 * (8 * 2 * 0.95), price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor6Books() {
		// Given
		int[] books = { 0, 0, 1, 2, 2, 3 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), price, 0D);
	}

	@Test
	public void shouldCalculatePriceFor6MoreBooks() {
		// Given
		int[] books = { 0, 1, 1, 2, 3, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(8 + (8 * 5 * 0.75), price, 0D);
	}

	@Test
	@Ignore
	public void shouldCalculatePriceForEdgeCase1() {
		// Given
		int[] books = { 0, 0, 1, 1, 2, 2, 3, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(2 * (8 * 4 * 0.8), price, 0D);
	}

	@Test
	@Ignore
	public void shouldCalculatePriceForEdgeCase2() {
		// Given
		int[] books = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4 };

		// When
		double price = potterPriceCalculatorImpl.price(books);

		// Then
		assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), price, 0D);
	}
}
