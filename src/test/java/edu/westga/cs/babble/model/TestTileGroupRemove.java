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
	private Tile tile0, tile1, tile2, tile3, tile4, tile5, tile6;
	
	@BeforeEach
	void setUp() {
		dummy = new TileGroupDummy();
		tile0 = new Tile('A');
		tile1 = new Tile('B');
		tile2 = new Tile('C');
		tile3 = new Tile('D');
		tile4 = new Tile('E');
		tile5 = new Tile('F');
		tile6 = new Tile('G');
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileGroup#remove(edu.westga.cs.babble.model.Tile)}.
	 */
	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> dummy.remove(null));
	}
	
	@Test
	void canNotRemoveFromEmptyTileGroup() {
		assertTrue(dummy.tiles().isEmpty());
		assertThrows(TileNotInGroupException.class, () -> dummy.remove(tile0));
	}
	
	@Test
	void canNotRemoveTileNotInTileGroup() {
		assertThrows(TileNotInGroupException.class, () -> dummy.remove(tile1));
		dummy.append(tile1);
		assertThrows(TileNotInGroupException.class, () -> dummy.remove(tile2));		
	}

	@Test
	void canRemoveOnlyTileInTileGroup() {
		dummy.append(tile3);
		assertFalse(dummy.tiles().isEmpty());
		assertEquals('D', dummy.tiles().get(0).getLetter());
		try {
			dummy.remove(tile3);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertTrue(dummy.tiles().isEmpty());
	}

	@Test
	void canRemoveFirstOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, dummy.tiles().size());
		assertEquals("ABCDEFG", dummy.getHand());
		try {
			dummy.remove(tile0);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, dummy.tiles().size());
		assertEquals('B', dummy.tiles().get(0).getLetter());
		assertEquals('C', dummy.tiles().get(1).getLetter());
		assertEquals('D', dummy.tiles().get(2).getLetter());
		assertEquals('E', dummy.tiles().get(3).getLetter());
		assertEquals('F', dummy.tiles().get(4).getLetter());
		assertEquals('G', dummy.tiles().get(5).getLetter());
		assertEquals("BCDEFG", dummy.getHand());
	}

	@Test
	void canRemoveLastOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, dummy.tiles().size());
		assertEquals("ABCDEFG", dummy.getHand());
		try {
			dummy.remove(tile6);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals('B', dummy.tiles().get(1).getLetter());
		assertEquals('C', dummy.tiles().get(2).getLetter());
		assertEquals('D', dummy.tiles().get(3).getLetter());
		assertEquals('E', dummy.tiles().get(4).getLetter());
		assertEquals('F', dummy.tiles().get(5).getLetter());
		assertEquals("ABCDEF", dummy.getHand());
	}

	@Test
	void canRemoveMiddleOfManyTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, dummy.tiles().size());
		assertEquals("ABCDEFG", dummy.getHand());
		try {
			dummy.remove(tile3);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(6, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals('B', dummy.tiles().get(1).getLetter());
		assertEquals('C', dummy.tiles().get(2).getLetter());
		assertEquals('E', dummy.tiles().get(3).getLetter());
		assertEquals('F', dummy.tiles().get(4).getLetter());
		assertEquals('G', dummy.tiles().get(5).getLetter());
		assertEquals("ABCEFG", dummy.getHand());
	}

	@Test
	void canRemoveMultipleTilesFromTileGroup() {
		this.add7Tiles();
		assertEquals(7, dummy.tiles().size());
		assertEquals("ABCDEFG", dummy.getHand());
		try {
			dummy.remove(tile1);
			dummy.remove(tile3);
			dummy.remove(tile5);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(4, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals('C', dummy.tiles().get(1).getLetter());
		assertEquals('E', dummy.tiles().get(2).getLetter());
		assertEquals('G', dummy.tiles().get(3).getLetter());
		assertEquals("ACEG", dummy.getHand());
	}

	@Test
	void doesNotRemoveDuplicateTilesFromTileGroup() {
		dummy.append(tile0);
		dummy.append(new Tile('A'));
		dummy.append(new Tile('A'));
		assertEquals(3, dummy.tiles().size());
		assertEquals("AAA", dummy.getHand());
		try {
			dummy.remove(tile0);
		} catch (TileNotInGroupException tnige) {
			fail("That tile isn't in the TileGroup");
		}
		assertEquals(2, dummy.tiles().size());
		assertEquals("AA", dummy.getHand());
	}
	
	private void add7Tiles() {
		dummy.append(tile0);
		dummy.append(tile1);
		dummy.append(tile2);
		dummy.append(tile3);
		dummy.append(tile4);
		dummy.append(tile5);
		dummy.append(tile6);
	}

}
