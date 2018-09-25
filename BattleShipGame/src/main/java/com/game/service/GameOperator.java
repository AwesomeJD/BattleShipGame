/*
 * @author Janardhan Sharma
 */
package com.game.service;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.logging.Logger;

import com.game.constants.GameConstants;
import com.game.model.Player;
import com.game.strategies.HitStrategy;
import com.game.strategies.MissStrategy;

/**
 * The Class GameOperator.
 */
public class GameOperator {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(GameOperator.class.getName());

	/**
	 * Play.
	 * 
	 * Games continues until the missiles are empty for both the players or the
	 * there is a winner.
	 * 
	 * Firing is done by player1 first and then the player two. This could have been
	 * made fair by adding a tossing criteria.
	 * 
	 * after each firing a winner check is done.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 */
	public void play(Player player1, Player player2) {
		while (!stopCondition(player1, player2)) {

			fire(player2, player1);
			if (checkWinner(player2, player1))
				return;
			fire(player1, player2);
			if (checkWinner(player1, player2))
				return;
		}
		LOGGER.info("\n\n" + GameConstants.GAME_DRAWN_MISSILES_OVER + "\n\n");
	}

	/**
	 * Check winner.
	 *
	 * @param hitRecievingPlayer the hit recieving player
	 * @param firingPlayer       the firing player
	 * @return the boolean
	 */
	private Boolean checkWinner(Player hitRecievingPlayer, Player firingPlayer) {
		if (hitRecievingPlayer.getShipCount().equals(0)) {
			LOGGER.info(MessageFormat.format("\n\n {0} {1} \n\n", firingPlayer.getName(), GameConstants.GAME_WON));
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Fire. First it checks if the there are any missiles available with the firing
	 * player.
	 * 
	 * Takes the missile from firingPlayer and checks in the hitRecieving player if
	 * the missile exists. If it exists a HitStartegy is called else a MissStartegy.
	 *
	 * @param hitRecievingPlayer the hit recieving player
	 * @param firingPlayer       the firing player
	 */
	private void fire(Player hitRecievingPlayer, Player firingPlayer) {
		if (Objects.isNull(firingPlayer.checkHitSequence())) {
			LOGGER.info(
					MessageFormat.format("\n\n {0} {1} \n\n", firingPlayer.getName(), GameConstants.NO_MISSLES_LEFT));
			return;
		}
		while (hitRecievingPlayer.getShipLocations().containsKey(firingPlayer.checkHitSequence())) {
			new HitStrategy().process(hitRecievingPlayer, firingPlayer.getHitSequence(), firingPlayer.getName());
		}
		new MissStrategy().process(hitRecievingPlayer, firingPlayer.getHitSequence(), firingPlayer.getName());
	}

	/**
	 * Stop condition. Checks if the missiles are over both the players aresenal :)
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return the boolean
	 */
	private Boolean stopCondition(Player player1, Player player2) {
		if (player1.isMissilesOver() && player2.isMissilesOver()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
