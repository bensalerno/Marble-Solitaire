package cs3500.marblesolitaire.model.hw02;

/**
 * represents a peg for the gameboard Takes in a singular method that returns the state of the peg.
 */

public interface Peg {
  // gives the state of the peg, either blank, "O" or "_"
  String getPegState();
}