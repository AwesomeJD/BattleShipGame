/*
 * @author Janardhan Sharma
 */
package com.game.enums;

/**
 * The Enum ShipType.
 */
public enum ShipType {

	/** The p. */
	P(1),
	
	/** The q. */
	Q(2);

	/** The required hits. */
	private Integer requiredHits;

	/**
	 * Instantiates a new ship type.
	 *
	 * @param requiredHits the required hits
	 */
	private ShipType(Integer requiredHits) {
		this.requiredHits = requiredHits;
	}

	/**
	 * Gets the required hits.
	 *
	 * @return the required hits
	 */
	public Integer getRequiredHits() {
		return this.requiredHits;
	}

}
