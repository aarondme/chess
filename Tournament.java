import java.io.*;
import java.util.*;
import javax.swing.*;

class Tournament
{
  private ArrayList<Player> players;
  private Round[] rounds;
  private int currentRound, numberOfRounds, seed;
  private boolean isCancelPressed = false;
  private String name;

    
  Tournament(String name, int numOfRounds){
    this.name = name;
    numberOfRounds = numOfRounds;
    currentRound = 0; 
    rounds = new Round[numOfRounds];
    players = new ArrayList<Player>();
    seed = (int) (Math.random() * 1000000);
    getPlayerList();
  }
  
  /**
     * Sorts the list descending by quicksort
     * @param startIndex the startindex to sort
     * @param lastIndex the last index to sort (inclusive)
     */
    private void sortPlayers(int startIndex, int lastIndex){
      if(startIndex >= lastIndex)
          return;

      Player k = players.get(startIndex);
      int l = startIndex;

      for(int i = startIndex + 1; i <= lastIndex; i++){
        int compare = comparePlayer(players.get(i), k); 
          if(compare == 0){
              l++;
              swap(players, i, l); //puts it in front of the cutoff, it has the same value as the cutoff
          }
          else if(compare > 0){
              swap(players, l + 1, i); //puts element to move in front of the cutoff
              swap(players, l, l + 1); //swaps it with the cutoff
              l++;    
          }
      }
      
      sortPlayers(startIndex, l - 1); //sort subarray before cutoff
      sortPlayers(l + 1, lastIndex); //sort subarray after cutoff
  }
  /**
     * Swaps two elements in an array
     * @param arr the array
     * @param a the index of element 1
     * @param b the index of element 2
     */
    private void swap(ArrayList<Player> arr, int a, int b){
      Player c = arr.get(a);
      arr.set(a, arr.get(b));
      arr.set(b, c);
  }
    private int comparePlayer(Player a, Player b){
      int q = a.getScore() - b.getScore();
      if(q != 0) return q;
      
      int[] aTB = a.getTiebreaks();
      int[] bTB = b.getTiebreaks();

      for(int i = 0; i < aTB.length; i++){
        q = aTB[i] - bTB[i];
        if(q != 0) return q;
      }
      return 0;
    }

  public void addPlayer(Player p){
    players.add(p);
  }
  public void startNextRound(){
    //if(currentRound != 0)
      //saveTournament();  
    rounds[currentRound] = new Round();
    sortPlayers(0, players.size() - 1);
    rounds[currentRound].start(players);
  }
  public void showResults(){
    if(isCancelPressed)
      return;

      //DISPLAY
  }
  public void run(){
    for(currentRound = 0; currentRound < numberOfRounds; currentRound++){
      if(isCancelPressed)
        break;
      startNextRound();
      showResults();
    }
  }
   /**
    * @return the name
    */
   public String getName() {
     return name;
   }
   public void configure(){
     
   }

   public void getPlayerList(){
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      JLabel label = new JLabel("<html>Enter the players to add in the text field below.<br>" + "Enter the team name in brackets (), followed by each players name on a separate line.<br>" + "Do not skip lines</html>");
      panel.add(label);
      JTextArea textArea = new JTextArea(20, 0);
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setAlignmentX(0);
      panel.add(scrollPane);
    
      int input = JOptionPane.showOptionDialog(null, panel, name + " - Enter Players", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);

      String[] lines = textArea.getText().split();
    }
}