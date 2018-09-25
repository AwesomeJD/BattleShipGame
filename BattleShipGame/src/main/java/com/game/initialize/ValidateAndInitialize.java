/*
 * @author Janardhan Sharma
 */
package com.game.initialize;

import com.game.exception.InvalidInputException;

/**
 * The Interface ValidateAndInitialize. Since the Validation and Initialization
 * are closely related in this use case so, a single interface for both the work
 * will take care.
 * 
 * 
 */
public interface ValidateAndInitialize {

	/**
	 * Validate and initiaze.
	 *
	 * @throws InvalidInputException the invalid input exception
	 */
	public void validateAndInitiaze() throws InvalidInputException;
}
