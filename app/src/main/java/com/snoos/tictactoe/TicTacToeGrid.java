package com.snoos.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
        gridpainter = new Paint();
        gridpainter.setColor(Color.GRAY);
        gridpainter.setStrokeWidth(LINE_THICKNESS);
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
        drawXO(canvas);
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

        for (int i : xList) {
            drawX(canvas, i);
        }

        for (int i : oList) {
            drawO(canvas, i);
        }

    }

    private void drawX(Canvas canvas, int position) {
        int row = position / 3;
        int column = position % 3;
        gamePainter.setColor(Color.RED);
        int leftX = cell_width * column + LINE_THICKNESS;
        int topY = cell_height * row + LINE_THICKNESS;
        int rightX = cell_width * (column + 1) - LINE_THICKNESS;
        int bottomY = cell_height * (row + 1) - LINE_THICKNESS;
        canvas.drawLine(leftX, topY,
                rightX, bottomY, gamePainter);
        canvas.drawLine(rightX, topY,
                leftX, bottomY, gamePainter);
    }

    private void drawO(Canvas canvas, int position) {
        int column, row;
        row = position / 3;
        column = position % 3;
        int cx, cy;
        cx = column * cell_width + cell_width / 2;
        cy = row * cell_width + cell_width / 2;
        canvas.drawCircle(cx, cy, cell_width / 2 - 30, gridpainter);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            int position = (x / cell_width) * 3 + (y / cell_height);
            board.touchedPosition(position);
            invalidate();
            return true;
        }
        return false;
    }
}
