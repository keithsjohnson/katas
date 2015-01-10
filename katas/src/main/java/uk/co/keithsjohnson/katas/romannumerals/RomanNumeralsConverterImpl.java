package uk.co.keithsjohnson.katas.romannumerals;

public class RomanNumeralsConverterImpl {

	public String convert(int value) {
		switch (value) {
		case 1:
			return "I";
		case 2:
			return "II";
		case 3:
			return "III";
		}
		throw new RuntimeException("Unknown value: " + value);
	}
}
