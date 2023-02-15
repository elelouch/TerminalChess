package main;

import java.util.ArrayList;
import java.util.Hashtable;

import pieces.Pieces;
import pieces.PieceFactory;

public class ChessBoardSetup {

	public static final int ROWS = 8;
	public static final int COLS = 8;

	// The rows are being "read" from top to bottom
	private static final int FIRST_ROW = 0;
	private static final int LAST_ROW = 7;
	private static final int FIRST_PAWN_ROW = 1;
	private static final int LAST_PAWN_ROW = 6;

	ArrayList<ArrayList<Slot>> board = new ArrayList<ArrayList<Slot>>();
	Hashtable<Pieces, String> equivalences = new Hashtable<Pieces, String>();

	/*-
	 * Constructor for setting up the board with the slots
	 * placed in the right order
	 */
	ChessBoardSetup() {
		for (int i = 0; i < ROWS; i++) {
			board.add(new ArrayList<Slot>());
			for (int j = 0; j < COLS; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board.get(i).add(new Slot(i, j, Chess.WHITE));
					} else {
						board.get(i).add(new Slot(i, j, Chess.BLACK));
					}
				} else {
					if (j % 2 == 0) {
						board.get(i).add(new Slot(i, j, Chess.BLACK));
					} else {
						board.get(i).add(new Slot(i, j, Chess.WHITE));
					}
				}
			}
		}
		equivalences.put(Pieces.KING, "\u265A");
		equivalences.put(Pieces.QUEEN, "\u265B");
		equivalences.put(Pieces.ROOK, "\u265C");
		equivalences.put(Pieces.BISHOP, "\u265D");
		equivalences.put(Pieces.KNIGHT, "\u265E");
		equivalences.put(Pieces.PAWN, "\u265F");
	}

	/**
	 * Setups the board with the piece well placed
	 */
	public void setupBoard() {

		PieceFactory pf = new PieceFactory();
		ArrayList<Pieces> piecesType = new ArrayList<Pieces>();
		piecesType.add(Pieces.ROOK);
		piecesType.add(Pieces.KNIGHT);
		piecesType.add(Pieces.BISHOP);
		piecesType.add(Pieces.QUEEN);

		/*-
		 * The pieces where placed conveniently on the array so if 
		 * i == 0,places a rook
		 * i == 1,places a knight
		 * i == 2,places a bishop
		 * i == 3,places a queen
		 */

		/*-
		 * This was made with the idea that the board row 
		 * will be filled as
		 * 
		 * 	|r	|k	|b	|	|	|b	|k	|r	|
		 * 
		 * And then last two slots will be filled after
		 * The loop 
		 */
		int halfBoard = COLS / 2;
		int slotSide = 0;
		int oppositeSide;

		while (slotSide < halfBoard) {
			int i = slotSide;
			oppositeSide = COLS - (slotSide + 1);
			Pieces pieceToCreate = piecesType.get(i);

			ArrayList<Slot> firstPawnRow = board.get(FIRST_PAWN_ROW);
			firstPawnRow.get(slotSide).setPiece(pf.createPiece(Pieces.PAWN, Chess.WHITE));
			firstPawnRow.get(oppositeSide).setPiece(pf.createPiece(Pieces.PAWN, Chess.WHITE));

			ArrayList<Slot> lastPawnRow = board.get(LAST_PAWN_ROW);
			lastPawnRow.get(slotSide).setPiece(pf.createPiece(Pieces.PAWN, Chess.BLACK));
			lastPawnRow.get(oppositeSide).setPiece(pf.createPiece(Pieces.PAWN, Chess.BLACK));

			ArrayList<Slot> firstRow = board.get(FIRST_ROW);
			firstRow.get(slotSide).setPiece(pf.createPiece(pieceToCreate, Chess.WHITE));
			firstRow.get(oppositeSide).setPiece(pf.createPiece(pieceToCreate, Chess.WHITE));
			ArrayList<Slot> lastRow = board.get(LAST_ROW);
			lastRow.get(slotSide).setPiece(pf.createPiece(pieceToCreate, Chess.BLACK));
			lastRow.get(oppositeSide).setPiece(pf.createPiece(pieceToCreate, Chess.BLACK));

			if (slotSide == oppositeSide - 1) {
				pieceToCreate = Pieces.KING;
				lastRow.get(oppositeSide).setPiece(pf.createPiece(pieceToCreate, Chess.BLACK));
				firstRow.get(oppositeSide).setPiece(pf.createPiece(pieceToCreate, Chess.WHITE));
			}
			slotSide++;
		}
	}

	public Hashtable<Pieces, String> getEquivalences() {
		return equivalences;
	}

	public ArrayList<ArrayList<Slot>> getBoard() {
		return board;
	}

}
