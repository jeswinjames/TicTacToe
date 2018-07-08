package com.snoos.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TicTacToeGrid extends View {
    private int height, width;
    private int cell_width, cell_height;
    private static final int LINE_THICKNESS = 10;
    private Paint gridpainter;

    public TicTacToeGrid(Context context) {
        super ( context );
    }

    public TicTacToeGrid(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );
        gridpainter = new Paint (  );
        gridpainter.setColor ( Color.GRAY);
        gridpainter.setStrokeWidth ( LINE_THICKNESS );
    }

    public TicTacToeGrid(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super ( context, attrs, defStyleAttr );
    }

    public TicTacToeGrid(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super ( context, attrs, defStyleAttr, defStyleRes );
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = View.MeasureSpec.getSize ( widthMeasureSpec );
        height = View.MeasureSpec.getSize ( heightMeasureSpec );
        cell_width = (width - LINE_THICKNESS) / 3;
        cell_height = (width - LINE_THICKNESS) / 3;
        setMeasuredDimension ( width, height );
    }

    @Override
    protected void onDraw(Canvas canvas){
    drawGrid(canvas);
    }

    private void drawGrid(Canvas canvas) {
        canvas.drawRect ( 0, 0, width, height , gridpainter);

    }
}
