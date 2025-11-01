package soccerclub;

/**
 * This is the interface of CreatTeamControllerImpl. It enables the actions on addPlayers, create
 * team, list All Team Players, list Starting LineUp, and exit program.
 */
public interface CreatTeamController {
  /**
   * Set up the view with all the callbacks.
   */
  void setTeam();

  /**
   * To interact with the model to add a player.
   *
   * @param firstName         the first name of the player.
   * @param lastName          the last name of the player.
   * @param dateOfBirth       the date of birth of the player.
   * @param preferredPosition the preferred position of the player.
   * @param skillLevel        the skill level of the player.
   */
  void addPlayers(String firstName, String lastName, String dateOfBirth, String preferredPosition,
      String skillLevel);

  /**
   * To interact with model to construct a soccer team of size 10-20.
   */
  void createTeam();

  /**
   * To display all players in the team.
   */
  void listAllTeamPlayers();

  /**
   * To display starting line up players.
   */
  void listStartingLineUp();

  /**
   * Exit the program.
   */
  void exitProgram();
}
