public class PingPong extends SPIEL
{
    private Ball ball;
    private Schlaeger schlaeger1;
    private Schlaeger schlaeger2;
    
    public PingPong()
    {
        this.ball = new Ball(30);
        ball.setzeMittelpunkt(400, 300);
        
        tickerNeuStarten(100);
        
    }
    @Override
    public void tick()
    {
       ball.bewegen();
    }
}