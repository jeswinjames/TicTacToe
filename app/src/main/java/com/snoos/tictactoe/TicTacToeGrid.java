package com.snoos.tictactoe;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class TicTacToeGrid extends ConstraintLayout {

    public TicTacToeGrid(Context context) {
        super ( context );
    }

    public TicTacToeGrid(Context context, AttributeSet attrs) {
        super ( context, attrs );
    }

    public TicTacToeGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super ( context, attrs, defStyleAttr );
    }
}
