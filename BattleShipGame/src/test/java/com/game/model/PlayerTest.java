/*
 * @author Janardhan Sharma
 */
package com.game.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class PlayerTest.
 */
public class PlayerTest {

	/** The player. */
	Player player;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		player = new Player("TEST");
		player.setHitSequence(new Coordinate('A', 5));
	}

	/**
	 * Test missiles empty.
	 */
	@Test
	public void test_missiles_empty() {

		// given

		// when

		// then
		assertThat(player.isMissilesOver(), is(equalTo(Boolean.FALSE)));
	}

	/**
	 * Test get hit sequence.
	 */
	@Test
	public void test_get_hit_sequence() {

		// given

		// when
		player.getHitSequence();

		// then
		assertThat(player.checkHitSequence(), is(equalTo(null)));
	}

}
