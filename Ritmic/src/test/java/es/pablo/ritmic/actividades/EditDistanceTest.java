package es.pablo.ritmic.actividades;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import es.ua.dlsi.im3.IM3Exception;
import junit.framework.Assert;

public class EditDistanceTest {

  @Test
  public void distance1() throws IM3Exception {
	  
	  long array1[] = {0,1000,1500,2000,2500};
	  Long[] longObjects1 = ArrayUtils.toObject(array1);
	  List<Long> longList1 = java.util.Arrays.asList(longObjects1);
	  
	  long array2[] = {0,1000,1500,2000,2500};
	  Long[] longObjects2 = ArrayUtils.toObject(array2);
	  List<Long> longList2 = java.util.Arrays.asList(longObjects2);
	  
	  EditDistance ed = new EditDistance();
	  double distance = ed.computeDistance(longList1, longList2);
	  Assert.assertEquals(distance, 0.0);
  }
  
  @Test
  public void distance2() throws IM3Exception {
	  
	  long array1[] = {0,1000,2000,2500};
	  Long[] longObjects1 = ArrayUtils.toObject(array1);
	  List<Long> longList1 = java.util.Arrays.asList(longObjects1);
	  
	  long array2[] = {0,1000,1500,2000,2500};
	  Long[] longObjects2 = ArrayUtils.toObject(array2);
	  List<Long> longList2 = java.util.Arrays.asList(longObjects2);
	  
	  EditDistance ed = new EditDistance();
	  double distance = ed.computeDistance(longList1, longList2);
	  Assert.assertTrue(distance < 1);
	  
  }
  
  @Test
  public void distance3() throws IM3Exception {
	  
	  long array1[] = {0,2000,3000,3500,4500,5000,6000};
	  Long[] longObjects1 = ArrayUtils.toObject(array1);
	  List<Long> longList1 = java.util.Arrays.asList(longObjects1);
	  
	  long array2[] = {0,1000,1500,2000,2500};
	  Long[] longObjects2 = ArrayUtils.toObject(array2);
	  List<Long> longList2 = java.util.Arrays.asList(longObjects2);
	  
	  EditDistance ed = new EditDistance();
	  double distance = ed.computeDistance(longList1, longList2);
	  Assert.assertTrue(distance > 1);
	  
  }
}
