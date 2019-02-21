package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Describes the interface for the controller.
 */
public interface MarbleSolitaireController {
  /**
   * Plays a game of marble solitaire based on the given model. Will throw exception for null
   * argument and for failure to receive input or transmit output.
   *
   * @param model the model that the controller will manipulate
   */

  public void playGame(MarbleSolitaireModel model) throws IllegalStateException,
          IllegalArgumentException;
}

