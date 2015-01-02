package uk.co.keithsjohnson.katas.tenpinbowling.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RoundJUnitTest {

	@Test
	public void shouldCreateNormalRound() {
		// Given
		Round testSubject = new Round(1, 2);

		// Then
		assertEquals(1, testSubject.getFirst());
		assertEquals(2, testSubject.getSecond());
		assertTrue(testSubject.isNormal());
		assertFalse(testSubject.isStrike());
		assertFalse(testSubject.isSpare());
	}

	@Test
	public void shouldCreateSpareRound() {
		// Given
		Round testSubject = new Round(1, 9);

		// Then
		assertEquals(1, testSubject.getFirst());
		assertEquals(9, testSubject.getSecond());
		assertFalse(testSubject.isNormal());
		assertFalse(testSubject.isStrike());
		assertTrue(testSubject.isSpare());
	}

	@Test
	public void shouldCreateStrikeRound() {
		// Given
		Round testSubject = new Round(10);

		// Then
		assertEquals(10, testSubject.getFirst());
		assertEquals(0, testSubject.getSecond());
		assertFalse(testSubject.isNormal());
		assertTrue(testSubject.isStrike());
		assertFalse(testSubject.isSpare());
	}
}
