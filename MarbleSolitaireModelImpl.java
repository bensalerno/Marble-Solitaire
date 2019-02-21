package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractModelImpl;

public class MarbleSolitaireModelImpl extends AbstractModelImpl {
  /**
   * Accesses the board class to perform the necessary methods.
   *
   * @param arm  the given arm of the board. must be a positive odd number.
   * @param sRow the given row.
   * @param sCol the given column.
   */


  public MarbleSolitaireModelImpl(int arm, int sRow, int sCol) {
    if (arm < 0 || arm % 2 == 0) {
      throw new IllegalArgumentException("Must be positive and odd");
    }
    if ((sCol < 0 || sRow < 0) || ((sCol < 2 || sCol > (arm * 3) - 2)
            && (sRow < 2 || sRow > (arm * 3) - 2))) {
      throw new IllegalArgumentException("Must be at center");
    } else {
      this.board = new BoardStandard(arm, sRow, sCol);
    }
  }

  /**
   * Constructs the board at a default arm length of 3.
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs the board with a given arm length.
   *
   * @param arm the given arm length determining the size of the board.
   */
  public MarbleSolitaireModelImpl(int arm) {
    this(arm, (arm / 2) + 2, (arm / 2) + 2);
  }

  /**
   * constructs the board with arm size 3 with an empty space at the given coordinates.
   *
   * @param sRow the given row.
   * @param sCol the given col.
   */

  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }
}