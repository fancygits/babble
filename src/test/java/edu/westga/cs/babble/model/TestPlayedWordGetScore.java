package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		this.playedWord = new PlayedWord();
	}

	/**
	 * Test method for {@link edu.westga.cs.babble.model.PlayedWord#getScore()}.
	 */
	@Test
	void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.playedWord.tiles().size());
		assertEquals(0, this.playedWord.getScore());
	}
	
	@Test
	void scoreAOneTileWord() {
		this.playedWord.append(new Tile('A'));
		assertEquals(1, this.playedWord.getScore());
	}
	
	@Test
	void scoreAWordWithMultipleDifferingTiles() {
		this.playedWord.append(new Tile('C'));
		this.playedWord.append(new Tile('O'));
		this.playedWord.append(new Tile('M'));
		this.playedWord.append(new Tile('P'));
		this.playedWord.append(new Tile('U'));
		this.playedWord.append(new Tile('T'));
		this.playedWord.append(new Tile('E'));
		assertEquals(13, this.playedWord.getScore());
	}
	
	@Test
	void scoreAWordContainingDuplicateTiles() {
		this.playedWord.append(new Tile('B'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		this.playedWord.append(new Tile('N'));
		this.playedWord.append(new Tile('A'));
		assertEquals(8, this.playedWord.getScore());
	}

}
