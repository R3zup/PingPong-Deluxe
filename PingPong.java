public class PingPong extends SPIEL
{
    private Ball ball;
    private Schlaeger schlaeger1;
    private Schlaeger schlaeger2;
    private int punkteLinks;
    private int punkteRechts;
    private int tickerIntervall;

    public PingPong()
    {
        this.ball = new Ball(30);
        ball.setzeMittelpunkt(400, 300);
        
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
            this.tickerIntervall = this.tickerIntervall -1;
            tickerIntervallSetzen(this.tickerIntervall);
        }
        
        if(ball.getX() <= 20)
        {
            this.punkteRechts = this.punkteRechts +1;
            setzePunkteanzeigeRechts(this.punkteRechts);
            ball.setzeMittelpunkt(400, 300);
            this.tickerIntervall = this.tickerIntervall -1;
            tickerIntervallSetzen(this.tickerIntervall);
        }
    }
    
    @Override
    public void tick()
    {
       ball.bewegen();
       punkten();
    }
}