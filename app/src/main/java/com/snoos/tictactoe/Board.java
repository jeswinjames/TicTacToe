package com.snoos.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Integer> OPositions;
    private List<Integer> XPositions;
    private GameStatus currentStatus;

    private static final int[] MAGICSQUARE = {6, 1, 8, 7, 5, 3, 2, 9, 4};

    public enum XO{
        X, O;
    };

    public enum GameStatus{
        DRAW, IN_PROGRESS, X_WON, O_WON
    };


    public Board(){
        XPositions = new ArrayList<Integer> (  );
        OPositions = new ArrayList<Integer> (  );
    }

    public boolean isEnded(){
      return (currentStatus!= GameStatus.IN_PROGRESS);
    }

    private void updateStatus(){
        if(XPositions.size ()<3){
            currentStatus = GameStatus.IN_PROGRESS;
        }
        else{

        }
    }

    public int put(int position, XO value){
        if(XPositions.contains (position)|| OPositions.contains ( position))
            return -1;

        if(value == XO.X){
            XPositions.add (position);
        }
        if(value ==XO.O){
            OPositions.add (position);
        }
        return 0;
    }
}
