/*
 * @author Janardhan Sharma
 */
package com.game.util;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * The Class UtilTest.
 */
public class UtilTest {

	/**
	 * Test get integer.
	 */
	@Test
	public void test_getInteger() {
		// given
		String input = "1";
		Integer expected = 1;

		// when
		Integer returnValue = Util.getInteger(input);

		// then
		assertThat(returnValue, is(equalTo(expected)));
	}

	/**
	 * Test get character.
	 */
	@Test
	public void test_getCharacter() {
		// given
		String input = "A";
		Character expected = new Character('A');

		// when
		Character returnValue = Util.getCharacter(input);

		// then
		assertThat(returnValue, is(equalTo(expected)));
	}

	/**
	 * Test get string array.
	 */
	@Test
	public void test_getStringArray() {
		// given
		String input = "A1 B2 D7";
		String[] expected = { "A1", "B2", "D7" };

		// when
		String[] returnValue = Util.getStringArray(input);

		// then
		assertThat(returnValue, is(equalTo(expected)));
	}

	/**
	 * Test get random id.
	 */
	@Test
	public void test_getRandomId() {
		// given
		// when
		String randomId = Util.getRandomId();

		// then
		assertThat(randomId, instanceOf(String.class));
	}

}
