package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestTileGroupRemove {
	
	private TileGroup dummy;
	private Tile tile0;
	private Tile tile1;
	private Tile tile2;
	private Tile tile3;
	private Tile tile4;
	private Tile tile5;
	private Tile tile6;
	
	@BeforeEach
	void setUp() {
		this.dummy = new TileGroupDummy();
		this.tile0 = new Tile('A');
		this.tile1 = new Tile('B');
		this.tile2 = new Tile('C');
		this.tile3 = new Tile('D');
		this.tile4 = new Tile('E');
		this.tile5 = new Tile('F');
		this.tile6 = new Tile('G');
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileGroup#remove(edu.westga.cs.babble.model.Tile)}.
	 */
	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> this.dummy.remove(null));
	}
	
	@Test
	void canNotRemoveFromEmptyTileGroup() {
		assertTrue(this.dummy.tiles().isEmpty());
		assertThrows(TileNotInGroupException.class, () -> this.dummy.remove(this.tile0));
	}
	
	@Test
	void canNotRemoveTileNotInTileGroup() {
		assertThrows(TileNotInGroupException.class, () -> this.dummy.remove(this.tile1));
		this.dummy.append(this.tile1);
		assertThrows(TileNotInGroupException.class, () -> this.dummy.remove(this.tile2));		
	}

	@Test
	void canRemoveOnlyTileInTileGroup() {
		this.dummy.append(this.tile3);
		assertFalse(this.dummy.tiles().isEmpty());
		assertEquals('D', this.dummy.tiles().get(0).getLetter());
		try {
			this.dummy.remove(this.tile3);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertTrue(this.dummy.tiles().isEmpty());
	}

	@Test
	void canRemoveFirstOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, this.dummy.tiles().size());
		assertEquals("ABCDEFG", this.dummy.getHand());
		try {
			this.dummy.remove(this.tile0);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, this.dummy.tiles().size());
		assertEquals('B', this.dummy.tiles().get(0).getLetter());
		assertEquals('C', this.dummy.tiles().get(1).getLetter());
		assertEquals('D', this.dummy.tiles().get(2).getLetter());
		assertEquals('E', this.dummy.tiles().get(3).getLetter());
		assertEquals('F', this.dummy.tiles().get(4).getLetter());
		assertEquals('G', this.dummy.tiles().get(5).getLetter());
		assertEquals("BCDEFG", this.dummy.getHand());
	}

	@Test
	void canRemoveLastOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, this.dummy.tiles().size());
		assertEquals("ABCDEFG", this.dummy.getHand());
		try {
			this.dummy.remove(this.tile6);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals('B', this.dummy.tiles().get(1).getLetter());
		assertEquals('C', this.dummy.tiles().get(2).getLetter());
		assertEquals('D', this.dummy.tiles().get(3).getLetter());
		assertEquals('E', this.dummy.tiles().get(4).getLetter());
		assertEquals('F', this.dummy.tiles().get(5).getLetter());
		assertEquals("ABCDEF", this.dummy.getHand());
	}

	@Test
	void canRemoveMiddleOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, this.dummy.tiles().size());
		assertEquals("ABCDEFG", this.dummy.getHand());
		try {
			this.dummy.remove(this.tile3);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals('B', this.dummy.tiles().get(1).getLetter());
		assertEquals('C', this.dummy.tiles().get(2).getLetter());
		assertEquals('E', this.dummy.tiles().get(3).getLetter());
		assertEquals('F', this.dummy.tiles().get(4).getLetter());
		assertEquals('G', this.dummy.tiles().get(5).getLetter());
		assertEquals("ABCEFG", this.dummy.getHand());
	}

	@Test
	void canRemoveMultipleTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, this.dummy.tiles().size());
		assertEquals("ABCDEFG", this.dummy.getHand());
		try {
			this.dummy.remove(this.tile1);
			this.dummy.remove(this.tile3);
			this.dummy.remove(this.tile5);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(4, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals('C', this.dummy.tiles().get(1).getLetter());
		assertEquals('E', this.dummy.tiles().get(2).getLetter());
		assertEquals('G', this.dummy.tiles().get(3).getLetter());
		assertEquals("ACEG", this.dummy.getHand());
	}

	@Test
	void doesNotRemoveDuplicateTilesFromTileGroup() {
		this.dummy.append(this.tile0);
		this.dummy.append(new Tile('A'));
		this.dummy.append(new Tile('A'));
		assertEquals(3, this.dummy.tiles().size());
		assertEquals("AAA", this.dummy.getHand());
		try {
			this.dummy.remove(this.tile0);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(2, this.dummy.tiles().size());
		assertEquals("AA", this.dummy.getHand());
	}
	
	private void add7Tiles() {
		this.dummy.append(this.tile0);
		this.dummy.append(this.tile1);
		this.dummy.append(this.tile2);
		this.dummy.append(this.tile3);
		this.dummy.append(this.tile4);
		this.dummy.append(this.tile5);
		this.dummy.append(this.tile6);
	}

}
