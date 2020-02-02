package Project2;
public class Surround4Game {
    private Cell[][] board;
    private int player;

    public Surround4Game() {
        //super();
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
        //		player = player + 1;
        //		if (player == 2)
        //			player = 0;

        player = (player + 1) % 2;
        return player;
    }

    public boolean select(int row, int col) {
        if (board[row][col] == null ) {  //|| (cats() && board[row][col].getPlayeNumber() != player)) {
            Cell c = new Cell(player);
            board[row][col] = c;
            return true;
        }
        else
            return false;
    }

    public int getWinner() {

        // top-left corner case (check 2 sides only)
        if (row == 0 && col == 0) 
        if (board[0][1] != null && board[1][0] != null)
            if (board[0][1].getPlayeNumber() == board[1][0].getPlayeNumber())
                return board[0][1];

        // left-border case (excluding corners - check 3 sides only)
        if (row != 0 && row != boardSize-1 && col == 0) 
        if (board[row-1][col] != null && board[row][col+1] != null && board[row+1][col] != null)
            if (board[row-1][col].getPlayeNumber() == board[row][col+1].getPlayeNumber() &&
                    board[row-1][col].getPlayeNumber() == board[row+1][col].getPlayeNumber())
                return board[row-1][col];    // just pick one of them

        for (int row = 0; row < 10; row++)
            for (int col = 0; col < 10; col++)
                if (board[row][col] != null) {
                    return player;
                }
        return -1;
    }
}
