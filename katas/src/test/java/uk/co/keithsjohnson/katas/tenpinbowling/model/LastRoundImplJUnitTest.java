package uk.co.keithsjohnson.katas.tenpinbowling.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LastRoundImplJUnitTest {

	@Test
	public void shouldCreateStrikeLastRound() {
		// Given
		Round testSubject = new LastRoundImpl(10, 10, 10);

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

	@Test
	public void shouldCallToString() {
		// Given
		Round testSubject = new LastRoundImpl(10, 10, 10);

		// Then
		System.out.println(testSubject.toString());
	}
}
