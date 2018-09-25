/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import java.util.Objects;

import com.game.enums.ShipType;
import com.game.exception.InvalidInputException;
import com.game.model.BattleArea;
import com.game.model.Coordinate;
import com.game.model.Player;
import com.game.model.Ship;
import com.game.util.Util;

/**
 * The Class ValidateAndInitializeShip.
 */
public class ValidateAndInitializeShip extends AbstractShipInitializer implements ValidateAndInitialize {

	/** The player. */
	private Player player;
	
	/** The ship info. */
	private String shipInfo;

	/**
	 * Instantiates a new validate and initialize ship.
	 *
	 * @param player the player
	 * @param shipInfo the ship info
	 */
	public ValidateAndInitializeShip(Player player, String shipInfo) {
		super();
		this.player = player;
		this.shipInfo = shipInfo;
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.ValidateAndInitialize#validateAndInitiaze()
	 */
	@Override
	public void validateAndInitiaze() throws InvalidInputException {
		String[] shipInfoArray = Util.getStringArray(shipInfo);
		Ship ship = new Ship(getShipType(shipInfoArray));

		initailizeShip(shipInfoArray, ship);
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.AbstractShipInitializer#setShipDimensions(java.lang.String[], com.game.model.Ship)
	 */
	@Override
	protected void setShipDimensions(String[] shipInfoArray, Ship ship) {
		Integer width = Util.getInteger(shipInfoArray[1]);
		Integer height = Util.getInteger(shipInfoArray[2]);
		ship.setHeight(height);
		ship.setWitdh(width);
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.AbstractShipInitializer#setShipLocation(java.lang.String[], com.game.model.Ship)
	 */
	@Override
	protected void setShipLocation(String[] shipInfoArray, Ship ship) {
		Character height = Util.getCharacter(shipInfoArray[3].substring(0, 1));
		Integer width = Util.getInteger(shipInfoArray[3].substring(1, 2));

		if (player.getArea().isHeightPresent(height) && player.getArea().isWidthPresent(width)) {
			ship.setInitialPostion(new Coordinate(height, width));
		} else {
			throw new InvalidInputException("Invalid hit sequence detected. " + shipInfoArray[3]);
		}
	}

	/* (non-Javadoc)
	 * @see com.game.initialize.AbstractShipInitializer#setShipCoordinates(java.lang.String[], com.game.model.Ship)
	 */
	@Override
	protected void setShipCoordinates(String[] shipInfoArray, Ship ship) {

		Coordinate shipLocation = ship.getInitialPostion();
		BattleArea area = player.getArea();

		ship.setCoordinates(shipLocation);
		Integer currentWidth = shipLocation.getWidth();
		Character currentHeight = shipLocation.getHeight();

		for (int i = 0; i < ship.getWitdh(); i++) {
			Integer nextWidth = i == 0 ? currentWidth : area.getNextWidth(currentWidth);
			for (int j = 0; j < ship.getHeight(); j++) {
				Character nextHeight = j == 0 ? currentHeight : area.getNextHeight(currentHeight);
				Coordinate currentCoordinate = new Coordinate(nextHeight, nextWidth);
				checkShipLocationOverlap(currentCoordinate);
				ship.setCoordinates(currentCoordinate);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.game.initialize.AbstractShipInitializer#loadShipDetailsInPlayer(com.game.model.Ship)
	 */
	@Override
	protected void loadShipDetailsInPlayer(Ship ship) {
		ship.getCoordinates().forEach(coordinate -> player.addShipLocation(coordinate, ship));
		player.addShip(ship);
	}

	/**
	 * Gets the ship type.
	 *
	 * @param shipInfoArray the ship info array
	 * @return the ship type
	 */
	private ShipType getShipType(String[] shipInfoArray) {
		ShipType shipType = ShipType.valueOf(shipInfoArray[0]);
		if (Objects.isNull(shipType)) {
			throw new InvalidInputException("Invalid ship type provided : " + shipInfoArray[0]);
		}
		return shipType;
	}

	/**
	 * Check ship location overlap.
	 *
	 * @param currentCoordinate the current coordinate
	 */
	private void checkShipLocationOverlap(Coordinate currentCoordinate) {
		if (player.getShipLocations().containsKey(currentCoordinate))
			throw new InvalidInputException("Ship location overlap for : " + currentCoordinate.toString());
	}

}
