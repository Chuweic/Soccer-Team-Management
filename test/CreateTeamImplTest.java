import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerclub.CreateTeam;
import soccerclub.CreateTeamModel;
import soccerclub.Player;
import soccerclub.Position;


/**
 * This class is to test CreateTeam.
 */
public class CreateTeamImplTest {
  private CreateTeam t1;
  private CreateTeam t2;
  private Player p1;
  private Player p2;
  private Player p3;
  private Player p4;
  private Player p5;
  private Player p6;
  private Player p7;
  private Player p8;
  private Player p9;
  private Player p10;
  private Player p11;
  private Player p12;
  private Player p13;
  private Player p14;
  private Player p15;
  private Player p16;
  private Player p17;
  private Player p18;
  private Player p19;
  private Player p20;
  private Player p21;
  private Player p22;
  private Player p23;
  private Player p24;
  private Player p25;

  /**
   * to set up the test by initializing 25 player objects and 2 team objects.
   */
  @Before
  public void setUp() {
    p1 = new Player("Chuwei1", "One", LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    p2 = new Player("Chuwei2", "two", LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    p3 = new Player("Chuwei3", "Three", LocalDate.of(2015, 11, 11), Position.Defender, 5);
    p4 = new Player("Chuwei4", "Four", LocalDate.of(2015, 11, 11), Position.Defender, 5);
    p5 = new Player("Chuwei5", "Five", LocalDate.of(2016, 11, 11), Position.Defender, 1);
    p6 = new Player("Chuwei6", "Six", LocalDate.of(2016, 11, 11), Position.Midfield, 3);
    p7 = new Player("Chuwei7", "Seven", LocalDate.of(2017, 11, 11), Position.Midfield, 4);
    p8 = new Player("Chuwei8", "eight", LocalDate.of(2017, 11, 11), Position.Midfield, 3);
    p9 = new Player("Chuwei9", "Nine", LocalDate.of(2018, 11, 11), Position.Forward, 4);
    p10 = new Player("Chuwei10", "Ten", LocalDate.of(2018, 11, 11), Position.Forward, 4);
    p11 = new Player("Chuwei11", "Eleven", LocalDate.of(2014, 11, 11), Position.Goalie, 5);
    p12 = new Player("Chuwei12", "Twelve", LocalDate.of(2014, 11, 11), Position.Goalie, 3);
    p13 = new Player("Chuwei13", "Thirteen", LocalDate.of(2015, 11, 11), Position.Defender, 4);
    p14 = new Player("Chuwei14", "Fourteen", LocalDate.of(2015, 11, 11), Position.Defender, 4);
    p15 = new Player("Chuwei15", "Fifteen", LocalDate.of(2016, 11, 11), Position.Defender, 5);
    p16 = new Player("Chuwei16", "Sixteen", LocalDate.of(2016, 11, 11), Position.Midfield, 4);
    p17 = new Player("Chuwei17", "Seventeen", LocalDate.of(2017, 11, 11), Position.Midfield, 4);
    p18 = new Player("Chuwei18", "Eighteen", LocalDate.of(2017, 11, 11), Position.Midfield, 2);
    p19 = new Player("Chuwei19", "Nineteen", LocalDate.of(2018, 11, 11), Position.Forward, 2);
    p20 = new Player("Chuwei20", "Twenty", LocalDate.of(2018, 11, 11), Position.Forward, 1);
    p21 = new Player("Chuwei21", "AOne", LocalDate.of(2014, 11, 11), Position.Goalie, 1);
    p22 = new Player("Chuwei22", "BTwo", LocalDate.of(2014, 11, 11), Position.Goalie, 1);
    p23 = new Player("Chuwei23", "CThree", LocalDate.of(2015, 11, 11), Position.Defender, 1);
    p24 = new Player("Chuwei24", "DFour", LocalDate.of(2015, 11, 11), Position.Defender, 4);
    p25 = new Player("Chuwei25", "EFive", LocalDate.of(2016, 11, 11), Position.Defender, 1);
    t1 = new CreateTeamModel();
    t2 = new CreateTeamModel();
  }

  /**
   * test addCandidate() method by adding 10 players.
   */
  @Test
  public void testAddCandidate10() {
    t1.addCandidate(p1);
    t1.addCandidate(p2);
    t1.addCandidate(p3);
    t1.addCandidate(p4);
    t1.addCandidate(p5);
    t1.addCandidate(p6);
    t1.addCandidate(p7);
    t1.addCandidate(p8);
    t1.addCandidate(p9);
    t1.addCandidate(p10);
  }

  /**
   * test addCandidate() method by adding 25 players.
   */
  @Test
  public void testAddCandidate25() {
    t2.addCandidate(p1);
    t2.addCandidate(p2);
    t2.addCandidate(p3);
    t2.addCandidate(p4);
    t2.addCandidate(p5);
    t2.addCandidate(p6);
    t2.addCandidate(p7);
    t2.addCandidate(p8);
    t2.addCandidate(p9);
    t2.addCandidate(p10);
    t2.addCandidate(p11);
    t2.addCandidate(p12);
    t2.addCandidate(p13);
    t2.addCandidate(p14);
    t2.addCandidate(p15);
    t2.addCandidate(p16);
    t2.addCandidate(p17);
    t2.addCandidate(p18);
    t2.addCandidate(p19);
    t2.addCandidate(p20);
    t2.addCandidate(p21);
    t2.addCandidate(p22);
    t2.addCandidate(p23);
    t2.addCandidate(p24);
    t2.addCandidate(p25);
  }

  /**
   * test IllegalArgumentException by construct team with less than 10 candidates.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructTeamLessThanTen() {
    CreateTeam t3 = new CreateTeamModel();
    t3.addCandidate(p1);
    t3.addCandidate(p2);
    t3.addCandidate(p3);
    t3.addCandidate(p4);
    t3.addCandidate(p5);
    t3.addCandidate(p6);
    t3.addCandidate(p7);
    t3.addCandidate(p8);
    t3.addCandidate(p9);
    t3.constructTeam();
  }

  /**
   * test displayAllTeamPlayers() method by adding 10 players.
   */
  @Test
  public void testDisplayAllTeamPlayersOfTen() {
    t1.addCandidate(p1);
    t1.addCandidate(p2);
    t1.addCandidate(p3);
    t1.addCandidate(p4);
    t1.addCandidate(p5);
    t1.addCandidate(p6);
    t1.addCandidate(p7);
    t1.addCandidate(p8);
    t1.addCandidate(p9);
    t1.addCandidate(p10);
    t1.constructTeam();
    String expectedAllPlayerOutput = "All players in the team:\n"
        + "Chuwei8, eight, 13\n"
        + "Chuwei5, Five, 7\n"
        + "Chuwei4, Four, 19\n"
        + "Chuwei9, Nine, 5\n"
        + "Chuwei1, One, 17\n"
        + "Chuwei7, Seven, 16\n"
        + "Chuwei6, Six, 14\n"
        + "Chuwei10, Ten, 10\n"
        + "Chuwei3, Three, 12\n"
        + "Chuwei2, two, 11\n";
    assertEquals(expectedAllPlayerOutput, t1.displayAllTeamPlayers());
  }

  /**
   * test displayStartingLineUp() method with 10 players.
   */
  @Test
  public void testDisplayStartingLineUpOutOfTen() {
    t1.addCandidate(p1);
    t1.addCandidate(p2);
    t1.addCandidate(p3);
    t1.addCandidate(p4);
    t1.addCandidate(p5);
    t1.addCandidate(p6);
    t1.addCandidate(p7);
    t1.addCandidate(p8);
    t1.addCandidate(p9);
    t1.addCandidate(p10);
    t1.constructTeam();
    String expectedOutput = "Starting line up:\n" + "Chuwei1, One, 17, Goalie\n"
        + "Chuwei4, Four, 19, Defender\n" + "Chuwei3, Three, 12, Defender\n"
        + "Chuwei7, Seven, 16, Midfield\n" + "Chuwei10, Ten, 10, Midfield\n"
        + "Chuwei2, two, 11, Midfield\n" + "Chuwei9, Nine, 5, Forward\n";
    assertEquals(expectedOutput, t1.displayStartingLineUp());
  }

  /**
   * test displayAllTeamPlayers() method with 25 players.
   */
  @Test
  public void displayAllTeamPlayersOf25() {
    t2.addCandidate(p1);
    t2.addCandidate(p2);
    t2.addCandidate(p3);
    t2.addCandidate(p4);
    t2.addCandidate(p5);
    t2.addCandidate(p6);
    t2.addCandidate(p7);
    t2.addCandidate(p8);
    t2.addCandidate(p9);
    t2.addCandidate(p10);
    t2.addCandidate(p11);
    t2.addCandidate(p12);
    t2.addCandidate(p13);
    t2.addCandidate(p14);
    t2.addCandidate(p15);
    t2.addCandidate(p16);
    t2.addCandidate(p17);
    t2.addCandidate(p18);
    t2.addCandidate(p19);
    t2.addCandidate(p20);
    t2.addCandidate(p21);
    t2.addCandidate(p22);
    t2.addCandidate(p23);
    t2.addCandidate(p24);
    t2.addCandidate(p25);
    t2.constructTeam();
    String expectedAllPlayerOutput =
        "All players in the team:\n" + "Chuwei24, DFour, 1\n" + "Chuwei8, eight, 2\n"
            + "Chuwei18, Eighteen, 18\n" + "Chuwei11, Eleven, 16\n" + "Chuwei15, Fifteen, 5\n"
            + "Chuwei5, Five, 4\n" + "Chuwei4, Four, 19\n" + "Chuwei14, Fourteen, 6\n"
            + "Chuwei9, Nine, 14\n" + "Chuwei19, Nineteen, 20\n" + "Chuwei1, One, 17\n"
            + "Chuwei7, Seven, 10\n" + "Chuwei17, Seventeen, 15\n" + "Chuwei6, Six, 3\n"
            + "Chuwei16, Sixteen, 8\n" + "Chuwei10, Ten, 13\n" + "Chuwei13, Thirteen, 7\n"
            + "Chuwei3, Three, 12\n" + "Chuwei12, Twelve, 9\n" + "Chuwei2, two, 11\n";
    assertEquals(expectedAllPlayerOutput, t2.displayAllTeamPlayers());
  }

  /**
   * test displayStartingLineUp() method with 25 players.
   */
  @Test
  public void displayStartingLineOutOf25() {
    t2.addCandidate(p1);
    t2.addCandidate(p2);
    t2.addCandidate(p3);
    t2.addCandidate(p4);
    t2.addCandidate(p5);
    t2.addCandidate(p6);
    t2.addCandidate(p7);
    t2.addCandidate(p8);
    t2.addCandidate(p9);
    t2.addCandidate(p10);
    t2.addCandidate(p11);
    t2.addCandidate(p12);
    t2.addCandidate(p13);
    t2.addCandidate(p14);
    t2.addCandidate(p15);
    t2.addCandidate(p16);
    t2.addCandidate(p17);
    t2.addCandidate(p18);
    t2.addCandidate(p19);
    t2.addCandidate(p20);
    t2.addCandidate(p21);
    t2.addCandidate(p22);
    t2.addCandidate(p23);
    t2.addCandidate(p24);
    t2.addCandidate(p25);
    t2.constructTeam();
    String expectedAllPlayerOutput =
        "Starting line up:\n" + "Chuwei1, One, 17, Goalie\n" + "Chuwei4, Four, 19, Defender\n"
            + "Chuwei3, Three, 12, Defender\n" + "Chuwei11, Eleven, 16, Midfield\n"
            + "Chuwei7, Seven, 10, Midfield\n" + "Chuwei2, two, 11, Midfield\n"
            + "Chuwei15, Fifteen, 5, Forward\n";
    assertEquals(expectedAllPlayerOutput, t2.displayStartingLineUp());
  }

}
