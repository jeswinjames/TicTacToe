package com.snoos.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TicTacToeGrid ticTacToeGrid = findViewById(R.id.tictac);
        ticTacToeGrid.setBoard(new Board());
    }
}
