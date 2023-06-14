public class Ball extends KREIS
{
    private float deltaX;
    private float deltaY;
    private int punkteLinks;
    private int punkteRechts;
    public Ball(int rNeu)
    {
       super(rNeu);
       deltaX = 3.0f;
       deltaY = 3.0f;
    }
    
}