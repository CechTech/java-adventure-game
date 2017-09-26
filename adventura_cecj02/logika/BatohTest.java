package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída {@code BatohTest} slouží ke komplexnímu otestování
 * třídy {@link BatohTest}.
 *
 * @author    Jiří Čech
 * @version   9.1.2017
 */
public class BatohTest
{

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }


    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testBatohu()
        {   
            Batoh batoh = new Batoh();
            Vec mapa = new Vec("mapa", "popis", true, false);
            Vec mec = new Vec("mec", "popis", true, true);
            Vec penize = new Vec("penize", "popis", true, false);            
            Vec kulomet = new Vec("kulomet", "popis", false, true);                   
            
            assertEquals(1, batoh.vlozVec(mapa));
            assertEquals(2, batoh.vlozVec(kulomet)); // Nepřenositelná věc
            assertEquals(1, batoh.vlozVec(mec));
            assertEquals(3, batoh.vlozVec(penize)); // Věc nad kapacitu
            
            assertEquals(true, batoh.obsahujeVecVBatohu("mapa"));
            assertEquals(false, batoh.obsahujeVecVBatohu("kulomet"));
            assertEquals(true, batoh.obsahujeVecVBatohu("mec"));
            assertEquals(false, batoh.obsahujeVecVBatohu("penize"));
            
            assertEquals(mec, batoh.vyhodZBatohu("mec")); // Odebraná věc
            assertEquals(false, batoh.obsahujeVecVBatohu("mec"));
        }        
}