

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LagerTest.
 *
 * @author  Pascal
 * @version 1
 */
public class LagerTest
{
    private Lager lager;
    private Lager lager1;
    private Lager lager2;
    private Artikel artikel;
    private Artikel artikel1;
    private Artikel artikel2;
    private Artikel artikel3;
    
    private final static String MSG_AUSGABE     =
    "Ausgabe ist nicht richtig verlaufen";
    private final static String MSG_BEZEICHNUNG =
    "Bezeichnung anderung ist nicht richtig verlaufen";
    private final static String MSG_EINNAHME    =
    "Einnahme ist nicht richtig verlaufen";
    /**
     * Default constructor for test class LagerTest
     */
    public LagerTest()
    {
    }

    /**
     * Neues lager erstellen, dass dann getestet wird
     */
    @Before
    public void setUp()
    {
        lager = new Lager("netto", 30);
        artikel = new Artikel(1234, "nutella", 2.50);
        artikel.zugang(500);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Testet was passiert wenn man 0 als maximalgroesse eingibt
     */
    @Test(expected = RuntimeException.class)
    public void testKonstructorIntNull(){
        Lager lager2;
        lager2 = new Lager("lol",0);
    }
    
    /**
     * Testet was passiert wenn man eine negative maximlagroesse eingibt
     */
    @Test(expected = RuntimeException.class)
    public void testKonstructorIntNegative(){
        Lager lager2;
        lager2 = new Lager("nico",-100);
    }
    
    @Test
    public void testArtikelAnlegen()
    {
        artikel = new Artikel(1234, "nutella", 2.50);
    }
    
    @Test(expected= AssertionError.class)
    public void testArtikelnr_Zu_Lang(){
        artikel2 = new Artikel(12345, "nutella", 2.50);
    }
    
    @Test(expected= AssertionError.class)
    public void testArtikelnr_Zu_Kurz(){
        artikel2 = new Artikel(123, "nutella", 2.50);
    }

    @Test(expected= RuntimeException.class)
    public void testBezeichnung_null(){
        artikel1.setArtikelbzg(null);
    }
    
    @Test(expected= RuntimeException.class)
    public void testBezeichnung_nix(){
        artikel1.setArtikelbzg("");
    }
    
    @Test(expected= RuntimeException.class)
    public void testBezeichnung_lehrzeichen(){
        artikel1.setArtikelbzg("     ");
    }
    
    @Test(expected= RuntimeException.class)
    public void testPreis_negative(){
        artikel1.setPreis(-10);
    }
    
    @Test(expected= RuntimeException.class)
    public void testPreis_gleich_0(){
        artikel1.setPreis(0);
    }
    
    @Test (expected = AssertionError.class)
    public void testZugang()
    {
        artikel.abgang(600);
    }
    
    //@Test
    //public void testPreis_gleich_55_cent(){
      //  artikel1.setPreis(.55);
    //}
    
    @Test
    public void testAusgabe(){
        artikel.abgang(200);
        assertEquals(MSG_AUSGABE, 
            300, artikel.getBestand());
        
        artikel.abgang(300);
        assertEquals(MSG_AUSGABE, 
            0, artikel.getBestand());
    }
    
    @Test
    public void testEinahme(){
        artikel.zugang(300);
        assertEquals(MSG_EINNAHME, 
            800, artikel.getBestand());
            
        artikel.zugang(500);
        assertEquals(MSG_EINNAHME, 
            1300, artikel.getBestand());
    }
    
    @Test(expected= RuntimeException.class)
    public void testMenge_negative(){
        artikel1.abgang(-200);
        artikel1.zugang(-200);
    }
    
    //@Test
    //public void testBezeichnung_andern(){
      //  artikel1.setArtikelbzg("bauer");
        //assertEquals(MSG_BEZEICHNUNG, 
          //    "bauer", artikel1.getArtikelbzg());
   // }
}
