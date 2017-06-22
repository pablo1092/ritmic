package es.pablo.ritmic.actividades;

import java.util.ArrayList;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.played.Meter;
import es.ua.dlsi.im3.core.played.PlayedNote;
import es.ua.dlsi.im3.core.played.PlayedSong;
import es.ua.dlsi.im3.core.played.SongTrack;
import es.ua.dlsi.im3.core.played.Tempo;

/**
 * TODO Tresillos, puntillos en lugar de ligadas
 * @author drizo
 *
 */
public class CodificadorTaps {
	private static final int DEFAULT_MIDI = 60;
	private PlayedSong playedSong;
	
	/**
	 * Uses as default meter 4/4 and quantization figure 16th
	 * @param tempo
	 * @param timeSequence
	 * @throws IM2Exception
	 */
	public CodificadorTaps(int resolucion, int tempo, String timeMillisecondsSequence) throws IM3Exception {
		this(resolucion, new Meter(4,4), tempo, timeMillisecondsSequence);
	}
	/**
	 * 
	 * @param meter Default meter used
	 * @param tempo e.g. t=120
	 * @param timeMillisecondsSequence Separada por espacios: p.ej. 0 1000 2000 2500
	 * @throws IM2Exception
	 */
	public CodificadorTaps(int resolucion, Meter meter, int tempoValue, String timeMillisecondsSequence) throws IM3Exception {
		String [] stimes = timeMillisecondsSequence.split(" ");
		Tempo tempo = new Tempo(tempoValue); 
		playedSong = new PlayedSong();
		ArrayList<Long> times = new ArrayList<Long>(); 
		for (String stime : stimes) {
			try {
				System.out.println(stime);
				long time = Long.parseLong(stime);
				long ticks = Math.max(0, tempo.millisecondsToTicksJustTempo(resolucion, time)-200); //TODO QUITAR RETRASO HAMMER
				//long ticks = Math.max(0, tempo.millisecondsToTicksJustTempo(resolucion, time)); 
				times.add(ticks);
			} catch (Throwable t) {
				throw new IM3Exception("Cannot parse long value representing time: '" + stime + "'");
			}
		}
		
		playedSong = new PlayedSong();
		playedSong.addMeter(0, meter);
		SongTrack track = playedSong.addTrack();
		for (int i=0; i<times.size(); i++) {
			long dur;
			if (i == times.size()-1) {
				dur = resolucion; // le añadimos una negra
			} else {
				dur = times.get(i+1) - times.get(i);
			}
			PlayedNote note = new PlayedNote(DEFAULT_MIDI, dur);
			track.addNote(times.get(i), note);
		}
	}

	public PlayedSong getPlayedSong() {
		return playedSong;
	}
	
	
}
