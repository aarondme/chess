import javax.swing.JOptionPane;

class ChessTournamentManager
{
  private static boolean isCancelPressed = false;
  public static void main ( String[] args )
  {
    Tournament tournament;
    tournament = createTournament();
    if(tournament != null)
      tournament.run();
  }

 
}