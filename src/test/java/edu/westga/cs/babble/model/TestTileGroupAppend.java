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
		this.dummy = new TileGroupDummy();
	}
	
	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileGroup#append(edu.westga.cs.babble.model.Tile)}.
	 */
	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> this.dummy.append(null));
	}

	@Test
	void emptyGroupShouldBeEmpty() {
		assertEquals(0, this.dummy.tiles().size());
		assertEquals("", this.dummy.getHand());
	}

	@Test
	void shouldHaveOneTileInTileGroup() {
		this.dummy.append(new Tile('A'));
		assertEquals(1, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals("A", this.dummy.getHand());
	}
	
	@Test
	void shouldHaveManyTilesInTileGroup() {
		this.dummy.append(new Tile('A'));
		this.dummy.append(new Tile('B'));
		this.dummy.append(new Tile('C'));
		this.dummy.append(new Tile('D'));
		assertEquals(4, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals('B', this.dummy.tiles().get(1).getLetter());
		assertEquals('C', this.dummy.tiles().get(2).getLetter());
		assertEquals('D', this.dummy.tiles().get(3).getLetter());
		assertEquals("ABCD", this.dummy.getHand());
	}

	@Test
	void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		this.dummy.append(new Tile('A'));
		this.dummy.append(new Tile('B'));
		this.dummy.append(new Tile('C'));
		this.dummy.append(new Tile('D'));
		this.dummy.append(new Tile('A'));
		this.dummy.append(new Tile('A'));
		assertEquals(6, this.dummy.tiles().size());
		assertEquals('A', this.dummy.tiles().get(0).getLetter());
		assertEquals('B', this.dummy.tiles().get(1).getLetter());
		assertEquals('C', this.dummy.tiles().get(2).getLetter());
		assertEquals('D', this.dummy.tiles().get(3).getLetter());
		assertEquals('A', this.dummy.tiles().get(4).getLetter());
		assertEquals('A', this.dummy.tiles().get(5).getLetter());
		assertEquals("ABCDAA", this.dummy.getHand());
	}

	@Test
	void canNotAddSameTileTwice() {
		Tile tile = new Tile('A');
		this.dummy.append(tile);
		assertThrows(IllegalArgumentException.class, () -> this.dummy.append(tile));
		assertEquals("A", this.dummy.getHand());
	}

}
