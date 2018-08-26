package edu.westga.cs.babble.views;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileCellFactory;
import edu.westga.cs.babble.model.TileRack;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Defines the controller for the Babble GUI
 * @author James Luke Johnson
 * @version 2018.08.25
 *
 */
public class BabbleController {
	@FXML
    private TextField scoreField;
	@FXML
	private ListView<Tile> tileRack;
	@FXML
	private ListView<Tile> playedWord;
	
	private IntegerProperty score;

	
	private TileBag tileBag;
	private TileRack tiles;
	private PlayedWord played;
	
	
	/**
	 * Constructs a new BabbleController object
	 */
	public BabbleController() {
		this.score = new SimpleIntegerProperty();
		this.tiles = new TileRack();
		this.played = new PlayedWord();
		this.tileBag = new TileBag();
	}
	
	/**
	 * Initializes the GUI FXML
	 */
	@FXML
	private void initialize() {
		this.scoreField.textProperty().bind(this.score.asString());
		this.tileRack.setCellFactory(new TileCellFactory());
		this.playedWord.setCellFactory(new TileCellFactory());
		this.fillRack();
		this.tileRack.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> tileInRackClicked(oldValue));
	}
	
	/**
	 * Fills the TileRack from Tiles from the TileBag
	 */
	private void fillRack() {
		int tilesNeeded = this.tiles.getNumberOfTilesNeeded();
		for (int i = 0; i < tilesNeeded; i++) {
			try {
				Tile tile = this.tileBag.drawTile();
				this.tiles.append(tile);
			} catch(EmptyTileBagException etbe) {
				this.babbleAlert("TileBag Empty", "The TileBag is empty", "There are no more tiles to draw from.");
			}
		}
		this.tileRack.setItems(this.tiles.tiles());
		//System.out.println(tiles.getHand());
	}
	
	private void tileInRackClicked(Tile tile) {
		try {
			this.tiles.remove(tile);
			this.played.append(tile);
		} catch (Exception e) {
			this.babbleAlert("Doesn't exist", "Tile Not in Rack", "Somehow you clicked a tile that doesn't exist.");
		}
		
	}
	
	/**
	 * Alerts the user if the TileBag is empty
	 */
	private void babbleAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
	}
}
