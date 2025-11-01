package soccerclub;

/**
 * This is the driver class of CreateTeam.
 */
public class Main {
  /**
   * the main function to run the CreateTeam class.
   *
   * @param args commend-line arguments.
   */
  public static void main(String[] args) {
    CreateTeam m = new CreateTeamModel();
    CreateTeamView v = new CreatTeamViewImpl("Soccer Team Under 10");
    CreatTeamController c = new CreateTeamControllerImpl(m, v);
    c.setTeam();
  }
}