package es.ua.dlsi.im3.core.score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang3.math.Fraction;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.IM3RuntimeException;

/**
 * This layer may contain atoms that belong to other staff
 * @author drizo
 */
public class ScoreLayer implements Comparable<ScoreLayer>, IUniqueIDObject {
	String ID;
	int number;
	/**
	 * It may be null
	 */
	ScorePart part;
	/**
	 * It may be null
	 */
	Staff staff;
	
	/**
	 * This is the main list of elements
	 */
	List<Atom> atoms;

	public ScoreLayer(Staff staff, ScorePart part, int number) {
		this.part = part;
		this.staff = staff;
		this.number = number; //TODO Comprobar que es un número único
		atoms = new ArrayList<>();
	}

	public ScoreLayer(ScorePart part, int number) {
		this.part = part;
		this.number = number; //TODO Comprobar que es un número único
		atoms = new ArrayList<>();
	}

	public ScoreLayer(int number) {
		this.number = number; //TODO Comprobar que es un número único
		atoms = new ArrayList<>();
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/**
	 * It updates the onsets from the atom fromAtom (not included) to the end of
	 * the list of atoms
	 * 
	 * @param fromAtom
	 * @throws IM3Exception
	 */
	private void updateOnsets(Atom fromAtom) throws IM3Exception {
		int index = atoms.indexOf(fromAtom);
		if (index < 0) {
			throw new IM3Exception("Cannot find referenced atom");
		}
		// correct onset times
		updateOnsets(index);
	}

	/**
	 * It updates the onsets from the atom fromAtom (not included) to the end of
	 * the list of atoms
	 * 
	 * @param fromAtom
	 * @throws IM3Exception
	 */
	private void updateOnsets(int fromAtomIndex) throws IM3Exception {
		// correct onset times
		Atom lastAtom = atoms.get(fromAtomIndex);
		for (int i = fromAtomIndex + 1; i < atoms.size(); i++) {
			atoms.get(i).setTime(lastAtom.getOffset());
		}
	}

	public void add(Atom atom) {
		try {
			atom.setTime(getDuration());
			atom.setLayer(this);
		} catch (IM3Exception e) {
			throw new IM3RuntimeException("The onset should have been set for all atoms in a voice");
		}
		atoms.add(atom);
	}
	
	//TODO añadir con huecos, he quitado el VoiceGap
	public void add(Time time, Atom atom) {
		atom.setTime(time);
		atoms.add(atom);
	}

	
	// TODO Test unitario
	public void addAfter(Atom referenceAtom, Atom newAtom) throws IM3Exception {
		int index = atoms.indexOf(referenceAtom);
		if (index < 0) {
			throw new IM3Exception("Cannot find referenced atom");
		}
		atoms.add(index + 1, newAtom);

		// correct onset times
		updateOnsets(index + 1);
	}

	// TODO Test unitario
	public void addBefore(Atom referenceAtom, Atom newAtom) throws IM3Exception {
		int index = atoms.indexOf(referenceAtom);
		if (index < 0) {
			throw new IM3Exception("Cannot find referenced atom");
		}
		atoms.add(index, newAtom);

		// correct onset times
		updateOnsets(index);
	}
	
	public void remove(Atom atom) throws IM3Exception {
		int index = atoms.indexOf(atom);
		if (index < 0) {
			throw new IM3Exception("Cannot find referenced atom");
		}
		atoms.remove(index);
		if (atoms.size() > index) { // if not last
			updateOnsets(index);	
		}
	}

	
	

	/**
	 * Sequence of ordered notes (first time, next pitch) that should be played
	 * @return
	 * @throws IM3Exception 
	 */
	public List<PlayedNote> getPlayedNotes() throws IM3Exception {
		ArrayList<PlayedNote> result = new ArrayList<>();
		
		for (Atom atom : atoms) {
			List<PlayedNote> pn = atom.computePlayedNotes();
			if (pn != null) {
				result.addAll(pn);
			}
		}
		Collections.sort(result);
		return result;
	}
	/**
	 * Sequence of (non necessarily ordered) onset and continuation pitches 
	 * @return
	 */
	public ArrayList<AtomPitch> getAtomPitches() {
		ArrayList<AtomPitch> result = new ArrayList<>();
		for (Atom atom : atoms) {
			List<AtomPitch> atomPitches = atom.getAtomPitches();
			if (atomPitches != null) {
				for (AtomPitch atomPitch: atomPitches) {
					if (atomPitch.getStaff() == staff) { // no staff change
						result.add(atomPitch);
					}
				}
			}
		}
		return result;
	}

	
	/**
	 * Sequence of figures with their absolute onset times
	 * 
	 * @return
	 */
	public List<AtomFigure> getAtomFigures() {
		ArrayList<AtomFigure> result = new ArrayList<>();
		for (Atom atom : atoms) {
			for (AtomFigure atomFigure: atom.getAtomFigures()) {
				if (atomFigure.getStaff() == staff) {
					result.add(atomFigure);
				}
			}
		}
		return result;
	}	

	/**
	 * 
	 * @return Num of atoms
	 */
	public int size() {
		return atoms.size();
	}

	public Atom getAtom(int index) {
		return atoms.get(index);
	}

	public Time getDuration() throws IM3Exception {
		/*
		 * Fraction duration = Fraction.ZERO; for (Atom atom: atoms) { duration
		 * = duration.add(atom.getExactDuration()); } return new Time(duration);
		 */
		if (atoms.isEmpty()) {
			return new Time(Fraction.ZERO);
		} else {
			return atoms.get(atoms.size() - 1).getOffset();
		}
	}

	public void onAtomDurationChanged(Atom atom) throws IM3Exception {
		updateOnsets(atom);

	}

	// ----------------------------------------------------------------------
	// ----------------------- General information
	// --------------------------------
	// ----------------------------------------------------------------------

	@Override
	public String toString() {
		return "ScoreLayer [number=" + number + "]";
	}

	public ScorePart getPart() {
		return part;
	}

	public void setPart(ScorePart part) {
		this.part = part;
	}

	/**
	 * package visibility for reordering in ScorePart
	 *
	 * @param i
	 */
	void setNumber(int i) {
		this.number = i;
	}

	public int getNumber() {
		return this.number;
	}

	/**
	 * It does not contain atoms (notes, chords...)
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return atoms.isEmpty();
	}

	@Override
	public int compareTo(ScoreLayer o) {
		if (this.getPart() != o.getPart()) {
			return this.getPart().getNumber() - o.getPart().getNumber();
		} else {
			return this.number - o.number;
		}
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + this.number;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ScoreLayer other = (ScoreLayer) obj;
		if (this.number != other.number) {
			return false;
		}
		return true;
	}

	public TreeSet<ScientificPitch> getScientificPitches() {
		TreeSet<ScientificPitch> result = new TreeSet<>();
		List<AtomPitch> pitchSeq = getAtomPitches();
		for (AtomPitch atomPitch : pitchSeq) {
			result.add(atomPitch.getScientificPitch());
		}
		return result;
	}

	//TODO Todos los métodos de bajo (within onset ...) son extremadamente ineficientes
	// Debemos usar los RangeTree .... del im2
	/*FRACCIONES public final List<AtomPitch> getAtomPitchesWithOnsetWithin(Measure bar) throws IM3Exception {
		return getAtomPitchesWithOnsetWithin(bar.getTime(), bar.getEndTime());
	}*/

	/*FRACCIONES public final List<AtomFigure> getAtomFiguresWithOnsetWithin(Measure bar) throws IM3Exception {
		return getAtomFiguresWithOnsetWithin(bar.getTime(), bar.getEndTime());
	}*/

	/**
	 * 
	 * @param fromTime Included
	 * @param toTime Not included
	 * @return
	 * @throws IM3Exception 
	 */
	public List<AtomFigure> getAtomFiguresWithOnsetWithin(Time fromTime, Time toTime)  {
		ArrayList<AtomFigure> result = new ArrayList<>();
		List<AtomFigure> figureSeq = getAtomFigures();
		for (AtomFigure atomFigure : figureSeq) {
			if (atomFigure.getTime().isContainedIn(fromTime, toTime)) {
				result.add(atomFigure);
			} 
		}
		return result;
	}
	
	public List<Atom> getAtomsWithOnsetWithin(Measure bar) throws IM3Exception {
		return getAtomsWithOnsetWithin(bar.getTime(), bar.getEndTime());
	}

	

	/**
	 * 
	 * @param fromTime Included
	 * @param toTime Not included
	 * @return
	 * @throws IM3Exception 
	 */	
	public List<Atom> getAtomsWithOnsetWithin(Time fromTime, Time toTime) {
		ArrayList<Atom> result = new ArrayList<>();
		for (Atom atom : atoms) {
			if (atom.getTime().isContainedIn(fromTime, toTime)) {
				result.add(atom);
			} 
		}
		return result;
	}

	public List<Atom> getAtoms() {
		return atoms;
	}

	public Atom getLastAtom() throws IM3Exception {
		if (atoms.isEmpty()) {
			throw new IM3Exception("There are no atoms");
		}
		return atoms.get(atoms.size()-1);
	}
	
	@Override
	public String __getID() {
		return ID;
	}

	@Override
	public void __setID(String id) {
		this.ID = id;
		
	}

	@Override
	public String __getIDPrefix() {
		return "V";
	}

	public Staff getStaff() {
		return staff;
	}

}
