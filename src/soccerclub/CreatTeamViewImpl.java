package soccerclub;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the implementation of createTeamView.
 * users are able to use this view to create soccer team.
 * It has labels to show information, text fields to let user enter data in,
 * and user can see information by clicking buttons.
 */
public class CreatTeamViewImpl extends JFrame implements CreateTeamView {
  private final JLabel topText;
  private final JTextField inputFirstName;
  private final JTextField inputLastName;
  private final JTextField inputDateOfBirth;
  private final JComboBox<String> inputSkillLevel;
  private final JComboBox<String> inputPreferredPosition;
  private final JButton addCandidateButton;
  private final JButton createTeamButton;
  private final JButton allTeamButton;
  private final JButton startingLineUpButton;
  private final JButton exitButton;
  private final JLabel display;
  private final StringBuilder showInputData;
  private JPanel panel4;

  /**
   * Initialize the window.
   *
   * @param title Title for the window.
   */
  public CreatTeamViewImpl(String title) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

    // Set up the top text field.
    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.add(panel1);
    topText = new JLabel("Enter candidate information: ");
    panel1.add(topText);

    // Set up the input field.
    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.add(panel2);
    JLabel firstName = new JLabel("First Name: ");
    panel2.add(firstName);
    inputFirstName = new JTextField(10);
    panel2.add(inputFirstName);

    JLabel lastName = new JLabel("Last Name: ");
    panel2.add(lastName);
    inputLastName = new JTextField(10);
    panel2.add(inputLastName);

    JLabel dateOfBirth = new JLabel("Date of Birth(YYYY-MM-DD): ");
    panel2.add(dateOfBirth);
    inputDateOfBirth = new JTextField(10);
    panel2.add(inputDateOfBirth);

    JLabel preferredPosition = new JLabel("Preferred Position: ");
    panel2.add(preferredPosition);
    String[] positionChoices = { "Goalie", "Defender", "Midfield", "Forward" };
    inputPreferredPosition = new JComboBox<String>(positionChoices);
    inputPreferredPosition.setSelectedItem(null);
    panel2.add(inputPreferredPosition);

    JLabel skillLevel = new JLabel("Skill Level: ");
    panel2.add(skillLevel);
    String[] skillLevelChoices = { "1", "2", "3", "4", "5" };
    inputSkillLevel = new JComboBox<String>(skillLevelChoices);
    inputSkillLevel.setSelectedItem(null);
    panel2.add(inputSkillLevel);

    // Set up buttons.
    // addCandidate Button.
    JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.add(panel3);
    addCandidateButton = new JButton("Add Candidate");
    addCandidateButton.setActionCommand("Add Candidate");
    panel3.add(addCandidateButton);

    // createTeam Button.
    createTeamButton = new JButton("Create Team");
    createTeamButton.setActionCommand("Create Team");
    panel3.add(createTeamButton);

    // displayAllTeam Button.
    allTeamButton = new JButton("Display All Team Players");
    allTeamButton.setActionCommand("Display All Team Players");
    allTeamButton.setEnabled(false);
    panel3.add(allTeamButton);

    // starting line up Button.
    startingLineUpButton = new JButton("Display Starting Lineup");
    startingLineUpButton.setActionCommand("Display Starting Lineup");
    startingLineUpButton.setEnabled(false);
    panel3.add(startingLineUpButton);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    panel3.add(exitButton);

    // Set up text field to display output.
    panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    this.add(panel4);
    showInputData = new StringBuilder();
    display = new JLabel();
    panel4.add(display);

    pack();
    setVisible(true);
  }

  @Override
  public void updateTopTextAfterAddCandidates(int n) {
    topText.setText(n + " candidate(s) has/have been added. Enter the next candidate information:");
  }

  @Override
  public void updateTopTextAfterCreateTeam() {
    topText.setText("Team created successfully!");
  }

  @Override
  public void clearInputFields() {
    inputFirstName.setText("");
    inputLastName.setText("");
    inputDateOfBirth.setText("");
    inputPreferredPosition.setSelectedItem(null);
    inputSkillLevel.setSelectedItem(null);
  }

  @Override
  public void enableButtons() {
    addCandidateButton.setEnabled(false);
    allTeamButton.setEnabled(true);
    startingLineUpButton.setEnabled(true);
  }

  @Override
  public void showExceptionMessage(String s) {
    JOptionPane.showMessageDialog((Component) this, s);
  }

  @Override
  public void displayAddedCandidateInfo(int n, String s) {
    String text = "<html>" + "Candidate" + n + ": " + s + "<br/>" + "<html>";
    showInputData.append(text);
    display.setText(String.valueOf(showInputData));
    panel4.revalidate();
    panel4.repaint();
    pack();
  }

  @Override
  public void displayPlayers(String text) {
    String message = "<html>" + text.replace("\n", "<br/>") + "<html>";
    display.setText(message);
    panel4.revalidate();
    panel4.repaint();
    pack();
  }

  @Override
  public void addFeatures(CreatTeamController creatTeamController) {
    addCandidateButton.addActionListener(
        evt -> creatTeamController.addPlayers(inputFirstName.getText(), inputLastName.getText(),
            inputDateOfBirth.getText(),
            Objects.requireNonNull(inputPreferredPosition.getSelectedItem()).toString(),
            Objects.requireNonNull(inputSkillLevel.getSelectedItem()).toString()));
    createTeamButton.addActionListener(evt -> creatTeamController.createTeam());
    allTeamButton.addActionListener(evt -> creatTeamController.listAllTeamPlayers());
    startingLineUpButton.addActionListener(evt -> creatTeamController.listStartingLineUp());
    exitButton.addActionListener(evt -> creatTeamController.exitProgram());
  }
}
