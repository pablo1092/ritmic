package es.pablo.ritmic.actividades;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.score.NoMeterException;
import es.ua.dlsi.im3.io.FileType;
import es.ua.dlsi.im3.io.ImportException;

public class CorreccionActivdadLecturaTest {
	
	File fichero = TestFileUtils.getFile("/partituras/test1.xml");

  @Test
  public void corrigeTest() throws IM3Exception, ImportException, NoMeterException {

    CorreccionActivdadLectura cal = new CorreccionActivdadLectura(fichero, FileType.musicxml, 60, "0 1500 2000");
    Assert.assertEquals(cal.corrige(), 10.0);
    
  }
  
  @Test
  public void corrigePocaDesviacion() throws ImportException, IM3Exception, NoMeterException {
	  
	  CorreccionActivdadLectura cal = new CorreccionActivdadLectura(fichero, FileType.musicxml, 60, "0 1400 2100");
	  double correccion = cal.corrige();
	  Assert.assertTrue(correccion > 5 && correccion < 10); 
  }
  
  @Test
  public void corrigeMuchaDesviacion() throws ImportException, IM3Exception, NoMeterException {

	  CorreccionActivdadLectura cal = new CorreccionActivdadLectura(fichero, FileType.musicxml, 60, "0 300 4000");
	  double correccion = cal.corrige();
	  Assert.assertTrue(correccion < 5);
  }
}
