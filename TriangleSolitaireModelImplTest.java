import org.junit.Test;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.Board;
import cs3500.marblesolitaire.model.hw04.TriangleBoard;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TriangleSolitaireModelImplTest {
  MarbleSolitaireModel model1 = new TriangleSolitaireModelImpl();
  MarbleSolitaireModel model2 = new TriangleSolitaireModelImpl(7);
  MarbleSolitaireModel model3 = new TriangleSolitaireModelImpl(5, 3,3);
  MarbleSolitaireModel model4 = new TriangleSolitaireModelImpl(3,3);
  MarbleSolitaireModel model5 = new TriangleSolitaireModelImpl(3, 2);

  Board triBoard = new TriangleBoard(5, 0, 0);

  @Test
  public void testOrigin() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
  }

  @Test
  public void testValidMove() {
    assertEquals(true, triBoard.isValid(2, 2, 0, 0));
  }

  @Test
  public void thatsGame() {
    assertEquals(false, model1.isGameOver());
  }

  @Test
  public void testMove1() {
    model1.move(2,2, 0, 0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
  }

  @Test
  public void testScore1() {
    assertEquals(14, model1.getScore());
  }

  @Test
  public void testScoreMove() {
    model1.move(2,2,0,0);
    assertEquals(13, model1.getScore());
  }

  @Test
  public void testConstructorNoParam() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
  }

  @Test
  public void testConstructor1Param() {
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", model2.getGameState());
  }

  @Test
  public void testConstructor2Param() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O", model3.getGameState());
  }

  @Test
  public void testConstructor3Param() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O", model4.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void armIllegal1() {
    new TriangleSolitaireModelImpl(-1);
    new TriangleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void armIllegal2() {
    new TriangleSolitaireModelImpl(-1, 0,0);
    new TriangleSolitaireModelImpl(0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalPosition1() {
    new TriangleSolitaireModelImpl(4, 5);
    new TriangleSolitaireModelImpl(-1,-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalPosition2() {
    new TriangleSolitaireModelImpl(5, 4, 5);
    new TriangleSolitaireModelImpl(-1, -1, -1);
  }

  @Test
  public void makeMoveUp() {
    model1.move(2,2,0,0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
  }

  @Test
  public void makeMoveRight() {
    model1.move(2,2,0,0);
    model1.move(4, 4, 2,2);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _", model1.getGameState());
  }

  @Test
  public void makeMoveLeft() {
    model1.move(2, 0,0,0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
    model1.move(2, 2, 2, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
  }

  @Test
  public void makeMoveDown() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O O O", model5.getGameState());
    model5.move(1, 0, 3, 2);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", model5.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNoExist() {
    model1.move(-1, -1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNoExist() {
    model1.move(2, 2, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromIsNotMarble() {
    model1.move(2, 2, 0,0);
    model1.move(2,2, 0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNotEmpty() {
    model5.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void middleEmpty() {
    model5.move(1, 0, 3,2);
    model5.move(3, 2, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooFarAway() {
    model1.move(4, 4, 0,0);
  }

  @Test
  public void gameNotOver() {
    assertFalse(model1.isGameOver());
  }

  @Test
  public void gameIsOver() {
    model1.move(2, 2,0,0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", model1.getGameState());
    model1.move(4, 4, 2, 2);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _", model1.getGameState());
    model1.move(4, 2, 4, 4);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O _ _ O", model1.getGameState());
    model1.move(3, 1, 3, 3);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O _ _ O\n" +
            "O O _ _ O", model1.getGameState());
    model1.move(1, 0, 3, 2);
    model1.move(4, 0, 4, 2);
    model1.move(3, 3, 1, 1);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O _ O _\n" +
            "_ _ O _ O", model1.getGameState());
    model1.move(3,0, 1,0);
    model1.move(4, 2, 2, 2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  _ _ O\n" +
            " _ _ _ _\n" +
            "_ _ _ _ O", model1.getGameState());
    model1.move(0,0, 2, 0);
    model1.move(1, 1, 3, 3);
    assertEquals("    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ _ _ O\n" +
            "_ _ _ _ O", model1.getGameState());
    model1.move(4, 4, 2, 2);
    assertTrue(model1.isGameOver());
  }
}
