package edu.westga.cs.babble.model;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Defines the TileCellFactory to add TileCell objects to ListView objects.
 * @author James Luke Johnson
 * @version 2018.08.26
 *
 */
public class TileCellFactory implements Callback<ListView<Tile>, ListCell<Tile>> {

	@Override
	public ListCell<Tile> call(ListView<Tile> listview) {
		return new TileCell();
	}
}
