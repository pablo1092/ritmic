package es.ua.dlsi.im3.core.score;


import java.util.ArrayList;

import org.apache.commons.lang3.math.Fraction;

import es.ua.dlsi.im3.IM3Exception;


/**
 * @author drizo
 *
 */
public class SimpleTuplet extends CompoundAtom {	
	private Fraction wholeDuration;
	private Figures eachFigure;
	/**
	 * E.g. 3 in a triplet
	 */
	private int numAtoms;
	/**
	 * E.g. 2 in triplet
	 */
	private int inSpaceOfAtoms;

	/**
	 * @param inSpaceOf
	 * @param inSpaceOfDots
	 * @param eachFigure
	 * @param pitches If a rest is required, use null in its position //TODO Probar esto
	 */
	public SimpleTuplet(int numAtoms, int inSpaceOfAtoms, Figures eachFigure, ScientificPitch ...pitches) {
		this.numAtoms = numAtoms;
		this.inSpaceOfAtoms = inSpaceOfAtoms;
		
		wholeDuration = eachFigure.getDuration().multiplyBy(Fraction.getFraction(inSpaceOfAtoms, 1)); 
		this.eachFigure = eachFigure;
		
		Fraction eachNoteDuration = wholeDuration.divideBy(Fraction.getFraction(numAtoms, 1));
		Fraction currentRelativeOnset = Fraction.ZERO;
		
		for (ScientificPitch scientificPitch : pitches) {
			SingleFigureAtom element;
			if (scientificPitch != null) {
				element = new SimpleNote(eachFigure, 0, eachNoteDuration, scientificPitch);
			} else {
				element = new SimpleRest(eachFigure, 0, eachNoteDuration);
			}
			element.setParentAtom(this);			
			element.setRelativeOnset(currentRelativeOnset);
			element.setDuration(eachNoteDuration);
			addSubatom(element);
			currentRelativeOnset = currentRelativeOnset.add(eachNoteDuration);			
		}

	}

	/**
	 * 
	 * @param inSpaceOf
	 * @param inSpaceOfDots
	 * @param eachFigure
	 * @param pitches pitches[i] represents a chord, pitches[i][j] is the j_th pitch in i_th
	 */
	public SimpleTuplet(int numAtoms, int inSpaceOfAtoms, Figures eachFigure, ScientificPitch [] ... chordPitches) {
		this.numAtoms = numAtoms;
		this.inSpaceOfAtoms = inSpaceOfAtoms;
		wholeDuration = eachFigure.getDuration().multiplyBy(Fraction.getFraction(inSpaceOfAtoms, 1)); 
		this.eachFigure = eachFigure;
		
		Fraction eachNoteDuration = wholeDuration.divideBy(Fraction.getFraction(numAtoms, 1));
		Fraction currentRelativeOnset = Fraction.ZERO;
		
		for (ScientificPitch [] scientificPitches : chordPitches) {
			SingleFigureAtom element;
			if (scientificPitches == null || scientificPitches.length == 0) {
				element = new SimpleRest(eachFigure, 0, eachNoteDuration);
			} else if (scientificPitches.length == 1) {
				element = new SimpleNote(eachFigure, 0, eachNoteDuration, scientificPitches[0]);
			} else {
				element = new SimpleChord(eachFigure, 0, eachNoteDuration, scientificPitches);
			}
			element.setParentAtom(this);
			element.setRelativeOnset(currentRelativeOnset);
			element.setDuration(eachNoteDuration);
			addSubatom(element);
			currentRelativeOnset = currentRelativeOnset.add(eachNoteDuration);			
		}		

	}
	
	/**
	 * 
	 * @param wholeTupletDuration
	 * @param tupletElements
	 * @param numAtoms
	 * @param inSpaceOfAtoms
	 * @throws IM3Exception
	 */
	public SimpleTuplet(int numAtoms, int inSpaceOfAtoms, Figures eachFigure, ArrayList<Atom> tupletElements) throws IM3Exception {
		this.numAtoms = numAtoms;
		this.inSpaceOfAtoms = inSpaceOfAtoms;
		wholeDuration = eachFigure.getDuration().multiplyBy(Fraction.getFraction(inSpaceOfAtoms, 1)); 
		this.eachFigure = eachFigure;
		
		Fraction eachNoteDuration = wholeDuration.divideBy(Fraction.getFraction(numAtoms, 1));
		Fraction currentRelativeOnset = Fraction.ZERO;
		for (Atom element : tupletElements) {
			element.setParentAtom(this);
			element.setTime(new Time(currentRelativeOnset));
			element.setDuration(eachNoteDuration);
			addSubatom(element);
			currentRelativeOnset = currentRelativeOnset.add(eachNoteDuration);			
		}

	}

	public final Fraction getWholeDuration() {
		return wholeDuration;
	}

	public final Figures getEachFigure() {
		return eachFigure;
	}

	/**
	 * In a triplet = 3
	 * @return
	 */
	public final int getNumAtoms() {
		return numAtoms;
	}
	/**
	 * In a triplet = 2
	 * @return
	 */
	public final int getInSpaceOfAtoms() {
		return inSpaceOfAtoms;
	}
	@Override
	public String toString() {
		return "tuplet " + numAtoms + "/" + inSpaceOfAtoms + ", " + super.toString();
	}

}
