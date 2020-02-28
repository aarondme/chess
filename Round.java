import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.*;

class Round
{
  private Match[] matches;

  Round(){

  }
  public void start(ArrayList<Player> p){
    int[] r;
    
    determineMatches(p);
    r = getResults();
    setResults(r, p);
  }
  public void determineMatches(ArrayList<Player> p){

  }
  public void setResults(int[] s, ArrayList<Player> p){
    for(int i = 0; i < s.length; i++){
        matches[i].setResult(s[i]);
        matches[i].updatePlayerScores();
    }
    for(Player q : p){
        q.updateTiebreakScores();
    }
  }
  public int[] getResults(){
    JPanel bigPanel = new JPanel();
    bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));

    JPanel[] panels = new JPanel[matches.length + 1];
    panels[0] = new JPanel();
    panels[0].setLayout(new BoxLayout(panels[0], BoxLayout.X_AXIS));
    panels[0].add(new JLabel("Board #"));
    panels[0].add(new JLabel("White Player"));
    panels[0].add(new JLabel("              "));
    panels[0].add(new JLabel("Black Player"));
    bigPanel.add(panels[0]);
    for(int i = 1; i <= matches.length; i++){
      panels[i] = new JPanel();
      panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.X_AXIS));
      panels[i].add(new JLabel("" + i));
      panels[i].add(new JLabel(matches[i - 1].getPlayerWhite().getName()));

      String[] choices = {"   ", "White Win", "Draw", "Black Win"};
      //JComboBox options = new JComboBox(choices);
      //panels[i].add(options);

      panels[i].add(new JLabel(matches[i - 1].getPlayerBlack().getName()));
      bigPanel.add(panels[i]);
    }

      return null;
  }
  public void addMatch(Match s){

  }

}