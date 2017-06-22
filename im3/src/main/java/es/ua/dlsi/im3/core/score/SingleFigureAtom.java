package es.ua.dlsi.im3.core.score;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.Fraction;

public abstract class SingleFigureAtom extends Atom {
	AtomFigure atomFigure;
	
	public SingleFigureAtom(Figures figure, int dots) {
		atomFigure = new AtomFigure(this, figure, dots);
		addDuration(atomFigure.getDuration());
	}
	
	/**
	 * Package visibility, used by tuplets and mensural
	 * @param figure
	 * @param dots
	 */
	SingleFigureAtom(Figures figure, int dots, Fraction alteredDuration) {
		atomFigure = new AtomFigure(this, figure, dots, alteredDuration);
		addDuration(atomFigure.getDuration());
	}
	
	public void setRelativeToAtomOnset(Fraction currentRelativeOnset) {
		atomFigure.setRelativeOnset(currentRelativeOnset);
	}
	
	public final AtomFigure getAtomFigure() {
		return atomFigure;
	}
	
	@Override
	public List<AtomFigure> getAtomFigures() {
		return Arrays.asList(atomFigure);
	}
	@Override
	public List<Atom> getAtoms() {
		return Arrays.asList(this);
	}

	public void setRelativeOnset(Fraction relativeOnset) {
		this.atomFigure.setRelativeOnset(relativeOnset);
		
	}

	@Override
	public String toString() {
		return super.toString() + ", " + atomFigure;
	}

}
