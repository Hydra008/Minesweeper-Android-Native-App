package com.codegodfather.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codegodfather.minesweeper.Model.GameGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameGenerator gameGenerator = new GameGenerator(10,10);
        gameGenerator.createGame();



    }

}
