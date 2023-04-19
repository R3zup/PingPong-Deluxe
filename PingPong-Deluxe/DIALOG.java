import ea.edu.FensterE;

/**
 * Klasse DIALOG der EDU-Variante der Engine Alpha. 
 * Vier Methoden realisieren Dialog-Fenster zur Kommunikation mit dem Spieler. 
 * Die Methoden setzen ein existierendes Spiele-Fenster voraus. Sollte dieses noch nicht 
 * instanziiert worden sein, so wird es beim Methoden-Aufruf erzeugt.
 * 
 * @author      mike ganshorn
 * 
 * @version     2.0 (2017-04-11)
 */
public class DIALOG
{

    /**
     * Konstruktor der Klasse DIALOG. 
     * Ein Dialog-Objekt kann diverse Dialog-Fenster erzeugen.
     */
    public DIALOG()
    {
        // nichts
    }
        

    /**
     * Zeigt ein Fenster mit einer Frage an, wodurch das Spiele-Fenster verdeckt wird. 
     * Erst wenn der Dialog mit JA oder NEIN besaetigt wurde, ist das Spiele-Fenster wieder frei. 
     * VORSICHT! Das Spiel sollte vorher angehalten werden, da es sonst verdeckt weiter laeuft.
     *
     * @param   frage   Die Frage, die an den Spieler gestellt werden soll.
     * 
     * @return  'true', wenn JA geklickt wurde, sonst 'false'
     */
    public boolean frage( String frage )
    {
        return FensterE.getFenster().frage( frage );
    }
    
    
    /**
     * Zeigt ein Fenster mit einer Nachricht an, wodurch das Spiele-Fenster verdeckt wird. 
     * Erst wenn der Dialog mit OK besaetigt wurde, ist das Spiele-Fenster wieder frei. 
     * VORSICHT! Das Spiel sollte vorher angehalten werden, da es sonst verdeckt weiter laeuft.
     *
     * @param   nachricht       Die Nachricht, die an den Spieler gestellt werden soll.
     * 
     */
    public void nachricht( String nachricht )
    {
        FensterE.getFenster().nachrichtSchicken( nachricht );
    }
    
    
    /**
     * Zeigt ein Fenster mit einer Frage an, wodurch das Spiele-Fenster verdeckt wird. 
     * Der Spieler kann etwas in eine Eingabe-Zeile schreiben. 
     * Erst wenn der Dialog mit OK besaetigt wurde, ist das Spiele-Fenster wieder frei. 
     * VORSICHT! Das Spiel sollte vorher angehalten werden, da es sonst verdeckt weiter laeuft.
     *
     * @param   frage   Die Frage, die an den Spieler gestellt werden soll
     * 
     * @return  Der Text, den der Spieler in die Eingabe-Zeile schreibt. ("" bei leerer Eingabe-Zeile)
     */
    public String eingabe( String frage )
    {
        return FensterE.getFenster().eingabeFordern( frage );
    }
    
    
    /**
     * Zeigt ein Fenster mit einer Highscore-Anzeige, wodurch das Spiele-Fenster verdeckt wird. 
     * Die Werte fuer die Highscores stammen aus uebergebenen Arrays, die vorher angelegt werden muessen. 
     * Erst wenn der Dialog mit JA oder NEIN besaetigt wurde, ist das Spiele-Fenster wieder frei. 
     * VORSICHT! Das Spiel sollte vorher angehalten werden, da es sonst verdeckt weiter laeuft.
     *
     * @param   namen           Das Array mit den Spieler-Namen fuer die Highscore-Anzeige
     * 
     * @param   punkte          Das Array mit den Punkte-Staenden fuer die Highscore-Anzeige
     * 
     * @param   fensterTitel    Der gewuenschte Text im Fenster-Kopf
     */
    public void highscoreAnzeige( String[] namen , int[] punkte , String fensterTitel )
    {
        FensterE.getFenster().highscoreAnzeigen( namen , punkte , fensterTitel );
    }
}
