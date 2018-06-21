package TimeDuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import TimeDuration.BadBadValueException;

public class TestTimeDuration {

	@Test(expected=NullPointerException.class)
	public void testNullSeconds() throws BadBadValueException {
		new TimeDuration(null);
	}

	@Test(expected=BadBadValueException.class)
	public void testNegativeSeconds() throws BadBadValueException {
		new TimeDuration(-5);
	}
	
	@Test
	public void testToStringOnlySecond() throws BadBadValueException {
		assertEquals("0s", new TimeDuration(0).toString());
	}
	@Test
	public void testToStringMinuteSecond() throws BadBadValueException {
		assertEquals("12m 12s", new TimeDuration(732).toString());
	}
	
	@Test
	public void testToStringHourMinuteSecond() throws BadBadValueException {
		assertEquals("2h 0m 42s", new TimeDuration(7242).toString());
	}
	
}
