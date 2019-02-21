package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractBoard;

/**
 * Represents a game board for the peg solitaire. Creates a 2D Array using the different types of
 * pegs in the peg interface, and then manipulates them based on the methods.
 */

public class BoardStandard extends AbstractBoard {

  /**
   * Creates a standard board based on the parameters.
   *
   * @param arm  determines the size of the board.
   * @param sRow the Y coordinate of the center.
   * @param sCol the X coordinate of the center.
   */
  public BoardStandard(int arm, int sRow, int sCol) {
    super(arm, sRow, sCol);
  }

  /**
   * Generates a game board.
   *
   * @param sRow the row.
   * @param sCol the column.
   */

  public Peg[][] generateBoard(int sRow, int sCol) {
    Peg[][] boardInit = new Peg[(arm * 3) - 2][(arm * 3) - 2];
    this.score = 0;
    for (int x = 0; x < ((arm * 3) - 2); x++) {
      for (int y = 0; y < ((arm * 3) - 2); y++) {
        if ((x < arm - 1 || x > (((arm * 2) - 2))) && (y < arm - 1 || y > ((arm * 2) - 2))) {
          boardInit[x][y] = new BlankPeg();
        } else if (sCol == x && sRow == y) {
          boardInit[x][y] = new CenterPeg();
        } else {
          boardInit[x][y] = new OPeg();
          ++score;
        }
      }
    }
    return boardInit;
  }

}