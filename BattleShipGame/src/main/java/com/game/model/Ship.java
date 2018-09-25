/*
 * @author Janardhan Sharma
 */
package com.game.model;

import java.util.HashSet;
import java.util.Set;

import com.game.enums.ShipType;
import com.game.util.Util;

/**
 * The Class Ship.
 */
public class Ship {

	/** The type. */
	private ShipType type;

	/** The name. */
	private String name;

	/** The hits required. */
	private Integer hitsRequired;

	/** The coordinates. */
	Set<Coordinate> coordinates;

	/** The initial postion. */
	private Coordinate initialPostion;

	/** The witdh. */
	private Integer witdh;

	/** The height. */
	private Integer height;

	/**
	 * Instantiates a new ship.
	 *
	 * @param type the type
	 */

	public Ship(ShipType type) {
		super();
		this.type = type;
		this.name = Util.getRandomId();
		this.coordinates = new HashSet<>();
		this.hitsRequired = type.getRequiredHits();
	}

	/**
	 * Instantiates a new ship.
	 */
	public Ship() {
		super();
	}

	/**
	 * Gets the hits required.
	 *
	 * @return the hits required
	 */
	public Integer getHitsRequired() {
		return hitsRequired;
	}

	/**
	 * Decrement required hits.
	 */
	public void decrementRequiredHits() {
		this.hitsRequired = hitsRequired - 1;
	}

	/**
	 * Gets the coordinates.
	 *
	 * @return the coordinates
	 */
	public Set<Coordinate> getCoordinates() {
		return this.coordinates;
	}

	/**
	 * Sets the coordinates.
	 *
	 * @param coordinate the new coordinates
	 */
	public void setCoordinates(Coordinate coordinate) {
		this.coordinates.add(coordinate);
	}

	/**
	 * Gets the initial postion.
	 *
	 * @return the initial postion
	 */
	public Coordinate getInitialPostion() {
		return initialPostion;
	}

	/**
	 * Sets the initial postion.
	 *
	 * @param initialPostion the new initial postion
	 */
	public void setInitialPostion(Coordinate initialPostion) {
		this.initialPostion = initialPostion;
	}

	/**
	 * Gets the witdh.
	 *
	 * @return the witdh
	 */
	public Integer getWitdh() {
		return witdh;
	}

	/**
	 * Sets the witdh.
	 *
	 * @param witdh the new witdh
	 */
	public void setWitdh(Integer witdh) {
		this.witdh = witdh;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ShipType getType() {
		return type;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
