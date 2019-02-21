package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Peg;

/**
 * An interface class that represents the 3 different types of boards. The methods written here
 * are common across the other boards, and extended by an abstract board class.
 */
public interface Board {

  /**
   * Generates a board for the constructor, placing the center peg at sRow, sCol.
   * @param sRow The Y value for the center peg.
   * @param sCol The X value for the center peg.
   * @return a 2D array of pegs.
   */

  Peg[][] generateBoard(int sRow, int sCol);

  /**
   * Moves a piece on the board assuming that the move is valid.
   * @param fromRow the Y coordinate of the from.
   * @param fromCol the X coordinate of the from.
   * @param toRow the Y coordinate of the to.
   * @param toCol the X coordinate of the to.
   */
  void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException;

  /**
   * Returns a boolean determining if a given move is valid or not.
   * @param fromRow the Y coordinate of the from.
   * @param fromCol the X coordinate of the from.
   * @param toRow the Y coordinate of the to.
   * @param toCol the X coordinate of the to.
   * @return a boolean true if it is valid and false if it is not.
   */
  boolean isValid(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Determines if the game is over or not.
   * @return a boolean, true if it is over, false if it is not.
   */
  boolean isGameOver();

  /**
   * Returns the game state in the form of a string.
   * @return String representing the game state.
   */
  String getGameState();

  /**
   * Returns the score representing the number of pegs still on the board.
   * @return an int representing this.
   */
  int getScore();
}
