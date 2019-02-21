import org.junit.Test;


import cs3500.marblesolitaire.model.hw02.BoardStandard;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MarbleSolitaireModelImplTest {

  MarbleSolitaireModel model1 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel model2 = new MarbleSolitaireModelImpl(3, 3);
  MarbleSolitaireModel model3 = new MarbleSolitaireModelImpl(7);
  MarbleSolitaireModel model4 = new MarbleSolitaireModelImpl(5, 6, 6);
  BoardStandard board1 = new BoardStandard(3, 3, 3);
  BoardStandard board2 = new BoardStandard(3, 1, 4);
  BoardStandard board3 = new BoardStandard(5, 6, 6);

  @Test
  public void testIsGameOver1() {
    assertFalse(model1.isGameOver());
  }

  @Test
  public void testIsGameOverNo() {
    model1.move(1, 3, 3, 3);
    assertFalse(model1.isGameOver());
  }

  @Test
  public void testGetScore() {
    assertEquals(32, model1.getScore());
    model1.move(1, 3, 3, 3);
    assertEquals(31, model1.getScore());
    model1.move(2, 5, 2, 3);
    assertEquals(30, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMove() {
    model1.move(1, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMove2() {
    model4.move(6, 6, 5, 5);
  }

  @Test
  public void testGetGameState1() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.model1.getGameState());
  }

  @Test
  public void testIsValid() {
    assertFalse(board1.isValid(3, 3, 3, 3));
    assertTrue(board1.isValid(1, 3, 3, 3));
  }


  // test constructor
  @Test
  public void testConstructor() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model2.getGameState());
  }

  @Test
  public void testConstructor2() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorExceptions() {
    new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorExceptions2() {
    new MarbleSolitaireModelImpl(2, 3, 3);
  }


  @Test
  public void moveTest() {
    model2.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model2.getGameState());
  }

  @Test
  public void moveTest2() {
    model1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test
  public void moveTest3() {
    model2.move(3, 5, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model2.getGameState());
  }

  @Test
  public void moveTest4() {
    model1.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", model1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions() {
    model1.move(0, 0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions2() {
    model1.move(3, 1, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions3() {
    model2.move(5, 3, 6, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions5() {
    model2.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions6() {
    model1.move(3, 0, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptions7() {
    model1.move(4, 5, 2, 2);
  }

  @Test
  public void testMoveBig1() {
    model4.move(6, 8, 6, 6);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O _ _ O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", model4.getGameState());
  }


  @Test
  public void testMoveBig3() {
    model4.move(8, 6, 6, 6);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", model4.getGameState());
  }

  @Test
  public void testMoveBig4() {
    model4.move(4, 6, 6, 6);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", model4.getGameState());
  }


  @Test
  public void testGameState() {
    assertEquals("    O O O\n" +
            "    O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", board2.getGameState());
  }

  @Test
  public void testGameState2() {
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", board3.getGameState());
  }
}





