package Project2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Surround4Panel extends JPanel {

    private JButton[][] board;

    private JPanel panel1;
    private int player;
    private ButtonListener listen;
    private JMenuItem quitItem;
    private Surround4Game game;
    int bSize;

    public Surround4Panel(JMenuItem pQuitItem) {
        quitItem = pQuitItem;
        listen = new ButtonListener();

        setLayout(new BorderLayout());
        panel1 = new JPanel();

        game = new Surround4Game();
        game.setNumPlayers();
        game.setFirst();

        String strBdSize = JOptionPane.showInputDialog ("Enter the size of the board");
        if( Integer.parseInt(strBdSize) < 0 && !(Integer.parseInt(strBdSize) > 3 && Integer.parseInt(strBdSize) < 20)){
            String strBdSize2 = JOptionPane.showInputDialog ("WARNING! No negative integers allowed!");
            if( Integer.parseInt(strBdSize2) < 0 && !(Integer.parseInt(strBdSize2) > 3 && Integer.parseInt(strBdSize2) < 20)){
                bSize = 10;
            } else {
                bSize = Integer.parseInt(strBdSize2);
            }
        } else {
            bSize = Integer.parseInt(strBdSize);
        }

        createBoard();
        add(panel1, BorderLayout.CENTER);

        quitItem.addActionListener(listen);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitItem)
                System.exit(1);

            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board[0].length; col++)
                    if (board[row][col] == e.getSource())
                        if (game.select(row, col)) {
                            //		board[row][col].setText(""+game.getCurrentPlayer());
                            player = game.nextPlayer();
                        } else
                            JOptionPane.showMessageDialog(null, "Not a valid square! Pick again.");

            displayBoard();
            int winner = game.getWinner();
            if (winner != -1) {
                JOptionPane.showMessageDialog(null, "Player " + winner + " Wins!");
                game = new Surround4Game();
                displayBoard();

            }
        }
    }

    private void createBoard() {

        board = new JButton[bSize][bSize];
        panel1.setLayout(new GridLayout(bSize, bSize));

        for (int i = 0; i < bSize; i++) // rows
            for (int j = 0; j < bSize; j++) {
                board[i][j] = new JButton("");
                board[i][j].addActionListener(listen);
                panel1.add(board[i][j]);
            }
    }

    private void displayBoard() {

        for (int row = 0; row < bSize; row++)
            for (int col = 0; col < bSize; col++) {
                Cell c = game.getCell(row, col);
                if (c != null)
                    board[row][col].setText("" + c.getPlayeNumber());
                else
                    board[row][col].setText("");
            }
    }


}

