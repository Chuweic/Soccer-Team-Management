package soccerclub;

/**
 * This is the interface of createTeamViewImpl.
 * It provides the view that users can input player information and create team.
 */
public interface CreateTeamView {

  /**
   * To update the top text to show the number of candidate added.
   *
   * @param n the number of candidate added.
   */
  void updateTopTextAfterAddCandidates(int n);

  /**
   * To update the top text to indicate that the team has been created.
   */
  void updateTopTextAfterCreateTeam();

  /**
   * Clear the text field.
   */
  void clearInputFields();

  /**
   * Set the label to show the added candidate information.
   *
   * @param n the number of candidate added.
   * @param s the candidate information to display.
   */
  void displayAddedCandidateInfo(int n, String s);

  /**
   * Set the label that is showing the palyer information that the model stores.
   *
   * @param text the text entered by the user.
   */
  void displayPlayers(String text);

  /**
   * to set display buttons clickable.
   */
  void enableButtons();

  /**
   * To pop up the message when there is an exception.
   *
   * @param s The exception message.
   */
  void showExceptionMessage(String s);

  /**
   * Add the Controller to the view.
   *
   * @param creatTeamController the implementation of our controller.
   */
  void addFeatures(CreatTeamController creatTeamController);
}
