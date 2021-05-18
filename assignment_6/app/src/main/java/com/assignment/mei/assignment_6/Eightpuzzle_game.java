package com.assignment.mei.assignment_6;

import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import graph.Vertex;
import problem.Mover;
import problem.State;
import solution.StateSpaceSolver;

public class Eightpuzzle_game extends AppCompatActivity {

    public TextView text;
    public PuzzleProblem puzzleProblem;
    public Mover mover;
    public GridLayout gridLayout;
    public State next;
    public solution.Solver solver;
    public TextView statText;

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eightpuzzle_game);

        puzzleProblem = new PuzzleProblem();
        text = findViewById(R.id.textView7);
        statText = findViewById(R.id.textView19);

        mover = puzzleProblem.getMover();
        solver = new StateSpaceSolver(puzzleProblem,true);

        gridLayout = findViewById(R.id.gridLayout);

        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);
        button4 = findViewById(R.id.button6);
        button5 = findViewById(R.id.button7);
        button6 = findViewById(R.id.button8);
        button7 = findViewById(R.id.button9);
        button8 = findViewById(R.id.button10);

        buttonReset = findViewById(R.id.buttonreset);

    }

    public void onClickNext(View v){
        PuzzleState old = (PuzzleState)puzzleProblem.getCurrentState();
        if(solver.getSolution().hasNext()){
        Vertex nextV = solver.getSolution().next();
        PuzzleState next = (PuzzleState)nextV.getData();
        puzzleProblem.setCurrentState(next);
        PuzzleState newState = (PuzzleState) puzzleProblem.getCurrentState();
        for(int tile = 0;tile<9;tile++){
                if(old.getLocation(tile) != newState.getLocation(tile)){
                    int row = getRow(newState,tile);
                    int col = getCol(newState,tile);

                    switch(tile){
                        case 1: button1.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 2: button2.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 3: button3.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 4: button4.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 5: button5.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 6: button6.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 7: button7.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;

                        case 8: button8.setLayoutParams(
                                new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
                            if(puzzleProblem.success()){
                                text.setText("Congrats. You have beaten the game.");
                            }
                            break;
                    }
                }

        }

        }
    }

    public void onClickSolve(View v){
    solver.solve();
    statText.setText(solver.getStatistics().toString());
    puzzleProblem.setCurrentState((PuzzleState)solver.getSolution().next().getData());
    }

    public int getRow(PuzzleState state, int tile){
        return state.getLocation(tile).getRow();
    }

    public int getCol(PuzzleState state, int tile){
        return state.getLocation(tile).getColumn();
    }

    public void onClick1(View v){
        next = mover.doMove("Slide Tile 1", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,1);
            int col = getCol(st,1);
            button1.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }

    }

    public void onClick2(View v){
        next = mover.doMove("Slide Tile 2", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,2);
            int col = getCol(st,2);
            button2.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick3(View v){
        next = mover.doMove("Slide Tile 3", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,3);
            int col = getCol(st,3);
            button3.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick4(View v){
        next = mover.doMove("Slide Tile 4", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,4);
            int col = getCol(st,4);
            button4.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick5(View v){
        next = mover.doMove("Slide Tile 5", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,5);
            int col = getCol(st,5);
            button5.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick6(View v){
        next = mover.doMove("Slide Tile 6", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,6);
            int col = getCol(st,6);
            button6.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick7(View v){
        next = mover.doMove("Slide Tile 7", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,7);
            int col = getCol(st,7);
            button7.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

    public void onClick8(View v){
        next = mover.doMove("Slide Tile 8", puzzleProblem.getCurrentState());
        text.setText("");

        if(next!=null && !puzzleProblem.success()){
            PuzzleState st = (PuzzleState) next;
            int row = getRow(st,8);
            int col = getCol(st,8);
            button8.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(row), GridLayout.spec(col)));
            puzzleProblem.setCurrentState(next);
            if(puzzleProblem.success()){
                text.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text.setText("illegal move");
        }
    }

public void onClickReset(View v){
    puzzleProblem.setCurrentState(puzzleProblem.getInitialState());
    text.setText("");
    statText.setText("");
    button1.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(0)));
    button2.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(0)));
    button3.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(2)));
    button4.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(2)));
    button5.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(2)));
    button6.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(1)));
    button7.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(0)));
    button8.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(1)));
}

}
