package soccerclub;

/**
 * This is the Interface oto create a soccer team. It can add candidate, construct team, and display
 * all player information in the team, and starting line up.
 */
public interface CreateTeam {

  /**
   * to add players information to the candidate pool.
   *
   * @param p the Player to be added.
   */
  void addCandidate(Player p);

  /**
   * to select players out of the candidate pool, assign unique and random jersey numbers to each
   * player in the team, select starting line up by skill levels, and assign positions.
   */
  void constructTeam();

  /**
   * to display a list of the starting lineup. including their first name, last name, jersey number,
   * and position. The list must be sorted by position (goalie, defender, midfielder, forward).
   * Players with the same position should be ordered alphabetically.
   *
   * @return to return a String with a list of players.
   */
  String displayStartingLineUp();

  /**
   * to display a list of all the players in the team, including their first name, last name, jersey
   * number, sorted in alphabetical order (last name).
   *
   * @return return a String with a list of players.
   */
  String displayAllTeamPlayers();
}
