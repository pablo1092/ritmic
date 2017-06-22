/*
 * Copyright (C) 2014 David Rizo Valero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ua.dlsi.im3;

import java.io.File;
import java.net.URL;

/**
 * It reads files for test correctly in Maven
 * 
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
