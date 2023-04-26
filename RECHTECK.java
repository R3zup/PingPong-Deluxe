/** @author     mike ganshorn + michael andonie
 * 
 *  @Version    2.4-beginner (2017-04-11)
 *  
 *  @changelog  2.4 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 *  
 *              2.3 Methode beruehrt(WECHSELBILD) hinzugefuegt
 *  
 *              2.2 Jump'n'Run-Physik hinzu gefuegt
 *  
 *              2.1 Bei Aenderung der Breite/Hoehe bleibt der Mittelpunkt erhalten
 *                  Keine Abhaengigkeit mehr zwischen den alpha-Formen
 *              
*/

import ea.edu.RechteckE;
import ea.Raum;

/**
 * Diese Klasse stellt ein einfaches Rechteck dar.
 */
public class RECHTECK 
        extends RechteckE 
{
        
    /**
     * Die Farbe dieses Rechtecks
     */
    private String farbe;
    
    /**
     * Gibt an, ob dieses Rechteck sichtbar ist.
     */
    private boolean sichtbar;
    
    /**
     * Breite des Rechtecks
     */
    private int breite;
    
    /**
     * Hoehe des Rechtecks
     */
    private int hoehe;
    
    /**
     * x-Koordinate ds Mittelpunkts
     */
    private float M_x;
    
    /**
     * y-Koordinate des Mittelpunkts
     */
    private float M_y;
    
    
    /**
     * Konstruktor der Klasse <code>RECHTECK</code>. Erstellt ein neues Standard-Rechteck.
     */
    public RECHTECK() 
    {
        this( 200 , 130 );
    }
    
    
    /**
     * Konstruktor der Klasse <code>RECHTECK</code>. Erstellt ein neues Rechteck mit gegebenen Massen.
     *
     * @param   breite  Breite des Rechtecks
     * 
     * @param   hoehe   Hoehe des Rechtecks
     */
    public RECHTECK( int breite , int hoehe ) 
    {
        this.sichtbar = true;
        super.sichtbarSetzen( true );
        this.farbe = "Rot";
        super.farbeSetzen( this.farbe );
        this.breite = breite;
        this.hoehe = hoehe;
        super.masseSetzen( this.breite , this.hoehe );
        this.M_x = 250;
        this.M_y = 250;
        super.mittelpunktSetzen( (int)this.M_x , (int)this.M_y );
    }
    
    
    /**
     * Setzt die Hoehe und Breite dieses Rechtecks neu.
     * 
     * @param   breite  Die neue Breite dieses Rechtecks
     * 
     * @param   hoehe   Die neue Hoehe dieses Rechtecks
     */
    public void setzeGroesse( int breite , int hoehe ) 
    {
        int x = (int)(this.nenneMx());
        int y = (int)(this.nenneMy());
        this.breite = breite;
        this.hoehe = hoehe;
        super.masseSetzen( breite , hoehe );
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * Setzt die Farbe dieses Rechtecks neu.
     * 
     * @param   farbeNeu    Diese Farbe erhaelt das Rechteck (z.B. "Rot")
     */
    public void setzeFarbe( String farbeNeu ) 
    {
        this.farbe = farbeNeu;
        super.farbeSetzen( farbe );
    }
    
    
    /**
     * Setzt den Mittelpunkt dieses Rechtecks neu.
     * 
     * @param   m_x Die X-Koordinate des neuen Mittelpunktes
     * 
     * @param   m_y Die Y-Koordinate des neuen Mittelpunktes
     */
    public void setzeMittelpunkt( int x , int y ) 
    {
        this.M_x = x;
        this.M_y = y;
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * Setzt, ob dieses Rechteck sichtbar sein soll.
     * 
     * @param   sichtbarNeu Ist dieser Wert <code>true</code>, ist nach dem Aufruf dieser 
     *          Methode dieses Rechteck sichtbar. Ist dieser Wert <code>false</code>, so ist 
     *          nach dem Aufruf dieser Methode dieses Rechteck unsichtbar.
     */
    public void setzeSichtbar( boolean sichtbarNeu ) 
    {
        this.sichtbar = sichtbarNeu;
        super.sichtbarSetzen( sichtbarNeu );
    }
    
    
    /**
     * Verschiebt dieses Rechteck um eine Verschiebung - angegeben durch ein "Delta X" und "Delta Y".
     * 
     * @param   deltaX  Der X Anteil dieser Verschiebung. Positive Werte verschieben nach rechts, negative nach links.
     * 
     * @param   deltaY  Der Y Anteil dieser Verschiebung. Positive Werte verschieben nach unten, negative nach oben.
     */
    public void verschiebenUm( float deltaX , float deltaY ) 
    {
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
     * Testet, ob ein Punkt beruehrt wird.
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * 
     * @param   y   x-Koordinate des Punkts (Pixel)
     * 
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt( int x , int y ) 
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
     * Diese Methode gibt die Breite dieses Rechtecks zurueck.
     * 
     * @return  Die aktuelle Breite dieses Rechtecks
     */
    public int nenneBreite()
    {
        return this.breite;
    }
    
    
    /**
     * Diese Methode gibt die Hoehe dieses Rechtecks zurueck.
     * 
     * @return  Die aktuelle Hoehe dieses Rechtecks
     */
    public int nenneHoehe()
    {
        return this.hoehe;
    }
    
    
    /**
     * Diese Methode gibt die Farbe dieses Rechtecks zurueck.
     * 
     * @return  Die aktuelle Farbe dieses Rechtecks
     */
    public String nenneFarbe()
    {
        return this.farbe;
    }
    
    
    /**
     * Diese Methode gibt die Sichtbarkeit dieses Rechtecks zurueck.
     * 
     * @return  Die aktuelle Sichtbarkeit dieses Rechtecks
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
        return (int)(this.M_x - grafikObjekt.mittelPunkt().x());
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in y-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in y-Richtung (>0, wenn dieses Rechteck unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY( Raum grafikObjekt )
    {
        return (int)(this.M_y - grafikObjekt.mittelPunkt().y());
    }
    
    
    /**
     * liefert den Sinus des Drehwinkels der Grafik
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