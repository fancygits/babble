package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.Babble;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author James Luke Johnson
 * @version 2018.08.25
 *
 */
public class BabbleController {
	@FXML
    private TextField scoreField;
	
	@FXML
	private IntegerProperty score;
	
	// Reference to the main application.
    private Babble babble;
	
	public BabbleController() {
		this.score = new SimpleIntegerProperty();
		this.score.setValue(0);
	}
	
	@FXML
	private void initialize() {
		//this.scoreField.textProperty().bind(this.score.asString());
	}
}
