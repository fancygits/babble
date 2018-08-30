package edu.westga.cs.babble.model;

import javafx.scene.control.ListCell;

/**
 * Defines a TileCell object, to format the ListView objects
 * @author James Luke Johnson
 * @version 2018.08.26
 *
 */
public class TileCell extends ListCell<Tile> {
	
	@Override
	public void updateItem(Tile item, boolean empty) {
		super.updateItem(item, empty);
		
		String name = "";
		if (item != null || !empty) 	{
			name = Character.toString(item.getLetter());
		}
		this.setAccessibleText(name);
		this.setText(name);
	}
}
