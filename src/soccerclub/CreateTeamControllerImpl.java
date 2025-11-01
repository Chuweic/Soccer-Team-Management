package soccerclub;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The implementation of the CreateTeamController interface. It interacts with both CreateTeamView
 * and CreatTeam model. It implements all the methods in the interface.
 */
public class CreateTeamControllerImpl implements CreatTeamController {
  private final CreateTeam model;
  private final CreateTeamView view;
  private int count;

  /**
   * The constructor of the CreateTeamControllerImpl.
   *
   * @param m the CreateTeam object model.
   * @param v the CreateTeamView object view.
   */
  public CreateTeamControllerImpl(CreateTeam m, CreateTeamView v) {
    this.model = m;
    this.view = v;
    this.count = 0;
  }

  @Override
  public void setTeam() {
    view.addFeatures(this);
  }

  @Override
  public void addPlayers(String firstName, String lastName, String date, String position,
      String skill) {
    try {
      DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate dateOfBirth = LocalDate.parse(date, format);
      int skillLevel = Integer.parseInt(skill);
      Position preferredPosition = Position.valueOf(position);
      Player p = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      model.addCandidate(p);
      count++;
      view.updateTopTextAfterAddCandidates(count);
      view.displayAddedCandidateInfo(count, p.toString());
      view.clearInputFields();
    } catch (IllegalArgumentException e) {
      view.showExceptionMessage(e.getMessage());
    } catch (DateTimeParseException e) {
      view.showExceptionMessage("Invalid Date of Birth Format");
    }
  }

  @Override
  public void createTeam() {
    try {
      model.constructTeam();
      view.enableButtons();
      view.updateTopTextAfterCreateTeam();
    } catch (IllegalArgumentException e) {
      view.showExceptionMessage(e.getMessage());
    }
  }

  @Override
  public void listAllTeamPlayers() {
    String text = model.displayAllTeamPlayers();
    view.displayPlayers(text);
  }

  @Override
  public void listStartingLineUp() {
    String text = model.displayStartingLineUp();
    view.displayPlayers(text);
  }

  @Override
  public void exitProgram() {
    System.exit(0);
  }
}
