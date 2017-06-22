package es.ua.dlsi.im3.core.score;

import org.apache.commons.lang3.math.Fraction;

public class SimpleMeasureRest extends SimpleRest {
	public SimpleMeasureRest(Fraction measureDuration) {
		this(Figures.WHOLE, measureDuration);
	}
	/**
	 * 
	 * @param measureDuration
	 */
	public SimpleMeasureRest(Figures figure, Fraction measureDuration) {
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
}
