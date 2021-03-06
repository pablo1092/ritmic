package es.ua.dlsi.im3.core.score;

import org.apache.commons.lang3.math.Fraction;
import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.IM3RuntimeException;

/**
 * @author drizo
 *
 */
public class AtomFigure implements ITimedElement, Comparable<AtomFigure> {
	private String ID;
	private Atom atom;
	private Time onsetRelativeToAtom;
	private Time duration;
	private int dots;
	private Figures figure;
	/**
	 * Used in mensural
	 */
	Boolean colored;
	/**
	 * Used for tuplets and proportions in mensural. In MEI = @num. In a triplet this value is 3
	 */
	Integer irregularGroupActualFigures;
	/**
	 * Used for tuplets and proportions in mensural. In MEI = @numbase. In a triplet this value is 2
	 */
	Integer irregularGroupInSpaceOfFigures;
	
	/**
	 * Package visibility, use  Atom.addFigure
	 * @param atom
	 * @param figure
	 * @param dots
	 */
	AtomFigure(Atom atom, Figures figure, int dots) {
		if (atom == null) {
			throw new IM3RuntimeException("Atom cannot be null");
		}
		this.atom = atom;
		this.figure = figure;
		this.dots = dots;
		duration = new Time(figure.getDurationWithDots(dots));
		onsetRelativeToAtom = new Time(Fraction.ZERO);
	}
	
	/**
	 * Package visibility, use  Atom.addFigure
	 * Used tipically by tuplets
	 * @param figure
	 * @param dots2
	 * @param alteredDuration
	 */
	AtomFigure(Atom atom, Figures figure, int dots, Fraction alteredDuration) {
		if (atom == null) {
			throw new IM3RuntimeException("Atom cannot be null");
		}
		
		this.atom = atom;
		this.figure = figure;
		this.dots = dots;
		this.duration = new Time(alteredDuration);
		onsetRelativeToAtom = new Time(Fraction.ZERO);
	}
	
	/**
	 * Different duration from that computed from the figures. Used for tuplets or imperfectio
	 * in mensural notation 
	 * @param duration
	 * @throws IM3Exception 
	 */
 	public void setSpecialDuration(Time duration) throws IM3Exception {
 		atom.onFigureDurationChanged(this.duration, duration);
 		this.duration = duration;
 	}
	
 	public void setIrregularGroup(int irregularGroupActualFigures, int irregularGroupInSpaceOfFigures) throws IM3Exception {
 		this.irregularGroupActualFigures = irregularGroupActualFigures;
 		this.irregularGroupInSpaceOfFigures = irregularGroupInSpaceOfFigures;
 		Fraction nd = duration.getExactTime().multiplyBy(Fraction.getFraction(irregularGroupInSpaceOfFigures, irregularGroupActualFigures));
 		setSpecialDuration(new Time(nd));
 	}
 	
	public final Integer getIrregularGroupActualFigures() {
		return irregularGroupActualFigures;
	}

	public final Integer getIrregularGroupInSpaceOfFigures() {
		return irregularGroupInSpaceOfFigures;
	}


	public Time getDuration() {
		return duration;
	}
	public double getComputedDuration() {
		return duration.getComputedTime();
	}
	
	public Fraction getExactDuration() {
		return duration.getExactTime();
	}

	public void setRelativeOnset(Fraction relativeOnset) {
		this.onsetRelativeToAtom = new Time(relativeOnset);		
	}
	
	//TODO Guardarla para que no haya que recalcularla siempre
	@Override
	/**
	 * It returns the absolute time
	 * @throws IM3Exception 
	 */
	public Time getTime()  {
		return atom.getTime().add(onsetRelativeToAtom);
	}
	
	public Time getRelativeOnset() {
		return this.onsetRelativeToAtom;
	}

	public final int getDots() {
		return dots;
	}

	public final Figures getFigure() {
		return figure;
	}

	@Override
	public int compareTo(AtomFigure o) {
		int diff;
		diff = getTime().compareTo(o.getTime());
		if (diff == 0) {
			diff = duration.compareTo(o.duration);
			if (diff == 0) {
				diff = atom.compareTo(o.atom);
			}
		}
		return diff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atom == null) ? 0 : atom.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((onsetRelativeToAtom == null) ? 0 : onsetRelativeToAtom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtomFigure other = (AtomFigure) obj;
		if (atom == null) {
			if (other.atom != null)
				return false;
		} else if (!atom.equals(other.atom))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (onsetRelativeToAtom == null) {
			if (other.onsetRelativeToAtom != null)
				return false;
		} else if (!onsetRelativeToAtom.equals(other.onsetRelativeToAtom))
			return false;
		return true;
	}

	public final Atom getAtom() {
		return atom;
	}

	public ScoreLayer getLayer() {
		return atom.getLayer();
	}

	public final boolean hasColoration() {
		return colored != null;
	}
	public final boolean isColored() {
		return colored != null && colored.booleanValue();
	}

	public final void setColored(boolean colored) {
		this.colored = colored;
	}

	@Override
	public String toString() {
		return "AtomFigure [figure="
				+ figure + ", dots=" + dots + ", duration=" + duration + ", onsetRelativeToAtom=" + onsetRelativeToAtom
				+ ", irregularGroupActualFigures=" + irregularGroupActualFigures + ", irregularGroupInSpaceOfFigures="
				+ irregularGroupInSpaceOfFigures + ", ID=" + ID + "]";
	}

	/**
	 * The figure of its atom
	 * @return
	 */
	public Staff getStaff() {
		return atom.getStaff();
	}

	/**
	 * Package visibility - used by mrests handling in MusicXML importer
	 */
	void setFigure(Figures figure) {
		this.figure = figure;
		
	}

	

}