import java.io.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChessTournamentManager
{
  private static boolean isCancelPressed = false;
  public static void main ( String[] args ) throws IOException
  {
    Tournament tournament;
    tournament = createTournament();
    if(tournament != null)
      tournament.run();
  }

  private static Tournament createTournament() throws IOException{
    boolean isNewTournament = getIfNewTournament();
    Tournament t;

    if(isCancelPressed)
      return null;
    if(isNewTournament){
      t = newTournament();
      t.configure();
    }
    else
      t = resume();

    return t;
  }

  private static boolean getIfNewTournament(){
    String[] options = {"New Tournament", "Resume Tournament"};
    String prompt = "Choose whether to create a new tournament or to resume an existing tournament";
    String title = "Chess tournament Manager";
    int input;

    input = JOptionPane.showOptionDialog(null, prompt, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    if(input == -1){
      isCancelPressed = true;
      return false;
    }
      
    return (input == 0);
  }

  private static Tournament newTournament() throws IOException{
    JPanel panel = new JPanel();
    JTextField n = new JTextField();
    JTextField num = new JTextField();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel("Enter the tournament name"));
    panel.add(n);
    panel.add(new JLabel("Enter the number of Rounds"));
    panel.add(num);
    
    boolean isInputValid = true;
    do {
      if(isCancelPressed)
        return null;
      JOptionPane.showMessageDialog(null, panel, "New Tournament", JOptionPane.PLAIN_MESSAGE);

      isInputValid = (checkIfTournamentNameValid(n.getText()) && checkIfNumOfRoundsValid(num.getText()));
      
    } while (!isInputValid);
    
    Tournament t = new Tournament(n.getText(), Integer.parseInt(num.getText()));
    createFile(t);
    return t;
  }
 
  //NEED TO CHECK IF INPUT STRING CAN BE A FILE NAME
  private static boolean checkIfTournamentNameValid(String name){
    File x = new File(name);
    return !x.isFile();
  }
  /**
     * Checks if the number of rounds entered is valid 
     * @param in the input string
     * @return true if valid, false otherwise
     */
  private static boolean checkIfNumOfRoundsValid(String in){          
      try {
          int x = Integer.parseInt(in);        
            if(x <= 0)
              return false;
          return true;
      } catch (NumberFormatException e) {
          return false;
      }
  }

  private static void createFile(Tournament t) throws IOException{
    String name = t.getName();
    File x = new File(name);
    //x.createNewFile();
  }
  
  private static Tournament resume() throws IOException{
    //SEARCH FOR ALL TOURNAMENTS
    
    //String[] of all tournament names

    //if no tournaments found
    

    String in = (String) JOptionPane.showInputDialog(null, "Choose a tournament to start", "Resume Tournament", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    return null;
  }
}