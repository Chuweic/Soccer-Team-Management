package soccerclub;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is the class of Player. It takes in the Player's first name, last name, Player's date of
 * birth (only player's under ten years of age can be part of the team), Player's preferred position
 * (goalie, defender, midfielder, forward), Skill level, which is a number between 1 and 5 based on
 * the coach's assessment (1 = lowest skill level, 5 = highest skill level).
 */
public class Player {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private Position preferredPosition;
  private int skillLevel;

  /**
   * This is the constructor of Player class.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player
   * @param skillLevel        the skill level of the player
   * @throws IllegalArgumentException player is older than 10 years old, or if provided skill level
   *                                  if not within 1 - 5
   */
  public Player(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {
    this.firstName = firstName;
    this.lastName = lastName;
    LocalDate now = LocalDate.now();
    if (Period.between(dateOfBirth, now).getYears() >= 10) {
      throw new IllegalArgumentException("Player should under 10 years old");
    }
    if (dateOfBirth.isAfter(now)) {
      throw new IllegalArgumentException("Date of Birth should not be in the future");
    }
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level should be in the range of 1 - 5, try again!");
    }
    this.skillLevel = skillLevel;
  }

  /**
   * to get the first name of the player.
   *
   * @return String of first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * to get the last name of the player.
   *
   * @return String of last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * to get the preferred position of the player.
   *
   * @return Position of the preferred position of the player.
   */
  public Position getPreferredPosition() {
    return this.preferredPosition;
  }

  /**
   * to get the skill level of the player.
   *
   * @return int of the preferred position of the player.
   */
  public int getSkillLevel() {
    return this.skillLevel;
  }

  /**
   * to generate unique key to identify a player, by combining his/her firstname, last name, and
   * date of birth.
   *
   * @return a string combined by the player's firstname, last name, and date of birth.
   */
  public String generateMapKeyByNameAndDate() {
    return String.format(this.firstName + this.lastName + this.dateOfBirth);
  }

  @Override public String toString() {
    return String.format(this.firstName + " " + this.lastName + " " + this.dateOfBirth + " "
        + getPreferredPosition().toString() + " " + this.skillLevel);
  }
}
