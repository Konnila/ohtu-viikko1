
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    Varasto varesto;
    Varasto negatiivinenVarasto;
    Varasto negatiivinenVarasto2;
    Varasto huono;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varesto = new Varasto(20,6);
        negatiivinenVarasto = new Varasto(-6);
        negatiivinenVarasto2 = new Varasto(-6, -2);
        huono = new Varasto(10, 20);
    }
    
    @Test
    public void varastostaOtetaanLiikaa() {
        varasto.otaVarastosta(6);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
        @Test
    public void varastoonLaitetaanNeg() {
        varasto.lisaaVarastoon(-7.0);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void otetaanNegatiivinenMaara() {
        assertEquals(0.0, varasto.otaVarastosta(-6), vertailuTarkkuus);
    }
    
    @Test
    public void oikeaToString() {
        
        String expected = "saldo = 0.0, viela tilaa 10.0";
        assertEquals(expected, varasto.toString());
    }
    
    @Test
    public void negatiivinenTilavuusLaittaaNollaksi() {
        assertEquals(0, negatiivinenVarasto.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLuoVarastonJollaOikeaSaldoJaTilavuus() {
        
        assertEquals(20, varesto.getTilavuus(), vertailuTarkkuus);
        assertEquals(6, varesto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoHuononVaraston() {
        assertEquals(0.0, negatiivinenVarasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0.0, negatiivinenVarasto2.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktorissaAlkuSaldoSuurempiKuTilavuus() {
        assertEquals(10.0, huono.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void mahtuuOikeaMaaraKunKonstruktorillaKaksiParam() {
        assertEquals(14, varesto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void VarastoonLiikaaTavaraa() {
        varasto.lisaaVarastoon(200);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
}