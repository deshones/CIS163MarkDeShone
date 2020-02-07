package ProjectTwo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.TimerTask;

import javax.swing.*;

public class Surround4Panel extends JPanel {

    private JButton[][] board;

    private Timer JTimer;
    //private TimerListener timer;

    private JPanel panel1;
    private int player;
    private ButtonListener listen;
    private JMenuItem quitItem;
    private JMenuItem newGameItem;
    private JButton resetButton;
    private Surround4Game game;
    private int boardRows;
    private int boardCols;
    private int size;


    public Surround4Panel(JMenuItem pQuitItem, JMenuItem pNewGameItem) {
        quitItem = pQuitItem;
        newGameItem = pNewGameItem;

        listen = new ButtonListener();

        setLayout(new BorderLayout());
        panel1 = new JPanel();

        createBoard();
        add(panel1, BorderLayout.CENTER);
        game = new Surround4Game();
        quitItem.addActionListener(listen);
        newGameItem.addActionListener(listen);

        /*timer  = new TimerListener;
        JTimer = new Timer(1, timer);*/



        /*String playerDialog = JOptionPane.showInputDialog(null, "How Many Players?");
        player = Integer.parseInt(playerDialog);*/

        resetButton = new JButton("Reset");
        resetButton.addActionListener(listen);
        //add(resetButton);

    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitItem)
                System.exit(1);

            if (e.getSource() == resetButton)
                game.reset();

            //int countdown = 10000;
            //Timer timer = new Timer(countdown, this);

            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board[0].length; col++)
                    if (board[row][col] == e.getSource())
                        if (game.select(row, col)) {
                            board[row][col].setText("" + game.getCurrentPlayer());
                            player = game.nextPlayer();
                            //timer.start();
                        } else
                            JOptionPane.showMessageDialog(null, "Not a valid square! Pick again.");

            displayBoard();

            int winner = game.getWinner();


            if (winner != -1) {
                JOptionPane.showMessageDialog(null, "Player " + winner + " Wins!");
                game = new Surround4Game();
                displayBoard();
            }
            else
                game.nextPlayer();

        }

    }

    private void createBoard() {

        //game.boardSize();

        boardRows = 10;//game.getBoardSize();
        boardCols = 10;//game.getBoardSize();

        board = new JButton[boardRows][boardCols];
        panel1.setLayout(new GridLayout(boardRows, boardCols));

        for (int i = 0; i < boardRows; i++) // rows
            for (int j = 0; j < boardCols; j++) {
                board[i][j] = new JButton("");
                board[i][j].addActionListener(listen);
                panel1.add(board[i][j]);
            }
        // add(resetButton);
    }

    private void displayBoard() {

        for (int row = 0; row < boardRows; row++)
            for (int col = 0; col < boardCols; col++) {
                Cell c = game.getCell(row, col);
                if (c != null) {
                    board[row][col].setText("" + c.getPlayerNumber());
                    board[row][col].setForeground(Color.GREEN);
                } else
                    board[row][col].setText("");
            }
    }

    /*public int isWinner() {
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                // top-left corner case (check 2 sides only)
                if (row == 0 && col == 0) //checks that is top left corner

                    if (board[0][1] != null && board[1][0] != null) //checks that cells are filled

                        if (game.getCell(0, 1).getPlayerNumber() == game.getCell(1, 0).getPlayerNumber()) *//*&& //checks that cells are filled by same player
                                game.getCell(1, 0).getPlayerNumber() != game.getCell(0, 0).getPlayerNumber())*//* //checks that not surrounding self

                            return game.getCell(0, 1).getPlayerNumber();


                // left-border case (excluding corners - check 3 sides only)
                if (row != 0 && row != boardRows - 1 && col == 0)

                    if (board[row - 1][col] != null && board[row][col + 1] != null && board[row + 1][col] != null)

                        if (game.getCell(row - 1, col).getPlayerNumber() == game.getCell(row, col + 1).getPlayerNumber() &&
                                game.getCell(row - 1, col).getPlayerNumber() == game.getCell(row + 1, col).getPlayerNumber())

                            return game.getCell(row - 1, col).getPlayerNumber();    // just pick one of them


                // bottom-right corner case (check 2 sides only)
                if (row == size && col == size) //checks that is bottom right corner

                    if (board[size][size - 1] != null && board[size-1][size] != null)

                        if (game.getCell(size, size - 1).getPlayerNumber() == game.getCell(size - 1, size).getPlayerNumber()) *//*&&
                                game.getCell(size - 1, size).getPlayerNumber() != game.getCell(size, size).getPlayerNumber())*//*

                            return game.getCell(size, size - 1).getPlayerNumber();
            }
        }
        return -1;
    }*/
}



//Wrap using mod (%)
//Color property
//win count
//countdown timer


