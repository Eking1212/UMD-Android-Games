package com.assignment.mei.assignment_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity6 extends AppCompatActivity {
public Button fwgcButton;
public Button eightPuzzleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        init();
    }

    public void init(){
        fwgcButton = findViewById(R.id.button);
        eightPuzzleButton = findViewById(R.id.button2);

        fwgcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity6.this,FWGC_direct.class);
                startActivity(intent);
            }
        });

        eightPuzzleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity6.this,eightpuzzle_direct.class);
                startActivity(intent);
            }
        });
    }
}
