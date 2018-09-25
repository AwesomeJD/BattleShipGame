/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import com.game.exception.InvalidInputException;
import com.game.model.Coordinate;
import com.game.model.Player;
import com.game.util.Util;

/**
 * The Class ValidateAndInitializeSequences.
 */
public class ValidateAndInitializeSequences implements ValidateAndInitialize {

	/** The player. */
	private Player player;
	
	/** The sequences. */
	private String sequences;

	/**
	 * Instantiates a new validate and initialize sequences.
	 *
	 * @param player the player
	 * @param sequences the sequences
	 */
	public ValidateAndInitializeSequences(Player player, String sequences) {
		super();
		this.player = player;
		this.sequences = sequences;
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.ValidateAndInitialize#validateAndInitiaze()
	 */
	@Override
	public void validateAndInitiaze() throws InvalidInputException {

		String[] sequencesArray = Util.getStringArray(sequences);

		for (String sequence : sequencesArray) {
			Character height = Util.getCharacter(sequence.substring(0, 1));
			Integer width = Util.getInteger(sequence.substring(1, 2));

			if (player.getArea().isHeightPresent(height) && player.getArea().isWidthPresent(width)) {
				player.setHitSequence(new Coordinate(height, width));
			} else {
				throw new InvalidInputException("Invalid hit sequence detected. " + sequence);
			}
		}
	}
}
