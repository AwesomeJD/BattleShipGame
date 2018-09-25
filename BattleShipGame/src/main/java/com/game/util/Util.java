/*
 * @author Janardhan Sharma
 */
package com.game.util;

import java.util.regex.PatternSyntaxException;
import com.game.exception.InvalidInputException;

/**
 * The Class Util.
 */
public class Util {

	/**
	 * Gets the integer.
	 *
	 * @param value the value
	 * @return the integer
	 */
	public static Integer getInteger(String value) {
		Integer returnvalue = null;
		try {
			returnvalue = Integer.parseInt(value);
		} catch (Exception ex) {
			throw new InvalidInputException("Invalid input value : " + value);
		}
		return returnvalue;
	}

	/**
	 * Gets the character.
	 *
	 * @param value the value
	 * @return the character
	 */
	public static Character getCharacter(String value) {
		Character returnvalue = null;
		try {
			returnvalue = new Character(value.charAt(0));
		} catch (Exception ex) {
			throw new InvalidInputException("Invalid input value : " + value);
		}
		return returnvalue;
	}

	/**
	 * Gets the string array.
	 *
	 * @param value the value
	 * @return the string array
	 */
	public static String[] getStringArray(String value) {
		String[] splitArray;
		try {
			splitArray = value.split("\\s+");
		} catch (PatternSyntaxException ex) {
			throw new InvalidInputException("Invalid input value : " + value);
		}
		return splitArray;
	}

	/**
	 * Gets the random id.
	 *
	 * @return the random id
	 */
	public static String getRandomId() {
		return Long.toString(System.currentTimeMillis());
	}
}
