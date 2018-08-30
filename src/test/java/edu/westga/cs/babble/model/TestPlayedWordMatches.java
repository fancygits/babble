package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestPlayedWordMatches {
	private PlayedWord playedWord;
	
	@BeforeEach
	void setUp() {
		this.playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#matches(java.lang.String)}.
	 */
	@Test
	void hasTilesForAMultipleLetterWord() {
		this.playedWord.append(new Tile('C'));
		this.playedWord.append(new Tile('O'));
		this.playedWord.append(new Tile('M'));
		this.playedWord.append(new Tile('P'));
		this.playedWord.append(new Tile('U'));
		this.playedWord.append(new Tile('T'));
		this.playedWord.append(new Tile('E'));
		assertTrue(this.playedWord.matches("COMPUTE"));
	}

	@Test
	void hasTilesForASingleLetterWord() {
		this.playedWord.append(new Tile('A'));
		assertTrue(this.playedWord.matches("A"));
	}

	@Test
	void cannotMatchWordWhenTilesAreScrambled() {
		this.playedWord.append(new Tile('O'));
		this.playedWord.append(new Tile('C'));
		this.playedWord.append(new Tile('P'));
		this.playedWord.append(new Tile('M'));
		this.playedWord.append(new Tile('E'));
		this.playedWord.append(new Tile('U'));
		this.playedWord.append(new Tile('T'));
		assertFalse(this.playedWord.matches("COMPUTE"));
	}

	@Test
	void cannotMatchWordIfInsufficientTiles() {
		this.playedWord.append(new Tile('C'));
		this.playedWord.append(new Tile('O'));
		this.playedWord.append(new Tile('M'));
		this.playedWord.append(new Tile('P'));
		this.playedWord.append(new Tile('U'));
		this.playedWord.append(new Tile('T'));
		assertFalse(this.playedWord.matches("COMPUTE"));
	}

	@Test
	void canMatchWordWithDuplicateLetters() {
		this.playedWord.append(new Tile('B'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		assertTrue(this.playedWord.matches("BANANA"));
	}

	@Test
	void nonEmptyWordShouldNotMatchEmptyText() {
		this.playedWord.append(new Tile('B'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		assertFalse(this.playedWord.matches(""));
	}

	@Test
	void emptyWordShouldNotMatchEmptyText() {
		assertFalse(this.playedWord.matches(""));
	}

	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> this.playedWord.matches(null));
	}

}
