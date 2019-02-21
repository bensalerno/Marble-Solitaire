package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a triangular board.
 */
public class TriangleSolitaireModelImpl extends AbstractModelImpl {

  /**
   * Constructs a triangular solitaire board.
   * @param arm the number of pegs in the bottom row. Determines the size.
   * @param sRow the Y coordinate of the center peg.
   * @param sCol the X coordinate of the center peg.
   */

  public TriangleSolitaireModelImpl(int arm, int sRow, int sCol) {
    if (arm <= 0) {
      throw new IllegalArgumentException("Must be positive");
    }
    if ((sCol > sRow) || (sCol < 0) || (sRow > arm))  {
      throw new IllegalArgumentException("Invalid position");
    } else {
      this.board = new TriangleBoard(arm, sRow, sCol);
    }
  }

  /**
   * Constructs the board at a default arm length of 5.
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  /**
   * Constructs the board with a given arm length.
   *
   * @param arm the given arm length determining the size of the board.
   */
  public TriangleSolitaireModelImpl(int arm) {
    this(arm, 0, 0);
  }

  /**
   * constructs the board with arm size 3 with an empty space at the given coordinates.
   *
   * @param sRow the given row.
   * @param sCol the given col.
   */

  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    this(5, sRow, sCol);
  }
}
