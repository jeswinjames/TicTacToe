package com.snoos.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class TicTacToeGrid extends View {
    private int height, width;
    private int cell_width, cell_height;
    private static final int LINE_THICKNESS = 10;
    private Paint gridpainter;
    private Paint gamePainter;

    private Board board;

    public TicTacToeGrid(Context context) {
        super ( context );
    }

    public TicTacToeGrid(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );
        gridpainter = new Paint (  );
        gridpainter.setColor(Color.GRAY);
        gridpainter.setStrokeWidth ( LINE_THICKNESS );
        gridpainter.setStyle(Paint.Style.STROKE);
        gamePainter = new Paint();
        gridpainter.setStrokeWidth(LINE_THICKNESS);
        gridpainter.setStyle(Paint.Style.STROKE);
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
        cell_height = (height - LINE_THICKNESS) / 3;
        setMeasuredDimension ( width, height );
    }

    @Override
    protected void onDraw(Canvas canvas){
    drawGrid(canvas);
    }

    private void drawGrid(Canvas canvas) {
        canvas.drawRect ( 0, 0, width, height , gridpainter);
        for (int i = 1; i <= 2; i++) {
            canvas.drawLine(cell_width * i, 0, cell_width * i, height, gridpainter);
            canvas.drawLine(0, cell_height * i, width, cell_height * i, gridpainter);
        }
    }

    private void drawXO(Canvas canvas) {
        List<Integer> xList = board.getXPositions();
        List<Integer> oList = board.getOPositions();

    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
