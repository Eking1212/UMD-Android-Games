package com.assignment.mei.assignment_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import domains.farmer.FarmerMover;
import domains.farmer.FarmerProblem;
import domains.farmer.FarmerState;
import problem.Mover;
import problem.Problem;
import problem.State;
import solution.Solver;
import solution.StateSpaceSolver;

public class FWGC_game extends AppCompatActivity {

    public TextView text;
    public TextView text2;
    public TextView text3;

    public FarmerProblem fProblem;
    public Mover mover;
    public State next;
    public solution.Solver solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_game);

        fProblem = new FarmerProblem();
        solver = new StateSpaceSolver(fProblem,true);
        mover = fProblem.getMover();
        next = new FarmerState("West","West","West","West");

        text = (TextView) findViewById(R.id.textView6);
        text2 = (TextView) findViewById(R.id.textView4);
        text3 = (TextView) findViewById(R.id.textView20);
        text.setText(fProblem.getCurrentState().toString());
    }

    public void onClickSolve(View v){
        solver.solve();
        text2.setText(solver.getStatistics().toString());
        text.setText(solver.getSolution().next().toString());
    }

    public void onCLickNext(View v){
        if(solver.getSolution().hasNext()){
            text.setText(solver.getSolution().next().toString());
            if(fProblem.success()&& !solver.getSolution().hasNext()){
                text2.setText("");
                text3.setText("Congrats. You have beaten the game.");
            }
        }
    }

    public void onCLickF(View v){
        //text.setText("name: " + name);
        next = mover.doMove("Farmer Goes Alone", fProblem.getCurrentState());
        text2.setText("");

        if(next != null && !fProblem.success()) {
            fProblem.setCurrentState(next);
            text.setText(fProblem.getCurrentState().toString());
        }
        else{
            text2.setText("illegal move");
        }
    }

    public void onClickW(View v){
        next = mover.doMove("Farmer Takes Wolf", fProblem.getCurrentState());
        text2.setText("");

        if(next != null && !fProblem.success()) {
            fProblem.setCurrentState(next);
            text.setText(fProblem.getCurrentState().toString());
        }
        else{
            text2.setText("illegal move");
        }
    }

    public void onClickG(View v){
        next = mover.doMove("Farmer Takes Goat", fProblem.getCurrentState());
        text2.setText("");

        if(next != null && !fProblem.success()) {
            fProblem.setCurrentState(next);
            text.setText(fProblem.getCurrentState().toString());
            if(fProblem.success()){
                text3.setText("Congrats. You have beaten the game.");
            }
        }
        else{
            text2.setText("illegal move");
        }
    }

    public void onClickC(View v){
        next = mover.doMove("Farmer Takes Cabbage", fProblem.getCurrentState());
        text2.setText("");

        if(next != null && !fProblem.success()) {
            fProblem.setCurrentState(next);
            text.setText(fProblem.getCurrentState().toString());
        }
        else{
            text2.setText("illegal move");
        }
    }

    public void onClickReset(View v){
        fProblem.setCurrentState(fProblem.getInitialState());
        text.setText(fProblem.getInitialState().toString());
        text2.setText("");
        text3.setText("");
    }


}
