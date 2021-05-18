package com.assignment.mei.assignment_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FWGC_direct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_direct);
    }

        public void onCLick(View v){
            startActivity(new Intent(FWGC_direct.this, FWGC_game.class));
        }
    }


