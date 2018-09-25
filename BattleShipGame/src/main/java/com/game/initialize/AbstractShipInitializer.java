/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import com.game.model.Ship;

/**
 * The Class AbstractShipInitializer.
 * 
 * This follows a TEMPALTE design pattern.
 * 
 * The process of creating ships needs to follow a specific order, and hence
 * this pattern suits it.
 */
public abstract class AbstractShipInitializer {

	/**
	 * Initialize ship.
	 *
	 * @param shipInfoArray the ship info array
	 * @param ship          the ship
	 */
	public final void initailizeShip(String[] shipInfoArray, Ship ship) {
		setShipDimensions(shipInfoArray, ship);
		setShipLocation(shipInfoArray, ship);
		setShipCoordinates(shipInfoArray, ship);
		loadShipDetailsInPlayer(ship);
	}

	/**
	 * Sets the ship dimensions.
	 * 
	 * Validates the ships Dimensions and then sets the dimension values in the ship
	 * object.
	 *
	 * @param shipInfoArray the ship info array
	 * @param ship          the ship
	 */
	protected abstract void setShipDimensions(String[] shipInfoArray, Ship ship);

	/**
	 * Sets the ship location.
	 * 
	 * Validates the ship location and then sets the ship initial position.
	 *
	 * @param shipInfoArray the ship info array
	 * @param ship          the ship
	 */
	protected abstract void setShipLocation(String[] shipInfoArray, Ship ship);

	/**
	 * Sets the ship coordinates.
	 *
	 * Uses the SHip initial location and then ship dimensions to generate the ships
	 * coordinates in the battle area.
	 *
	 * @param shipInfoArray the ship info array
	 * @param ship          the ship
	 */
	protected abstract void setShipCoordinates(String[] shipInfoArray, Ship ship);

	/**
	 * Load ship details in player.
	 * 
	 * Loads the ships coordinates in the Player that can be used to check if the
	 * all the ships are sunk for a particular player.
	 *
	 * @param ship the ship
	 */
	protected abstract void loadShipDetailsInPlayer(Ship ship);

}