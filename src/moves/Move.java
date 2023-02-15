package moves;
import pieces.Piece;
import main.Slot;

public class Move {
	private Piece piece; 			// piece that executed the move
	private Slot startSlot;
	private Slot endSlot;

	Move(Piece piece){
		this.piece = piece;		
	}
	
	/**
	 * set starter slot of the move
	 * @param starterSlot
	 * @throws Exception
	 */
	public void setStartSlot(Slot starterSlot) throws Exception{
		if(starterSlot == null) {
			Exception e = new Exception("Cannot set starter slot to null");
			throw e;
		}

		this.startSlot = starterSlot;
	}

	/**
	 * set end slot of the move
	 * @param endSlot
	 */
	public void setEndSlot(Slot endSlot) {
		this.endSlot = endSlot;
	}
	
	/**
	 * 
	 * @return
	 */
	public Slot getStartSlot() {
		return startSlot;
	}
	
	public Slot getEndSlot() {
		return endSlot;
	}

}
