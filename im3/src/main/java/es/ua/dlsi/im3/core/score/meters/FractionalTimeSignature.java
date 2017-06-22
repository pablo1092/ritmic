package es.ua.dlsi.im3.core.score.meters;

import org.apache.commons.lang3.math.Fraction;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.score.ITimeSignatureWithDuration;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.Time;
import es.ua.dlsi.im3.core.score.TimeSignature;

/**
 * //TODO Add C and C/ TODO Hacer jerarquía de objetos, compuesto, simple,
 * etc... - orientación a objetos - compases de amalgama
 *
 * Modern (vs mensural) meter
 * @author drizo
 * @date 03/06/2011
 *
 */
public class FractionalTimeSignature extends TimeSignature implements Comparable<FractionalTimeSignature>, ITimeSignatureWithDuration {
	/**
	 * The lesser the tempo, the most stable or strong //TODO Generalizarlo -
	 * podemos usar los árboles métricos It is important that the order is held,
	 * but also the absolute numbers can be shared between meters //TODO
	 */
	static int[] NOTE_STABILITIES_4x4 = { 1, 9, 5, 13, 3, 11, 7, 15, 2, 10, 6, 14, 4, 12, 8, 16 };
	static int[] NOTE_STABILITIES_2x4 = { 1, 5, 3, 7, 2, 6, 4, 8 };
	static int[] NOTE_STABILITIES_3x4 = { 1, 7, 4, 10, 2, 8, 5, 11, 3, 9, 6, 12 };
	static int[] NOTE_STABILITIES_6x8 = { 1, 5, 9, 3, 7, 11, 2, 6, 10, 4, 8, 12 };
	static int[] NOTE_STABILITIES_9x8 = { 1, 7, 13, 4, 10, 16, 2, 8, 14, 5, 11, 17, 3, 9, 15, 6, 12, 18 };
	static int[] NOTE_STABILITIES_12x8 = { 1, 9, 17, 5, 13, 21, 3, 11, 19, 7, 15, 23, 2, 10, 18, 6, 14, 22, 4, 12, 20,
			8, 16, 24 };
	public static int MAX_INSTABILITY = 25;

	private static final String SLASH = "/";

	protected Fraction fraction;
	/**
	 * Cached
	 */
	private Time duration;

	/**
	 * The lesser the tempo, the most stable or strong //TODO Generalizarlo -
	 * podemos usar los �rboles m�tricos
	 */
	// protected int [] rhythmicStability;
	/**
	 * @param numerator
	 * @param denominator
	 */
	public FractionalTimeSignature(int numerator, int denominator) {
		super(NotationType.eModern);
		fraction = Fraction.getFraction(numerator, denominator);				
		duration = new Time(Fraction.getFraction(numerator, 1).multiplyBy(Fraction.getFraction(4, denominator)));
	}

	/**
	 * Compute the figureAndDots in ticks of a measure
	 *
	 * @return
	 */
	/*FRACCIONES public long getMeasureDurationAsTicks() {
		if (this.isCompound()) {
			float longBeat = (float) ScoreSong.DEFAULT_RESOLUTION / (getDenominator() / 4); // the
																								// resolution
																								// is
																								// always
																								// set
																								// (at
																								// least
																								// from
																								// Finale
																								// 2008)
																								// in
																								// terms
																								// of
																								// quarter,
																								// not
																								// in
																								// terms
																								// of
																								// beat
			return (int) (getNumerator() * longBeat);
		} else {
			float beatRelation = (float) getDenominator() / 4; // the resolution
																// is always set
																// (at least
																// from Finale
																// 2008) in
																// terms of
																// quarter, not
																// in terms of
																// beat
			float longBeat = (float) ScoreSong.DEFAULT_RESOLUTION / beatRelation;
			return (int) (getNumerator() * longBeat);
		}
	}*/

	/**
	 * getMeasureDuration / DEFAULT_DESOLUTION E.g. a 4/4 will return 4
	 * 
	 * @return
	 */
	/*FRACCIONES public double getMeasureDurationAsRatio() {
		return (double) getMeasureDurationAsTicks() / (double) ScoreSong.DEFAULT_RESOLUTION;
	}*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "[getNumerator()=" + getNumerator() + ", getDenominator()=" + getDenominator() + "]";
	}

	/**
	 * @return the getNumerator()
	 */
	public final int getNumerator() {
		return fraction.getNumerator();
	}

	/**
	 * @return the getDenominator()
	 */
	public final int getDenominator() {
		return fraction.getDenominator();
	}
	// TODO Javi Ver esto para compases compuestos
	// TODO Test unitario

