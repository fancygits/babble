package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.TileBag;
import javafx.beans.property.IntegerProperty;

/**
 * @author James Luke Johnson
 * @version 2018.08.25
 *
 */
public class BabbleController {
	private IntegerProperty score;
	
	public BabbleController(TileBag tileBag) {
		this.score.set(0);
	}
}
