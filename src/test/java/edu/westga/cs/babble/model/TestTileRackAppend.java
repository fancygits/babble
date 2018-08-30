package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestTileRackAppend {

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileRack#append(edu.westga.cs.babble.model.Tile)}.
	 */
	@Test
	void shouldNotAppendToFullRack() {
		TileRack tileRack = new TileRack();
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		assertEquals(7, tileRack.tiles().size());
		assertThrows(TileRackFullException.class, () -> tileRack.append(new Tile('A')));
	}

}
