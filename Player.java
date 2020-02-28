import java.util.*;
class Player
{
  private String name, team;
  private int score, gamesAsWhite, gamesAsBlack;
  private ArrayList<Player> opponents;
  private int[] tiebreaks;
  private ArrayList<Match> matches;

  Player(String n, String t){
    name = n;
    team = t;
    opponents = new ArrayList<Player>();
  }

  public int getScore(){
    return score;
  } 
  public int[] getTiebreaks(){
    return tiebreaks;
  }
  public String getName(){
    return name;
  }
  public String getTeam(){
    return team;
  }
  public int getGamesAsWhite(){
    return gamesAsWhite;
  }
  public int getGamesAsBlack(){
    return gamesAsBlack;
  }
  public void setGamesAsWhite(int g){
    gamesAsWhite = g;
  }
  public void setGamesAsBlack(int g){
    gamesAsBlack = g;
  }
  public void setScore(int s) {
    score = s;
  }
  public void addOpponent(Player p){
    opponents.add(p);
  }
  public void updateTiebreakScores(){
    
  }
}