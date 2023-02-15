package pieces;
import moves.Move;
import java.util.ArrayList;

/**
 * Attributes are inherited and also methods
 * But if there is a reference on a method to the superclass
 * (say that we declare something like System.out.println(THIS.rndmString), there's the reference)
 * The inherited method will keep referencing to the superclass and not 
 * the class. Thus for changing the value of the referenced field
 * on the method, we have to change the values through super or 
 * setting the fields to anything that's not private
 *
 */

public class Bishop extends Piece{
	Bishop(boolean shade){
		super(shade,Pieces.BISHOP);
	}
}
