package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.28
 *
 */
class TestTileConstructor {

	/**
	 * Test method for {@link edu.westga.cs.babble.model.Tile#Tile(char)}.
	 */
	@Test
	void shouldNotAllowNonLetters() {
		assertThrows(IllegalArgumentException.class, () -> new Tile('4'));
		assertThrows(IllegalArgumentException.class, () -> new Tile('0'));
		assertThrows(IllegalArgumentException.class, () -> new Tile('#'));
		assertThrows(IllegalArgumentException.class, () -> new Tile('!'));
	}
	
	@Test
	void shouldCreateOnePointTiles() {
		char[] onePointLetters = "eEaAiIoOnNrRtTlLsSuU".toCharArray();
		for (char letter: onePointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(1, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateTwoPointTiles() {
		char[] twoPointLetters = "dDgG".toCharArray();
		for (char letter: twoPointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(2, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateThreePointTiles() {
		char[] threePointLetters = "bBcCmMpP".toCharArray();
		for (char letter: threePointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(3, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateFourPointTiles() {
		char[] fourPointLetters = "fFhHvVwWyY".toCharArray();
		for (char letter: fourPointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(4, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateFivePointTiles() {
		char[] fivePointLetters = "kK".toCharArray();
		for (char letter: fivePointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(5, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateEightPointTiles() {
		char[] eightPointLetters = "jJxX".toCharArray();
		for (char letter: eightPointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(8, tile.getPointValue());
		}
	}

	@Test
	void shouldCreateTenPointTiles() {
		char[] tenPointLetters = "qQzZ".toCharArray();
		for (char letter: tenPointLetters) {
			Tile tile = new Tile(letter);
			assertEquals(10, tile.getPointValue());
		}
	}

}
