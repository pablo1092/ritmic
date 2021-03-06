package es.ua.dlsi.im3.core.score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.score.scales.ScaleSelectorFactory;

/**
 * //TODO Jerarquí OO The name of a chord with root and type
 * 
 * @author drizo
 * @date 05/06/2011
 *
 */
public class Harmony implements ITimedElement, Comparable<Harmony>, IUniqueIDObject {
	ScoreSong song;

	private String ID;

	private Time time;

	PitchClass root;
	// ChordType chordType;
	//ChordType chordType = ChordType.MAJOR; // if not specified, it is major
	ChordType chordType;
	/**
	 * It represents the degree from the tonic (1=I, 2=II, ...) plus the
	 * possible null extension and any secondary chord (e.g. secondary dominant)
	 */
	HarmonyDegree degree;

	// The degrees in MusicXML are used for setting extensions of chords.
	// Accidentals degreeAlter;
	// String degreeType; // TODO Enum: add, alter, subtract
	String inversion;
	PitchClass bass;
	List<PitchClass> chordPitchClasses; // computed only when required

	/**
	 * An alternate option for this harmony (CM V/GM I) - in this case GM is the commonHarmony
	 */
	Harmony commonHarmony;

	TonalFunction tonalFunction;

	/**
	 * True if this is a previousKey change (valid for the next harmony after a
	 * subkey)
	 */
	Key keyChange;
	/**
	 *
	 */
	Key previousKey;

	// TODO Modelarlo de otra forma
	boolean subkeyStart = false;
	boolean subkeyEnd = false;

	//TODO No tiene sentido que desde aquí apuntemos a algo de score
	//FRACCIONES ScoreAnalysisHook analysisHook;

	/**
	 * @param previousKey
	 * @param keyChange
	 *            null if not a instrumentKey change
	 * @param root
	 * @param chordType
	 */
	public Harmony(Key previousKey, Key keyChange, PitchClass root, ChordType chordType) {
		this.time = new Time(); 
		this.root = root;
		this.previousKey = previousKey;
		this.keyChange = keyChange;
		this.setChordType(chordType);
	}

	public Harmony(Key previousKey, Key keyChange, PitchClass root, HarmonyDegree degree, ChordType chordType) {
		this.time = new Time();
		this.root = root;
		this.previousKey = previousKey;
		this.root = root;
		this.setChordType(chordType);
		this.degree = degree;
	}

	public Harmony(Key previousKey, Key keyChange, PitchClass root, Degree degree, ChordType chordType)
			throws IM3Exception {
		this.time = new Time();
		this.root = root;
		this.previousKey = previousKey;
		this.root = root;
		this.setChordType(chordType);
		this.degree = new HarmonyDegree(keyChange != null ? keyChange : previousKey, new ExtendedDegree(degree));
	}

	public Harmony(Key previousKey, Key keyChange, Degree degree, ChordType chordType) throws IM3Exception {
		this.time = new Time();
		this.previousKey = previousKey;
		this.keyChange = keyChange;
		this.setChordType(chordType);
		this.degree = new HarmonyDegree(keyChange != null ? keyChange : previousKey, new ExtendedDegree(degree));
	}

	/**
	 * @param degree
	 */
	public Harmony(Key previousKey, Key keyChange, int degree)
			throws IM3Exception {/*
									 * , Accidentals degreeAlter, String
									 * degreeType) {
									 */
		this.time = new Time();
		this.previousKey = previousKey;
		this.keyChange = keyChange;
		this.degree = new HarmonyDegree(keyChange != null ? keyChange : previousKey,
				new ExtendedDegree(Degree.values()[degree]));
		// this.degreeAlter = degreeAlter;
		// this.degreeType = degreeType;
	}

	public Harmony(Key previousKey, Key keyChange) {
		this.time = new Time();
		this.previousKey = previousKey;
		this.keyChange = keyChange;
	}

