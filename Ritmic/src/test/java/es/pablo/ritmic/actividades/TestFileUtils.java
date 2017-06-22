package es.pablo.ritmic.actividades;

import java.io.File;
import java.net.URL;

/**
 * It reads files for test correctly in Maven
 * @author drizo
 */
public class TestFileUtils {
    public static File getFile(String filename) {
	TestFileUtils t = new TestFileUtils();
	return t.run(filename);
    }

    public static File getFile(String folder, String file) {
	TestFileUtils t = new TestFileUtils();
	return t.run(folder + "/" + file);
    }
    
    private File run(String filename) {
	URL url = getClass().getResource(filename);
	if (url == null) {
	    throw new RuntimeException("Cannot find the filename '" + filename + "'");
	}
	File f = new File(url.getFile());
	return f;
	
    }
}
