package edu.westga.cs.babble.views;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileCellFactory;
import edu.westga.cs.babble.model.TileGroup;
import edu.westga.cs.babble.model.TileNotInGroupException;
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
/**
 * @author James Luke Johnson
 * @version 2018.08.27
 *
 */
public class BabbleController {
	@FXML
    private TextField scoreField;
	@FXML
	private ListView<Tile> tileRackField;
	@FXML
	private ListView<Tile> playedWordField;
	
	private IntegerProperty score;

	
	private TileBag tileBag;
	private TileRack tileRack;
	private PlayedWord playedWord;
	
	
	/**
	 * Constructs a new BabbleController object
	 */
	public BabbleController() {
		this.score = new SimpleIntegerProperty();
		this.tileBag = new TileBag();
		this.tileRack = new TileRack();
		this.playedWord = new PlayedWord();
	}
	
	/**
	 * Initializes the GUI FXML
	 */
	@FXML
	private void initialize() {
		this.scoreField.textProperty().bind(this.score.asString());
		this.tileRackField.setCellFactory(new TileCellFactory());
		this.playedWordField.setCellFactory(new TileCellFactory());
		this.fillRack();
		this.playedWordField.setItems(this.playedWord.tiles());
		this.tileRackField.setItems(this.tileRack.tiles());
	}
	
	/**
	 * Moves a tile from the top rack to the played word area
	 */
	@FXML
	private void tileRackClicked() {
		Tile tile = this.tileRackField.getSelectionModel().getSelectedItem();
		this.tileRackField.getSelectionModel().clearSelection();
		if (tile != null) {
			this.moveTile(this.tileRack, this.playedWord, tile);
		}
	}
	
	/**
	 * Moves a tile from the played word area to the top TileRack
	 */
	@FXML
	private void playedWordClicked() {
		Tile tile = this.playedWordField.getSelectionModel().getSelectedItem();
		this.playedWordField.getSelectionModel().clearSelection();
		if (tile != null) {
			this.moveTile(this.playedWord, this.tileRack, tile);
		}
	}
	
	@FXML
	private void reset() {
		while (this.playedWord.tiles().size() > 0) {
			Tile tile = this.playedWord.tiles().get(0);
			this.moveTile(this.playedWord, this.tileRack, tile);
		}
	}
	
	private void moveTile(TileGroup fromRack, TileGroup toRack, Tile tile) {
		try {
			fromRack.remove(tile);
			toRack.append(tile);
		} catch (TileNotInGroupException tnige) {
			this.babbleAlert("Doesn't exist", "Tile Not in Rack", "Somehow you clicked a tile that doesn't exist.");
		}
	}
	
	/**
	 * Fills the TileRack from Tiles from the TileBag
	 */
	private void fillRack() {
		int tilesNeeded = this.tileRack.getNumberOfTilesNeeded();
		for (int i = 0; i < tilesNeeded; i++) {
			try {
				Tile tile = this.tileBag.drawTile();
				this.tileRack.append(tile);
			} catch(EmptyTileBagException etbe) {
				this.babbleAlert("TileBag Empty", "The TileBag is empty", "There are no more tiles to draw from.");
			}
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
