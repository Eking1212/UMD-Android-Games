package domains.farmer;

import java.util.function.UnaryOperator;

import problem.State;

/**
 * @author Emily King
 */
public class FarmerMover extends problem.Mover {
     
        public static final String ALONE = "Farmer Goes Alone";
        public static final String WOLF = "Farmer Takes Wolf";
        public static final String GOAT = "Farmer Takes Goat";
        public static final String CABBAGE = "Farmer Takes Cabbage";
        
        /**
         * adds a move
         */
        public FarmerMover(){

            super.addMove(ALONE, new UnaryOperator<State>() {
                @Override
                public State apply(State state) {
                    return tryAlone(state);
                }
            });
            super.addMove(WOLF, new UnaryOperator<State>() {
                @Override
                public State apply(State state) {
                    return tryWolf(state);
                }
            });

            super.addMove(GOAT, new UnaryOperator<State>() {
                @Override
                public State apply(State state) {
                    return tryGoat(state);
                }
            });
            super.addMove(CABBAGE, new UnaryOperator<State>() {
                @Override
                public State apply(State state) {
                    return tryCabbage(state);
                }
            });
        }
        
        /**
         * tests if the farmer can move of his/her own
         * @param state the current state of the problem
         * @return returns the state when an object is moved
         */
        private State tryAlone(State state){
            FarmerState direction = (FarmerState) state;
            
            if((direction.getFarmerState().equals("West")) && (direction.getWolfState().equals("West"))
                    && (direction.getGoatState().equals("West")) && (direction.getCabbageState().equals("West"))){
                return null;
            }
            
            if (((direction.getFarmerState().equals("East")) && (direction.getWolfState().equals("East")) && (direction.getGoatState().equals("East"))) ||
                    ((direction.getFarmerState().equals("East")) && ((direction.getGoatState().equals("East")) && ((direction.getCabbageState().equals("East")))))){
            return null;
        }
            if(direction.getWolfState().equals(direction.getGoatState())){
                return null;
            }
            
            if (direction.getGoatState().equals(direction.getCabbageState())){
                return null;
            }
            
            if(direction.getFarmerState().equals("West")){
                return null;
            }
//            if(!direction.getGoatState().equals(direction.getFarmerState())){
//                return null;
//            }
           
            if(direction.getFarmerState().equals("West")){
                return new FarmerState("East",direction.getWolfState(), direction.getGoatState(), direction.getCabbageState());
            }
            else{
                return new FarmerState("West", direction.getWolfState(), direction.getGoatState(), direction.getCabbageState());
            }  
            
            }
        
    /**
     * test if the farmer can take the wolf
     * @param state the current state of the problem
     * @return return the state when the farmer and wolf are moved
     */
        private State tryWolf(State state){
            FarmerState direction = (FarmerState) state;
            
            if((direction.getFarmerState().equals("West")) && (direction.getWolfState().equals("West"))
                    && (direction.getGoatState().equals("West")) && (direction.getCabbageState().equals("West"))){
                return null;
            }
            
//            if((direction.getWolfState().equals("East")) && (direction.getCabbageState().equals("East"))){
//                return null;
//        }
            if(!direction.getWolfState().equals(direction.getFarmerState())){
                return null;
            }
            
            if(direction.getFarmerState().equals("West")){
                return new FarmerState("East","East", direction.getGoatState(), direction.getCabbageState());
            }
            else 
                return new FarmerState("West", "West", direction.getGoatState(), direction.getCabbageState());
        }
    
        /**
         * tests if the farmer can take the goat
         * @param state the current state of the problem
         * @return return a new state when the farmer and goat are moved
         */
        private State tryGoat(State state){
            FarmerState direction = (FarmerState) state;

//            if((direction.getGoatState().equals("East")) && direction.getFarmerState().equals("West")){
//                return null;
//            }
            
            if(!direction.getGoatState().equals(direction.getFarmerState())){
                return null;
            }
            
            if(direction.getFarmerState().equals("West")){
                return new FarmerState("East", direction.getWolfState(), "East", direction.getCabbageState());
            }
            else
                return new FarmerState("West", direction.getWolfState(), "West", direction.getCabbageState());
        }
//            return null;
//        }
    
        private State tryCabbage(State state){
            FarmerState direction = (FarmerState) state;
//            if(!illegalMoves(state)){
            if((direction.getFarmerState().equals("West")) && (direction.getWolfState().equals("West"))
                    && (direction.getGoatState().equals("West")) && (direction.getCabbageState().equals("West"))){
                return null;
            }
            
            if(!direction.getCabbageState().equals(direction.getFarmerState())){
                return null;
            }
            
            if(direction.getFarmerState().equals("West")){
                return new FarmerState("East", direction.getWolfState(), direction.getGoatState(), "East");
            }
            else
                return new FarmerState("West", direction.getWolfState(), direction.getGoatState(), "West");
        }// return null;
//        }
        
        
        private State illegalMove(State state){
            System.out.println("Illegal move, try again");
            return null;
        }

}
