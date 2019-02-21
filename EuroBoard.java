package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.BlankPeg;
import cs3500.marblesolitaire.model.hw02.CenterPeg;
import cs3500.marblesolitaire.model.hw02.OPeg;
import cs3500.marblesolitaire.model.hw02.Peg;

/**
 * Class that represents the European board.
 */
public class EuroBoard extends AbstractBoard {

  /**
   * Constructs a European board. Inherits several params from the abstract class.
   *
   * @param arm  determines the size of the board.
   * @param sRow the Y coordinate of the center.
   * @param sCol the X coordinate of the center.
   */
  public EuroBoard(int arm, int sRow, int sCol) {
    super(arm, sRow, sCol);
  }

  /**
   * Generates a board for a European board.
   *
   * @param sRow the Y coordinate.
   * @param sCol the X coordinate.
   * @return a 2D array of pegs.
   */
  public Peg[][] generateBoard(int sRow, int sCol) {
    Peg[][] boardInit = new Peg[(arm * 3) - 2][(arm * 3) - 2];
    int left = (boardInit.length / 2) - (arm / 2);
    int right = (boardInit.length / 2) + (arm / 2);
    this.score = -1;
    for (int y = 0; y < ((arm * 3) - 2); y++) {
      for (int x = 0; x < ((arm * 3) - 2); x++) {
        if ((x >= left) && (x <= right)) {
          boardInit[x][y] = new OPeg();
          ++score;
        } else {
          boardInit[x][y] = new BlankPeg();
          if (sCol == x && sRow == y) {
            throw new IllegalArgumentException("Invalid Blank Location");
          }
        }
      }
      if (y < (boardInit.length / 2) - (arm / 2)) {
        left--;
        right++;
      }
      if (y >= (boardInit.length / 2) + (arm / 2)) {
        left++;
        right--;
      }
    }
    boardInit[sCol][sRow] = new CenterPeg();
    return boardInit;
  }
}