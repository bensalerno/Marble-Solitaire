package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.CenterPeg;
import cs3500.marblesolitaire.model.hw02.OPeg;
import cs3500.marblesolitaire.model.hw02.Peg;


/**
 * An abstract class that holds all the methods that are common across the three different shapes of
 * gameboards.
 */
public abstract class AbstractBoard implements Board {

  protected int arm;
  protected Peg[][] board;
  protected int score;

  /**
   * Represents the Board in the form of a 2D array.
   *
   * @param arm  the arm determining the size.
   * @param sRow the row of the empty space.
   * @param sCol the column of the empty space.
   */

  protected AbstractBoard(int arm, int sRow, int sCol) {
    this.arm = arm;
    this.board = generateBoard(sRow, sCol);
  }

  /**
   * Generates the board for the constructor to use. Will be overridden.
   *
   * @param sRow the Y coordinate.
   * @param sCol the X coordinate.
   * @return a 2D array of Pegs.
   */
  public abstract Peg[][] generateBoard(int sRow, int sCol);


  /**
   * Moves a game piece from one position to another.
   *
   * @param fromRow the Y coordinate of the from.
   * @param fromCol the X coordinate of the from.
   * @param toRow   the Y coordinate of the to.
   * @param toCol   the X coordinate of the to.
   */

  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.isValid(fromRow, fromCol, toRow, toCol)) {
      this.board[toCol][toRow] = new OPeg();
      this.board[fromCol][fromRow] = new CenterPeg();
      this.board[(toCol + fromCol) / 2][(toRow + fromRow) / 2] = new CenterPeg();
      --score;
    } else {
      throw new IllegalArgumentException("Not a valid move");
    }
  }

  /**
   * Determines if a given mood is valid or not. Is called in the move method.
   *
   * @param fromRow the Y coordinate of the from.
   * @param fromCol the X coordinate of the from.
   * @param toRow   the Y coordinate of the to.
   * @param toCol   the X coordinate of the to.
   */

  public boolean isValid(int fromRow, int fromCol, int toRow, int toCol) {
    return (goodStuff(fromRow, toRow, fromCol, toCol)
            && fromRow >= 0 && fromRow < ((arm * 3) - 2)
            && toRow >= 0 && toRow < ((arm * 3) - 2)
            && fromCol >= 0 && fromCol < ((arm * 3) - 2)
            && toCol >= 0 && toCol < ((arm * 3) - 2)
            && validMidpoint(fromRow, toRow, fromCol, toCol));
  }

  /**
   * Determines if the game is over or not based on the amount of moves that can be made.
   *
   * @return a boolean that states if the game is over or not.
   */

  public boolean isGameOver() {
    for (int x = 0; x < (board.length); x++) {
      for (int y = 0; y < (board.length); y++) {
        if (this.isValid(x, y, x, y - 2) || this.isValid(x, y, x, y + 2)
                || this.isValid(x, y, x + 2, y) || this.isValid(x, y, x - 2, y)
                || this.isValid(x, y, x + 2, y + 2)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * The gamestate in the form of a string.
   *
   * @return a string representing the state of the game.
   */
  public String getGameState() {
    StringBuilder result = new StringBuilder();
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board.length; x++) {
        if (x == board.length - 1) {
          result.append(this.board[x][y].getPegState());
          result.append("\n");
        } else if ((this.board[x + 1][y].getPegState().equals("O")
                || (this.board[x + 1][y].getPegState().equals("_")))) {
          result.append(this.board[x][y].getPegState() + " ");
        } else if ((this.board[x][y].getPegState().equals("O")
                && this.board[x + 1][y].getPegState().equals(" ")
                || (this.board[x][y].getPegState().equals("_")))) {
          result.append(this.board[x][y].getPegState());
          if (y < board.length - 1) {
            result.append("\n");
          }
          break;
        } else {
          result.append(this.board[x][y].getPegState() + " ");
        }
      }
    }
    return result.toString();
  }

  /**
   * A score that represents the number of pegs that remain on the board.
   *
   * @return an integer that does this.
   */
  public int getScore() {
    return score;
  }

  /**
   * Creates white space based on the number given.
   *
   * @param y the number needed.
   * @return the amount of white space necessary.
   */
  public String whiteSpace(int y) {
    String stringInit = "";
    for (int x = 1; x < y; x++) {
      stringInit = stringInit + " ";
    }
    return stringInit;
  }

  /**
   * abstracts the content from isValid that is consistent across the three.
   *
   * @param fromRow the from Row.
   * @param toRow   the to Row.
   * @param fromCol the from Column.
   * @param toCol   the to Column.
   * @return a boolean that confirms if it is valid.
   */
  public boolean goodStuff(int fromRow, int toRow, int fromCol, int toCol) {
    return ((Math.abs(fromRow - toRow) == 2) && fromCol == toCol)
            || (Math.abs(fromCol - toCol) == 2 && fromRow == toRow);
  }

  /**
   * abstracts some more of the isValid content.
   * @param fromRow the from Row.
   * @param toRow the to Row.
   * @param fromCol the from Column.
   * @param toCol the to Column.
   * @return a boolean confirming its validity.
   */

  public boolean validMidpoint(int fromRow, int toRow, int fromCol, int toCol) {
    return this.board[fromCol][fromRow].getPegState().equals("O")
            && this.board[toCol][toRow].getPegState().equals("_")
            && this.board[(toCol + fromCol) / 2][(toRow + fromRow) / 2].getPegState().equals("O");
  }
}
