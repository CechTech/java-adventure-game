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
public class VecTest
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
    
    /**
     * Testuje veci a metody getNazev(), getPopis(), isPrenositelna()
     * a isPouzitelna()
     */
    @Test
    public void testVeci()
    {
        Vec mec = new Vec("mec","popis", true, true);        
        assertEquals("mec", mec.getNazev());
        assertEquals("popis", mec.getPopis());
        assertEquals(true, mec.isPrenositelna());
        assertEquals(true, mec.isPouzitelna());
        
        Vec strom = new Vec("strom","popis", false, false);        
        assertEquals(false, strom.isPrenositelna());
        assertEquals(false, strom.isPouzitelna());
    }
}