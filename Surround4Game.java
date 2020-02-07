package ProjectTwo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.*;

public class Surround4Game {
    private int boardSize;
    private Cell[][] board;
    private int player;

    public Surround4Game() {
        super();
        board = new Cell[10][10];
        this.player = 1;
    }

    public void reset() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                board[r][c] = null;
            }
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public int getCurrentPlayer() {
        return player;
    }

    public int nextPlayer() {
        		player = player + 1;
        		if (player == 2)
        			player = 0;

        player = (player + 1) % 2;
        return player;
    }

    public boolean select(int row, int col) {
        if (board[row][col] == null ) {  //|| (cats() && board[row][col].getPlayerNumber() != player)) {
            Cell c = new Cell(player);
            board[row][col] = c;
            return true;
        }
        else
            return false;
    }

    public int getWinner() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (board[row][col] != null) {
                    return player;
                }

                // top-left corner case (check 2 sides only)
                if (row == 0 && col == 0) //checks that is top left corner

                    if (board[0][1] != null && board[1][0] != null) //checks that cells are filled

                        if (getCell(0, 1).getPlayerNumber() == getCell(1, 0).getPlayerNumber())


                return getCell(0, 1).getPlayerNumber();


                // left-border case (excluding corners - check 3 sides only)
                if (row != 0 && row != getBoardSize() - 1 && col == 0)

                    if (board[row - 1][col] != null && board[row][col + 1] != null && board[row + 1][col] != null)

                        if (getCell(row - 1, col).getPlayerNumber() == getCell(row, col + 1).getPlayerNumber() &&
                                getCell(row - 1, col).getPlayerNumber() == getCell(row + 1, col).getPlayerNumber())

                            return getCell(row - 1, col).getPlayerNumber();    // just pick one of them


                // bottom-right corner case (check 2 sides only)
                if (row == getBoardSize() && col == getBoardSize()) //checks that is bottom right corner

                    if (board[getBoardSize()][getBoardSize() - 1] != null && board[getBoardSize()-1][getBoardSize()] != null)

                        if (getCell(getBoardSize(), getBoardSize() - 1).getPlayerNumber() == getCell(getBoardSize() - 1, getBoardSize()).getPlayerNumber())

                return getCell(getBoardSize(), getBoardSize() - 1).getPlayerNumber();

            }
        }



                return -1;
    }

    public void boardSize() {
         String bdSize = JOptionPane.showInputDialog(null, "Enter Desired Board Size");
        try {
            int bSize = Integer.parseInt(bdSize);
            if (bSize > 3 && bSize < 20) {
                boardSize = bSize;
            } else {
                JOptionPane.showMessageDialog(null, "INVALID INPUT!!!\nUsing default value");
                bSize = 10;
                boardSize = bSize;
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT!!!\nUsing default value");
            boardSize = 10;
        }
    }

    public int getBoardSize() {

        return boardSize;
    }
}


