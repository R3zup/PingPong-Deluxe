/** @author     mike ganshorn
 * 
 *  @Version    2.4-beginner (2017-04-11)
 *  
 *  @changelog  2.4 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 *  
 *              2.3 Methode beruehrt(WECHSELBILD) hinzugefuegt
 *  
 *              2.2 Jump'n'Run-Physik hinzu gefuegt.
 *  
 *              2.1 keine Abhaengigkeit mehr zwischen den alpha-Formen
 *                  Der Mittelpunkt des Dreiecks ist hier der Mittelpunkt des umhuellenden Rechtecks !!!
 * 
 *              
*/

import ea.edu.DreieckE;
import ea.Raum;

/**
 * Diese Klasse stellt ein einfaches Dreieck dar.
 */
public class DREIECK 
        extends DreieckE 
{
    
    /**
     * Die Farbe dieses Dreiecks
     */
    private String farbe;
    
    /**
     * Gibt an, ob dieses Dreieck sichtbar ist.
     */
    private boolean sichtbar;
    
    /**
     * x-Koordinate des Eckpunkts A
     */
    private float A_x;
    
    /**
     * y-Koordinate des Eckpunkts A
     */
    private float A_y;
    
    /**
     * x-Koordinate des Eckpunkts B
     */
    private float B_x;
    
    /**
     * y-Koordinate des Eckpunkts B
     */
    private float B_y;
    
    /**
     * x-Koordinate des Eckpunkts C
     */
    private float C_x;
    
    /**
     * y-Koordinate des Eckpunkts C
     */
    private float C_y;
    
     /**
     * x-Koordinate des Mittelpunkts des umschliessenden Rechtecks
     */
    private float M_x;
    
    /**
     * y-Koordinate des Mittelpunkts des umschliessenden Rechtecks
     */
    private float M_y;
    
    
    /**
     * Konstruktor der Klasse <code>DREIECK</code>. Erstellt ein neues Standard-Dreieck.
     */
    public DREIECK() 
    {
        this( 80 , 190 , 150 , 70 , 220 , 190 );
    }
    
    
    /**
     * Konstruktor der Klasse <code>DREIECK</code>. Erstellt ein neues Dreieck mit gegebenen Eck-Koordinaten. 
     * Die Reihenfolge der Ecken ist egal. 
     *
     * @param   Ax  Die x-Koordinate der ersten Ecke
     * @param   Ay  Die y-Koordinate der ersten Ecke
     * @param   Bx  Die x-Koordinate der zweiten Ecke
     * @param   By  Die y-Koordinate der zeiten Ecke
     * @param   Cx  Die x-Koordinate der dritten Ecke
     * @param   Cy  Die y-Koordinate der dritten Ecke
     */
    public DREIECK( float Ax , float Ay , float Bx , float By , float Cx , float Cy ) 
    {
        this.A_x = Ax;
        this.A_y = Ay;
        this.B_x = Bx;
        this.B_y = By;
        this.C_x = Cx;
        this.C_y = 50;
        this.M_x = ( Math.min(Math.min(Ax,Bx),Cx) + Math.max(Math.max(Ax,Bx),Cx) ) / 2 ;
        this.M_y = ( Math.min(Math.min(Ay,By),Cy) + Math.max(Math.max(Ay,By),Cy) ) / 2 ;
        super.punkteSetzen( (int)Ax , (int)Ay , (int)Bx , (int)By , (int)Cx , (int)Cy );
        this.sichtbar = true;
        super.sichtbarSetzen( true);
        this.farbe = "Gruen";
        super.farbeSetzen( this.farbe );
    }
    
    
    /**
     * Setzt die Ecken dieses Dreiecks (A, B, C) neu.
     * 
     * @param   Ax  Die X-Koordinate des Punktes A
     * @param   Ay  Die Y-Koordinate des Punktes A
     * @param   Bx  Die X-Koordinate des Punktes B
     * @param   By  Die Y-Koordinate des Punktes B
     * @param   Cx  Die X-Koordinate des Punktes C
     * @param   Cy  Die Y-Koordinate des Punktes C
     */
    public void setzeEcken( float Ax , float Ay , float Bx , float By , float Cx , float Cy ) 
    {
        this.A_x = Ax;
        this.A_y = Ay;
        this.B_x = Bx;
        this.B_y = By;
        this.C_x = Cx;
        this.C_y = Cy;
        this.M_x = ( Math.min(Math.min(Ax,Bx),Cx) + Math.max(Math.max(Ax,Bx),Cx) ) / 2 ;
        this.M_y = ( Math.min(Math.min(Ay,By),Cy) + Math.max(Math.max(Ay,By),Cy) ) / 2 ;
        super.punkteSetzen( (int)Ax , (int)Ay , (int)Bx , (int)By , (int)Cx , (int)Cy );
    }
    
    
    /**
     * Setzt die Farbe dieses Dreiecks neu.
     * 
     * @param   farbeNeu    Diese Farbe erhaelt das Dreieck (z.B. "Rot")
     */
    public void setzeFarbe( String farbeNeu ) 
    {
        this.farbe = farbeNeu;
        super.farbeSetzen( farbe );
    }
    
    
    /**
     * Setzt den Mittelpunkt dieses Dreieck neu.<br />
     * <b>ACHTUNG!</b><br />
     * Dies ist <i>nicht</i> der geometrische Mittelpunkt. Denkt man sich ein Rechteck, 
     * das man "genau ueber das Dreieck" spannt, sodass es dieses gerade von allen Seiten umschliesst, 
     * so ist der Mittelpunkt <b>dieses Rechtecks</b> der, der hier neu gesetzt wird.
     * 
     * @param   x Die X-Koordinate des neuen Mittelpunktes
     * 
     * @param   y Die Y-Koordinate des neuen Mittelpunktes
     */
    public void setzeMittelpunkt( int x , int y ) 
    {
        int deltaX = (int)(x - this.M_x);
        int deltaY = (int)(y - this.M_y);
        this.A_x = this.A_x + deltaX;
        this.A_y = this.A_y + deltaY;
        this.B_x = this.B_x + deltaX;
        this.B_y = this.B_y + deltaY;
        this.C_x = this.C_x + deltaX;
        this.C_y = this.C_y + deltaY;
        this.M_x = x;
        this.M_y = y;
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * Setzt, ob dieses Dreieck sichtbar sein soll.
     * 
     * @param   sichtbarNeu Ist dieser Wert <code>true</code>, ist nach dem Aufruf dieser Methode 
     *          dieses Dreieck sichtbar. Ist dieser Wert <code>false</code>, so ist nach dem Aufruf 
     *          dieser Methode dieses Dreieck unsichtbar.
     */
    public void setzeSichtbar( boolean sichtbarNeu ) 
    {
        this.sichtbar = sichtbarNeu;
        super.sichtbarSetzen( sichtbarNeu );
    }
    
    
    /**
     * Verschiebt dieses Dreieck um eine Verschiebung - angegeben durch ein "Delta X" und "Delta Y".
     * 
     * @param   deltaX  Der X Anteil dieser Verschiebung. Positive Werte verschieben nach rechts, negative nach links.
     * 
     * @param   deltaY  Der Y Anteil dieser Verschiebung. Positive Werte verschieben nach unten, negative nach oben.
     */
    public void verschiebenUm( float deltaX , float deltaY ) 
    {
        this.A_x = this.A_x + deltaX;
        this.A_y = this.A_y + deltaY;
        this.B_x = this.B_x + deltaX;
        this.B_y = this.B_y + deltaY;
        this.C_x = this.C_x + deltaX;
        this.C_y = this.C_y + deltaY;
        this.M_x = this.M_x + deltaX;
        this.M_y = this.M_y + deltaY;
        super.bewegen( deltaX , deltaY );
    }
    
    
    /**
     * Testet, ob ein anderes Grafik-Objekt beruehrt wird.
     *
     * @param   r   Ein anderes BILD, RECHTECK, KREIS, DREIECK, ...
     * 
     * @return  true, wenn sich die beiden Objekte ueberschneiden
     */
    public boolean beruehrt( Raum r ) 
    {
        return super.schneidet( r );
    }
    
    
    /**
     * Methode beinhaltetPunkt
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * @param   y   x-Koordinate des Punkts (Pixel)
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt(int x, int y) 
    {
        return super.beinhaltet( new ea.Punkt(x,y) );
    }
    
    
    /**
     * Diese Methode gibt die x-Koordinate des Mittelpunkts dieses Dreiecks zurueck.
     * 
     * @return  Die aktuelle x-Koordinate des Mittelpunktes dieses Dreiecks
     */
    public int nenneMx()
    {
        return (int)( Math.round(this.M_x) );
    }
    
    
    /**
     * Diese Methode gibt die y-Koordinate des Mittelpunkts dieses Kreises zurueck.
     * 
     * @return  Die aktuelle y-Koordinate des Mittelpunktes dieses Kreises
     */
    public int nenneMy()
    {
        return (int)( Math.round(this.M_y) );
    }
    
    
    /**
     * Diese Methode gibt die Farbe dieses Dreiecks zurueck.
     * 
     * @return  Die aktuelle Farbe dieses Dreiecks
     */
    public String nenneFarbe()
    {
        return this.farbe;
    }
    
    
    /**
     * Diese Methode gibt die Sichtbarkeit dieses Dreiecks zurueck.
     * 
     * @return  Die aktuelle Sichtbarkeit dieses Dreiecks
     */
    public boolean nenneSichtbar()
    {
        return this.sichtbar;
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in x-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandX( Raum grafikObjekt )
    {
        return (int)( this.M_x - grafikObjekt.mittelPunkt().x() );
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Dreiecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in y-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Dreiecks vom anderen Grafik-Objekt in y-Richtung (>0, wenn dieses Dreieck unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY( Raum grafikObjekt )
    {
        return (int)( this.M_y - grafikObjekt.mittelPunkt().y() );
    }
    
    
    /**
     * liefert den Sinus des Drehwinkels der Grafik.
     *
     * @return  Sinus des aktuellen Drehwinkels
     */
    public float sin_Drehwinkel()
    {
        return (float)( Math.sin( this.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * liefert den Cosinus des Drehwinkels der Grafik
     *
     * @return  Cosinus des aktuellen Drehwinkels
     */
    public float cos_Drehwinkel()
    {
        return (float)( Math.cos( this.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Dreht die Grafik um einen Winkel
     *
     * @param   winkelAenderung     +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void drehenUm( float winkelAenderung )
    {
        this.drehenRelativ( -winkelAenderung );
    }
    
    
    /**
     * Setzt den Drehwinkel auf eine absoluten neuen Wert
     *
     * @param   neuerDrehwinkel     der neue Drehwinkel
     *                              +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void setzeDrehwinkel( float neuerDrehwinkel )
    {
        this.drehenAbsolut( -neuerDrehwinkel );
    }
    
    
    /**
     * Nennt den Winkel, um den die Grafik gedreht wurde
     *
     * @return      der Winkel, um den die Grafik gedreht wurde
     *              0: wenn nicht gedreht
     *              +: wenn mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *              -: wenn mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public float nenneWinkel()
    {
        return (float)( -this.gibDrehung() );
    }

    
}