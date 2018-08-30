package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author James Luke Johnson
 * @version 2018.08.29
 *
 */
class TestPlayedWordGetScore {
	private PlayedWord playedWord;

	@BeforeEach
	void setUp() {
		playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#getScore()}.
	 */
	@Test
	void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, playedWord.tiles().size());
		assertEquals(0, playedWord.getScore());
	}
	
	@Test
	void scoreAOneTileWord() {
		playedWord.append(new Tile('A'));
		assertEquals(1, playedWord.getScore());
	}
	
	@Test
	void scoreAWordWithMultipleDifferingTiles() {
		playedWord.append(new Tile('C'));
		playedWord.append(new Tile('O'));
		playedWord.append(new Tile('M'));
		playedWord.append(new Tile('P'));
		playedWord.append(new Tile('U'));
		playedWord.append(new Tile('T'));
		playedWord.append(new Tile('E'));
		assertEquals(13, playedWord.getScore());
	}
	
	@Test
	void scoreAWordContainingDuplicateTiles() {
		playedWord.append(new Tile('B'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		playedWord.append(new Tile('N'));
		playedWord.append(new Tile('A'));
		assertEquals(8, playedWord.getScore());
	}

}
