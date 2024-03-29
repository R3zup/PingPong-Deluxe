import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class HardcorePingPong extends SPIEL
{
    private Ball ball;
    private Schlaeger schlaeger1;
    private Schlaeger schlaeger2;
    private TEXT geschwindigkeit;
    private TEXT neustartTutorial;
    private int punkteLinks;
    private int punkteRechts;
    private int tickerIntervall;
    private int geschwindigkeitsAnzeige;
    private float deltaX;
    private float deltaY;
    private String spieler;
    private long startZeit;
    private long zeitVergangen;
    private long endZeit;
    private TEXT zeitAnzeige;
    private long startZeit2;
    private long zeitVergangen2;
    private long endZeit2;

    public HardcorePingPong(String spieler)
    {
        this.ball = new Ball(25);
        ball.setzeMittelpunkt(400, 300);

        this.spieler = spieler;

        this.geschwindigkeit = new TEXT(400, 50, "Geschwindigkeit: "+ 10);
        this.geschwindigkeitsAnzeige = 10;
        geschwindigkeit.setzeFarbe("pink");
        
        this.zeitAnzeige = new TEXT(400, 100, "Zeit: "+ zeitVergangen2 /1000000000 +"s" );
        zeitAnzeige.setzeFarbe("lila");

        this.neustartTutorial = new TEXT(150, 550, "drücke R für Neustart");
        neustartTutorial.setzeSichtbar(true);
        neustartTutorial.setzeFarbe("rot");

        this.schlaeger1 = new Schlaeger();
        schlaeger1.setzeGroesse(20, 100);
        schlaeger1.setzeMittelpunkt(790, 300);

        this.schlaeger2 = new Schlaeger();
        schlaeger2.setzeGroesse(20, 100);
        schlaeger2.setzeMittelpunkt(10, 300);
        schlaeger2.setzeFarbe("türkis");

        deltaX = 3.0f;
        deltaY = 3.0f;

        setzeHintergrundgrafik("Hintergrund.jpg");

        this.startZeit = System.nanoTime();
        this.startZeit2 = System.nanoTime();
        tickerNeuStarten(5);
        setzeAllePunkteanzeigenSichtbar();
        this.tickerIntervall = 5;
    }

    /**
     * Erhöht den Punktestand und setzt den Ball zurück.
     * Startet das Spiel neu, wenn der Computer 3 Punkte erzielt.
     * (Adrian,Maik)
     */
    public void punkten()
    {

        if(ball.getX() >= 755)
        {
            this.punkteLinks = this.punkteLinks +1;
            setzePunkteanzeigeLinks(this.punkteLinks);
            ball.setzeMittelpunkt(400, 300);
            neustartTutorial.setzeSichtbar(false);
        }

        if(ball.getX() <= -25)
        {
            this.punkteRechts = this.punkteRechts +1;
            setzePunkteanzeigeRechts(this.punkteRechts);
            ball.setzeMittelpunkt(400, 300);
            neustartTutorial.setzeSichtbar(false);
        }

        if(this.punkteLinks >= 3)
        {
            zeitmessungBeenden();
            highscoreSpeichern();
            System.exit(0);
        }
    }

    /**
     * Bewegt den rechten Schläger mit Pfeiltaste oben und unten.
     * Der Computer verfolgt den Ball abhängig davon, an welcher Position der Ball sich befindet.
     * (Maik,Adrian)
     */
    public void schlaegerBewegen()
    {
        schlaeger2.mittelpunktSetzen(10, ball.nenneMy());

        if(schlaeger1.getY() >0)
        {
            if(tasteGedrueckt(26) == true)
            {
                schlaeger1.verschiebenUm(0, -3);
            }
        }

        if(schlaeger1.getY() <500)
        {
            if(tasteGedrueckt(28) == true)
            {
                schlaeger1.verschiebenUm(0, 3);
            }
        }
    }

    /**
     * Der Ball bewegt sich um die gegeben Werte deltaX und deltaY.
     * Der Ball prallt ab wenn er den oberen und unteren Spielfeldrand berührt.
     * Der Ball prallt von den Schlägern ab.
     * (Adrian)
     */
    public void bewegen()
    {
        ball.verschiebenUm(deltaX,deltaY);     
        if ( ball.getY() > 550 )
        {

            this.deltaY = - deltaY;   

        }

        if ( ball.getY() < 0 )
        {

            this.deltaY =  - deltaY ;

        }

        if(schlaeger2.beruehrt(ball) == true)
        {
            this.deltaX = - deltaX;
        }

        if(schlaeger1.beruehrt(ball) == true)
        {
            this.deltaX = - deltaX;
        }

    }

    /**
     * Startet das gesamte Spiel neu.
     * (Adrian,Maik)
     */
    public void neustart()
    {
        if(tasteGedrueckt(17))
        {
            zeitmessungBeenden();
            highscoreSpeichern();
            this.startZeit = 0;
            this.zeitVergangen = 0;
            this.endZeit = 0;
            this.startZeit2 = 0;
            this.zeitVergangen2 = 0;
            this.endZeit2 = 0; 
            tickerNeuStarten(5);
            this.tickerIntervall = 5;
            setzePunkteanzeigeRechts(0);
            ball.setzeMittelpunkt(400, 300);
            setzePunkteanzeigeLinks(0);
            this.punkteRechts = 0;
            this.punkteLinks = 0;
            geschwindigkeit.setzeInhalt("Geschwindigkeit: " + 10);
            this.geschwindigkeitsAnzeige = 10;
            schlaeger1.setzeMittelpunkt(790, 300);
            schlaeger2.setzeMittelpunkt(10, 300);
            neustartTutorial.setzeSichtbar(true);
            zeitAnzeige.setzeInhalt("Zeit: "+ 0 +"s");
        }   
    }

    /**
     * Speichert die Punktzahl des jeweiligen Spielers.
     * (Adrian, Internetquelle: https://www.baeldung.com/java-write-to-file)
     */
    public void highscoreSpeichern() {
        Path p = Path.of("Highscore.txt");
        try {
            String x = Files.readString(p);
            Path filePath = Files.writeString(p, x + "\n" + this.spieler + ":" + zeitVergangen / 1000000000 + " Sekunden (Hardcore)");
            String s = Files.readString(filePath);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Beendet die Zeitmessung
     * (Adrian, Internetquelle: https://www.techiedelight.com/de/measure-elapsed-time-execution-time-java/#:~:text=nanoTime()%20Methode,laufenden%20JVM%20in%20Nanosekunden%20zurück.)
     */
    public void zeitmessungBeenden()
    {
        this.endZeit = System.nanoTime();
        this.zeitVergangen = endZeit - startZeit;
    }
    
    public void zeitmessung()
    {
        this.endZeit2 = System.nanoTime();
        this.zeitVergangen2 = endZeit2 - startZeit2;
        zeitAnzeige.setzeInhalt("Zeit: "+ zeitVergangen2 /1000000000 +"s");
    }

    /**
     * Ermöglicht die Synchronisation der Methoden.
     * (Adrian)
     */
    @Override
    public void tick()
    {
        bewegen();
        punkten();
        schlaegerBewegen();
        neustart();
        zeitmessung();
    }
}