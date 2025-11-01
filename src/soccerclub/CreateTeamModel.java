package soccerclub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This is the implementation of CreateTeam, it allowed users to add candidates, construct soccer
 * team, and display the players information in the Team and in the starting line up.
 */
public class CreateTeamModel implements CreateTeam {
  private static final int TEAMSIZE_MIN = 10;
  private static final int TEAMSIZE_MAX = 20;
  private static final int STARTINGLINEUPSIZE = 7;
  private static final int GOALIESIZE = 1;
  private static final int DEFENDERSIZE = 2;
  private static final int MIDFIELDSIZE = 3;
  private static final int FORWARDSIZE = 1;
  private List<Player> candidateList;
  private List<Player> teamList;
  private Map<String, Integer> jerseyMap;
  private Map<Position, List<Player>> positionMap;
  private Boolean isTeamCreated;

  /**
   * this is the constructor of CreateTeamModel.
   */
  public CreateTeamModel() {
    this.candidateList = new ArrayList<>();
    this.teamList = new ArrayList<>();
    this.jerseyMap = new TreeMap<>();
    this.positionMap = new TreeMap<>();
    this.isTeamCreated = false;
  }

  @Override public void addCandidate(Player p) {
    this.candidateList.add(p);
  }

  /**
   * to select players among all candidates to construct a team. team size is between 10 - 20. if
   * there are more than 20 candidates, choose top 20 candidates by skill level.
   *
   * @throws IllegalArgumentException if there are less than 10 candidates.
   */
  private void getTeamList() throws IllegalArgumentException {
    int i;
    if (candidateList.size() < TEAMSIZE_MIN) {
      throw new IllegalArgumentException(
          "The team must have a minimum of 10 players, please add player(s)");
    } else if (candidateList.size() > TEAMSIZE_MAX) {
      // sort all players by skill level from high to low,
      // save the sorted list to the sortedPlayerList
      List<Player> sortedPlayerList = candidateList.stream()
          .sorted(Comparator.comparing(Player::getSkillLevel).reversed())
          .collect(Collectors.toList());
      // select top 20 players to construct team.
      for (i = 0; i < TEAMSIZE_MAX; i++) {
        this.teamList.add(sortedPlayerList.get(i));
      }
    } else {
      // sort all players by skill level, save the sorted list to the sortedPlayerList
      List<Player> sortedPlayerList = candidateList.stream()
          .sorted(Comparator.comparing(Player::getSkillLevel).reversed())
          .collect(Collectors.toList());
      for (i = 0; i < this.candidateList.size(); i++) {
        this.teamList.add(sortedPlayerList.get(i));
      }
    }
  }

  /**
   * To initialize the position map by adding positions as key, and empty array list as value.
   */
  private void initializePositionMap() {
    this.positionMap.put(Position.Goalie, new ArrayList<>());
    this.positionMap.put(Position.Defender, new ArrayList<>());
    this.positionMap.put(Position.Midfield, new ArrayList<>());
    this.positionMap.put(Position.Forward, new ArrayList<>());
  }

