package uk.co.keithsjohnson.katas.romannumerals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsConverterImplJUnitTest {

	private RomanNumeralsConverterImpl testSubject;

	@Before
	public void setUp() {
		testSubject = new RomanNumeralsConverterImpl();
	}

	@Test
	public void shouldConvert1() {
		// Given
		int value = 1;

		// When
		String result = testSubject.convert(value);

		// Then
		assertEquals("I", result);
	}
}
