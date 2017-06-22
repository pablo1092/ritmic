package es.ua.dlsi.im3.core.score;

import es.ua.dlsi.im3.IM3Exception;

/**
@author drizo
@date 06/06/2011
 **/
public enum Mode {
	MAJOR ("M"),
	MINOR ("m"),
	UNKNOWN ("unknown"); // for cases in which the major has been chosen because it is unknown
	/**
	 * Most usual string translation
	 */
	String name;
	
	Mode(String n) {
		this.name = n;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @return the name
	 */
	public final char getNameChar() {
		return name.charAt(0);
	}
	
	public static Mode stringToMode(String s) throws IM3Exception {
		if (s.equalsIgnoreCase(MAJOR.name())) {
			return MAJOR;
		} else if (s.equalsIgnoreCase(MINOR.name())) {
			return MINOR;
		} else if (s.equalsIgnoreCase(UNKNOWN.name()))	{
		    return UNKNOWN;
		} else {
			throw new IM3Exception("Invalid mode: '" + s + "'");
		}
	}
	
	public static Mode[] validValues() {
		return new Mode[] {MAJOR, MINOR};
	}
	
	
}
