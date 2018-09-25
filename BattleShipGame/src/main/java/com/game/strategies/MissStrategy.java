/*
 * @author Janardhan Sharma
 */
package com.game.strategies;

import java.text.MessageFormat;
import java.util.logging.Logger;

import com.game.constants.GameConstants;
import com.game.model.Coordinate;
import com.game.model.Player;

/**
 * The Class MissStrategy.
 */
public class MissStrategy implements MissileStrategy {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(MissStrategy.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.game.strategies.MissileStrategy#process(com.game.model.Player,
	 * com.game.model.Coordinate, java.lang.String)
	 */
	@Override
	public void process(Player player, Coordinate missileLocation, String firingPlayer) {
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
				missileLocation.toString(), GameConstants.MISS));
	}
}
