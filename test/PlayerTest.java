import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;
import soccerclub.Player;
import soccerclub.Position;

/**
 * this is the test for Player class.
 */
public class PlayerTest {

  /**
   * test IllegalArgumentException by providing player older than 10 years old.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAgeOlderThanTen() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2013, 02, 01), Position.Goalie, 5);
  }

  /**
   * test getFirstName() method.
   */
  @Test
  public void testGetFirstName() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    assertEquals("Tom", p.getFirstName());
  }

  /**
   * test getLastName() method.
   */
  @Test
  public void testGetLastName() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    assertEquals("Hanks", p.getLastName());
  }

  /**
   * test getPreferredPosition() method.
   */
  @Test
  public void testGetPreferredPosition() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    assertEquals(Position.Goalie, p.getPreferredPosition());
  }

  /**
   * test getSkillLevel() method.
   */
  @Test
  public void testGetSkillLevel() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    assertEquals(5, p.getSkillLevel());
  }

  /**
   * test IllegalArgumentException by providing skill level higher than Five.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentExceptionSkillLevel() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 6);
  }

  /**
   * test IllegalArgumentException by providing skill level as Zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentExceptionZeroSkillLevel() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 0);
  }

  /**
   * test IllegalArgumentException by providing negative skill level.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentExceptionNegativeSkillLevel() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, -5);
  }

  /**
   * test generateMapKeyByNameAndDate() method.
   */
  @Test
  public void testGenerateMapKeyByNameAndDate() {
    Player p = new Player("Tom", "Hanks",
        LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    assertEquals("TomHanks2014-11-11", p.generateMapKeyByNameAndDate());
  }
}