	/**
	 * @param time
	 * @param root
	 * @param chordType
	 * @param degree
	 */
	public Harmony(Key previousKey, Key keyChange, PitchClass root, ChordType chordType, int degree)
			throws IM3Exception {
		// Accidentals degreeAlter, String degreeType) {
		this.time = new Time();
		this.previousKey = previousKey;
		this.keyChange = keyChange;

		this.root = root;
		this.setChordType(chordType);

		this.degree = new HarmonyDegree(keyChange != null ? keyChange : previousKey,
				new ExtendedDegree(Degree.values()[degree]));
		/*
		 * this.degreeAlter = degreeAlter; this.degreeType = degreeType;
		 */
	}

	public Harmony() {
		this.time = new Time();
	}

	// TODO Key information - Mejor que no se use harmony sino LabelledChord o
	// algo así
	public Harmony(PitchClass root, ChordType type) {
		this.time = new Time();
		this.root = root;
		this.chordType = type;
	}

	// TODO Key information - Mejor que no se use harmony sino LabelledChord o
	// algo así
	public Harmony(PitchClass root, ChordType ctype, int degree) {
		this.time = new Time();
		throw new UnsupportedOperationException("Cannot build a harmony without instrumentKey information"); // To
																									// change
																									// body
																									// of
																									// generated
																									// methods,
																									// choose
																									// Tools
																									// |
																									// Templates.
	}

	public Harmony getCommonHarmony() {
		return commonHarmony;
	}

	public void setCommonHarmony(Harmony commonHarmony) {
		this.commonHarmony = commonHarmony;
	}

	/**
	 * @return the root
	 */
	public final PitchClass getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public final void setRoot(PitchClass root) {
		this.root = root;
		this.chordPitchClasses = null;
	}

	/**
	 * @return the chordType
	 */
	public final ChordType getChordType() {
		return chordType;
	}

	/**
	 * @param chordType
	 *            the chordType to set
	 */
	public final void setChordType(ChordType chordType) {
		if (chordType == null) {
			this.chordType = ChordType.MAJOR; // when not specified it is major
		} else {
			this.chordType = chordType;
		}
		this.chordPitchClasses = null;
	}

	/**
	 * @return the degree
	 */
	public final HarmonyDegree getDegree() {
		return degree;
	}

	/**
	 * @param degree
	 *            the degree to set I = 1
	 */
	public final void setDegree(int degree) throws IM3Exception {
		// this.degree = Degree.values()[degree - 1];
		this.degree = new HarmonyDegree(previousKey, new ExtendedDegree(Degree.values()[degree]));
		this.chordPitchClasses = null;
	}

	/**
	 * @param degree
	 *            the degree to set I = 1
	 */
	public final void setDegree(Degree d) throws IM3Exception {
		// this.degree = Degree.values()[degree - 1];
		this.degree = new HarmonyDegree(previousKey, new ExtendedDegree(d));
		this.chordPitchClasses = null;
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public final void setDegree(HarmonyDegree degree) {
		this.degree = degree;
		this.chordPitchClasses = null;
	}

	public void setInversion(String inversion_value) {
		this.inversion = inversion_value;
		this.chordPitchClasses = null;

	}

	public void setBass(PitchClass basspc) {
		this.bass = basspc;
		this.chordPitchClasses = null;

	}

	public String toLongString() {
		StringBuilder sb = new StringBuilder();

		if (keyChange != null) {
			sb.append(getKeyString()).append(' ');
		}

		if (degree != null) {
			sb.append(getDegreeString()).append(' ');
		}

		if (chordType != null) {
			sb.append(getChordTypeString()).append(' ');
		}

		if (this.tonalFunction != null) {
			sb.append(getTonalFunctionString()).append(' ');
		}

		return sb.toString();
	}

	// TODO Gramatica acordes
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.root == null) {
			sb.append("NoRoot");
		} else {
			sb.append(this.root.toString());
		}

		sb.append('_');

		if (this.chordType != null) {
			sb.append(this.chordType);
			sb.append('_');
		}
		if (this.degree != null) {
			sb.append(this.degree);
			// sb.append('_');
			// sb.append(this.degreeAlter==null?'
			// ':this.degreeAlter.toString());
			sb.append('_');
		}
		if (this.inversion != null) {
			sb.append(this.inversion);
			sb.append('_');
		}
		sb.append(this.bass == null ? '_' : this.bass.toString());

