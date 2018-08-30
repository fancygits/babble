package edu.westga.cs.babble.controllers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the WordDictionary class
 * @author lewisb
 * @version 2018.08.29
 *
 */
public class TestWordDictionary {

	private WordDictionary dictionary;
	
	@BeforeEach
	void setUp() throws Exception {
		this.dictionary = new WordDictionary();
	}

	@Test
	void stringExpandShouldBeValid() {
		assertTrue(this.dictionary.isValidWord("Expand"));
	}
	
	@Test
	void stringBugblatShouldNotBeValid() {
		assertFalse(this.dictionary.isValidWord("Bugblat"));
	}
	
	@Test
	void emptyStringShouldNotBeValid() {
		assertFalse(this.dictionary.isValidWord(""));
	}

	@Test
	void shouldNotAcceptNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.dictionary.isValidWord(null);
		});
	}
}
