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
    
    public void bewegen()
    {
        verschiebenUm(deltaX,deltaY);     
        if ( super.nenneMy() > 580 )
    {
            
        this.deltaY = - deltaY;   
            
    }
        
        if ( super.nenneMy() < 20 )
    {
     
        this.deltaY =  -deltaY ;
        
    }
    
    
    
    }

}