package es.ua.dlsi.im3.core.score;

import org.apache.commons.lang3.math.Fraction;

public class SimpleMultiMeasureRest extends SimpleRest {
	/**
	 * Number of measures
	 */
	int numMeasures;
	public SimpleMultiMeasureRest(Fraction measureDuration, int numMeasures) {
		this(Figures.WHOLE, measureDuration.multiplyBy(Fraction.getFraction(numMeasures, 1)));
		this.numMeasures = numMeasures;
	}
	/**
	 *
	 * @param measureDuration
	 */
	public SimpleMultiMeasureRest(Figures figure, Fraction measureDuration) {
		super(figure, 0, measureDuration);
	}

	@Override
	public String toString() {
		return super.toString() + ", measure rest";
	}

	/**
	 * Used by MusicXML importer
	 * @param duration
	 */
	public void setDuration(Time duration) {
		super.setDuration(duration.getExactTime());		
	}
	public void setFigure(Figures figure) {
		this.atomFigure.setFigure(figure);
	}

	public int getNumMeasures() {
		return numMeasures;
	}
}
