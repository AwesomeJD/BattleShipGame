/*
 * @author Janardhan Sharma
 */
package com.game.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.game.constants.GameConstants;
import com.game.exception.InvalidInputException;
import com.game.initialize.ValidateAndInitializeArea;
import com.game.initialize.ValidateAndInitializeSequences;
import com.game.initialize.ValidateAndInitializeShip;
import com.game.model.Player;

/**
 * The Class GameDriver.
 */
public class GameDriver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws IOException {

		BufferedReader bufferedReader = null;
		File inputFile = null;
		try {
			inputFile = new File("resources/input.txt");
			bufferedReader = new BufferedReader(new FileReader(inputFile));

			// create the player objects with predefined names
			Player player1 = new Player(GameConstants.PLAYER_1_NAME);
			Player player2 = new Player(GameConstants.PLAYER_2_NAME);

			// read the area from input
			String area = bufferedReader.readLine();
			// validate the area input and then populate the players with the area
			new ValidateAndInitializeArea(player1, player2, area).validateAndInitiaze();

			// read the number of ships from the input
			Integer noOfShips = Integer.parseInt(bufferedReader.readLine());
			
			// loop through the input file lines for the number of ships.
			for (int i = 0; i < noOfShips; i++) {

				String shipFullInfo = bufferedReader.readLine();
				String shipPlayer1Info = shipFullInfo.substring(0, 8);
				new ValidateAndInitializeShip(player1, shipPlayer1Info).validateAndInitiaze();
				String shipPlayer2Info = shipFullInfo.substring(0, 6) + shipFullInfo.substring(9, 11);
				new ValidateAndInitializeShip(player2, shipPlayer2Info).validateAndInitiaze();
			}

			// read the hit sequence input for player1
			String player1HitSequence = bufferedReader.readLine();
			// validate and populate the hit sequences for the player1
			new ValidateAndInitializeSequences(player1, player1HitSequence).validateAndInitiaze();

			// read the hit sequence input player2
			String player2HitSequence = bufferedReader.readLine();
			// validate and populate the hit sequences for the player2
			new ValidateAndInitializeSequences(player2, player2HitSequence).validateAndInitiaze();

			// START the GAME
			new GameOperator().play(player1, player2);

		} catch (IOException e) {
			throw new InvalidInputException("Issue with the file : " + e.toString());
		} finally {
			bufferedReader.close();
		}

	}

}
