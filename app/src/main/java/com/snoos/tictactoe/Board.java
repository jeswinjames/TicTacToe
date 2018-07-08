package com.snoos.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Integer> OPositions;
    private List<Integer> XPositions;
    private GameStatus currentStatus;

    private static final int[] MAGICSQUARE = {6, 1, 8, 7, 5, 3, 2, 9, 4};

    public enum XO{
        X, O
    }

    public enum GameStatus{
        DRAW, IN_PROGRESS, X_WON, O_WON
    }


    public Board(){
        XPositions = new ArrayList<>();
        OPositions = new ArrayList<>();
    }

    public boolean isEnded(){
      return (currentStatus!= GameStatus.IN_PROGRESS);
    }

    private void updateStatus(){
        if(XPositions.size ()<3){
            currentStatus = GameStatus.IN_PROGRESS;
        } else{
            if (check15(XPositions)) {
                currentStatus = GameStatus.X_WON;
            } else if (check15(OPositions)) {
                currentStatus = GameStatus.O_WON;
            } else if (XPositions.size() == 5) {
                currentStatus = GameStatus.DRAW;
            } else {
                currentStatus = GameStatus.IN_PROGRESS;
            }

        }
    }

    private boolean check15(List<Integer> elementList) {
        int size = elementList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int a = MAGICSQUARE[elementList.get(i)];
                    int b = MAGICSQUARE[elementList.get(j)];
                    int c = MAGICSQUARE[elementList.get(k)];
                    if ((a + b + c) == 15) {
                        return true;
                    }
                }
            }
        }
        return false;
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

        updateStatus();
        return 0;
    }
}
