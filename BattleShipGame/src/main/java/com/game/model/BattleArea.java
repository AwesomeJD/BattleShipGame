/*
 * @author Janardhan Sharma
 */
package com.game.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.game.constants.GameConstants;
import com.game.constants.Positions;

/**
 * The Class BattleArea.
 */
public class BattleArea extends Positions {
	
	/** The width. */
	private Integer width;
	
	/** The height. */
	private Character height;

	/**
	 * Instantiates a new battle area.
	 *
	 * @param height the height
	 * @param width the width
	 */
	public BattleArea(Character height, Integer width) {
		this.width = width;
		this.height = height;
		this.HEIGHT = new LinkedHashMap<>();
		this.WIDTH = new LinkedHashSet<>();
		this.load();
	}

	/* (non-Javadoc)
	 * @see com.game.constants.Positions#load()
	 */
	@Override
	protected void load() {
		String[] heights = GameConstants.HEIGHTS.split(",");

		for (int index = 0; index < 26; index++) {
			Character heightKey = new Character(heights[index].charAt(0));
			HEIGHT.put(heightKey, index);
			if (heightKey.equals(height))
				break;
		}

		for (int i = 1; i <= GameConstants.WIDTH_LIMIT; i++) {
			Integer widthkey = new Integer(i);
			WIDTH.add(widthkey);
			if (widthkey.equals(width))
				break;
		}
	}

}
