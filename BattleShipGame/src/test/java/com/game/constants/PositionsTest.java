/*
 * @author Janardhan Sharma
 */
package com.game.constants;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * The Class PositionsTest.
 */
public class PositionsTest {

	/**
	 * Test get next position.
	 */
	@Test
	public void test_get_next_position() {
		// given
		Character height = new Character('Y');
		Character nextHeightExpected = new Character('Z');

		// when
		Character nextHeight = new Positions().getNextHeight(height);

		// then
		assertThat(nextHeightExpected, is(nextHeight));
	}

}
