package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		this.tileRack = new TileRack();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileRack#getNumberOfTilesNeeded()}.
	 */
	@Test
	void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
		assertEquals(TileRack.MAX_SIZE, this.tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		this.tileRack.append(new Tile('A'));
		assertEquals(TileRack.MAX_SIZE - 1, this.tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithSeveralTilesShouldNeedSomeTiles() {
		this.tileRack.append(new Tile('A'));
		this.tileRack.append(new Tile('A'));
		this.tileRack.append(new Tile('A'));
		this.tileRack.append(new Tile('A'));
		assertEquals(TileRack.MAX_SIZE - 4, this.tileRack.getNumberOfTilesNeeded());
	}
	
	@Test
	void fullRackNeedsZeroTiles() {
		for (int count = 0; count < TileRack.MAX_SIZE; count++) {
			this.tileRack.append(new Tile('A'));
		}
		assertEquals(0, this.tileRack.getNumberOfTilesNeeded());
	}
}
