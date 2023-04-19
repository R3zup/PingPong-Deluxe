public class Ball extends KREIS
{
    private float deltaX;
    private float deltaY;
    public Ball(int rNeu)
    {
       super(rNeu);
       deltaX = 3.0f;
       deltaY = 3.0f;
    }
    
    public void bewegen()
    {
        verschiebenUm(deltaX,deltaY);     
        if ( super.nenneMy() > 600 )
    {
            
        this.deltaY = - deltaY;   
            
    }
        
        if ( super.nenneMy() < -600 )
    {
     
        this.deltaY =  -deltaY ;
        
    }
    
    if ( super.nenneMx() > 800 )
    {
        
        
        this.deltaX = -deltaX;
        
    }
    
    if ( super.nenneMx() < -800 )
    {
        
        
        this.deltaX = -deltaX;
        
    }
    
    }

}