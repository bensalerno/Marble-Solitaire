package cs3500.marblesolitaire.model.hw04;


/**
 * Represents the European board.
 */
public class EuropeanSolitaireModelImpl extends AbstractModelImpl {

  /**
   * Constructs a European Solitiare board.
   *
   * @param arm  the arm of the board that determines the size.
   * @param sRow the Y coordinate of the center peg.
   * @param sCol the X coordinate of the center peg.
   */
  public EuropeanSolitaireModelImpl(int arm, int sRow, int sCol) {
    if (arm < 0 || arm % 2 == 0) {
      throw new IllegalArgumentException("Must be positive and odd");
    } else {
      this.board = new EuroBoard(arm, sRow, sCol);
    }
  }

  /**
   * Constructs the board at a default arm length of 3.
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs the board with a given arm length.
   *
   * @param arm the given arm length determining the size of the board.
   */
  public EuropeanSolitaireModelImpl(int arm) {
    this(arm, ((arm * 3) - 2) / 2, ((arm * 3) - 2) / 2);
  }

  /**
   * constructs the board with arm size 3 with an empty space at the given coordinates.
   *
   * @param sRow the given row.
   * @param sCol the given col.
   */

  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }
}
