package es.ua.dlsi.im3.core.score;

import es.ua.dlsi.im3.IM3Exception;

/**
 * The atom figure is the one this pitch is attached to, that in turn will belong to an Atom
 * @author drizo
 */
public class AtomPitch implements ITimedElementInStaff, Comparable<AtomPitch>, IUniqueIDObject {
	AtomFigure atomFigure;
	private ScientificPitch scientificPitch;
	private AtomPitch tiedFromPrevious;
	private AtomPitch tiedToNext;
	/**
	 * Force this accidental to appear
	 */
	private Accidentals writtenExplicitAccidental;
	/**
	 * For pitches that are not contained in the same staff as the atom they belong to
	 */
	private Staff staffChange;
	private String ID;
	
	public AtomPitch(AtomFigure atomFigure, ScientificPitch spitch) {
		this.atomFigure = atomFigure;
		this.scientificPitch = spitch;
		tiedFromPrevious = null;
		tiedToNext = null;
	}

	public ScientificPitch getScientificPitch() {
		return scientificPitch;
	}

	//TODO Test (de todos los compareTo, equals, hashCode) !!!! URGENT
	@Override
	public int compareTo(AtomPitch o) {
		return getScientificPitch().compareTo(o.scientificPitch);
	}

	public final AtomFigure getAtomFigure() {
		return atomFigure;
	}

	public boolean isTiedToNext() {
		return tiedToNext != null;
	}

	public final AtomPitch getTiedToNext() {
		return tiedToNext;
	}

	public final void setTiedToNext(AtomPitch tiedTo) throws IM3Exception {
		if (this.tiedToNext != null) {
			if (this.tiedToNext != tiedTo) {
				tiedTo.tiedFromPrevious = null;  
			} // else it is the same
		} else {
			if (tiedTo == null) {
				this.tiedToNext = null;
			} else {
				if (!scientificPitch.equals(tiedTo.getScientificPitch())) {
					throw new IM3Exception("Cannot tie different pitches: " + scientificPitch + " and " + tiedTo.getScientificPitch());
				}
				tiedTo.tiedFromPrevious = this;
				this.tiedToNext = tiedTo;
			}
		}
	}
	

	public boolean isTiedFromPrevious() {
		return tiedFromPrevious != null;
	}

	public final AtomPitch getTiedFromPrevious() {
		return tiedFromPrevious;
	}

	public final void setTiedFromPrevious(AtomPitch tiedFrom) throws IM3Exception {
		if (this.tiedFromPrevious != null) {
			if (this.tiedFromPrevious != tiedFrom) {
				tiedFrom.tiedToNext = null;  
			} // else it is the same
		} else {
			if (tiedFrom == null) {
				this.tiedFromPrevious = null;
			} else {
				if (!scientificPitch.equals(tiedFrom.getScientificPitch())) {
					throw new IM3Exception("Cannot tie different pitches: " + scientificPitch + " and " + tiedFrom.getScientificPitch());
				}
		
				tiedFrom.tiedToNext = this;
				this.tiedFromPrevious = tiedFrom;
			}
		}
	}
	
	public final Staff getStaffChange() {
		return staffChange;
	}

	public final void setStaffChange(Staff staff) {
		this.staffChange = staff;
	}

	public final Accidentals getWrittenExplicitAccidental() {
		return writtenExplicitAccidental;
	}

	public final void setWrittenExplicitAccidental(Accidentals writtenExplicitAccidental) throws IM3Exception {
		this.writtenExplicitAccidental = writtenExplicitAccidental;
		setAccidental(writtenExplicitAccidental);
	}

	public void setAccidental(Accidentals accidental) throws IM3Exception {
		if (this.scientificPitch == null) {
			throw new IM3Exception("No scientific pitch defined yet");
		}
		this.scientificPitch.getPitchClass().setAccidental(accidental);		
	}

	@Override
	public Staff getStaff() {
		if (staffChange != null) {
			return staffChange;
		} else {
			return atomFigure.getStaff();
		}
	}

	@Override
	public void setStaff(Staff staff) {
		this.setStaffChange(staff);		
	}

	@Override
	public String toString() {
		return "AtomPitch [scientificPitch=" + scientificPitch + ", writtenExplicitAccidental="
				+ writtenExplicitAccidental + ", onsetRelativeToFigure=" + ", tiedFromPrevious=" + (tiedFromPrevious != null) + ", tiedToNext=" + (tiedToNext != null)
				+ ", staffChange=" + staffChange + "]";
	}

	@Override
	public Time getTime() {
		return atomFigure.getTime();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scientificPitch == null) ? 0 : scientificPitch.hashCode());
		result = prime * result + ((staffChange == null) ? 0 : staffChange.hashCode());
		result = prime * result + ((tiedFromPrevious == null) ? 0 : tiedFromPrevious.hashCode());
		result = prime * result + ((tiedToNext == null) ? 0 : tiedToNext.hashCode());
		result = prime * result + ((writtenExplicitAccidental == null) ? 0 : writtenExplicitAccidental.hashCode());
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
		AtomPitch other = (AtomPitch) obj;
		if (scientificPitch == null) {
			if (other.scientificPitch != null)
				return false;
		} else if (!scientificPitch.equals(other.scientificPitch))
			return false;
		if (staffChange == null) {
			if (other.staffChange != null)
				return false;
		} else if (!staffChange.equals(other.staffChange))
			return false;
		if (tiedFromPrevious == null) {
			if (other.tiedFromPrevious != null)
				return false;
		} else if (!tiedFromPrevious.equals(other.tiedFromPrevious))
			return false;
		if (tiedToNext == null) {
			if (other.tiedToNext != null)
				return false;
		} else if (!tiedToNext.equals(other.tiedToNext))
			return false;
		if (writtenExplicitAccidental != other.writtenExplicitAccidental)
			return false;
		return true;
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
		return "P";
	}
}