	/**
	 * It returns the beat of an onset (e.g. 0,1,2,3 for 4/4 bars)
	 *
	 * @param resolution
	 * @param onset
	 * @return Integer tempo if it starts in a beat, float tempo with decimals
	 *         if the onset is located between two beats. It starts from 0
	 */
	/*FRACCIONES public int getIntegerBeat(long onset) throws IM3Exception {
		// return (int) Math.IEEEremainder(onset,
		// getMeasureDuration(resolution));
		// return (int) (onset % getMeasureDuration(resolution));
		return (int) getBeat(onset); // TODO Pruebas unitarias
	}*/

	/**
	 * It returns the beat of an onset
	 *
	 * @param resolution
	 * @param onset
	 * @return Integer tempo if it starts in a beat, float tempo with decimals
	 *         if the onset is located between two beats. It starts from 0
	 * @throws es.ua.dlsi.im3.IM3Exception
	 */
	/* FRACCIONES public float getBeat(long onset) throws IM3Exception {
		long offset = (onset - this.getTime()) % getMeasureDurationAsTicks();
		return ((float) offset / (float) ScoreSong.DEFAULT_RESOLUTION);
	}*/

	/*FRACCIONES public int stabilityRank(long onset) throws IM3Exception {

		float beat = getBeat(onset);
		return stabilityRank(beat);
	} */

	/**
	 * It returns true for the strong beats of the meter
	 *
	 * @param beat
	 * @return
	 * @throws IM3Exception
	 */
	public int stabilityRank(float beat) throws IM3Exception {
		int semi;
		float f = (float) (beat * 4.0); // *4 because we use 16ths
		if (Math.floor(f) != f) {
			return MAX_INSTABILITY; // When note does not onset just in a
									// sixteenth onset (e.g. it is the second
									// 32th of a 32ths group)
		} else {
			semi = (int) f;
		}

		//TODO Sacar esto de aquí - además, este switch es una barbaridad
		// URGENT - mejor que usar esto usar �rboles r�tmicos
		switch (getNumerator()) {
		case 4:
			return NOTE_STABILITIES_4x4[semi];
		case 3:
			return NOTE_STABILITIES_3x4[semi];
		case 2:
			return NOTE_STABILITIES_2x4[semi];
		case 12:
			return NOTE_STABILITIES_12x8[semi];
		case 9:
			return NOTE_STABILITIES_9x8[semi];
		case 6:
			return NOTE_STABILITIES_6x8[semi];

		default:
			throw new IM3Exception("The getNumerator() " + getNumerator() + " is not implemented yet");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getDenominator();
		result = prime * result + getNumerator();
		return result;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().isAssignableFrom(obj.getClass())) { // Important to
															// allow inheritance
			return false;
		}
		FractionalTimeSignature other = (FractionalTimeSignature) obj;
		if (getDenominator() != other.getDenominator()) {
			return false;
		}
		return getNumerator() == other.getNumerator();
	}

	/**
	 * It parses a string in the form NN/DD and creates a meter
	 *
	 * @param meterString
	 * @return
	 * @throws es.ua.dlsi.im3.IM3Exception
	 */
	public static FractionalTimeSignature parseTimeSignature(String meterString) throws IM3Exception {
		String[] tokens = meterString.split(SLASH);
		if (tokens.length != 2) {
			throw new IM3Exception("Invalid meter string: " + meterString + ", must have the form NN/DD");
		}
		try {
			int num = Integer.parseInt(tokens[0]);
			int den = Integer.parseInt(tokens[1]);
			FractionalTimeSignature meter = new FractionalTimeSignature(num, den);
			return meter;
		} catch (NumberFormatException e) {
			if (tokens.length != 2) {
				throw new IM3Exception("Invalid meter string: " + meterString + ", must have the form NN/DD");
			}
		}
		return null;
	}

	/**
	 * Returns true if the meter is compound (not simple)
	 *
	 * @return
	 */
	public boolean isCompound() { // TODO Javi Tests unitarios
		return (getDenominator() == 2 && getNumerator() == 6) || (getDenominator() > 2) && (getNumerator() % 3 == 0)
				&& (getDenominator() % 2 == 0) && (getNumerator() / 3 > 1);
	}

	@Override
	public FractionalTimeSignature clone() {
		return new FractionalTimeSignature(this.getNumerator(), this.getDenominator());
	}

	@Override
	public Time getMeasureDuration() {
		return duration;
	}

	public int compareTo(FractionalTimeSignature other) {
		return getNumerator() * getDenominator() - other.getNumerator() * other.getDenominator();
	}	
}
