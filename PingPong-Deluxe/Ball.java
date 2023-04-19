public class Ball extends KREIS
{
    private float deltaX;
    private float deltaY;
    public Ball(int rNeu)
    {
       super (rNeu);
       deltaX = 0.2f;
       deltaY = 0.2f;
    }
    
    public void bewegen()
    {
        super.verschiebenUm(deltaX,deltaY);     
        
    if ( super.nenneMy() > 9 )
    {
            
        this.deltaY = - deltaY;   
            
    }
        
        if ( super.nenneMy() < -9 )
    {
     
        this.deltaY =  -deltaY ;
        
    }
    
    if ( super.nenneMx() > 12.5 )
    {
        
        
        this.deltaX = -deltaX;
        
    }
    
    if ( super.nenneMx() < -12.5 )
    {
        
        
        this.deltaX = -deltaX;
        
    }
    }

}