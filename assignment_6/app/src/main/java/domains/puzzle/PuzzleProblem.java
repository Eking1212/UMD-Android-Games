package domains.puzzle;

import problem.Problem;
import problem.State;

/**
 * @author Emily King
 */
public class PuzzleProblem extends Problem{

public PuzzleProblem(){
    super();
    super.setName("Puzzle Problem");
    super.setIntroduction(INTRO);
    super.setMover(new PuzzleMover());
    super.setInitialState((State) new PuzzleState(new int [][]{new int[]{2,8,3},
                                                       new int[]{1,6,4},
                                                       new int[]{7,0,5}}));
    super.setCurrentState(super.getInitialState());
    super.setFinalState((State) new PuzzleState(new int [][]{new int[]{1,2,3},
                                                     new int[]{8,0,4}, 
                                                     new int[]{7,6,5}}));
//    super.setCurrentState(new PuzzleState(new int [][]{new int[]{3,6,4},
//                                                  new int []{1,0,2},
//                                                  new int []{8,7,5}}));
    
    
    
   /* b1 = new Benchmark("Mark 1: 5 moves", super.getInitialState(), super.getFinalState());
    b2 = new Benchmark("Mark 2: 10 moves", new PuzzleState(new int [][]{new int[]{3,6,4},
                                                                        new int []{1,0,2},
                                                                        new int []{8,7,5}}), super.getFinalState());
    b3 = new Benchmark("Mark 3: 13 moves", new PuzzleState(new int[][]{new int[]{3,0,4},
                                                                       new int[]{1,6,5},
                                                                       new int[]{8,2,7}}), super.getFinalState());
    b4 = new Benchmark("Mark 4: 18 moves", new PuzzleState(new int[][]{new int[]{2,1,3},
                                                                       new int[]{8,0,4},
                                                                       new int[]{6,7,5}}) , super.getFinalState());
    b5 = new Benchmark("Mark 5: 20 moves", new PuzzleState(new int[][]{new int[]{4,2,0},
                                                                       new int[]{8,3,6},
                                                                       new int[]{7,5,1}}), super.getFinalState());
    b6 = new Benchmark("Mark 6: 24 moves", new PuzzleState(new int[][]{new int[]{1,6,3},
                                                                       new int[]{4,0,8},
                                                                       new int[]{7,2,5}}), super.getFinalState());
    b7 = new Benchmark("Mark 7: 30 moves", new PuzzleState(new int[][]{new int[]{5,2,7},
                                                                       new int[]{8,0,4},
                                                                       new int[]{3,6,1}}), super.getFinalState());
    b8 = new Benchmark("Mark 8: 30 moves", new PuzzleState(new int[][]{new int[]{5,6,7},
                                                                       new int[]{4,0,8},
                                                                       new int[]{3,2,1}}), super.getFinalState());*/
    
//    benchmarkList.add(b1);
//    benchmarkList.add(b2);
//    benchmarkList.add(b3);
//    benchmarkList.add(b4);
//    benchmarkList.add(b5);
//    benchmarkList.add(b6);
//    benchmarkList.add(b7);
//    benchmarkList.add(b8);
   /* super.addToBench(b1);
    super.addToBench(b2);
    super.addToBench(b3);
    super.addToBench(b4);
    super.addToBench(b5);
    super.addToBench(b6);
    super.addToBench(b7);
    super.addToBench(b8);*/
}


private final String INTRO = 
        "You are given a board in which numbered tiles can slide around.\n"
        + "There is one blank space that holds no tile. A legal move consists\n"
        + "of sliding a tile into the blank space if the tile is adjacent to it.\n"
        + "The goal is to move tiles around until the board looks like the final state below. \n";

 
/*private Benchmark b1;
private Benchmark b2;
private Benchmark b3;
private Benchmark b4;
private Benchmark b5;
private Benchmark b6;
private Benchmark b7;
private Benchmark b8;*/
// private List<Benchmark> benchmarkList = new ArrayList();
}
