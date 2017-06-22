package es.pablo.ritmic.actividades;
import java.io.File;
import java.util.ArrayList;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.conversions.ScoreToPlayed;
import es.ua.dlsi.im3.core.played.PlayedNote;
import es.ua.dlsi.im3.core.played.PlayedSong;
import es.ua.dlsi.im3.core.score.NoMeterException;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.ScoreSong;
import es.ua.dlsi.im3.core.score.io.ScoreSongImporter;
import es.ua.dlsi.im3.io.FileType;
import es.ua.dlsi.im3.io.ImportException;

public class CorreccionActivdadLectura implements ICorreccionActividad {
	private ScoreSong correctSong;
	private PlayedSong studentPlayedSong;
	/**
	 * 
	 * @param musicXMLFile
	 * @param resultadoAlumno Sera una cadena de "taps". Formato: secuencia milisegundos separados por espacios
	 * 8 para corchea...
	 * @throws ImportException 
	 * @throws IM2Exception 
	 * @throws NoMeterException 
	 */
	public CorreccionActivdadLectura(File correctFile, FileType fileType, int defaultTempo, String resultadoAlumnoTapsMilisegundos) throws ImportException, IM3Exception, NoMeterException {
		correctSong = new ScoreSongImporter().importSong(NotationType.eModern, fileType, correctFile);
		int tempoValue = defaultTempo;
		CodificadorTaps codificadorTaps = new CodificadorTaps(1000, tempoValue, resultadoAlumnoTapsMilisegundos);
		studentPlayedSong = codificadorTaps.getPlayedSong();		
	}
	private ArrayList<Long> getOnsetTimes(ScoreSong song) throws IM3Exception {
		ScoreToPlayed stp = new ScoreToPlayed();
		PlayedSong playedCorrect = stp.createPlayedSongFromScore(1000, song); // resolucion 1000, mas facil para depurar que 960
		return getOnsetTimes(playedCorrect);
	}
	private ArrayList<Long> getOnsetTimes(PlayedSong played) throws IM3Exception {
		ArrayList<Long> result = new ArrayList<Long>();
		for (PlayedNote playedNote : played.getUniqueVoice().getPlayedNotes()) {
			result.add(playedNote.getTime());
		}
		return result;
	}
	
	/**
	 * Devuelve un valor entre 0 y 10. 10 es perfecto
	 */
	public double corrige() throws IM3Exception {
		ArrayList<Long> expectedOnsetTimes = getOnsetTimes(correctSong);
		System.out.println("Onsets esperados : " + expectedOnsetTimes);
		ArrayList<Long> studentOnsetTimes = getOnsetTimes(studentPlayedSong);
		System.out.println("Onsets del alumno: " + studentOnsetTimes);
		EditDistance ed = new EditDistance();
		return (1.0-ed.computeDistance(expectedOnsetTimes, studentOnsetTimes))*10;
	}
	
	

}
