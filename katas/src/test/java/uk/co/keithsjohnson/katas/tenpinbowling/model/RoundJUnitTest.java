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
		assertEquals(0, testSubject.getThird());
		assertEquals(3, testSubject.score());
		assertTrue(testSubject.isNormal());
		assertFalse(testSubject.isStrike());
		assertFalse(testSubject.isSpare());
		assertFalse(testSubject.isLastRound());
	}

	@Test
	public void shouldCreateSpareRound() {
		// Given
		Round testSubject = new Round(1, 9);

		// Then
		assertEquals(1, testSubject.getFirst());
		assertEquals(9, testSubject.getSecond());
		assertEquals(0, testSubject.getThird());
		assertEquals(10, testSubject.score());
		assertFalse(testSubject.isNormal());
		assertFalse(testSubject.isStrike());
		assertTrue(testSubject.isSpare());
		assertFalse(testSubject.isLastRound());
	}

	@Test
	public void shouldCreateStrikeRound() {
		// Given
		Round testSubject = new Round(10);

		// Then
		assertEquals(10, testSubject.getFirst());
		assertEquals(0, testSubject.getSecond());
		assertEquals(0, testSubject.getThird());
		assertEquals(10, testSubject.score());

		assertFalse(testSubject.isNormal());
		assertTrue(testSubject.isStrike());
		assertFalse(testSubject.isSpare());
		assertFalse(testSubject.isLastRound());
	}

	@Test
	public void shouldCreateStrikeLastRound() {
		// Given
		Round testSubject = new Round(10, 10, 10);

		// Then
		assertEquals(10, testSubject.getFirst());
		assertEquals(10, testSubject.getSecond());
		assertEquals(10, testSubject.getThird());
		assertEquals(20, testSubject.score());
		assertFalse(testSubject.isNormal());
		assertTrue(testSubject.isStrike());
		assertFalse(testSubject.isSpare());
		assertTrue(testSubject.isLastRound());
	}
}
