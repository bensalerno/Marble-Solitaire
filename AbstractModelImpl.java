package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


/**
 * Abstract class for the models. This represents the models that are consistent
 * across all shapes of the board. Methods that change are overridden in their respective classes.
 */
public abstract class AbstractModelImpl implements MarbleSolitaireModel {

  /**
   * A protected board means that it can be accessed in its subclasses.
   */
  protected Board board;

  /**
   * Moves a game piece, assuming that the move is valid. Calls the board class.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   */

  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.board.move(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Determines if the game is over or not. Calls the board class.
   *
   * @return a boolean that says if it is over or not.
   */
  public boolean isGameOver() {
    return this.board.isGameOver();
  }

  /**
   * Gives the state of the game in the form of a string. Calls the board class.
   *
   * @return a string representing the game.
   */

  public String getGameState() {
    return this.board.getGameState();
  }

  /**
   * Returns the score in the form on an int. Calls the board class.
   *
   * @return an int representing the score.
   */
  public int getScore() {
    return this.board.getScore();
  }
}

