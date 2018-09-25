/*
 * @author Janardhan Sharma
 */
package com.game.strategies;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.game.enums.ShipType;
import com.game.model.Coordinate;
import com.game.model.Player;
import com.game.model.Ship;

/**
 * The Class HitStrategyTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class HitStrategyTest {

	/** The ship. */
	@Mock
	public Ship ship;

	/**
	 * Test hit strategy.
	 */
	@Test
	public void test_hit_strategy() {

		// given
		Coordinate coordinate = new Coordinate('A', 5);
		Player player = new Player("TEST");
		player.addShipLocation(coordinate, ship);
		player.addShip(ship);

		when(ship.getType()).thenReturn(ShipType.P);
		when(ship.getHitsRequired()).thenReturn(0);

		// when
		new HitStrategy().process(player, coordinate, "AnotherPlayer");

		// then
		verify(ship).decrementRequiredHits();
		assertThat(player.getShips(), hasSize(0));
		assertThat(player.getShipLocations().keySet(), hasSize(0));

	}
}
