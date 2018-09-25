/*
 * @author Janardhan Sharma
 */
package com.game.strategies;

import com.game.model.Coordinate;
import com.game.model.Player;

/**
 * The Interface MissileStrategy.
 */
public interface MissileStrategy {

	/**
	 * Process.
	 *
	 * @param player the player
	 * @param missileLocation the missile location
	 * @param firingPlayer the firing player
	 */
	public void process(Player player, Coordinate missileLocation, String firingPlayer);
}
