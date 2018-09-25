/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

import com.game.constants.GameConstants;
import com.game.exception.InvalidInputException;
import com.game.model.Player;

/**
 * The Class ValidateAndInitializeAreaTest.
 */
public class ValidateAndInitializeAreaTest {

	/**
	 * Test validate and initialize area.
	 */
	@Test
	public void test_validate_and_initialize_area() {
		// given
		Player player1 = new Player(GameConstants.PLAYER_1_NAME);
		Player player2 = new Player(GameConstants.PLAYER_2_NAME);

		String area = "5 E";

		// when
		new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();

		// then
		assertThat(player1.getArea(), is(not(equalTo(null))));
		assertThat(player2.getArea(), is(not(equalTo(null))));

	}

	/**
	 * Test validate and initialize area invalid input.
	 */
	@Test(expected = InvalidInputException.class)
	public void test_validate_and_initialize_area_invalid_input() {
		// given
		Player player1 = new Player(GameConstants.PLAYER_1_NAME);
		Player player2 = new Player(GameConstants.PLAYER_2_NAME);

		String area = "5 x";

		// when
		new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();

		// then throws exception

	}
}
