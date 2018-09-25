/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.game.constants.GameConstants;
import com.game.model.Coordinate;
import com.game.model.Player;

/**
 * The Class ValidateAndInitializeShipTest.
 */
public class ValidateAndInitializeShipTest {

	/** The player 1. */
	public Player player1;
	
	/** The player 2. */
	public Player player2;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		player1 = new Player(GameConstants.PLAYER_1_NAME);
		player2 = new Player(GameConstants.PLAYER_2_NAME);
		String area = "5 E";
		new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();
	}

	/**
	 * Test validate and initiliaze ship with one x one dimension.
	 */
	@Test
	public void test_validate_and_initiliaze_ship_with_one_x_one_dimension() {
		// given

		String shipPlayer1Info = "Q 1 1 A1";

		// when
		ValidateAndInitializeShip validator = new ValidateAndInitializeShip(player1, shipPlayer1Info);
		validator.validateAndInitiaze();

		// then
		assertThat(player1.getShipLocations().size(), is(equalTo(1)));
		assertThat(player1.getShipLocations(), hasKey(new Coordinate('A', 1)));

	}

	/**
	 * Test validate and initiliaze ship with horizontal dimension.
	 */
	@Test
	public void test_validate_and_initiliaze_ship_with_horizontal_dimension() {
		// given
		String shipPlayer1Info = "P 2 1 D4";

		// when
		ValidateAndInitializeShip validator = new ValidateAndInitializeShip(player1, shipPlayer1Info);
		validator.validateAndInitiaze();

		// then
		assertThat(player1.getShipLocations().size(), is(equalTo(2)));
		assertThat(player1.getShipLocations(), hasKey(new Coordinate('D', 4)));
		assertThat(player1.getShipLocations(), hasKey(new Coordinate('D', 5)));

	}

	/**
	 * Test validate and initiliaze ship with vertical dimension.
	 */
	@Test
	public void test_validate_and_initiliaze_ship_with_vertical_dimension() {
		// given
		String shipPlayer1Info = "P 1 2 D4";

		// when
		ValidateAndInitializeShip validator = new ValidateAndInitializeShip(player1, shipPlayer1Info);
		validator.validateAndInitiaze();

		// then
		assertThat(player1.getShipLocations().size(), is(equalTo(2)));
		assertThat(player1.getShipLocations(), hasKey(new Coordinate('D', 4)));
		assertThat(player1.getShipLocations(), hasKey(new Coordinate('E', 4)));

	}

}
