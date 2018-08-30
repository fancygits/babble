package edu.westga.cs.babble.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Container for Tiles, allows drawing random this.tiles.  When created, it self-populates with a Scrabble-like set of this.tiles.
 * @author lewisb
 * @author James Luke Johnson
 * @version	2018.8.28
 */
public class TileBag {

	private ArrayList<Tile> tiles;
	private Random rand;
	
	/**
	 * Creates a new, populated TileBag
	 */
	public TileBag() {
		this.rand = new Random();
		this.tiles = new ArrayList<Tile>();
		this.populateWithScrabbleTiles();
	}
	
	/**
	 * Brute-force fills the bag with a set of tiles with the Scrabble points and letter distribution (ignoring the blank tiles)
	 */
	private void populateWithScrabbleTiles() {
		this.populate1ptTiles();
		this.populate2ptTiles();
		this.populate3ptTiles();
		this.populate4ptTiles();
		this.populate5ptTiles();
		this.populate8ptTiles();
		this.populate10ptTiles();
	}
	
	private void populate1ptTiles() {
		// 1-pt tiles: E, A, I, O, N, R, T, L, S, U
		for (int count = 0; count < 12; count++) {
			this.tiles.add(new Tile('E'));
		}
		for (int count = 0; count < 9; count++) {
			this.tiles.add(new Tile('A'));
			this.tiles.add(new Tile('I'));
		}
		for (int count = 0; count < 8; count++) {
			this.tiles.add(new Tile('O'));
		}
		for (int count = 0; count < 6; count++) {
			this.tiles.add(new Tile('N'));
			this.tiles.add(new Tile('R'));
			this.tiles.add(new Tile('T'));
		}
		for (int count = 0; count < 4; count++) {
			this.tiles.add(new Tile('L'));
			this.tiles.add(new Tile('S'));
			this.tiles.add(new Tile('U'));
		}
	}
	
	private void populate2ptTiles() {
		// 2-pt tiles: D, G
		for (int count = 0; count < 4; count++) {
			this.tiles.add(new Tile('D'));
		}
		for (int count = 0; count < 3; count++) {
			this.tiles.add(new Tile('G'));
		}
	}
	
	private void populate3ptTiles() {
		// 3 pt tiles: B, C, M, P
		for (int count = 0; count < 2; count++) {
			this.tiles.add(new Tile('B'));
			this.tiles.add(new Tile('C'));
			this.tiles.add(new Tile('M'));
			this.tiles.add(new Tile('P'));
		}
	}
	
	private void populate4ptTiles() {
		// 4 pt tiles: F, H, V, W, Y
		for (int count = 0; count < 2; count++) {
			this.tiles.add(new Tile('F'));
			this.tiles.add(new Tile('H'));
			this.tiles.add(new Tile('V'));
			this.tiles.add(new Tile('W'));
			this.tiles.add(new Tile('Y'));
		}
	}
	
	private void populate5ptTiles() {
		// 5-pt tiles: K
		this.tiles.add(new Tile('K'));
	}
		
	private void populate8ptTiles() {
		// 8-pt tiles: J, X
		this.tiles.add(new Tile('J'));
		this.tiles.add(new Tile('X'));
	}
	
	private void populate10ptTiles() {
		// 10-pt tiles: Q, Z
		this.tiles.add(new Tile('Q'));
		this.tiles.add(new Tile('Z'));
	}
	
	/**
	 * Answers the existential question of "is this bag empty?"
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return this.tiles.isEmpty();
	}
	
	/**
	 * Draws and removes a random tile from the bag
	 * @return the removed tile
	 * @throws EmptyTileBagException if the bag is empty
	 */
	public Tile drawTile() throws EmptyTileBagException {
		if (this.isEmpty()) {
			throw new EmptyTileBagException();
		}
		
		int size = this.tiles.size();
		int index = this.rand.nextInt(size);
		Tile patsy = this.tiles.remove(index);
		return patsy;
	}
}
