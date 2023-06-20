public class PingPong extends SPIEL
{
    private Ball ball;
    private Schlaeger schlaeger1;
    private Schlaeger schlaeger2;
    private TEXT geschwindigkeit;
    private int punkteLinks;
    private int punkteRechts;
    private int tickerIntervall;
    private int geschwindigkeitsAnzeige;
    private float deltaX;
    private float deltaY;
    /**
     * (Adrian, Maik, Daniil)
     */
    public PingPong()
    {
        this.ball = new Ball(25);
        ball.setzeMittelpunkt(400, 300);

        this.geschwindigkeit = new TEXT(400, 50, "Geschwindigkeit: "+ 1);
        this.geschwindigkeitsAnzeige = 1;
        geschwindigkeit.setzeFarbe("pink");

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

    /**
     * Erhöht den Punktestand und setzt den Ball zurück, erhöht außerdem die Geschwindigkeit bei jedem Punkt.
     * Startet das Spiel neu, wenn ein Spieler dreißig Punkte erreicht.
     * (Adrian,Maik)
     */
    public void punkten()
    {

        if(ball.getX() >= 755)
        {
            this.punkteLinks = this.punkteLinks +1;
            setzePunkteanzeigeLinks(this.punkteLinks);
            ball.setzeMittelpunkt(400, 300);
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
            if(this.tickerIntervall > 6)
            {
                this.tickerIntervall = this.tickerIntervall -1;
                tickerIntervallSetzen(this.tickerIntervall);
                this.geschwindigkeitsAnzeige = this.geschwindigkeitsAnzeige +1;
                geschwindigkeit.setzeInhalt("Geschwindigkeit: " + this.geschwindigkeitsAnzeige);
            }
        }

        if(this.punkteRechts >= 30)
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
        }

        if(this.punkteLinks >= 30)
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
        }
    }

    /**
     * Bewegt den rechten Schläger mit Pfeiltaste oben und unten.
     * Bewegt den linken Schläger mit W und S.
     * (Adrian,Maik)
     */
    public void schlaegerBewegen()
    {
        if(schlaeger2.getY() >0)
        {
            if(tasteGedrueckt(22) == true)
            {
                schlaeger2.verschiebenUm(0, -3);
            } 
        }

        if(schlaeger2.getY() <500)
        {
            if(tasteGedrueckt(18) == true)
            {
                schlaeger2.verschiebenUm(0, 3);
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
    }
}