  /**
   * To assign positions to seven most skilled players in the team. Players, who have been assign
   * positions, will be added to the array list of positionMap. If possible, these players will be
   * assigned their preferred positions but there is no guarantee that this will happen. The
   * remaining players are considered to be on the bench. They are not assigned positions.
   */
  private void assignPosition() {
    // get top seven players by skill level and add to a list.
    List<Player> sortedTopSevenPlayerList = new ArrayList<Player>();
    List<Player> notAssignedPositionPlayers = new ArrayList<>();
    for (int i = 0; i < STARTINGLINEUPSIZE; i++) {
      sortedTopSevenPlayerList.add(this.teamList.get(i));
    }
    // initialize a position pool map with max number of players in certain position.
    Map<Position, Integer> positionPoll = new TreeMap<>();
    positionPoll.put(Position.Goalie, GOALIESIZE);
    positionPoll.put(Position.Defender, DEFENDERSIZE);
    positionPoll.put(Position.Midfield, MIDFIELDSIZE);
    positionPoll.put(Position.Forward, FORWARDSIZE);
    // iterate through the top seven player list.
    // if a player's preferred position is not full, assign preferred position,
    // add the player to positionMap.
    // if a player's preferred position is full, add the player to a new list.
    for (int j = 0; j < sortedTopSevenPlayerList.size(); j++) {
      Position playerPreferredPosition = sortedTopSevenPlayerList.get(j).getPreferredPosition();
      if (positionPoll.get(playerPreferredPosition) != 0) {
        this.positionMap.get(playerPreferredPosition).add(sortedTopSevenPlayerList.get(j));
        positionPoll.put(playerPreferredPosition, positionPoll.get(playerPreferredPosition) - 1);
      } else {
        notAssignedPositionPlayers.add(sortedTopSevenPlayerList.get(j));
      }
    }
    // randomly assigned rest players to rest positions.
    for (int i = 0; i < notAssignedPositionPlayers.size(); i++) {
      for (Map.Entry<Position, Integer> entry : positionPoll.entrySet()) {
        if (entry.getValue() != 0) {
          this.positionMap.get(entry.getKey()).add(notAssignedPositionPlayers.get(i));
          positionPoll.put(entry.getKey(), entry.getValue() - 1);
          break;
        }
      }
    }
  }

  /**
   * to assign jersey number to players. The numbers are between 1 and 20 (inclusive). Jersey
   * numbers are unique, randomly assigned, and cannot be changed once created.
   */
  private void assignJersey() {
    ArrayList<Integer> jerseyList = new ArrayList<Integer>();
    for (int i = 1; i <= TEAMSIZE_MAX; i++) {
      jerseyList.add(i);
    }
    // seed is defined for test purpose.
    Collections.shuffle(jerseyList, new Random(2023));
    for (int j = 0; j < this.teamList.size(); j++) {
      String key = this.teamList.get(j).generateMapKeyByNameAndDate();
      int jerseyNum = jerseyList.get(j);
      this.jerseyMap.put(key, jerseyNum);
    }
  }

  @Override public void constructTeam() {
    if (isTeamCreated == false) {
      getTeamList();
      assignJersey();
      initializePositionMap();
      assignPosition();
      isTeamCreated = true;
    }
  }

  @Override public String displayAllTeamPlayers() {
    StringBuilder s = new StringBuilder();
    s.append("All players in the team:\n");
    this.teamList.sort(Comparator.comparing(Player::getLastName, String.CASE_INSENSITIVE_ORDER));
    for (int i = 0; i < this.teamList.size(); i++) {
      String key = teamList.get(i).generateMapKeyByNameAndDate();
      s.append(String.format("%s, %s, %d\n", this.teamList.get(i).getFirstName(),
          this.teamList.get(i).getLastName(), this.jerseyMap.get(key)));
    }
    return s.toString();
  }

  @Override public String displayStartingLineUp() {
    StringBuilder s = new StringBuilder();
    Position[] positionSequence = { Position.Goalie, Position.Defender, Position.Midfield,
        Position.Forward };
    s.append("Starting line up:\n");
    for (int i = 0; i < 4; i++) {
      List<Player> playerByPosition = this.positionMap.get(positionSequence[i]);
      playerByPosition.sort(
          Comparator.comparing(Player::getLastName, String.CASE_INSENSITIVE_ORDER));
      for (int j = 0; j < playerByPosition.size(); j++) {
        String key = playerByPosition.get(j).generateMapKeyByNameAndDate();
        s.append(String.format("%s, %s, %d, %s\n", playerByPosition.get(j).getFirstName(),
            playerByPosition.get(j).getLastName(), this.jerseyMap.get(key), positionSequence[i]));
      }
    }
    return s.toString();
  }

}
