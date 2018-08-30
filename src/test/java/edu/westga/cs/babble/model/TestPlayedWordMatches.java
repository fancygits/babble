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
		playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#matches(java.lang.String)}.
	 */
	@Test
	void hasTilesForAMultipleLetterWord() {
		playedWord.append(new Tile('C'));
		playedWord.append(new Tile('O'));
		playedWord.append(new Tile('M'));
		playedWord.append(new Tile('P'));
		playedWord.append(new Tile('U'));
		playedWord.append(new Tile('T'));
		playedWord.append(new Tile('E'));
		assertTrue(playedWord.matches("COMPUTE"));
	}

	@Test
	void hasTilesForASingleLetterWord() {
		playedWord.append(new Tile('A'));
		assertTrue(playedWord.matches("A"));
	}

	@Test
	void cannotMatchWordWhenTilesAreScrambled() {
		playedWord.append(new Tile('O'));
		playedWord.append(new Tile('C'));
		playedWord.append(new Tile('P'));
		playedWord.append(new Tile('M'));
		playedWord.append(new Tile('E'));
		playedWord.append(new Tile('U'));
		playedWord.append(new Tile('T'));
		assertFalse(playedWord.matches("COMPUTE"));
	}

	@Test
	void cannotMatchWordIfInsufficientTiles() {
		playedWord.append(new Tile('C'));
		playedWord.append(new Tile('O'));
		playedWord.append(new Tile('M'));
		playedWord.append(new Tile('P'));
		playedWord.append(new Tile('U'));
		playedWord.append(new Tile('T'));
		assertFalse(playedWord.matches("COMPUTE"));
	}

	@Test
	void canMatchWordWithDuplicateLetters() {
		playedWord.append(new Tile('B'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		assertTrue(playedWord.matches("BANANA"));
	}

	@Test
	void nonEmptyWordShouldNotMatchEmptyText() {
		playedWord.append(new Tile('B'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		assertFalse(playedWord.matches(""));
	}

	@Test
	void emptyWordShouldNotMatchEmptyText() {
		assertFalse(playedWord.matches(""));
	}

	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> playedWord.matches(null));
	}

}
