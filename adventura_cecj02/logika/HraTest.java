package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra.
 *
 * @author   Jarmila Pavlíčková
 * @version  ZS 2016/2017
 */
public class HraTest {
    private Hra hra1;
    private Hra hra2;
    private Hra hra3;
    private Hra hra4;
    private Hra hra5;
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
        hra2 = new Hra();
        hra3 = new Hra();
        hra4 = new Hra();
        hra5 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        // Testuje průchod prostory, aktuální pozici a příkaz konec        
        assertEquals("hrad", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi kouzelnyLes");
        assertEquals(false, hra1.konecHry());
        assertEquals("kouzelnyLes", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi poustZapomneni");
        assertEquals(false, hra1.konecHry());
        assertEquals("poustZapomneni", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi kouzelnyLes");
        hra1.zpracujPrikaz("jdi hrad");
        hra1.zpracujPrikaz("jdi ovocneSady");
        assertEquals(false, hra1.konecHry());
        assertEquals("ovocneSady", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi hrad");
        hra1.zpracujPrikaz("jdi pristavPiratu");
        assertEquals(false, hra1.konecHry());
        assertEquals("pristavPiratu", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
        
        // Testuje průchod celou hrou a výhru
        assertEquals("hrad", hra2.getHerniPlan().getAktualniProstor().getNazev());
        hra2.zpracujPrikaz("jdi ovocneSady");
        hra2.zpracujPrikaz("volim A");
        assertEquals(false, hra2.konecHry());
        hra2.zpracujPrikaz("jdi hrad");
        hra2.zpracujPrikaz("jdi kouzelnyLes");
        hra2.zpracujPrikaz("jdi poustZapomneni");
        hra2.zpracujPrikaz("volim C");
        assertEquals(false, hra2.konecHry());
        hra2.zpracujPrikaz("vezmi piratskaMince");
        hra2.zpracujPrikaz("jdi kouzelnyLes");
        hra2.zpracujPrikaz("jdi hrad");
        hra2.zpracujPrikaz("jdi pristavPiratu");
        hra2.zpracujPrikaz("volim B");
        assertEquals(false, hra2.konecHry());
        hra2.zpracujPrikaz("pouzi piratskaMince");
        hra2.zpracujPrikaz("jdi ledoveOstrovy");
        hra2.zpracujPrikaz("volim C");
        assertEquals(false, hra2.konecHry());
        hra2.zpracujPrikaz("vezmi kouzelnyRoh");
        hra2.zpracujPrikaz("vezmi horolezeckeVybaveni");
        hra2.zpracujPrikaz("pouzi horolezeckeVybaveni");
        hra2.zpracujPrikaz("jdi pristavPiratu");
        hra2.zpracujPrikaz("jdi hrad");
        hra2.zpracujPrikaz("jdi kouzelnyLes");
        hra2.zpracujPrikaz("pouzi kouzelnyRoh");
        hra2.zpracujPrikaz("volim B");
        assertEquals(false, hra2.konecHry());
        hra2.zpracujPrikaz("jdi mlzneHory");
        hra2.zpracujPrikaz("volim A");
        assertEquals(true, hra2.konecHry());
        
        // Testuje uzamčené prostory a jejich odemčení
        assertEquals("hrad", hra3.getHerniPlan().getAktualniProstor().getNazev());
        hra3.zpracujPrikaz("jdi kouzelnyLes");
        hra3.zpracujPrikaz("jdi poustZapomneni");
        hra3.zpracujPrikaz("vezmi piratskaMince");
        hra3.zpracujPrikaz("jdi kouzelnyLes");
        hra3.zpracujPrikaz("jdi hrad");
        hra3.zpracujPrikaz("jdi pristavPiratu");
        hra3.zpracujPrikaz("jdi ledoveOstrovy");
        assertEquals("pristavPiratu", hra3.getHerniPlan().getAktualniProstor().getNazev());
        hra3.zpracujPrikaz("pouzi piratskaMince");
        hra3.zpracujPrikaz("jdi ledoveOstrovy");
        assertEquals("ledoveOstrovy", hra3.getHerniPlan().getAktualniProstor().getNazev());
        hra3.zpracujPrikaz("vezmi horolezeckeVybaveni");
        hra3.zpracujPrikaz("jdi pristavPiratu");
        hra3.zpracujPrikaz("jdi hrad");
        hra3.zpracujPrikaz("jdi kouzelnyLes");
        hra3.zpracujPrikaz("jdi mlzneHory");
        assertEquals("kouzelnyLes", hra3.getHerniPlan().getAktualniProstor().getNazev());
        hra3.zpracujPrikaz("pouzi horolezeckeVybaveni");
        hra3.zpracujPrikaz("jdi mlzneHory");
        assertEquals("mlzneHory", hra3.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra3.konecHry());
        
        // Testuje špatně zodpovězenou otázku
        assertEquals("hrad", hra4.getHerniPlan().getAktualniProstor().getNazev());
        hra4.zpracujPrikaz("jdi ovocneSady");
        hra4.zpracujPrikaz("volim B");
        assertEquals(true, hra4.konecHry());
        assertEquals("hrad", hra5.getHerniPlan().getAktualniProstor().getNazev());
        hra5.zpracujPrikaz("jdi pristavPiratu");
        hra5.zpracujPrikaz("volim A");
        assertEquals(true, hra5.konecHry());
    }
}
