package es.pablo.ritmic.vistas;

import org.apache.commons.lang3.StringEscapeUtils;

import es.ua.dlsi.im3.io.FileType;


public class VerovioMEI {
	
	private String musicXMLContent;
	
	/**
	 * Cargar partitura a partir de un string
	 */
	public VerovioMEI(FileType fileType, String content) throws Exception {
		if (fileType != FileType.musicxml) {
			throw new Exception("Non supported type: " + fileType);
		}
		this.musicXMLContent = content;
	}	

	public String getMusicXMLContent() {
		return musicXMLContent;
	}
	
	public String getEscapedMusicXMLContent() {
		return StringEscapeUtils.escapeEcmaScript(musicXMLContent);
	}
	
}
