import ea.edu.*;
import ea.*;

/**
 * Klasse FIGUR.
 *
 * @author      mike ganshorn
 * @version     1.3 (2017-04-11)
 * 
 * @changelog   1.3 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 * 
 *              1.2 Methode beruehrt(WECHSELBILD) hinzugefuegt
 * 
 *              1.1 Jump'n'Run-Physik hinzu gefuegt
 *              
 *
 */
public class FIGUR
        extends FigurE
{
    
    private int groessenFaktor;
    
    private boolean farbNegativ;


    /**
     * FIGUR Konstruktor
     *
     * @param   x           x-Koordinate des Mittelpunkts
     * 
     * @param   y           y-Koordinate des Mittelpunkts
     * 
     * @param   figurDatei  z.B. meineFigur.eaf
     */
    public FIGUR( int x , int y , String figurDatei )
    {
        super( figurDatei );
        super.mittelpunktSetzen( x , y );
        
        this.groessenFaktor = 1;
        this.farbNegativ = false;
    }
    
    
    
    /**
     * Gibt den Index des aktuell sichtbaren Bilds zurueck. 
     *
     * @return  Index des aktuellen Bilds (beginnend mit 0)
     */
    public int nenneBildNummer()
    {
        return super.aktuellesBild();
    }
    
    
    /**
     * Macht ein bestimmtes Bild einer Figur sichtbar (und alle anderen Bilder unsichtbar)
     *
     * @param   index   Index des Bilds (beginnend mit 0)
     */
    public void setzeBildNummer( int index )
    {
        super.animationsBildSetzen( index );
    }
    
    
    /**
     * Zeigt an, ob die Figur gerade animiert ist.
     *
     * @return  true, wenn animiert, sonst false
     */
    public boolean nenneAnimiert()
    {
        return super.animiert();
    }
    
    
    /**
     * Schaltet den Animations-Effekt einer Figur an / aus.
     *
     * @param   animiert    true schaltet die Animation an, false schaltet sie aus
     */
    public void setzeAnimiert( boolean animiert )
    {
        super.animiertSetzen( animiert );
    }
    
    
    /**
     * Gibt die Zeit in Milli-Sekunden (Tausendstel Sekunden) zurueck, 
     * die zwischen 2 aufeinander folgenden Bildern liegt.
     *
     * @return  Anzahl an Milli-Sekunden zwischen 2 aufeinander folgenden Bildern
     */
    public int nenneAnimationsIntervall()
    {
        return super.intervall();
    }
    
    
    /**
     * Setzt das Zeit-Intervall fuer die Animation. 
     *
     * @param   milli_sec   Anzahl an Milli-Sekunden (Tausendstel Sekunden) zwischen 2 aufeinander folgenden Bildern
     */
    public void setzeAnimationsIntervall( int milli_sec )
    {
        super.animationsGeschwindigkeitSetzen( milli_sec );
    }
    
    
    /**
     * Gibt den aktuellen Vergroesserungs-Faktor an.
     *
     * @return  Vergroesserung als ganze Zahl ( 1 = normal , 2 = doppelt so gross , ... )
     */
    public int nenneVergroesserung()
    {
        return this.groessenFaktor;
    }
    
    
    /**
     * Setzt den Vergroesserungs-Faktor. 
     *
     * @param   faktor  Vergroesserung als ganze Zahl ( 1 = normal , 2 = doppelt so gross , ... )
     */
    public void setzeVergroesserung( int faktor )
    {
        super.faktorSetzen( faktor );
        this.groessenFaktor = faktor;
    }
    
    
    /**
     * Damit kann man eine Figur verfaerben. 
     *
     * @param   rot     0-255 fuer roten Anteil
     * 
     * @param   gruen   0-255 fuer gruenen Anteil
     * 
     * @param   blau    0-255 fuer blauen Anteil
     */
    public void setzeFarbtransformation( int rot , int gruen , int blau )
    {
        super.farbenTransformieren( rot , gruen , blau );
    }
    
    
    /**
     * Damit kann man eine Verfaerbung wieder rueckgaengig machen. 
     *
     */
    public void setzeFarbtransformationZurueck()
    {
        super.zurueckFaerben();
    }
    
    
    /**
     * Gibt an, ob die Farben gerade invertiert sind. 
     *
     * @return  true, wenn die Farben gerade invertiert sind, sonst false
     */
    public boolean nenneFarbenInvertiert()
    {
        return this.farbNegativ;
    }
    
    
    /**
     * Zwischen original Bild und Farb-Negativ-Bild wechseln.
     *
     * @param   invertiert  true zeigt das Negativ, false zeigt das Original;
     */
    public void setzeFarbenInvertiert( boolean invertiert )
    {
        if ( this.farbNegativ  &&  !invertiert )
        {
            super.negativ();
        }
        else if ( !this.farbNegativ  &&  invertiert )
        {
            super.negativ();
        }
        this.farbNegativ = invertiert;
    }
    
    
    /**
     * Gibt an, ob die Figur gerade horizontal gespiegelt ist.
     *
     * @return  true, wenn gespiegelt ist, sonst false
     */
    public boolean nenneSpiegelX()
    {
        return super.xGespiegelt();
    }
    
    
    /**
     * Figur horizontal spiegeln.
     *
     * @param   spiegelX    true spiegelt die Figur, false spiegelt wieder zurueck
     */
    public void setzeSpielgelX( boolean spiegelX )
    {
        this.spiegelXSetzen( spiegelX );
    }
    
    
     /**
     * Gibt an, ob die Figur gerade vertikal gespiegelt ist.
     *
     * @return  true, wenn gespiegelt ist, sonst false
     */
    public boolean nenneSpiegelY()
    {
        return super.yGespiegelt();
    }
    
    
    /**
     * Figur vertikal spiegeln.
     *
     * @param   spiegelY    true spiegelt die Figur, false spiegelt wieder zurueck
     */
    public void setzeSpielgelY( boolean spiegelY )
    {
        this.spiegelYSetzen( spiegelY );
    }
    
    
    
    
    
    
    
    
    


    /**
     * Verschiebt das Objekt um die angegebenen Pixel. 
     *
     * @param   deltaX  Pixel in x-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     * 
     * @param   deltaY  Pixel in y-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     */
    public void verschiebenUm( float deltaX , float deltaY ) 
    {
        super.bewegen( deltaX , deltaY );
    }
    
    
    /**
     * Prueft, ob ein anderes Grafik-Objekt beruehrt wird. 
     *
     * @param   r   Ein anderes BILD, RECHTECK, KREIS, DREIECK, ...
     * @return  true, wenn sich die beiden Objekte ueberschneiden
     */
    public boolean beruehrt( Raum r ) 
    {
        return super.schneidet( r );
    }

    
    /**
     * Prueft, ob das Objekt einen bestimmten Punkt (in Pixel-Koordinaten) beinhaltet. 
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * 
     * @param   y   x-Koordinate des Punkts (Pixel)
     * 
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt( int x , int y ) 
    {
        return super.beinhaltet( new Punkt(x,y) );
    }
    
    
    /**
     * Setzt den Mittelpunkt des Objekts auf einen (in Pixel-Koordinaten) anzugebenden Punkt. 
     *
     * @param   x   x-Koordinate des Mittelpunkts (Pixel)
     * 
     * @param   y   y-Koordinate des Mittelpunkts (Pixel)
     */
    public void setzeMittelpunkt( int x , int y ) 
    {
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * Nennt die x-Koordinate (in Pixel) des Mittelpunkts dieses Objekts. 
     *
     * @return  x-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMx() 
    {
        return super.zentrum().x();
    }
    
    
    /**
     * Nennt die y-Koordinate (in Pixel) des Mittelpunkts dieses Objekts. 
     *
     * @return  y-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMy() 
    {
        return super.zentrum().y();
    }
    
    
    /**
     * Macht das Objekt sichtbar / unsichtbar. 
     *
     * @param   sichtbarNeu     true, wenn die Grafik sichtbar sein soll, sonst false
     */
    public void setzeSichtbar( boolean sichtbarNeu ) 
    {
        super.sichtbarSetzen( sichtbarNeu );
    }
    
    
    /**
     * Prueft, od dieses Objekt gerade sichtbar ist. 
     *
     * @return  true, wenn die Grafik gerade sichbar ist, sonst false
     */
    public boolean nenneSichtbar()
    {
        return super.sichtbar();
    }
    
    
    /**
     * Dreht die Grafik um den angegebenen Winkel. 
     *
     * @param   winkelAenderung     +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void drehenUm( float winkelAenderung )
    {
        this.drehenRelativ( -winkelAenderung );
    }
    
    
    /**
     * Setzt den Drehwinkel auf einen absoluten neuen Wert. 
     * Die Orientierung unmittelbar nach dem Erzeugen des Objekts entspricht Winkel 0.
     *
     * @param   neuerDrehwinkel     der neue Drehwinkel
     *                              +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void setzeDrehwinkel(float neuerDrehwinkel)
    {
        this.drehenAbsolut( -neuerDrehwinkel );
    }
    
    
    /**
     * Nennt den Winkel, um den die Grafik gegenueber ihrer Erzeugung gedreht wurde. 
     *
     * @return      der Winkel, um den die Grafik gedreht wurde
     *              0: wenn nicht gedreht
     *              +: wenn mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *              -: wenn mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public float nenneWinkel()
    {
        return (float)( -super.gibDrehung() );
    }
    
    
    /**
     * Liefert den Sinus des aktuellen Drehwinkels der Grafik. 
     *
     * @return  Sinus des aktuellen Drehwinkels
     */
    public float sin_Drehwinkel()
    {
        return (float)( Math.sin( super.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Liefert den Cosinus des aktuellen Drehwinkels der Grafik. 
     *
     * @return  Cosinus des aktuellen Drehwinkels
     */
    public float cos_Drehwinkel()
    {
        return (float)( Math.cos( this.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Objekts vom Mittelpunkt 
     * eines anderen Grafik-Objekts in x-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in x-Richtung 
     *          (>0, wenn dieses Rechteck rechts des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandX( Raum grafikObjekt )
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().x();
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Objekts vom Mittelpunkt 
     * eines anderen Grafik-Objekts in y-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Kreises vom anderen Grafik-Objekt in y-Richtung 
     *          (>0, wenn dieser Kreis unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY( Raum grafikObjekt )
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().y();
    }
    
    
}