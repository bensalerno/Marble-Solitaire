package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.BlankPeg;
import cs3500.marblesolitaire.model.hw02.CenterPeg;
import cs3500.marblesolitaire.model.hw02.OPeg;
import cs3500.marblesolitaire.model.hw02.Peg;

/**
 * Represents the triangular board.
 */
public class TriangleBoard extends AbstractBoard {

  public TriangleBoard(int arm, int sRow, int sCol) {
    super(arm, sRow, sCol);
  }

  @Override
  public Peg[][] generateBoard(int sRow, int sCol) {
    Peg[][] boardInit = new Peg[arm][arm];
    this.score = -1;
    for (int y = 0; y < arm; y++) {
      for (int x = 0; x < arm; x++) {
        if (x <= y) {
          boardInit[x][y] = new OPeg();
          ++score;
        } else {
          boardInit[x][y] = new BlankPeg();
        }
      }
    }
    boardInit[sCol][sRow] = new CenterPeg();
    return boardInit;
  }

  @Override
  public boolean isValid(int fromRow, int fromCol, int toRow, int toCol) {
    return (goodStuff(fromRow, toRow, fromCol, toCol)
            || (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2))
            && fromRow >= 0 && fromRow < arm
            && toRow >= 0 && toRow < arm
            && fromCol >= 0 && fromCol < arm
            && toCol >= 0 && toCol < arm
            && validMidpoint(fromRow, toRow, fromCol, toCol);
  }

  @Override
  public String getGameState() {
    StringBuilder result = new StringBuilder();
    for (int y = 0; y < board.length; y++) {
      result.append(whiteSpace(board.length - y));
      for (int x = 0; x <= y; x++) {
        if (x == y) {
          result.append(this.board[x][y].getPegState());
          if (y != arm - 1) {
            result.append("\n");
          }
        } else if ((x < board.length - 1) && (this.board[x + 1][y].getPegState().equals("O")
                || (this.board[x + 1][y].getPegState().equals("_")))) {
          result.append(this.board[x][y].getPegState() + " ");
        } else if ((this.board[x][y].getPegState().equals("O")
                && this.board[x + 1][y].getPegState().equals(" ")
                || (this.board[x][y].getPegState().equals("_")))) {
          result.append(this.board[x][y].getPegState());
          break;
        } else {
          result.append(this.board[x][y].getPegState() + " ");
        }
      }
    }
    return result.toString();
  }
}
