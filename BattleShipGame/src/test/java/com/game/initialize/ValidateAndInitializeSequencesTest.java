/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.game.constants.GameConstants;
import com.game.exception.InvalidInputException;
import com.game.model.Coordinate;
import com.game.model.Player;

/**
 * The Class ValidateAndInitializeSequencesTest.
 */
public class ValidateAndInitializeSequencesTest {

	/**
	 * Test validate and initialize sequences test.
	 */
	@Test
	public void test_validate_and_initialize_sequences_test() {

		// given
		String sequence = "A1 B2 B2 B3";
		Player player1 = new Player(GameConstants.PLAYER_1_NAME);
		Player player2 = new Player(GameConstants.PLAYER_2_NAME);
		String area = "5 E";
		new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();

		// when
		new ValidateAndInitializeSequences(player1, sequence).validateAndInitiaze();

		// then
		assertThat(player1.getHitSequence(), is(equalTo(new Coordinate('A', 1))));
		assertThat(player1.getHitSequence(), is(equalTo(new Coordinate('B', 2))));
		assertThat(player1.getHitSequence(), is(equalTo(new Coordinate('B', 2))));
		assertThat(player1.getHitSequence(), is(equalTo(new Coordinate('B', 3))));

	}

	/**
	 * Test validate and initialize sequences invalid sequence test.
	 */
	@Test(expected = InvalidInputException.class)
	public void test_validate_and_initialize_sequences_invalid_sequence_test() {

		// given
		String sequence = "A1 B2 A2 Z3";
		Player player1 = new Player(GameConstants.PLAYER_1_NAME);
		Player player2 = new Player(GameConstants.PLAYER_2_NAME);
		String area = "5 E";
		new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();

		// when
		new ValidateAndInitializeSequences(player1, sequence).validateAndInitiaze();

		// then

	}

}
