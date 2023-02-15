package pieces;

public class PieceFactory {
	public Piece createPiece(Pieces pieceName, boolean shade) {
		Piece newPiece = null;
		switch (pieceName) {
		case PAWN:
			newPiece = new Pawn(shade);
			break;
		case ROOK:
			newPiece = new Rook(shade);
			break;
		case QUEEN:
			newPiece = new Queen(shade);
			break;
		case KING:
			newPiece = new King(shade);
			break;
		case BISHOP:
			newPiece = new Bishop(shade);
			break;
		case KNIGHT:
			newPiece = new Knight(shade);
			break;
		}
		return newPiece;
	}
}
