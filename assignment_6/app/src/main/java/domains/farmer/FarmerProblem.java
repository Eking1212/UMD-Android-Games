package domains.farmer;

import problem.Problem;

/**
 * @author Emily King
 */
public class FarmerProblem extends Problem{

    /**
     * Intializes the name, intro, mover, and states to the Farmer Problem
     */
public FarmerProblem(){
    super();
    super.setName("Farmer Problem");
    super.setIntroduction(INTRO);
    super.setMover(new FarmerMover());
    super.setInitialState(new FarmerState("West", "West", "West", "West"));
    super.setCurrentState(super.getInitialState());
    super.setFinalState(new FarmerState("East", "East", "East", "East"));
}


private static final String INTRO = 
        "There is a farmer, wolf, goat, and a cabbage that needs to go to the other side\n "
        + "of the river. The farmer can only take one other object besides himself across at\n "
        + "the same time. The wolf can not be left with the goat and the goat can not be\n "
        + "left with the cabbage. Find a sequence that allows them to get to the other side.";

    
}
