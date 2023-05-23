import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class PingPongCom extends SPIEL
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

    public PingPongCom(String spieler)
    {
        this.ball = new Ball(25);
        ball.setzeMittelpunkt(400, 300);

        this.spieler = spieler;

        this.geschwindigkeit = new TEXT(400, 50, "Geschwindigkeit: "+ 1);
        this.geschwindigkeitsAnzeige = 1;
        geschwindigkeit.setzeFarbe("pink");
        
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

        tickerNeuStarten(15);
        setzeAllePunkteanzeigenSichtbar();
        this.tickerIntervall = 15;
    }

    public void punkten()
    {

        if(ball.getX() >= 755)
        {
            this.punkteLinks = this.punkteLinks +1;
            setzePunkteanzeigeLinks(this.punkteLinks);
            ball.setzeMittelpunkt(400, 300);
            neustartTutorial.setzeSichtbar(false);
            if(this.tickerIntervall > 6)
            {
                this.tickerIntervall = this.tickerIntervall -1;
                tickerIntervallSetzen(this.tickerIntervall);
                this.geschwindigkeitsAnzeige = this.geschwindigkeitsAnzeige +1;
                geschwindigkeit.setzeInhalt("Geschwindigkeit: " + this.geschwindigkeitsAnzeige);
            }
        }

        if(ball.getX() <= -25)
        {
            this.punkteRechts = this.punkteRechts +1;
            setzePunkteanzeigeRechts(this.punkteRechts);
            ball.setzeMittelpunkt(400, 300);
            neustartTutorial.setzeSichtbar(false);
            if(this.tickerIntervall > 6)
            {
                this.tickerIntervall = this.tickerIntervall -1;
                tickerIntervallSetzen(this.tickerIntervall);
                this.geschwindigkeitsAnzeige = this.geschwindigkeitsAnzeige +1;
                geschwindigkeit.setzeInhalt("Geschwindigkeit: " + this.geschwindigkeitsAnzeige);
            }
        }

        if(this.punkteLinks >= 3)
        {
            highscoreSpeichern();
            tickerNeuStarten(15);
            this.tickerIntervall = 15;
            setzePunkteanzeigeRechts(0);
            ball.setzeMittelpunkt(400, 300);
            setzePunkteanzeigeLinks(0);
            this.punkteRechts = 0;
            this.punkteLinks = 0;
            geschwindigkeit.setzeInhalt("Geschwindigkeit: " + 1);
            this.geschwindigkeitsAnzeige = 1;
            schlaeger1.setzeMittelpunkt(790, 300);
            schlaeger2.setzeMittelpunkt(10, 300); 
        }
    }

    public void schlaegerBewegen()
    {

        if(schlaeger2.getY() <450)
        {

            if(ball.getY() >300)
            {
                schlaeger2.verschiebenUm(0,3);
            }
        }

        if(schlaeger2.getY() >50)
        {

            if(ball.getY() <300)
            {
                schlaeger2.verschiebenUm(0,-3);
            }
        }

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

    public void neustart()
    {
        if(tasteGedrueckt(17))
        {
            tickerNeuStarten(15);
            this.tickerIntervall = 15;
            setzePunkteanzeigeRechts(0);
            ball.setzeMittelpunkt(400, 300);
            setzePunkteanzeigeLinks(0);
            this.punkteRechts = 0;
            this.punkteLinks = 0;
            geschwindigkeit.setzeInhalt("Geschwindigkeit: " + 1);
            this.geschwindigkeitsAnzeige = 1;
            schlaeger1.setzeMittelpunkt(790, 300);
            schlaeger2.setzeMittelpunkt(10, 300);
            neustartTutorial.setzeSichtbar(true);
        }   
    }

    public void highscoreSpeichern() {
        Path p = Path.of("/Users/Guest/Downloads/PingPong-Deluxe-main/Highscore.txt");
        try {
            String x = Files.readString(p);
            Path filePath = Files.writeString(p, x + "\n" + this.spieler + ":" + punkteRechts);
            String s = Files.readString(filePath);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick()
    {
        bewegen();
        punkten();
        schlaegerBewegen();
        neustart();
    }
}