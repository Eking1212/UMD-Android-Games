package domains.puzzle;

import java.util.function.UnaryOperator;

import problem.Mover;
import problem.State;

/**
 * @author Emily King
 */
public class PuzzleMover extends Mover {
    
    public static final String ONE = "Slide Tile 1";
    public static final String TWO = "Slide Tile 2";
    public static final String THREE = "Slide Tile 3";
    public static final String FOUR = "Slide Tile 4";
    public static final String FIVE = "Slide Tile 5";
    public static final String SIX = "Slide Tile 6";
    public static final String SEVEN = "Slide Tile 7";
    public static final String EIGHT = "Slide Tile 8";
    
    /**
     * adds a move for each state
     */
    public PuzzleMover(){
        super.addMove(ONE, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryOne(state);
            }
        });

        super.addMove(TWO, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryTwo(state);
            }
        });

        super.addMove(THREE, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryThree(state);
            }
        });

        super.addMove(FOUR, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryFour(state);
            }
        });

        super.addMove(FIVE, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryFive(state);
            }
        });

        super.addMove(SIX, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySix(state);
            }
        });

        super.addMove(SEVEN, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return trySeven(state);
            }
        });

        super.addMove(EIGHT, new UnaryOperator<State>() {
            @Override
            public State apply(State state) {
                return tryEight(state);
            }
        });

    }
    
    /**
     * swaps tile one with the blank tile
     * @param state the current state of the puzzle
     * @return the new state once the two tiles have been swapped
     */
    private State tryOne(State state){
       return swapLoc(1, state);
    }
    
    private State tryTwo(State state){
        return swapLoc(2,state);
    }
    
    private State tryThree(State state){
        return swapLoc(3,state);
    }
    
    private State tryFour(State state){
        return swapLoc(4,state);
    }
    
    private State tryFive(State state){
        return swapLoc(5,state);
    }
    
    private State trySix(State state){
        return swapLoc(6,state);
    }
    
    private State trySeven(State state){
        return swapLoc(7,state);
    }
    
    private State tryEight(State state){
        return swapLoc(8,state);
    }
    
    /**
     * finds the location of the tile and compares it to the zero tile's location
     * @param tile an integer on which tile wanting to move 
     * @param state the current state of the puzzle
     * @return return a new State when the tile and blank are switched
     *         or null if the move is illegal
     */
    private State swapLoc(int tile, State state){
       PuzzleState st = (PuzzleState) state;
       int tileRow = st.getLocation(tile).getRow(); 
       int tileCol = st.getLocation(tile).getColumn();
       
       int zeroRow = st.getLocation(0).getRow();
       int zeroCol = st.getLocation(0).getColumn();
       
       if(((tileRow+1 == zeroRow) && (tileCol == zeroCol)) || ((tileCol+1 == zeroCol) && (tileRow == zeroRow)) 
               || ((tileRow-1 == zeroRow) && (tileCol == zeroCol)) || ((tileCol-1 == zeroCol) && (tileRow == zeroRow))){
           return (State) new PuzzleState(st, st.getLocation(tile), st.getLocation(0));
       }
       else return null;
    }
}
