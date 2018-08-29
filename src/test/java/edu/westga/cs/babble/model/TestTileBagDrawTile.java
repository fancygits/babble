package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.28
 *
 */
class TestTileBagDrawTile {
	private TileBag bag;
	
	@BeforeEach
	public void setUp() {
		bag = new TileBag();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.TileBag#drawTile()}.
	 */
	@Test
	void canDrawAllTiles() {
		for (int count = 0; count < 98; count++) {
			try {
				bag.drawTile();
			} catch (EmptyTileBagException etbe) {
				fail("Tile Bag is empty!");
			}
		}
		assertTrue(bag.isEmpty());
	}

	@Test
	void canNotDrawTooManyTiles() {
		for (int count = 0; count < 98; count++) {
			try {
				bag.drawTile();
			} catch (EmptyTileBagException etbe) {
				fail("Tile Bag is empty!");
			}
		}
		assertTrue(bag.isEmpty());
		assertThrows(EmptyTileBagException.class, () -> bag.drawTile());
	}

	@Test
	void hasProperTileDistribution() {
		// Create an ArrayList of all Scrabble tiles
		String scrabbleLetters = "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ";
		ArrayList<Character> standardDistribution = new ArrayList<Character>();
		for (char c: scrabbleLetters.toCharArray()) {
			standardDistribution.add(c);
		}
		
		for (int i = 0; i < 98; i++) {
			try {
				// Draw a tile and remove that letter from the standardDistribution
				char letter = bag.drawTile().getLetter();
				standardDistribution.remove(standardDistribution.indexOf(letter));
			} catch (EmptyTileBagException etbe) {
				fail("Tile Bag is empty!");
			} catch (IndexOutOfBoundsException ioobe) {
				fail("That tile isn't part of the standard distribution!");
			}
		}
		assertTrue(bag.isEmpty());
	}

}
