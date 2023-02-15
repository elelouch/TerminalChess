package main;

import java.util.Arrays;
import java.util.Objects;
import pieces.Piece;

public class Slot {
	private Piece piece = null;
	private boolean shade;
	int positionPair[] = new int[2]; // position will be stored here based on a tuple

	/**
	 * Construct the slot based on the position
	 * 
	 * @param row
	 * @param col
	 */
	Slot(int row, int col) {
		this.positionPair[0] = row;
		this.positionPair[1] = col;
	}

	/**
	 * Overloaded constructor with the shade
	 * 
	 * @param row
	 * @param col
	 * @param shade
	 */
	Slot(int row, int col, boolean shade) {
		this(row, col);
		this.shade = shade;
	}

	/**
	 * Set of the slot, it can be null
	 * 
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * get piece
	 * 
	 * @return piece held by the slot
	 */
	public Piece getPiece() {
		return this.piece;
	}

	/**
	 * get row
	 * 
	 * @return row of the slot
	 */
	public int getRow() {
		return this.positionPair[0];
	}

	/**
	 * get column
	 * 
	 * @return column of the slot
	 */
	public int getCol() {
		return this.positionPair[1];
	}

	/**
	 * get shade AKA color
	 * 
	 * @return shade of the color
	 */
	public boolean getShade() {
		return shade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(positionPair);
		result = prime * result + Objects.hash(piece, shade);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		return Objects.equals(piece, other.piece) && Arrays.equals(positionPair, other.positionPair)
				&& shade == other.shade;
	}

}