		return sb.toString();
	}

	public String getShortDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.root.toString());
		sb.append('_');
		sb.append(this.chordType);
		return sb.toString();
	}

	public String getDegreeString() {
		StringBuilder sb = new StringBuilder();
		if (degree != null) {
			sb.append(degree.toString());
		}
		if (this.commonHarmony != null) {
			sb.append('/');
			sb.append(this.commonHarmony.getDegreeString());
		}
		return sb.toString();
	}

	public String getKeyString() {
		StringBuilder sb = new StringBuilder();
		if (keyChange != null) {
			sb.append(keyChange.toString());
		}
		if (this.commonHarmony != null) {
			sb.append('/');
			sb.append(this.commonHarmony.getKeyString());
		}
		return sb.toString();
	}

	public String getChordTypeString() {
		StringBuilder sb = new StringBuilder();
		if (chordType != null) {
			sb.append(chordType.toString());
		}
		if (this.commonHarmony != null) {
			sb.append('/');
			sb.append(this.commonHarmony.getChordTypeString());
		}
		return sb.toString();
	}

	public String getTonalFunctionString() {
		StringBuilder sb = new StringBuilder();
		if (tonalFunction != null) {
			sb.append(tonalFunction.getAbbr());
		}
		if (this.commonHarmony != null) {
			sb.append('/');
			sb.append(this.commonHarmony.getTonalFunctionString());
		}
		return sb.toString();
	}

	public String getChordPitchClassesString() {
		if (chordPitchClasses == null) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for (PitchClass chordPitchClasse : chordPitchClasses) {
				if (sb.length() > 0) {
					sb.append(',');
				}
				sb.append(chordPitchClasse.toString());
			}
			return sb.toString();
		}
	}

	public void setDegreeString(String functionStr) throws IM3Exception {
		try {
			degree = HarmonyDegree.parseStringInKey(previousKey, functionStr);
		} catch (Throwable e) {
			throw new IM3Exception("Degree string not valid: " + functionStr);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bass == null) ? 0 : bass.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((inversion == null) ? 0 : inversion.hashCode());
		result = prime * result + ((chordType == null) ? 0 : chordType.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}

	/**
	 * It does not take into account the keyChange
	 *
	 * @param obj
	 * @return
	 */
	public boolean equalsChord(Object obj) {
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Harmony other = (Harmony) obj;
		if (bass == null) {
			if (other.bass != null) {
				return false;
			}
		} else if (!bass.equals(other.bass)) {
			return false;
		}
		if (!Objects.equals(this.degree, other.degree)) {
			return false;
		}
		if (inversion == null) {
			if (other.inversion != null) {
				return false;
			}
		} else if (!inversion.equals(other.inversion)) {
			return false;
		}
		if (chordType != other.chordType) {
			return false;
		}
		if (root == null) {
			if (other.root != null) {
				return false;
			}
		} else if (!root.equals(other.root)) {
			return false;
		}
		return true;
	}

	/**
	 * * It does not take into account the time
	 *
	 * @param mo
	 * @return
	 */
	@Override
	public int compareTo(Harmony mo) {
		if (degree == null && mo.degree == null) {
			return 0;
		} else if (degree == null) {
			return 1;
		} else if (mo.degree == null) {
			return -1;
		} else {
			return degree.compareTo(mo.degree);
		}
	}

	// TODO Ver esto
	public void setKind(HarmonyKind h) throws IM3Exception {
		this.chordType = ChordType.harmonyKind2ChordType(h);
		this.chordPitchClasses = null;
	}

	public boolean containsUsingRoot(PitchClass pitchClass) throws IM3Exception {
		return this.computeChordPitchClassesUsingRootAndChordType().contains(pitchClass);
	}

	/**
	 * @param instrumentKey
	 *            The current previousKey
	 * @param pitchClass
	 * @return
	 * @throws IM3Exception
	 */
	public boolean containsUsingKeyAndDegree(Key currentKey, PitchClass pitchClass, MotionDirection motionDirection, boolean isLastNote)
			throws IM3Exception {
		return this.computeChordPitchClassesUsingKeyAndDegree(currentKey, motionDirection, isLastNote).contains(pitchClass);
	}

	// TODO Test
	public List<PitchClass> computeChordPitchClassesUsingKeyAndDegree(Key currentKey, MotionDirection motionDirection, boolean isLastNote)
			throws IM3Exception {
		if (this.chordType == null) {
			throw new IM3Exception("Cannot compute the chord pitch classes without a chord type: " + this.toString());
		}
		if (currentKey == null) {
			throw new IM3Exception("Cannot compute the chord pitch classes without a current instrumentKey");
		}

		this.root = null;
		Scale scale = ScaleSelectorFactory.selectScale(currentKey.getMode(), motionDirection);
		HashMap<PitchClass, ScaleMembership> chordRoot = scale.computeDegree(currentKey.getPitchClass(),
				this.degree.getActualChord().getDegree().getDegree(), isLastNote);
		for (Map.Entry<PitchClass, ScaleMembership> sm : chordRoot.entrySet()) {
			if (sm.getValue().getDegree() == ScaleMembershipDegree.high) {
				this.root = sm.getKey();
				break;
			}
		}
		if (this.root == null) {
			throw new IM3Exception("Cannot find root pitch class for this harmony in instrumentKey " + currentKey);
		}

		return computeChordPitchClassesUsingRootAndChordType();
	}

	// TODO Inversiones
	/**
	 * Given the root and chord type, return the stack of pitch classes that the
	 * chord has.
	 *
	 * @return
	 * @throws IM3Exception
	 */
	public List<PitchClass> computeChordPitchClassesUsingRootAndChordType() throws IM3Exception {
		if (this.chordPitchClasses != null) {
			return this.chordPitchClasses;
		} else {
			if (this.root == null) {
				throw new IM3Exception("Cannot compute the chord pitch classes without a root: " + this.toString());
			}
			if (this.chordType == null) {
				throw new IM3Exception(
						"Cannot compute the chord pitch classes without a chord type: " + this.toString());
			}
			chordPitchClasses = new ArrayList<>();
			PitchClass lastPitchClass = this.root;
			chordPitchClasses.add(this.root);
			Interval[] intervals = this.chordType.getIntervals();
			for (Interval interval : intervals) {
				PitchClass next = interval.computePitchClassFrom(lastPitchClass);
				chordPitchClasses.add(next);
				lastPitchClass = next;
			}

			return chordPitchClasses;
		}
	}

	public void setChordPitchClasses(List<PitchClass> chordPitchClasses) {
		this.chordPitchClasses = chordPitchClasses;
	}

	// TODO Test unitario
	/**
	 *
	 * @param pitchClass
	 * @param motionDirection
	 *            From the previous note
	 * @param useChordType If true the chord type notes are taken into accound, if false the 1,3,5,7th are used
	 * @return null if it does not belongs by sure to the chord
	 * @throws IM3Exception
	 */
	public ScaleMembership belongsToChord(PitchClass pitchClass, MotionDirection motionDirection, boolean useChordType, boolean isLastNote) throws IM3Exception {
		if (song == null) {
			throw new IM3Exception("The harmony is not associated to any song");
		}
		Key k = song.getHarmonyKeyActiveAtTimeOrNull(this.getTime());
		if (k == null) {
			return null;
		} else {
			return belongsToChordInKey(k, pitchClass, motionDirection, useChordType, isLastNote);
		}
	}

	//TODO ¿Por qué hay que pasarla la instrumentKey?
	/**
	 *
	 * @param pitchClass
	 * @param motionDirection
	 *            From the previous note
	 * @param useChordType If true the chord type notes are taken into account, if false the 1,3,5,7th are used 
	 * @throws IM3Exception
	 */
	public ScaleMembership belongsToChordInKey(Key key, PitchClass pitchClass, MotionDirection motionDirection, boolean useChordType, boolean isLastMeasure)
			throws IM3Exception {
		if (this.chordPitchClasses != null) {
			if (this.chordPitchClasses.contains(pitchClass)) {
				return new ScaleMembership("In chord pitch classes", ScaleMembershipDegree.high);
			} else {
				return new ScaleMembership("Not belongs", ScaleMembershipDegree.notbelongs);
			}
		} else {
			if (this.degree == null) {
				throw new IM3Exception("Cannot compute the chord pitch classes without a degree: " + this.toString());
			}

			Degree [] d;
			if (useChordType && chordType != null) {
				d = chordType.getDegrees();
			} else {
				d = new Degree[]{Degree.I, Degree.III, Degree.V, Degree.VII}; // the chordType may not be specified
			}
						
			Degree harmonyDegreeIncludingSecondary;
			Key keyIncludingSecondary = key;
			
			if (this.commonHarmony != null && this.commonHarmony.getDegree() != null) {
				harmonyDegreeIncludingSecondary = this.commonHarmony.getDegree().getActualChord().getDegree().getDegree();
				keyIncludingSecondary = this.commonHarmony.getDegree().getActualChord().getNoModeKey();
				if (keyIncludingSecondary == null) {
					keyIncludingSecondary = this.commonHarmony.getActiveKey();
				}
			} else {
				harmonyDegreeIncludingSecondary = this.getDegree().getActualChord().getDegree().getDegree();
				keyIncludingSecondary = this.getDegree().getActualChord().getNoModeKey();
				if (keyIncludingSecondary == null) {
					keyIncludingSecondary = this.getActiveKey();
				}
			}
			
			if (keyIncludingSecondary == null) {
				keyIncludingSecondary = key;
			}
			Scale scale;
			//Scale scale = ScaleSelectorFactory.selectScale(keyIncludingSecondary.getMode(), motionDirection);
			if (keyIncludingSecondary.getMode() == Mode.MINOR) {
				scale = ScaleSelectorFactory.SCALE_MINOR;
			} else {
				scale = ScaleSelectorFactory.SCALE_MAJOR;
			}
			
			for (Degree degree1 : d) {
				HashMap<PitchClass, ScaleMembership> pcm = scale.computeDegree(keyIncludingSecondary.getPitchClass(), harmonyDegreeIncludingSecondary.add(degree1), isLastMeasure);
				ScaleMembership r = pcm.get(pitchClass);
				if (r != null) {
					return r;
				}
			}
			
			
			/*HashMap<PitchClass, ScaleMembership> chordRoot = scale.computeDegree(instrumentKey.getPitchClass(),
					this.degree.getActualChord().getDegree().getDegree());
			// just use high and medium membership
			for (Map.Entry<PitchClass, ScaleMembership> sm : chordRoot.entrySet()) {
				if (sm.getValue().getDegree() == ScaleMembershipDegree.high
						|| sm.getValue().getDegree() == ScaleMembershipDegree.medium) {
					for (Degree degree1 : d) {
						HashMap<PitchClass, ScaleMembership> pcm = scale.computeDegree(instrumentKey.getPitchClass(), sm.getKey().add(degree1));
						ScaleMembership r = pcm.get(pitchClass);
						if (r != null) {
							return r;
						}
					}
				}

			}*/
			return new ScaleMembership("Not belongs", ScaleMembershipDegree.notbelongs);
		}
	}

	/*
	 * @Override public void move(long offset) throws IM3Exception { if (time ==
	 * null) { throw new IM3Exception("The time has not been set yet"); }
	 * setTime(this.time.getTime() + offset); }
	 */
	public ScoreSong getSong() {
		return song;
	}

	public void setSong(ScoreSong song) {
		this.song = song;
	}

	public TonalFunction getTonalFunction() {
		return tonalFunction;
	}

	public TonalFunction getActiveTonalFunction() {
		if (this.getCommonHarmony() != null && this.getCommonHarmony().getTonalFunction() != null) {
			return this.getCommonHarmony().getTonalFunction();
		} else {
			return this.tonalFunction;
		}
	}
	
	public void setTonalFunction(TonalFunction tonalFunction) {
		this.tonalFunction = tonalFunction;
	}

	public Key getPreviousKey() {
		return previousKey;
	}

	/**
	 * Last instrumentKey found including the alternative
	 *
	 * @return
	 */
	public Key getActiveKey() {
		if (this.getCommonHarmony() != null && this.getCommonHarmony().getActiveKey() != null) {
			return this.getCommonHarmony().getActiveKey();
		} else if (this.keyChange != null) {
			return this.keyChange;
		} else {
			return this.previousKey;
		}
	}

	/**
	 *
	 * @return
	 */
	public Key getActiveKeyWithoutAlt() {
		if (this.keyChange != null) {
			return this.keyChange;
		} else {
			return this.previousKey;
		}
	}

	public boolean isEmpty() {
		return hasJustKeyInformation() && this.getActiveKey() == null
				&& (this.commonHarmony == null || this.commonHarmony.isEmpty());
	}

	public boolean hasJustKeyInformation() {
		return this.degree == null && this.root == null && this.getTonalFunction() == null
				&& (this.commonHarmony == null || this.commonHarmony.hasJustKeyInformation());

	}

	/**
	 * True if it is the same degree, tonal function, keyChange and the
	 * chordPitchClasses in this set are a subset of the ones in
	 *
	 * @param h
	 * @param get
	 * @return
	 */
	public boolean isSubsetOf(Harmony h) {
		if (previousKey != null && h.previousKey != null) {
			if (previousKey == null || h.previousKey == null) {
				return false;
			} else {
				if (!previousKey.equals(h.previousKey)) {
					return false;
				}
			}
		}
		if (degree != null && h.degree != null) {
			if (degree == null || h.degree == null) {
				return false;
			} else {
				if (!degree.equals(h.degree)) {
					return false;
				}
			}
		}
		if (tonalFunction != null && h.tonalFunction != null) {
			if (tonalFunction == null || h.tonalFunction == null) {
				return false;
			} else {
				if (!tonalFunction.equals(h.tonalFunction)) {
					return false;
				}
			}
		}

		return h.chordPitchClasses.containsAll(chordPitchClasses);
	}

	public List<PitchClass> getChordPitchClasses() {
		return chordPitchClasses;
	}

	@Override // TODO NO DEBEMOS COMPARAR chordPitchClasses que puede no estar
				// calculado
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Harmony other = (Harmony) obj;
		if (!Objects.equals(this.root, other.root)) {
			return false;
		}

		if (this.subkeyStart != other.subkeyStart) {
			return false;
		}

		if (this.subkeyEnd != other.subkeyEnd) {
			return false;
		}

		if (this.chordType != other.chordType) {
			return false;
		}
		if (!Objects.equals(this.degree, other.degree)) {
			return false;
		}
		if (!Objects.equals(this.inversion, other.inversion)) {
			return false;
		}
		if (!Objects.equals(this.bass, other.bass)) {
			return false;
		}
		if (!Objects.equals(this.chordPitchClasses, other.chordPitchClasses)) {
			return false;
		}
		if (this.tonalFunction != other.tonalFunction) {
			return false;
		}
		if (!Objects.equals(this.keyChange, other.keyChange)) {
			return false;
		}
		return true;
	}

	public boolean isSubkeyStart() {
		return subkeyStart;
	}

	public void setSubkeyStart(boolean subkeyStart) {
		this.subkeyStart = subkeyStart;
	}

	public boolean isSubkeyEnd() {
		return subkeyEnd;
	}

	public void setSubkeyEnd(boolean subkeyEnd) {
		this.subkeyEnd = subkeyEnd;
	}

	public void setKeyChange(Key kc) throws IM3Exception {
		this.keyChange = kc;
		if (this.degree != null) {
			degree.changeKey(getActiveKeyWithoutAlt());
		}
	}

	public boolean isKeyChange() {
		return keyChange != null;
	}

	public void setPreviousKey(Key f) {
		this.previousKey = f;
	}

	public Key getKeyChange() {
		return keyChange;
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
		return "H";
	}

	/*FRACCIONES public ScoreAnalysisHook getAnalysisHook() {
		return analysisHook;
	}

	public void setAnalysisHook(ScoreAnalysisHook analysisHook) {
		this.analysisHook = analysisHook;
	}*/

	/*FRACCIONES public static boolean readTonalFunction(Harmony harmony, String string) throws IM3Exception {
		String[] split = string.split("/");
		if (split.length >= 1) {
			TonalFunction f = TonalFunction.getTonalFunctionFromString(split[0]);
			if (f != null) {
				if (harmony.getTonalFunction() != null && harmony.getTonalFunction() != f) {
					throw new IM3Exception("Cannot change tonal function " + f.toString() + "(input string " + string + ") to the harmony " + harmony2String(harmony));
				}
				harmony.setTonalFunction(f);
			} else {
				return false;
			}

			if (split.length == 2) {
				TonalFunction altf = TonalFunction.getTonalFunctionFromString(split[1]);
				if (altf != null) {
					if (harmony.getCommonHarmony() == null) {
						harmony.setCommonHarmony(new Harmony());
					}
					harmony.getCommonHarmony().setTonalFunction(altf);
				} else {
					throw new IM3Exception("Cannot mix strings of different analysis type in " + string);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean readDegree(Harmony harmony, String string) throws IM3Exception {

		String[] split = string.split("/");
		if (split.length >= 1) {
			HarmonyDegree f = HarmonyDegree.parseStringInKey(harmony.getActiveKey(), split[0]);
			if (f != null) {
				if (harmony.getDegree() != null && !harmony.getDegree().equals(f)) {
					throw new IM3Exception("Cannot change degree " + f.toString() + "(input string " + string + ") to the harmony " + harmony2String(harmony));
				}
				
				harmony.setDegree(f);
			} else {
				return false;
			}

			if (split.length == 2) {
				Logger.getLogger(Harmony.class.getName()).log(Level.INFO, "Parsing compound: " + string);
				HarmonyDegree altf = HarmonyDegree.parseStringInKey(harmony.getActiveKey(), split[1]);
				if (altf != null) {
					if (harmony.getCommonHarmony() == null) {
						harmony.setCommonHarmony(new Harmony());
					}
					harmony.getCommonHarmony().setDegree(altf);
				} else {
					throw new IM3Exception("Cannot mix strings of different analysis type in " + string);
				}
				// String s = harmony.getDegreeString();
				// System.out.println(s);
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean readKey(Harmony harmony, String string) throws IM3Exception {
		String[] split = string.split("/");
		if (split.length >= 1) {
			Key f = Key.parseString(split[0]);
			if (f != null) {
				if (harmony.getKeyChange() != null && !harmony.getKeyChange().equals(f)) {
					throw new IM3Exception("Cannot change instrumentKey change " + f.toString() + "(input string " + string + ") to the harmony " + harmony2String(harmony));
				}
				
				harmony.setKeyChange(f);
			} else {
				return false;
			}

			if (split.length == 2) {
				Key altf = Key.parseString(split[1]);
				if (altf != null) {
					if (harmony.getCommonHarmony() == null) {
						harmony.setCommonHarmony(new Harmony());
					}
					harmony.getCommonHarmony().setKeyChange(altf);
					harmony.getCommonHarmony().setPreviousKey(f);
				} else {
					throw new IM3Exception("Cannot mix strings of different analysis type in " + string);
				}
			}
			return true;
		} else {
			return false;
		}
	}	

	public static String harmony2String(Harmony h) throws IM3Exception {
		float beat;
		beat = h.getSong().getActiveMeterAtTime(h.getTime()).getBeat(h.getTime());
		return h.toLongString() + " located at bar " + h.getSong().getBarActiveAtTime(h.getTime()) + ", beat " + beat;
	}*/

	@Override	
	public Time getTime()  {
		return this.time;
	}
	
	public void setTime(Time time) {
		this.time = time;
		
	}

	
}
