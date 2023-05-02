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

    public PingPong()
    {
        this.ball = new Ball(30);
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
        
        tickerNeuStarten(20);
        setzeAllePunkteanzeigenSichtbar();
        this.tickerIntervall = 20;
    }

    public void punkten()
    {
        
        if(ball.getX() >= 780)
        {
            this.punkteLinks = this.punkteLinks +1;
            setzePunkteanzeigeLinks(this.punkteLinks);
            ball.setzeMittelpunkt(400, 300);
            if(this.tickerIntervall > 11)
            {
            this.tickerIntervall = this.tickerIntervall -1;
            tickerIntervallSetzen(this.tickerIntervall);
            this.geschwindigkeitsAnzeige = this.geschwindigkeitsAnzeige +1;
            geschwindigkeit.setzeInhalt("Geschwindigkeit: " + this.geschwindigkeitsAnzeige);
        }
        }
        
        if(ball.getX() <= 20)
        {
            this.punkteRechts = this.punkteRechts +1;
            setzePunkteanzeigeRechts(this.punkteRechts);
            ball.setzeMittelpunkt(400, 300);
            if(this.tickerIntervall > 11)
            {
            this.tickerIntervall = this.tickerIntervall -1;
            tickerIntervallSetzen(this.tickerIntervall);
            this.geschwindigkeitsAnzeige = this.geschwindigkeitsAnzeige +1;
            geschwindigkeit.setzeInhalt("Geschwindigkeit: " + this.geschwindigkeitsAnzeige);
        }
        }
    }
    
    @Override
    public void tick()
    {
       ball.bewegen();
       punkten();
    }
}