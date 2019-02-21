package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * The controller class is responsible for controlling the playing of the game. This can be
 * accessed through the main method.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Readable rd;
  private final Appendable ap;

  /**
   * Constructs the controller so that neither readable nor appendable will be null.
   *
   * @param rd the readable.
   * @param ap the appendable.
   */

  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Neither arguments cannot be null");
    } else {
      this.rd = rd;
      this.ap = ap;
    }
  }


  /**
   * Plays the game according to the mode.
   *
   * @param model the model that the controller will manipulate
   */

  @Override
  public void playGame(MarbleSolitaireModel model) { // throws exception when provided model is
    // null

    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }

    Scanner scan = new Scanner(rd);
    ArrayList<Integer> arr = new ArrayList<>();
    int i = 0;
    arr.add(-1);
    arr.add(-1);
    arr.add(-1);
    arr.add(-1);

    this.playGameHelp(model);

    while (true) {
      String input;
      if (model.isGameOver()) {
        try {
          ap.append("Game over!\n" +
                  model.getGameState() + "\n" + "Score: " + model.getScore() + "\n");
        } catch (IOException p) {
          throw new IllegalStateException("Failed to transmit");
        }
        return;
      }

      try {
        input = scan.next();
      } catch (NoSuchElementException noE) {
        throw new IllegalStateException("Ran out of inputs.");
      }

      if (input.equals("Q") || input.equals("q")) {
        int n = model.getScore();
        try {
          ap.append("Game quit!\n" + "State of game when quit:\n" + model.getGameState() + "\n" +
                  "Score: " + n);
        } catch (IOException e) {
          throw new IllegalStateException("Failed to transmit");
        }
        return;
      }
      try {
        if (Integer.parseInt(input) > 0) {
          arr.set(i++, Integer.parseInt(input));
          if (i == 4) {
            try {
              model.move(arr.get(0) - 1, arr.get(1) - 1, arr.get(2) - 1,
                      arr.get(3) - 1);
            } catch (IllegalArgumentException e) {
              try {
                ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
              } catch (IOException p) {
                throw new IllegalStateException("Fail");
              }
            }
            i = 0;
            this.playGameHelp(model);
          }
        }
      } catch (Exception e) {
        // throw exception away with no action.
      }
    }
  }

  /**
   * Abstracts the common code.
   *
   * @param model the given model.
   */
  private void playGameHelp(MarbleSolitaireModel model) {
    try {
      ap.append(model.getGameState() + "\n" + "Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Failed to transmit"); // abstract this
    }
  }
}

