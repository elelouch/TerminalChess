package main;

import java.util.ArrayList;
import java.util.Hashtable;

import pieces.Piece;
import pieces.Pieces;

public class Chess {
	public static final boolean WHITE = true;
	public static final boolean BLACK = false;

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; /*- for black slot*/
	private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m"; /*- for white slot*/

	/*-
	 * pieceEquivalences is a hashmap for mapping a piece with a character
	 * in order to print it with more ease
	 */
	private static Hashtable<Pieces, Character> piecesEquivalences;

	/*-
	 * Ascii codes to print
	 */

	public static void main(String[] args) {
		ChessBoardSetup boardSetup = new ChessBoardSetup();
		piecesEquivalences = boardSetup.getEquivalences();
		boardSetup.setupBoard();

		ArrayList<ArrayList<Slot>> board = boardSetup.getBoard();
		printBoard(board);
	}

	private static void printBoard(ArrayList<ArrayList<Slot>> board) {

		for (int i = 0; i < ChessBoardSetup.ROWS; i++) {
			for (int j = 0; j < ChessBoardSetup.COLS; j++) {
				String styledChar = "";
				Slot slot = board.get(i).get(j);
				if (slot.getShade() == BLACK) {
					styledChar += ANSI_GREEN_BACKGROUND;
				} else {
					styledChar += ANSI_CYAN_BACKGROUND;
				}

				Piece piece = slot.getPiece();
				if (piece != null) {
					if (piece.getShade() == BLACK) {
						styledChar += ANSI_BLACK;
					} else {
						styledChar += ANSI_WHITE;
					}
					
					styledChar += " " + piecesEquivalences.get(piece.getPieceType()) + " ";
				}else {
					styledChar += "   "; // No piece on the slot
				}

				styledChar += ANSI_RESET;
				System.out.append(styledChar);
			}
			System.out.println();
		}
	}
}
