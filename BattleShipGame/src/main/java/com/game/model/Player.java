/*
 * @author Janardhan Sharma
 */
package com.game.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * The Class Player.
 */
public class Player {

	/** The area. */
	private BattleArea area;
	
	/** The name. */
	private String name;
	
	/** The ships. */
	private Set<Ship> ships;
	
	/** The hit sequence. */
	private Queue<Coordinate> hitSequence;
	
	/** The ship locations. */
	private Map<Coordinate, Ship> shipLocations;

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 */
	public Player(String name) {
		super();
		this.name = name;
		this.ships = new HashSet<>();
		this.hitSequence = new LinkedList<>();
		this.shipLocations = new HashMap<>();
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public BattleArea getArea() {
		return area;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the ships.
	 *
	 * @return the ships
	 */
	public Set<Ship> getShips() {
		return ships;
	}

	/**
	 * Adds the ship.
	 *
	 * @param ship the ship
	 */
	public void addShip(Ship ship) {
		this.ships.add(ship);
	}

	/**
	 * Removes the ship.
	 *
	 * @param ship the ship
	 */
	public void removeShip(Ship ship) {
		this.ships.remove(ship);
	}

	/**
	 * Gets the ship locations.
	 *
	 * @return the ship locations
	 */
	public Map<Coordinate, Ship> getShipLocations() {
		return shipLocations;
	}

	/**
	 * Removes the ship coordinate.
	 *
	 * @param coordinate the coordinate
	 */
	public void removeShipCoordinate(Coordinate coordinate) {
		this.shipLocations.remove(coordinate);
	}

	/**
	 * Adds the ship location.
	 *
	 * @param coordinate the coordinate
	 * @param ship the ship
	 */
	public void addShipLocation(Coordinate coordinate, Ship ship) {
		this.shipLocations.put(coordinate, ship);
	}

	/**
	 * Gets the ship count.
	 *
	 * @return the ship count
	 */
	public Integer getShipCount() {
		return this.ships.size();
	}

	/**
	 * Check hit sequence.
	 *
	 * @return the coordinate
	 */
	// methods to operate on the hit sequences
	public Coordinate checkHitSequence() {
		return hitSequence.peek();
	}

	/**
	 * Gets the hit sequence.
	 *
	 * @return the hit sequence
	 */
	public Coordinate getHitSequence() {
		return hitSequence.poll();
	}

	/**
	 * Sets the hit sequence.
	 *
	 * @param sequence the new hit sequence
	 */
	public void setHitSequence(Coordinate sequence) {
		this.hitSequence.add(sequence);
	}

	/**
	 * Checks if is missiles over.
	 *
	 * @return the boolean
	 */
	public Boolean isMissilesOver() {
		return this.hitSequence.size() > 0 ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	public void setArea(BattleArea area) {
		this.area = area;
	}

}
