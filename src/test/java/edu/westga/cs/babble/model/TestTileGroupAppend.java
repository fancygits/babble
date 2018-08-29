package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.28
 *
 */
class TestTileGroupAppend {
	private TileGroup dummy;

	@BeforeEach
	public void setUp() {
		dummy = new TileGroupDummy();
	}
	
	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileGroup#append(edu.westga.cs.babble.model.Tile)}.
	 */
	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> dummy.append(null));
	}

	@Test
	void emptyGroupShouldBeEmpty() {
		assertEquals(0, dummy.tiles().size());
		assertEquals("", dummy.getHand());
	}

	@Test
	void shouldHaveOneTileInTileGroup() {
		dummy.append(new Tile('A'));
		assertEquals(1, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals("A", dummy.getHand());
	}
	
	@Test
	void shouldHaveManyTilesInTileGroup() {
		dummy.append(new Tile('A'));
		dummy.append(new Tile('B'));
		dummy.append(new Tile('C'));
		dummy.append(new Tile('D'));
		assertEquals(4, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals('B', dummy.tiles().get(1).getLetter());
		assertEquals('C', dummy.tiles().get(2).getLetter());
		assertEquals('D', dummy.tiles().get(3).getLetter());
		assertEquals("ABCD", dummy.getHand());
	}

	@Test
	void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		dummy.append(new Tile('A'));
		dummy.append(new Tile('B'));
		dummy.append(new Tile('C'));
		dummy.append(new Tile('D'));
		dummy.append(new Tile('A'));
		dummy.append(new Tile('A'));
		assertEquals(6, dummy.tiles().size());
		assertEquals('A', dummy.tiles().get(0).getLetter());
		assertEquals('B', dummy.tiles().get(1).getLetter());
		assertEquals('C', dummy.tiles().get(2).getLetter());
		assertEquals('D', dummy.tiles().get(3).getLetter());
		assertEquals('A', dummy.tiles().get(4).getLetter());
		assertEquals('A', dummy.tiles().get(5).getLetter());
		assertEquals("ABCDAA", dummy.getHand());
	}

	@Test
	void canNotAddSameTileTwice() {
		Tile tile = new Tile('A');
		dummy.append(tile);
		assertThrows(IllegalArgumentException.class, () -> dummy.append(tile));
		assertEquals("A", dummy.getHand());
	}

}
