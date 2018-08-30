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
		this.playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#clear()}.
	 */
	@Test
	void shouldClearEmptyWord() {
		assertEquals(0, this.playedWord.tiles().size());
		this.playedWord.clear();
		assertEquals(0, this.playedWord.tiles().size());
		assertTrue(this.playedWord.tiles().isEmpty());
	}

	@Test
	void shouldClearWordWithOneTile() {
		assertEquals(0, this.playedWord.tiles().size());
		this.playedWord.append(new Tile('A'));
		assertEquals(1, this.playedWord.tiles().size());
		this.playedWord.clear();
		assertTrue(this.playedWord.tiles().isEmpty());
	}

	@Test
	void shouldClearWordWithManyTiles() {
		assertEquals(0, this.playedWord.tiles().size());
		this.playedWord.append(new Tile('L'));
		this.playedWord.append(new Tile('E'));
		this.playedWord.append(new Tile('W'));
		this.playedWord.append(new Tile('I'));
		this.playedWord.append(new Tile('S'));
		this.playedWord.append(new Tile('B'));
		assertEquals(6, this.playedWord.tiles().size());
		this.playedWord.clear();
		assertTrue(this.playedWord.tiles().isEmpty());
	}

}
