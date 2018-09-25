/*
 * @author Janardhan Sharma
 */
package com.game.strategies;

import java.text.MessageFormat;
import java.util.logging.Logger;

import com.game.constants.GameConstants;
import com.game.model.Coordinate;
import com.game.model.Player;
import com.game.model.Ship;

/**
 * The Class HitStrategy.
 */
public class HitStrategy implements MissileStrategy {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(HitStrategy.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.strategies.MissileStrategy#process(com.game.model.Player,
	 * com.game.model.Coordinate, java.lang.String)
	 */
	@Override
	public void process(Player player, Coordinate missileLocation, String firingPlayer) {

		Ship ship = player.getShipLocations().get(missileLocation);
		ship.decrementRequiredHits();
		if (ship.getHitsRequired() == 0) {
			player.removeShipCoordinate(missileLocation);
			player.removeShip(ship);
		}

		outputMessage(missileLocation, firingPlayer);
	}

	/**
	 * Output message.
	 *
	 * @param missileLocation the missile location
	 * @param firingPlayer the firing player
	 */
	private void outputMessage(Coordinate missileLocation, String firingPlayer) {
		LOGGER.info(MessageFormat.format("\n\n {0}{1}{2}{3} \n\n", firingPlayer, GameConstants.FIRES_MISSLE,
				missileLocation.toString(), GameConstants.HIT));
	}

}
