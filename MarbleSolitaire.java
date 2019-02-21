package cs3500.marblesolitaire.model.hw04;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;

/**
 * the main method class that allows you to play the game according to the controller.
 */
public final class MarbleSolitaire {

  /**
   * The Main method that allows you to run the game like the controller.
   * @param args the board that you want to play with.
   */
  public static void main(String[] args) {
    try {
      new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
              .playGame(new EuropeanSolitaireModelImpl(3));
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}

