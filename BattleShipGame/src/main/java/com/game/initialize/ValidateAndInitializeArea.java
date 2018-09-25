/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import com.game.constants.Positions;
import com.game.exception.InvalidInputException;
import com.game.model.BattleArea;
import com.game.model.Player;
import com.game.util.Util;

/**
 * The Class ValidateAndInitializeArea.
 */
public class ValidateAndInitializeArea implements ValidateAndInitialize {

	/** The player 1. */
	private Player player1;
	
	/** The player 2. */
	private Player player2;
	
	/** The area. */
	private String area;

	/**
	 * Instantiates a new validate and initialize area.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @param area the area
	 */
	public ValidateAndInitializeArea(Player player1, Player player2, String area) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.area = area;
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.ValidateAndInitialize#validateAndInitiaze()
	 */
	@Override
	public void validateAndInitiaze() throws InvalidInputException {
		Positions positions = new Positions();
		Integer width = Util.getInteger(area.substring(0, 1));
		Character height = Util.getCharacter(area.substring(2, 3));
		if (positions.isHeightPresent(height) && positions.isWidthPresent(width)) {
			player1.setArea(new BattleArea(height, width));
			player2.setArea(new BattleArea(height, width));
		} else {
			throw new InvalidInputException("Invalid area parameters provided.");
		}
	}
}
