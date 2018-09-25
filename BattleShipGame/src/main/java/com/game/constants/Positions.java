/*
 * @author Janardhan Sharma
 */
package com.game.constants;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.game.exception.InvalidInputException;

/**
 * The Class Positions.
 */
public class Positions {

	/** The height. */
	protected Map<Character, Integer> HEIGHT = new LinkedHashMap<>();
	
	/** The width. */
	protected Set<Integer> WIDTH = new LinkedHashSet<>();

	/**
	 * Instantiates a new positions.
	 */
	public Positions() {
		load();
	}

	/**
	 * Load.
	 */
	protected void load() {
		String[] heights = GameConstants.HEIGHTS.split(",");

		for (int index = 0; index < 26; index++) {
			HEIGHT.put(heights[index].charAt(0), index);
		}

		for (int i = 1; i <= GameConstants.WIDTH_LIMIT; i++) {
			WIDTH.add(i);
		}
	}

	/**
	 * Gets the next height.
	 *
	 * @param heightPosition the height position
	 * @return the next height
	 */
	public Character getNextHeight(Character heightPosition) {
		Character nextPosition = null;
		if (!HEIGHT.containsKey(heightPosition)) {
			throw new InvalidInputException("Invalid Height position look up detected.");
		}
		Iterator<Map.Entry<Character, Integer>> iterator = HEIGHT.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getKey().equals(heightPosition)) {
				if (iterator.hasNext()) {
					nextPosition = iterator.next().getKey();
				}
				break;
			}
		}
		return nextPosition;
	}

	/**
	 * Gets the next width.
	 *
	 * @param widthPosition the width position
	 * @return the next width
	 */
	public Integer getNextWidth(Integer widthPosition) {
		Integer nextPosition = null;
		if (!WIDTH.contains(widthPosition)) {
			throw new InvalidInputException("Invalid width position look up detected.");
		}
		Iterator<Integer> iterator = WIDTH.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(widthPosition)) {
				if (iterator.hasNext()) {
					nextPosition = iterator.next();
				}
				break;
			}
		}
		return nextPosition;
	}

	/**
	 * Checks if is width present.
	 *
	 * @param width the width
	 * @return the boolean
	 */
	public Boolean isWidthPresent(Integer width) {
		return WIDTH.contains(width);
	}

	/**
	 * Checks if is height present.
	 *
	 * @param height the height
	 * @return the boolean
	 */
	public Boolean isHeightPresent(Character height) {
		return HEIGHT.containsKey(height);
	}
}
