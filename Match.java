
class Match
{
  private Player playerWhite, playerBlack;
  private int result;

  Match(Player pWhite, Player pBlack){
      playerWhite = pWhite;
      playerBlack = pBlack;
  }

  /**
   * @return the result
   */
  public int getResult() {
      return result;
  }
  /**
   * @param result the result to set
   */
  public void setResult(int result) {
      this.result = result;
  }
  public void updatePlayerScores(){
      playerWhite.setScore(playerWhite.getScore() + result);
      playerBlack.setScore(playerBlack.getScore() + 2 - result);
  }

  /**
   * @return the player playing black 
   */
  public Player getPlayerBlack() {
      return playerBlack;
  }
  /**
   * @return the playerWhite
   */
  public Player getPlayerWhite() {
      return playerWhite;
  }
}