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
public class PostavaTest
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
     * Testuje postavy a metody getJmeno() a getRec()
     */
    @Test
    public void testPostavy()
    {
        Postava kapitanMorgan = new Postava("kapitanMorgan","rec");        
        assertEquals("rec", kapitanMorgan.getRec());
        assertEquals("kapitanMorgan", kapitanMorgan.getJmeno());
    }
    
}