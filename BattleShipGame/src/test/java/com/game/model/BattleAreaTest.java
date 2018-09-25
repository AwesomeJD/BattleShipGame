/*
 * @author Janardhan Sharma
 */
package com.game.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * The Class BattleAreaTest.
 */
public class BattleAreaTest {
	
	/**
	 * Test get next height position.
	 */
	@Test
	public void test_get_next_height_position() {
		// given
		Character height = new Character('C');
		Character nextHeightExpected = new Character('D');

		// when
		BattleArea area = new BattleArea('E', 5);
		Character nextHeight = area.getNextHeight(height);

		// then
		assertThat(nextHeightExpected, is(equalTo(nextHeight)));
	}

	/**
	 * Test get next width position.
	 */
	@Test
	public void test_get_next_width_position() {
		// given
		Integer nextWidthExpected = new Integer(4);

		// when
		BattleArea area = new BattleArea('E', 5);
		Integer nextWidth = area.getNextWidth(3);

		// then
		assertThat(nextWidthExpected, is(equalTo(nextWidth)));
	}
}
