package pieces;
import java.util.Objects;

import moves.Move;

public abstract class Piece {
	private Pieces pieceType;
	private boolean canMove = true;
	private boolean shade;

	Piece(boolean shade, Pieces pieceType) {
		this.pieceType = pieceType;
		this.shade = shade;

		// when setting up the lower pieces, pass the name of the piece on the
		// constructor
	}

	public boolean getShade() {
		return this.shade;
	}


	public boolean canMove() {
		return this.canMove;
	}

	public Pieces getPieceType() {
		return pieceType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(canMove, pieceType, shade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return canMove == other.canMove && pieceType == other.pieceType
				&& shade == other.shade;
	}

	@Override
	public String toString() {
		return "Piece [pieceType=" + pieceType + ", canMove=" + canMove
				+ ", shade=" + shade + "]";
	}
	
	
}
