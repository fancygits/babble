package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestPlayedWordClear {
	private PlayedWord playedWord;

	@BeforeEach
	void setUp() {
		playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#clear()}.
	 */
	@Test
	void shouldClearEmptyWord() {
		assertEquals(0, playedWord.tiles().size());
		playedWord.clear();
		assertEquals(0, playedWord.tiles().size());
		assertTrue(playedWord.tiles().isEmpty());
	}

	@Test
	void shouldClearWordWithOneTile() {
		assertEquals(0, playedWord.tiles().size());
		playedWord.append(new Tile('A'));
		assertEquals(1, playedWord.tiles().size());
		playedWord.clear();
		assertTrue(playedWord.tiles().isEmpty());
	}

	@Test
	void shouldClearWordWithManyTiles() {
		assertEquals(0, playedWord.tiles().size());
		playedWord.append(new Tile('L'));
		playedWord.append(new Tile('E'));
		playedWord.append(new Tile('W'));
		playedWord.append(new Tile('I'));
		playedWord.append(new Tile('S'));
		playedWord.append(new Tile('B'));
		assertEquals(6, playedWord.tiles().size());
		playedWord.clear();
		assertTrue(playedWord.tiles().isEmpty());
	}

}
