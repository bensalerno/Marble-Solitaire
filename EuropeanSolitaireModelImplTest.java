import org.junit.Test;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class EuropeanSolitaireModelImplTest {
  MarbleSolitaireModel model1 = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel model2 = new EuropeanSolitaireModelImpl(4, 4);

  MarbleSolitaireModel model5 = new EuropeanSolitaireModelImpl(5);
  MarbleSolitaireModel model6 = new EuropeanSolitaireModelImpl(5, 3, 3);

  @Test
  public void testGameState1() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void testGetScore() {
    assertEquals(36, model1.getScore());
    model1.move(1, 3, 3, 3);
    assertEquals(35, model1.getScore());
    model1.move(2, 5, 2, 3);
    assertEquals(34, model1.getScore());
  }

  @Test
  public void testConstructorNoParam() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void testConstructorOneParam() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", model5.getGameState());
  }

  @Test
  public void testConstructorTwoParam() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O", model2.getGameState());
  }

  @Test
  public void testConstructorThreeParam() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", model6.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException1() {
    new EuropeanSolitaireModelImpl(0, 0);
    new EuropeanSolitaireModelImpl(-5, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException2() {
    new EuropeanSolitaireModelImpl(-1);
    new EuropeanSolitaireModelImpl(14);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException3() {
    new EuropeanSolitaireModelImpl(3, 0, 0);
    new EuropeanSolitaireModelImpl(3, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException4() {
    new EuropeanSolitaireModelImpl(2, 3, 3);
    new EuropeanSolitaireModelImpl(-1, 3, 3);
  }

  @Test
  public void moveAbove() {
    model1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void moveBelow() {
    model1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void moveLeft() {
    model1.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void moveRight() {
    model1.move(3, 5, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void noFromPosition() {
    model1.move(-1,-1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noToPosition() {
    model1.move(3, 1, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noPegAtFrom() {
    model1.move(3, 1, 3, 3);
    model1.move(3,1,3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPegNotEmpty() {
    model1.move(3, 4, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moreThanTwoApart() {
    model1.move(3, 1, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalMove() {
    model1.move(4,4, 3, 3);
  }

  @Test
  public void gameNotOver() {
    assertFalse(model1.isGameOver());
  }

  @Test
  public void gameIsOver() {
    model1.move(1, 3, 3, 3);
    model1.move(4, 3, 2,3);
    model1.move(6, 3, 4, 3);
    model1.move(3, 1, 3,3);
    model1.move(3, 4, 3, 2);
    model1.move(3, 6, 3,4);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O _ O", model1.getGameState());
    model1.move(5, 1, 3, 1);
    model1.move(5, 5, 3, 5);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O _\n" +
            "O _ O O O _ O\n" +
            "  _ O _ O _\n" +
            "    O _ O", model1.getGameState());
    model1.move(3, 1, 3, 3);
    model1.move(3, 4, 3, 6);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O _ _ O\n" +
            "O _ O O O _ O\n" +
            "  _ O _ O _\n" +
            "    O _ O", model1.getGameState());
    model1.move(5, 2, 3, 2);
    model1.move(5, 4, 3, 4);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O _ O O O _ O\n" +
            "O _ _ O _ _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ O", model1.getGameState());
    model1.move(3, 3, 5, 3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ O\n" +
            "O _ _ _ _ _ O\n" +
            "  _ _ O _ _\n" +
            "    O _ O", model1.getGameState());
    model1.move(2, 2, 4, 2);
    model1.move(1, 1, 3, 1);
    model1.move(2, 4, 4, 4);
    assertEquals("    O O O\n" +
            "  _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "O O _ _ _ _ O\n" +
            "O _ O _ O _ O\n" +
            "  _ _ O _ _\n" +
            "    O _ O", model1.getGameState());
    assertFalse(model1.isGameOver());
    model1.move(0, 4, 2, 4);
    model1.move(0, 2, 2, 2);
    assertEquals("    _ O _\n" +
            "  _ _ _ _ O\n" +
            "O _ O O O O O\n" +
            "O O _ _ _ _ O\n" +
            "O _ O _ O _ O\n" +
            "  _ _ O _ _\n" +
            "    O _ O", model1.getGameState());
    model1.move(2, 3, 2, 1);
    model1.move(3, 0, 3, 2);
    assertEquals("    _ O _\n" +
            "  _ _ _ _ O\n" +
            "O O _ _ O O O\n" +
            "_ _ O _ _ _ O\n" +
            "O _ O _ O _ O\n" +
            "  _ _ O _ _\n" +
            "    O _ O", model1.getGameState());
    model1.move(2, 0, 2, 2);
    model1.move(2, 5, 2, 3);
    assertEquals("    _ O _\n" +
            "  _ _ _ _ O\n" +
            "_ _ O O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O _ O _ O _ O\n" +
            "  _ _ O _ _\n" +
            "    O _ O", model1.getGameState());
    model1.move(3, 2, 1, 2);
    assertTrue(model1.isGameOver());
  }
}


