package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestTileRackGetNumberOfTilesNeeded {
	private TileRack tileRack;

	@BeforeEach
	void setUp() {
		tileRack = new TileRack();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileRack#getNumberOfTilesNeeded()}.
	 */
	@Test
	void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
		assertEquals(TileRack.MAX_SIZE, tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		tileRack.append(new Tile('A'));
		assertEquals(TileRack.MAX_SIZE - 1, tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithSeveralTilesShouldNeedSomeTiles() {
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		tileRack.append(new Tile('A'));
		assertEquals(TileRack.MAX_SIZE - 4, tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void fullRackNeedsZeroTiles() {
		for (int count = 0; count < TileRack.MAX_SIZE; count++) {
			tileRack.append(new Tile('A'));
		}
		assertEquals(0, tileRack.getNumberOfTilesNeeded());
	}
}
