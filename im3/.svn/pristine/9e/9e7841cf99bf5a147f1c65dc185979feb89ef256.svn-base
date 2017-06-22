package es.ua.dlsi.im3.core.score.io.kern;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.IM3RuntimeException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.clefs.*;
import es.ua.dlsi.im3.core.score.io.IScoreSongImporter;
import es.ua.dlsi.im3.core.score.meters.FractionalTimeSignature;
import es.ua.dlsi.im3.core.score.staves.Pentagram;
import es.ua.dlsi.im3.io.ImportException;
import es.ua.dlsi.im3.io.antlr.ErrorListener;
import es.ua.dlsi.im3.io.antlr.GrammarParseRuntimeException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.ua.dlsi.im3.io.antlr.ParseError;
import es.ua.dlsi.im3.io.kern.kernBaseListener;
import es.ua.dlsi.im3.io.kern.kernLexer;
import es.ua.dlsi.im3.io.kern.kernParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**

 * Note: It imports the root voice as a new part
 *
 * @author drizo
 */
public class KernImporter implements IScoreSongImporter {

	public KernImporter() {
	}

	@Override
	public ScoreSong importSong(InputStream is) throws ImportException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	static class VoiceTemp {

		ArrayList<SingleFigureAtom> tupletElements = new ArrayList<>();
		ArrayList<Integer> tupletDurations = new ArrayList<>();
		boolean inTuplet;
		int mcdTupleElementDuration; // greatest common divisor
		int mcm; // lowest common multiple
		int tupletDots;
		private int lastDuration;
	}

	public static class Loader extends kernBaseListener {

		ScoreSong scoreSong;
		ScoreLayer currentVoice; // TODO De momento solo tengo una voice por part

		int currentSpineIndex = -1; // incremented in enterField
		private int harmSpine = -1;
		int currentRow = 0; // incremented in enterRecord - start from 1
		Time lastTime;
		int ksNotesCount = 0;
		int lastDots;
		Figures lastFigure;
		SimpleChord chord;

		HashMap<Integer, ScoreLayer> spines = new HashMap<>();
		HashMap<Integer, Staff> stavesForSpines = new HashMap<>();
		HashMap<Integer, Staff> stavesByNumber = new HashMap<>();
		HierarchicalIDGenerator hierarchicalIDGenerator = new HierarchicalIDGenerator();


		// long currentTime = 0;
		//ScoreFigureAndDots<Figures> lastDuration = null;
		private ScorePart globalPart;
		private ScorePart rootPart;
		TimeSignature currentMeter;
		// ArrayList<ScoreSoundingElement> measurescorenotes = new
		// ArrayList<>();
		Measure currentMeasure;
		private int rootSpine = -1;
		private Mode keyChangeMode;
		private String keyString;
		private int octaveModif;
		private String noteName;
		private VoiceTemp currentVoiceTemp;
		private SimpleNote lastRootNote;
		private VoiceTemp rootVoiceTemp;
		private SingleFigureAtom lastNoteOrChord;
		private Harmony lastHarmony;
		HashMap<Integer, VoiceTemp> voiceTemp;
		TreeSet<Double> figureBeatsSortedForTupletProcessing;
		private boolean inChord;

		// TODO refactorización private ScoreStaff rootStaff;

		TreeSet<Integer> nonTupletDurations = new TreeSet<>(); // faster than a math op
		{
			nonTupletDurations.add(0);
			nonTupletDurations.add(1);
			nonTupletDurations.add(2);
			nonTupletDurations.add(4);
			nonTupletDurations.add(8);
			nonTupletDurations.add(16);
			nonTupletDurations.add(32);
			nonTupletDurations.add(64);
			nonTupletDurations.add(128);
			nonTupletDurations.add(256);
		}


		Loader(ScoreSong song) {
			try {
				scoreSong = song;
				//TODO Ahora va todo a la misma part
				globalPart = new ScorePart(scoreSong, 0);
				scoreSong.addPart(globalPart);
				prepareFiguresForTuplet();
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
				throw new IM3RuntimeException(ex);
			}
		}
		/// -------- Helper methods -------
		boolean inHarmSpine() {
			return currentSpineIndex == this.harmSpine;
		}

		boolean inRootSpine() {
			return currentSpineIndex == this.rootSpine;
		}

		final boolean isRootBeforeHarmonies() {
			return rootSpine < harmSpine;
		}

		/**
		 * greatest common divisor (euclides)
		 *
		 * @return
		 */
		private int gcd(int a, int b) {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}

		private int mcm(int a, int b) {
			int m = gcd(a, b);
			return (m * (a / m) * (b / m));
		}




		private Staff getStaff(int currentSpineIndex) throws IM3Exception {
			Staff staff = stavesForSpines.get(currentSpineIndex);
			if (staff == null) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Adding staff 0 to part");
				staff = addStaff(stavesByNumber.size());
			}
			return staff;
		}

		Staff addStaff(int number) throws IM3Exception {
			/*2017 if (currentSpineIndex == rootSpine) {
				staff = rootPart.addStaff(number);
			} else {
				staff = globalPart.addStaff(number);
			}*/

			Staff staff = new Pentagram(scoreSong, hierarchicalIDGenerator.nextStaffHierarchicalOrder(null), number);
			stavesForSpines.put(currentSpineIndex, staff);
			scoreSong.addStaff(staff);
			return staff;
		}

		Time getAndUpdateCurrentTime() {
			if (inHarmSpine()) {
				return lastTime;
			} else {
				try {
					if (currentVoice.isEmpty()) {
						lastTime = Time.TIME_ZERO;
					} else {
						lastTime = currentVoice.getDuration();
					}
					return lastTime;
				} catch (IM3Exception ex) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
					throw new GrammarParseRuntimeException(ex);
				}
			}
		}

		VoiceTemp getCurrentVoiceTemp() {
			if (inHarmSpine()) {
				// try to get the root voice
				if (rootSpine != -1) {
					return rootVoiceTemp;
				} else {
					// get the first available voiceTemp
					for (int i = 0; i < this.voiceTemp.size(); i++) {
						if (voiceTemp.get(i) != null) {
							return voiceTemp.get(i);
						}
					}
					Logger.getLogger(KernImporter.class.getName()).log(Level.WARNING,
							"Cannot get a voice for the harm spine");
					return null;
				}
			} else {
				return voiceTemp.get(currentSpineIndex);
			}
		}

		private TimeSignature currentTimeSignature() throws NoMeterException, IM3Exception {
			Staff staff = getStaff(currentSpineIndex);
			return staff.getRunningTimeSignatureAt(lastTime);

			/*2017 f (currentVoice.isEmpty()) {
				return scoreSong.getFirstMeter();
			} else {
				try {
					return scoreSong.getActiveMeterAtTime(currentVoice.getLastDurationalSymbol().getTime());
				} catch (IM3Exception ex) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
					throw new GrammarParseRuntimeException(ex);
				}
			}*/
		}

		private void addAtom(Time time, Atom atom) throws IM3Exception {
			currentVoice.add(time, atom);
			Staff staff = getStaff(currentSpineIndex);
			staff.addCoreSymbol(atom);

		}


		//////////
		@Override
		public void enterHeader(kernParser.HeaderContext ctx) {
			super.enterHeader(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Enter Header {0}", ctx.getText());

			voiceTemp = new HashMap<>();
			currentSpineIndex = 0;
		}

		/**
		 * **kern
		 * @param ctx
		 */
		@Override
		public void enterHeaderKern(kernParser.HeaderKernContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Kern {0}", ctx.getText());
			voiceTemp.put(currentSpineIndex, new VoiceTemp());
			if (spines.get(currentSpineIndex) == null) {
				// 2017
				ScoreLayer v = new ScoreLayer(globalPart, currentSpineIndex); //TODO Ahora va todo a globalPart

				spines.put(currentSpineIndex, v);

				//TODO Pongo aquí el staff, habrá que ver luego cuando esté la etiqueta staff
				Staff staff = null;
				try {
					staff = getStaff(currentSpineIndex);
				} catch (IM3Exception ex) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
					throw new GrammarParseRuntimeException(ex);
				}
				staff.addLayer(v);
			}
			currentSpineIndex++;
		}

		@Override
		public void enterHeaderHarm(kernParser.HeaderHarmContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Harm {0}", ctx.getText());
			if (harmSpine != -1) {
				throw new GrammarParseRuntimeException("Cannot set two harm spines, previous was " + harmSpine
						+ ", and new one is " + currentSpineIndex + " at row " + currentRow);
			}
			harmSpine = currentSpineIndex;
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Setting harm spine in {0}", harmSpine);
			currentSpineIndex++;
		}

		@Override
		public void enterHeaderRoot(kernParser.HeaderRootContext ctx) {
			throw new UnsupportedOperationException("TODO refactorizacion");
			/*
			 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
			 * "Root {0}", ctx.getText()); if (rootSpine != -1) { throw new
			 * GrammarParseRuntimeException(
			 * "Cannot set two root spines, previous was " + rootSpine +
			 * ", and new one is " + currentSpineIndex + " at row " +
			 * currentRow); }
			 * 
			 * try { rootPart = this.scoreSong.addAnalysisPart("Analysis / Root"
			 * ); //ScoreLayer v = new ScoreLayer(rootPart, currentSpineIndex);
			 * spines.put(currentSpineIndex, this.scoreSong.getAnalysisVoice());
			 * //rootStaff = rootPart.addStaff(); rootStaff =
			 * this.scoreSong.getAnalysisStaff();
			 * stavesForSpines.put(currentSpineIndex, rootStaff); } catch
			 * (IM3Exception ex) {
			 * Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
			 * null, ex); throw new GrammarParseRuntimeException(ex); }
			 * rootVoiceTemp = new VoiceTemp(); voiceTemp.put(currentSpineIndex,
			 * new VoiceTemp()); rootSpine = currentSpineIndex;
			 * currentSpineIndex++;
			 */
		}

		@Override
		public void enterRecord(kernParser.RecordContext ctx) {
			super.enterRecord(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Record {0}", ctx.getText());
			currentRow++;

			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Record #{0}", currentRow);
			currentSpineIndex = -1;
			lastNoteOrChord = null;
		}

		@Override
		public void exitRecord(kernParser.RecordContext ctx) {
			super.exitRecord(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Record {0}", ctx.getText());
			if (lastNoteOrChord != null) {
				lastTime = lastTime.add(lastNoteOrChord.getDuration());
			}
		}



		@Override
		public void enterField(kernParser.FieldContext ctx) {
			super.enterField(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Entering field {0}", ctx.getText());
			currentSpineIndex++;
			currentVoiceTemp = this.getCurrentVoiceTemp();

			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Spine #{0}", currentSpineIndex);
			// currentScorePart = scoreSong.getPart(currentPartIndex);
			if (!inHarmSpine()) {
				currentVoice = spines.get(currentSpineIndex);
			} else {
				currentVoice = null;
			}
		}

		@Override
		public void enterInterpretation(kernParser.InterpretationContext ctx) {
			super.enterInterpretation(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Enter Interpretation {0}", ctx.getText());
		}


		@Override
		public void exitInterpretation(kernParser.InterpretationContext ctx) {
			super.exitInterpretation(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Exit Interpretation {0}", ctx.getText());
			// TODO
		}

		@Override
		public void enterTandemInterpretation(kernParser.TandemInterpretationContext ctx) {
			super.enterTandemInterpretation(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Enter Tandem Interpretation {0}", ctx.getText());
		}


		@Override
		public void exitTandemInterpretation(kernParser.TandemInterpretationContext ctx) {
			super.exitTandemInterpretation(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Exit Tandem Interpretation {0}", ctx.getText());
			// TODO
		}


		@Override
		public void exitClef(kernParser.ClefContext ctx) {
			try {
				super.exitClef(ctx);
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
						"Clef {0}", ctx.getText());

				Clef clef;
				switch (ctx.getText()) {
					case "G2":
						clef = new ClefG2();
						break;
					case "F4":
						clef = new ClefF4();
						break;
					case "C3":
						clef = new ClefC3();
						break;
					case "C4":
						clef = new ClefC4();
						break;
					case "G1":
						clef = new ClefG1();
						break;
					case "Gv2":
						clef = new ClefG2QuindicesimaBassa();
						break;
					default:
						throw new
								RuntimeException("Invalid clef: " + ctx.getText()); //TODO Logger
				}
				Staff staff = getStaff(currentSpineIndex);
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
						"Setting clef {0} to staff {1}", new Object[]{clef.toString(), staff.getNumberIdentifier()});

				Time t = getAndUpdateCurrentTime();
				Clef otherClef = staff.getClefAtTime(t);
				if (otherClef != null) {
					if (!otherClef.equals(clef)) {
						throw new
								GrammarParseRuntimeException("There is already a clef " +
								otherClef.toString() + " at time " + t +
								" while inserting " + clef.toString());
					}
				} else {
					clef.setTime(t);
					staff.addClef(clef);

				}
			} catch (IM3Exception ex) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
					throw new GrammarParseRuntimeException(ex);
				}
		}

		@Override
		public void enterKeysignature(kernParser.KeysignatureContext ctx) {
			super.enterKeysignature(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Beginning a key signature",
					ctx.getText());
			ksNotesCount = 0;
		}


		@Override
		public void exitKeysignature(kernParser.KeysignatureContext ctx) {
			super.exitKeysignature(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Key Signature {0}", ctx.getText());
			try {
				Logger.getLogger(KernImporter.class.getName()).log(Level.INFO,
						"Currently all key signatures are being encoded as UNKOWN");

				Time currentTime = getAndUpdateCurrentTime();
				Key ks;
				if (ctx.keysignatureNote().isEmpty()) {
					ks = new Key(PitchClasses.C.getPitchClass(), Mode.UNKNOWN); // mode
				} else {
					NoteNames nn = NoteNames.valueOf(ctx.keysignatureNote().get(0).noteNameLowerCase().getText().toUpperCase());
					if (nn == NoteNames.F) {
						// sharps
						ks = new Key(ctx.keysignatureNote().size(), Mode.UNKNOWN.name());
					} else if (nn == NoteNames.B) {
						// flats
						ks = new Key(-ctx.keysignatureNote().size(), Mode.UNKNOWN.name());
					} else {
						throw new GrammarParseRuntimeException("Unimplemented key signature support: " + ctx.getText());
					}
					// TODO Comprobar el contenido
				}

				Staff staff = getStaff(currentSpineIndex);

				KeySignature otherKey = staff.getKeySignatureWithOnset(currentTime);
				if (otherKey != null) {
					//TODO Comprobar transpositores
					if (!otherKey.getConcertPitchKey().equals(ks)) {
						throw new GrammarParseRuntimeException("There is already a key " + otherKey.toString()
								+ " at time " + currentTime + " while inserting " + ks.toString());
					}
				} else {
					staff.addKeySignature(new KeySignature(NotationType.eModern, ks));
				}
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
				throw new GrammarParseRuntimeException(ex);
			}
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Recognized key signature with {0} notes",
					ksNotesCount);

		}

		@Override
		public void exitKeysignatureNote(kernParser.KeysignatureNoteContext ctx) {
			super.exitKeysignatureNote(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Key Signature note {0}", ctx.getText());

			//TODO Control de qué notas pone
			ksNotesCount++;
		}

		@Override
		public void exitMeterKnown(kernParser.MeterKnownContext ctx) {
			super.exitMeterKnown(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Meter {0}", ctx.getText());
			Time currentTime = getAndUpdateCurrentTime();

			//TODO Common time ..., compuestos, denominadores con puntillos
			// Ver kern.g4 | (TANDEM_MET LEFTPAR 'C' RIGHTPAR) // not found in documentation, e.g. met(C) for common time
			try {
				TimeSignature ts = new FractionalTimeSignature(new Integer(ctx.numerator().getText()), new Integer(ctx.denominator().getText()));
				ts.setTime(currentTime);
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Recognized time signature {0}", ts);

				Staff staff = getStaff(currentSpineIndex);
				TimeSignature presentMeter = staff.getTimeSignatureWithOnset(currentTime);

				if (presentMeter != null) {
					if (!presentMeter.equals(ts)) {
						throw new GrammarParseRuntimeException("There is already a meter " + presentMeter.toString()
								+ " at time " + currentTime + " while inserting " + ts.toString());
					}
					currentMeter = presentMeter;
				} else {
					ts.setTime(currentTime);
					staff.addTimeSignature(ts);
					// TODO No soportamos cambios de compas entre spines, y tampoco lo comprobamos
					currentMeter = ts;

				}
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
				throw new GrammarParseRuntimeException(ex);
			}
		}

		@Override
		public void exitStaff(kernParser.StaffContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Staff {0}", ctx.getText());

			int number = new Integer(ctx.NUMBER().getText());
			try {
				Staff staff = stavesByNumber.get(number);
				if (staff == null) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Creating staff {0}", new Object[]{number});
					addStaff(number);
				}
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Associating spine {0} to staff {1}", new
								Object[]{currentSpineIndex, number});
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
						null, ex);
				throw new GrammarParseRuntimeException(ex);
			}
		}

		@Override
		public void exitKeyChange(kernParser.KeyChangeContext ctx) {
			try {
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Key change {0}", ctx.getText());
				NoteNames nn = NoteNames.valueOf(keyString.toUpperCase());
				PitchClass pc;
				if (ctx.keyAccidental() != null) {
					Accidentals acc = null;
					switch (ctx.keyAccidental().getText()) {
						case "n":
							acc = Accidentals.NATURAL;
							break;
						case "-":
							acc = Accidentals.FLAT;
							break;
						case "#":
							acc = Accidentals.SHARP;
							break;
						default:
							throw new GrammarParseRuntimeException(
									"Non valid accidental for key: " + ctx.keyAccidental().getText());
					}
					pc = new PitchClass(nn, acc);
				} else {
					pc = new PitchClass(nn);
				}
				Time t = getAndUpdateCurrentTime();

				Key kc = new Key(pc, keyChangeMode);

				Harmony previousH = scoreSong.getHarmonyWithOnsetOrNull(t);
				if (previousH != null) {
					if (previousH.getActiveKey() != null) {
						if (!previousH.getActiveKey().equals(kc)) {
							throw new GrammarParseRuntimeException(
									"Inserting two key changes (prev=" + previousH.getActiveKey().toString() + ", new="
											+ kc.toString() + ") at the same time (t=" + t + ")");
						}
					} else {
						previousH.setKeyChange(kc);
					}
				} else {
					Harmony previousHarmony = scoreSong.getHarmonyActiveAtTimeOrNull(t);
					Key previousKey = null;
					if (previousHarmony != null) {
						previousKey = previousHarmony.getKeyChange();
					}
					Harmony h = new Harmony(previousKey, kc);
					scoreSong.addHarmony(t, h);
					lastHarmony = h;
				}

				/*
				 * if (previousKC != null && !previousKC.hasMode()) {
				 * Logger.getLogger(KernImporter.class.getName()).log(Level.
				 * FINE,
				 * "Removing key signature without mode to substituted by this key change"
				 * , ctx.getText()); scoreSong.removeKey(previousKC); insertKey
				 * = true; } else if (previousKC == null) { insertKey = true; }
				 * else { if (t == previousKC.getTime()) { if
				 * (!previousKC.equals(kc)) { throw new
				 * GrammarParseRuntimeException(
				 * "Two different keys (previous = " + previousKC.toString() +
				 * ", new one = " + kc.toString() +
				 * ") being inserted in the same time " + t); } else { insertKey
				 * = false; // already present } } else { insertKey = true; //
				 * different time } }
				 *
				 * if (insertKey) { scoreSong.addKey(t, kc); }
				 */
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
				throw new GrammarParseRuntimeException(ex.toString());
			}
		}

		@Override
		public void exitMajorKey(kernParser.MajorKeyContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Major key {0}", ctx.getText());
			keyChangeMode = Mode.MAJOR;
			keyString = ctx.getText();
		}

		@Override
		public void exitMinorKey(kernParser.MinorKeyContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Minor key {0}", ctx.getText());
			keyChangeMode = Mode.MINOR;
			keyString = ctx.getText();
		}

		@Override
		public void exitNoteRestChord(kernParser.NoteRestChordContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
					"NoteRestChord {0}", ctx.getText());
			if (currentVoiceTemp.inTuplet) {
				try {
					int dur = currentVoiceTemp.lastDuration;
					currentVoiceTemp.tupletDurations.add(dur);
					currentVoiceTemp.mcdTupleElementDuration = gcd(dur,
							currentVoiceTemp.mcdTupleElementDuration);
					currentVoiceTemp.mcm = mcm(dur, currentVoiceTemp.mcm);
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Adding element to tuplet with figureAndDots {0}", dur);

					if (processTuplet()) { // tuplet complete
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"Tuplet processed");
						currentVoiceTemp.inTuplet = false;
						currentVoiceTemp.tupletDurations.clear();
						currentVoiceTemp.tupletElements.clear();
					}
				} catch (IM3Exception | NoMeterException ex) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
							null, ex);
					throw new GrammarParseRuntimeException(ex);
				}
			}
			 
		}

		@Override
		public void exitDuration(kernParser.DurationContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "ScoreFigureAndDots {0}", ctx.getText());

			int dur = new Integer(ctx.NUMBER().getText());
			/*
			 * boolean processFigure = true; if (currentVoiceTemp.inTuplet) {
			 * //if (dur != tupleElementDuration) { boolean isNonTupletDuration
			 * = nonTupletDurations.contains(dur); int gcdVal=0;
			 * //System.out.println("DUR: " + dur); if (!isNonTupletDuration) {
			 * gcdVal = gcd(dur, currentVoiceTemp.mcdTupleElementDuration); } if
			 * (isNonTupletDuration || gcdVal == 0) { try { processTuplet(); //
			 * process previous values con continue with this one } catch
			 * (NoMeterException | IM3Exception ex) {
			 * Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
			 * null, ex); throw new GrammarParseException(ex); } } else {
			 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
			 * "In tuplet with element figureAndDots {0}", ctx.getText());
			 * currentVoiceTemp.tupletDurations.add(new
			 * Integer(ctx.NUMBER().getText())); processFigure = false;
			 * currentVoiceTemp.mcdTupleElementDuration = gcdVal;
			 * currentVoiceTemp.mcm = mcm(dur, currentVoiceTemp.mcm);
			 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
			 * "In tuplet with gcd {0}",
			 * currentVoiceTemp.mcdTupleElementDuration); } }
			 */
			VoiceTemp currentVoiceTemp = getCurrentVoiceTemp();
			Figures f;
			switch (ctx.NUMBER().getText()) {
				case "0":
					f = Figures.DOUBLE_WHOLE;
					break;
				case "1":
					f = Figures.WHOLE;
					break;
				case "2":
					f = Figures.HALF;
					break;
				case "4":
					f = Figures.QUARTER;
					break;
				case "8":
					f = Figures.EIGHTH;
					break;
				case "16":
					f = Figures.SIXTEENTH;
					break;
				case "32":
					f = Figures.THIRTY_SECOND;
					break;
				case "64":
					f = Figures.SIXTY_FOURTH;
					break;
				case "128":
					f = Figures.HUNDRED_TWENTY_EIGHTH;
					break;
				case "256":
					f = Figures.TWO_HUNDRED_FIFTY_SIX;
					break;
				default: // tuplet
					f = Figures.TWO_HUNDRED_FIFTY_SIX;
					// one temporal that will be modified later
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"ScoreFigureAndDots figureAndDots has to be a tuplet {0}", ctx.getText());
					if (!currentVoiceTemp.inTuplet) {
						currentVoiceTemp.inTuplet = true;
						currentVoiceTemp.tupletElements.clear();
						currentVoiceTemp.mcdTupleElementDuration = dur;
						currentVoiceTemp.mcm = dur;
						currentVoiceTemp.tupletDurations.clear();
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"Starting tuplet with element figureAndDots {0}", ctx.getText());
					}
					currentVoiceTemp.lastDuration = dur;

			}
			int dots = ctx.augmentationDots().getText().length();
			if (!currentVoiceTemp.inTuplet) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Figure {0} with {1} dots",
						new Object[] {f, dots});

				if (ctx.getParent().getRuleIndex() != kernParser.RULE_denominator) {
					// not rule for meter
					lastFigure = f;
					lastDots = dots;
				}
			} else { // TODO Comprobar que no salimos de un tuplet sin dots y
				// pasamos a uno con dots...
				currentVoiceTemp.tupletDots = dots;
				lastFigure = f;
				lastDots = dots;
			}
		}

		private void checkAllNoteNameEqual(String text) throws GrammarParseRuntimeException {
			// check all letters are equal
			for (int i = 1; i < text.length(); i++) {
				if (text.charAt(i) != text.charAt(0)) {
					throw new GrammarParseRuntimeException(
							"The characters for a note name should be the same for specifying the octave, and we have '"
									+ text + "'");
				}
			}
		}

		@Override
		public void enterTrebleNotes(kernParser.TrebleNotesContext ctx) {
			super.enterTrebleNotes(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "TrebleNotes {0}", ctx.getText());
			String t = ctx.getText();
			checkAllNoteNameEqual(t);
			octaveModif = ctx.getText().length() - 1;
			noteName = t.substring(0, 1).toUpperCase();

		}

		@Override
		public void enterBassNotes(kernParser.BassNotesContext ctx) {
			super.enterBassNotes(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "BassNotes {0}", ctx.getText());
			String t = ctx.getText();
			checkAllNoteNameEqual(t);
			octaveModif = -ctx.getText().length();
			noteName = t.substring(0, 1).toUpperCase();
		}

		@Override
		public void exitNote(kernParser.NoteContext ctx) {
			super.enterNote(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
					"Note {0}", ctx.getText());

			int octave = 4 + octaveModif;

			// check all letters are equal
			NoteNames nn = NoteNames.valueOf(noteName);

			Accidentals acc = Accidentals.NATURAL;
			if (ctx.alteration() !=
					null) {
				switch (ctx.alteration().getText()) {
					case "n": acc = Accidentals.NATURAL;
						break;
					case "--":
						acc = Accidentals.DOUBLE_FLAT;
						break;
					case "-":
						acc = Accidentals.FLAT;
						break;
					case "#":
						acc = Accidentals.SHARP;
						break;
					case "##":
						acc = Accidentals.DOUBLE_SHARP;
						break;
					default:
						throw new
								GrammarParseRuntimeException("Unimplemented accidental: " +
								ctx.alteration().getText());
				}
			}
			try {
				Time currentTime = getAndUpdateCurrentTime();
				SingleFigureAtom sse;
				if (inChord) {
					if (chord == null) {
						chord = new SimpleChord(lastFigure, lastDots);
						chord.setTime(currentTime);
						chord.setStaff(getStaff(currentSpineIndex));
						lastNoteOrChord = chord;
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"New chord at time {0}", chord.getTime());
						if (currentVoiceTemp.inTuplet) {
							Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
									"Chord added to tuplet");
							currentVoiceTemp.tupletElements.add(chord);
						}
					} else {
						if (lastDots != chord.getAtomFigure().getDots() || !lastFigure.equals( chord.getAtomFigure().getFigure())) {
							throw new
									GrammarParseRuntimeException("The chord figure ( "+
									chord.getAtomFigure().getFigure() + ") or dots " +
									chord.getAtomFigure().getDots() + ") are different from last ones (" +
									lastFigure + "), (" + lastDots + ") dots");

						}
					}
					chord.addPitch(new ScientificPitch(new PitchClass(nn, acc), octave));
				} else {
					Atom previous = currentVoice.isEmpty() ? null : currentVoice.getLastAtom();
					ScientificPitch sp = new ScientificPitch(nn, acc, octave);
					SimpleNote sn = new SimpleNote(lastFigure, lastDots, sp);
					//currentVoice.add(currentTime, sn);
					addAtom(currentTime, sn);
					lastNoteOrChord = sn;
					if (currentSpineIndex == rootSpine) {
						//TODO - en teoría no debería hacer falta, el hash
						// stavesForSpines debería contenerlo - lo ponemos para depurar un error sn.setStaff(rootStaff);
						if (currentVoice != scoreSong.getAnalysisVoice()) {
							throw new GrammarParseRuntimeException("The analysis voice is different from the current voice in the root spine"
							);
						}
					} else {
						sn.setStaff(getStaff(currentSpineIndex));
					}

					if (ctx.afterNote() != null &&
							(!ctx.afterNote().tiemiddle().isEmpty() ||
									!ctx.afterNote().tieend().isEmpty())) {
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"Tie found");
						if (previous == null) {
							throw new
									GrammarParseRuntimeException(
									"Tie found but no previous note present");
						}
						if (previous instanceof SimpleNote) {
							sn.tieFromPrevious((SimpleNote) previous);
						} else {
							throw new GrammarParseRuntimeException(
									"Tie found but previous element is not a note, it is a " +
											previous.getClass().toString());
						}
					}

					if (!ctx.afterNote().pause().isEmpty()) {
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"Pause found");
						//TODO 2017 sn.setFermata(true);
					}
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Score note added {0}", sn.toString());
					if (currentVoiceTemp.inTuplet) {
						Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
								"Score note added {0} to tuplet", sn.toString());
						currentVoiceTemp.tupletElements.add(sn);
					}

					if (inRootSpine()) {
						lastRootNote = sn;
						if (!isRootBeforeHarmonies()) {
							if (lastHarmony != null) {
								Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
										"Setting root {0} to harmony {1}", new
												Object[]{sn.getPitch().getPitchClass(), lastHarmony});
								lastHarmony.setRoot(sn.getPitch().getPitchClass());
							}
						}
					}
				}
			} catch
					(IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
						null, ex);
				throw new
						GrammarParseRuntimeException(ex.getMessage());
			}

		}

		@Override
		public void enterChord(kernParser.ChordContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Enter chord {0}", ctx.getText());
			inChord = true;
			chord = null;
		}

		@Override
		public void exitChord(kernParser.ChordContext ctx) {
			inChord = false;
			chord = null;
		}

		@Override
		public void exitRest(kernParser.RestContext ctx) {

			super.enterRest(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
					"Rest {0}", ctx.getText());
			try {
				//ctx.noteName().
				// TODO Crear rest con ritmo lastDuration
				Staff staff = getStaff(currentSpineIndex);
				Time currentTime = getAndUpdateCurrentTime();
				SimpleRest rest = new SimpleRest(lastFigure, lastDots);
				//currentVoice.add(currentTime, rest);
				addAtom(currentTime, rest);
				//2017 rest.setStaff(getStaff(currentSpineIndex)); // Beniarbeig 2014
				//measurescorenotes.add(rest);

				if (ctx.pause() != null && !ctx.pause().isEmpty()) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Pause found");
					//TODO 2017 rest.setFermata(true);
				}

				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
						"Rest added {0}", rest.toString());
				if
						(currentVoiceTemp.inTuplet) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Rest added {0} to tuplet");
					currentVoiceTemp.tupletElements.add(rest);
				}

			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
						null, ex);
				throw new GrammarParseRuntimeException(ex);
			}
			 
		}

		private void prepareFiguresForTuplet() {
			figureBeatsSortedForTupletProcessing = new TreeSet<>();
			for (Figures f : Figures.values()) {
				// figureRatiosSortedForTupletProcessing.add(f.getRatio());
				figureBeatsSortedForTupletProcessing.add(new Double(f.getMeterUnit()));
			}
		}

		// see http://www2.siba.fi/muste1/index.php?id=100&la=en
		// TODO Probar dosillo en comp�s compuesto
		// TODO Seguramente esto no est� tampoco hecho en el MusicXMLImporter
		/**
		 *
		 * @return True if it is processed
		 * @throws IM3Exception
		 * @throws NoMeterException
		 */
		private boolean processTuplet() throws IM3Exception, NoMeterException {
			// int nelementsInTuplet = currentVoiceTemp.tupletElements.size();
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
					"Trying to process tuplet with {0} symbols of kern figureAndDots with m.c.d. {1} and m.c.m. {2}",
					new Object[] { currentVoiceTemp.tupletElements.size(), currentVoiceTemp.mcdTupleElementDuration,
							currentVoiceTemp.mcm });

			// this is like the first part of tupletComplete but also adds the
			// span
			int groupDuration = 0;
			ArrayList<Integer> spans = new ArrayList<>();
			int nelementsInTuplet = 0;
			for (Integer d : currentVoiceTemp.tupletDurations) {
				int span = currentVoiceTemp.mcm / d; // inverse figureAndDots
				// relation (longer
				// value = shorter
				// figureAndDots)
				spans.add(span);
				groupDuration += (currentVoiceTemp.mcm * span);
				nelementsInTuplet += span;
			}

			// int nelementsInTuplet = groupDuration /
			// currentVoiceTemp.mcdTupleElementDuration; //TODO Ver si puede dar
			// esto un valor no entero
			// Figures tupletDurationFigure = Figures.findBeats(groupDuration);
			TimeSignature ts = currentTimeSignature();
			// double tupletDurationRatio = tupletDurationFigure.getRatio();

			// double individualFigureRatio;
			double individualDuration;
			if (ts.isCompound()) {
				if (nelementsInTuplet != 2 && nelementsInTuplet != 4 && nelementsInTuplet != 5
						&& nelementsInTuplet != 7) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Tuplet not complete yet {0} symbols in compount meter, expecting 2, 4, 5, or 7",
							nelementsInTuplet);
					return false; // not complete yet
				}
				// individualFigureRatio =
				// figureRatiosSortedForTupletProcessing.floor(tupletDurationRatio
				// / (double) nelementsInTuplet);
				individualDuration = figureBeatsSortedForTupletProcessing
						.ceiling((double) groupDuration / (double) nelementsInTuplet);
			} else {
				if (nelementsInTuplet != 3 && nelementsInTuplet != 5 && nelementsInTuplet != 6 && nelementsInTuplet != 7
						&& nelementsInTuplet != 9) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Tuplet not complete yet {0} symbols in simple meter, expecting 3, 5, 6, 7, or 9",
							nelementsInTuplet);
					return false; // not complete yet
				}
				individualDuration = figureBeatsSortedForTupletProcessing
						.floor((double) groupDuration / (double) nelementsInTuplet);
				// individualFigureRatio =
				// figureRatiosSortedForTupletProcessing.ceiling(tupletDurationRatio
				// / (double) nelementsInTuplet);
			}
			int actualGroupDuration = (int) (groupDuration / nelementsInTuplet - individualDuration); // TODO
			// Esto es empirico, hay que comprobarlo bien
			Figures individualDurationFigure = Figures.findMeterUnit((int) individualDuration, NotationType.eModern);
			// ScoreFigureAndDots individualFigureDuration = new
			// ScoreFigureAndDots(Figures.findRatio(individualFigureRatio),
			// currentVoiceTemp.tupletDots); //TODO Ver lo que dice de los
			// puntillos, si se usan tuplets con puntillos en principio s�lo
			// tenemos que poner aqu� los puntillos
			//2017 ScoreFigureAndDots individualFigureDuration = new ScoreFigureAndDots(individualDurationFigure, currentVoiceTemp.tupletDots); // TODO
			// Ver lo que dice de los puntillos, si se usan tuplets con puntillos en principio solo
			// tenemos que poner aqui los puntillos

			// int inSpaceOfNotes = (int) ((double)tupletDurationRatio /
			// individualFigureDuration.getFigure().getRatio());
			// int inSpaceOfNotes = (int) (groupDuration / individualDuration);
			int inSpaceOfNotes = (int) (individualDuration / actualGroupDuration); // TODO
			// esto es empirico - va a la inversa, menor valor mayor duracion

			if (nelementsInTuplet * actualGroupDuration != currentVoiceTemp.mcm) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
						"Tuplet not complete yet {0} symbols * {1} actualGroupDuration != {2} mcm",
						new Object[] { nelementsInTuplet, actualGroupDuration, currentVoiceTemp.mcm });
				return false;
			}

			ArrayList<Atom> tupletElements = new ArrayList<>();
			for (int i = 0; i < currentVoiceTemp.tupletElements.size(); i++) {
				SingleFigureAtom sse = currentVoiceTemp.tupletElements.get(i);
				int dur = currentVoiceTemp.tupletDurations.get(i);
				// int span = dur / currentVoiceTemp.mcdTupleElementDuration;
				tupletElements.add(sse);
				//2017 tuplet.addElementAndChangeItsOnsetAndDuration(sse, spans.get(i));
			}

			SimpleTuplet tuplet = new SimpleTuplet(nelementsInTuplet, inSpaceOfNotes, individualDurationFigure,
					//currentVoiceTemp.tupletDots
					tupletElements
			);

			Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Tuplet processed: {0}", tuplet.toString());


			currentVoiceTemp.inTuplet = false;
			currentVoiceTemp.tupletElements.clear();
			currentVoiceTemp.tupletDots = 0;
			currentVoiceTemp.tupletDurations.clear();
			//currentVoice.add(tuplet); // 2017
			addAtom(lastTime, tuplet); // 2017
			return true;
		}



		/*
		 * @Override public void exitRepeatToken(kernParser.RepeatTokenContext
		 * ctx) { super.exitRepeatToken(ctx);
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST,
		 * "Repeat token {0}", ctx.getText()); ScoreSoundingElement lastToken =
		 * currentVoice.getScoreSoundingElements().last(); if (lastToken ==
		 * null) { throw new GrammarParseException(
		 * "Cannot repeat an empty token in row #" + currentRow + ", spine #" +
		 * currentSpineIndex); } //ScoreSoundingElement repeated =
		 * (ScoreSoundingElement) lastToken.clone(); ScoreSoundingElement
		 * repeated; if (lastToken instanceof Rest) { try { repeated = new
		 * Rest(currentVoice, getAndUpdateCurrentTime(), (ScoreFigureAndDots)
		 * lastToken.getDurationInTicks().clone()); // automaticly added } catch
		 * (IM3Exception ex) {
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
		 * null, ex); throw new GrammarParseException(
		 * "Repetition (cloning) of class " + lastToken.getClass().toString() +
		 * " not supported"); } } else if (lastToken instanceof ScoreNote) { try
		 * { repeated = new ScoreNote(currentVoice, getAndUpdateCurrentTime(),
		 * ((ScoreNote) lastToken).getPitchAndOctave().clone(), (ScoreFigureAndDots)
		 * lastToken.getDurationInTicks().clone()); // automaticly added } catch
		 * (IM3Exception ex) {
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
		 * null, ex); throw new GrammarParseException(
		 * "Repetition (cloning) of class " + lastToken.getClass().toString() +
		 * " not supported"); } } else { throw new GrammarParseException(
		 * "Repetition (cloning) of class " + lastToken.getClass().toString() +
		 * " not supported"); }
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
		 * "Added repeated element {0}", repeated.toString()); }
		 */

		@Override
		public void exitMordent(kernParser.MordentContext ctx) {
			super.exitMordent(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Mordent {0}", ctx.getText());
			// TODO Mordente no implementado
		}

		///
		/*
		 * ScorePart getCurrentPart() { ScorePart part = currentVoice.getPart();
		 * if (part == this.tempPart) { //currentPart =
		 * scoreSong.addPart(number); if (globalPart == tempPart) {
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
		 * "Creating global part"); globalPart = scoreSong.addPart(); } part =
		 * globalPart;
		 * //Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
		 * "Creating part {0}", number);
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
		 * "Associating spine {0} to global part", new
		 * Object[]{currentSpineIndex}); try {
		 * //part.addVoice(currentSpineIndex, currentVoice); if
		 * (currentVoice.getNumber() != currentSpineIndex) { throw new
		 * GrammarParseRuntimeException("Spine index != currentVoice.number");
		 * // Beniarbeig } tempPart.removeVoice(currentVoice);
		 * part.addVoice(currentVoice); currentVoice.setPart(part); //
		 * Beniarbeig 2014 } catch (IM3Exception ex) {
		 * Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
		 * null, ex); throw new GrammarParseRuntimeException(ex); } } return
		 * part; }
		 */

		@Override
		public void exitBarline(kernParser.BarlineContext ctx) {
			super.exitBarline(ctx);
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Barline {0}", ctx.getText());
			
			// only process last spine barline
			if (!inHarmSpine()) {
				if (currentSpineIndex < spines.size() - 1) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Barline in spine {0}, not processing for not being the last spine", currentSpineIndex);
				} else {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
							"Barline in last spine, processing it");
					/*
					 * long currentTime = getAndUpdateCurrentTime(); try { // close
					 * previous bar if (currentMeter != null && currentMeasure
					 * != null && scoreSong.getBarCount()<=1) { // only the
					 * first bar // check anacrusis long offset = currentTime -
					 * (currentMeter.getTime()+currentMeter.getMeasureDuration(
					 * scoreSong.getResolution())); if (offset != 0) {
					 * Logger.getLogger(KernImporter.class.getName()).log(Level.
					 * FINE, "Anacrusis found starting at time {0}", offset);
					 * scoreSong.setAnacrusisOffset(offset); //for
					 * (ScoreSoundingElement sn : measurescorenotes) { // try {
					 * // sn.move(offset); // } catch (IM3Exception ex) { //
					 * Logger.getLogger(KernImporter.class.getName()).log(Level.
					 * SEVERE, null, ex); // throw new
					 * GrammarParseException(ex); // } //} //measurescorenotes =
					 * new ArrayList<>(); } } } catch (IM3Exception ex) {
					 * Logger.getLogger(KernImporter.class.getName()).log(Level.
					 * SEVERE, null, ex); throw new
					 * GrammarParseRuntimeException(ex); }
					 */
					// check anacrusis
					int barNumber;
					if (ctx.NUMBER() == null) {
						try {
							barNumber = scoreSong.getMeaureCount() + 1;
							Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
									"Barline without number, assigning {0}", barNumber);
						} catch (IM3Exception ex) {
							Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
							throw new GrammarParseRuntimeException(ex);
						}
					} else {
							barNumber = new Integer(ctx.NUMBER().getText());
							Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Barline with number {0}",
									barNumber);
					}
					try {
						Time currentTime = getAndUpdateCurrentTime();
						Time newBarTime = currentTime;
						// only the first bar
						if (currentTime.getComputedTime() > 0.0 && currentMeter != null && scoreSong.getMeaureCount() == 0) {
							// check anacrusis
							// long offset =
							// (currentMeter.getTime()+currentMeter.getMeasureDuration(scoreSong.getResolution()))
							// - currentTime;
							if (! (currentMeter instanceof ITimeSignatureWithDuration)) {
								throw new IM3Exception("Cannot import a time signature without duration: " + currentMeter.getClass());
							}
							Time expectedTime = ((ITimeSignatureWithDuration)currentMeter).getMeasureDuration();
							Time offset = expectedTime.substract(currentTime);
							if (!offset.isZero()) {
								Logger.getLogger(KernImporter.class.getName()).log(Level.FINE,
										"Anacrusis found starting at time {0}", offset);
								scoreSong.setAnacrusisOffset(offset);
								lastTime = offset;
								scoreSong.addMeasure(Time.TIME_ZERO, new Measure(scoreSong, 0));
								scoreSong.setAnacrusisOffset(offset);
									/*
									 * for (ScorePart<ScoreDurationalElement<
									 * Figures>> part:
									 * scoreSong.getParts()) { for
									 * (ScoreLayer<ScoreDurationalElement<
									 * Figures>> voice: part.getVoices())
									 * { ArrayList<ScoreDurationalElement<
									 * Figures>> notes =
									 * voice.getDurationalSymbolsActiveWithin(0,
									 * currentTime); voice.moveElements(notes,
									 * offset); } }
									 */
									/*for (ScoreLayer spine : spines.values()) {
										ArrayList<ScoreDurationalSymbol> notes = spine
												.getDurationalSymbolsActiveWithin(0, currentTime);
										spine.moveElements(notes, offset);
									}

									scoreSong.moveHarmomies(offset);
									scoreSong.moveKeys(offset);
									newBarTime = expectedTime;*/
							}
						}
						//TODO 2017 - No esta ya anyadido arriba en caso de anacrusa?
						currentMeasure = new Measure(scoreSong, barNumber);
						scoreSong.addMeasure(newBarTime, currentMeasure);

						TimeSignature ts = currentTimeSignature();
						if (ts instanceof ITimeSignatureWithDuration) {
							Time measureDuration = ((ITimeSignatureWithDuration) ts).getMeasureDuration();
							currentMeasure.setEndTime(currentMeasure.getTime().add(measureDuration));
						} else {
							throw new ImportException("Cannot infer the measure duration with a time signature without duration (" + ts + ") at measure " + currentMeasure);
						}
						
					} catch (Exception ex) {
						Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
						throw new GrammarParseRuntimeException(ex);
					}
				}
			}
		}

		@Override
		public void exitSplineTerminator(kernParser.SplineTerminatorContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "Spline terminator for spline {0}",
					currentSpineIndex);
		}


		@Override
		public void exitHarmChordSpecification(kernParser.HarmChordSpecificationContext ctx) {
			Logger.getLogger(KernImporter.class.getName()).log(Level.FINEST, "HarmChordSpecification {0}",
					ctx.getText());
			try {
				ChordType type;
				Degree degree;
				if (ctx.harmMajorChord() != null) {
					type = ChordType.MAJOR;
					degree = Degree.valueOf(ctx.harmMajorChord().getText().toUpperCase());
				} else if (ctx.harmMinorChord() != null) {
					type = ChordType.MINOR; // URGENT Pasar las 7mas ...
					degree = Degree.valueOf(ctx.harmMinorChord().getText().toUpperCase());
				} else {
					throw new GrammarParseRuntimeException("Both major and minor chord are empty");
				}

				Time t = lastNoteOrChord.getTime();

				// TODO Lo he puesto ahora a piñon para que esta línea de bajo
				// compile
				// Harmony h = new Harmony(null, degree, type);
				Staff staff = getStaff(currentSpineIndex);
				KeySignature ks = staff.getRunningKeySignatureOrNullAt(t);
				Key key = ks != null?ks.getConcertPitchKey():null;
				//Key key = this.scoreSong.getActiveKeyAtTimeOrNull(t);
				Harmony h = new Harmony(key, null, degree, type);
				Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Creating harmony {0}", h.toString());
				// FIN TODO

				Harmony previousH = scoreSong.getHarmonyWithOnsetOrNull(t);
				if (previousH == null) {
					scoreSong.addHarmony(t, h);
					lastHarmony = h;
					// System.out.println("Adding harmony " + h.toString() + "
					// at time " + t);
				} else { // throw new GrammarParseRuntimeException("Previous
							// harmony (" + previousH.toString() + ") with the
							// same time (" + t + ") while inserting " +
							// h.toString());
					// TODO - comprobar en gramática, es un valor tipo IVb[vi] -
					// ver // alternate (2nd value) en kern.g4
					if (previousH.hasJustKeyInformation()) {
						try {
							h.setKeyChange(previousH.getActiveKey());
							h.setTime(t);
							lastHarmony = h;
							try {
								scoreSong.replace(previousH, h);
							} catch (IM3Exception ex) {
								Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
								throw new GrammarParseRuntimeException(
										"Cannot replace a harmony with a new with key information");
							}
						} catch (IM3Exception ex) {
							Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
							throw new GrammarParseRuntimeException(ex);
						}
					} else if (!previousH.equalsChord(h)) {
						previousH.setCommonHarmony(h);
						lastHarmony = h;
					} // if not we don't repeat it
				}

				if (lastRootNote != null && isRootBeforeHarmonies() && h.getRoot() == null) {
					Logger.getLogger(KernImporter.class.getName()).log(Level.FINE, "Setting root {0} to harmony {1}",
							new Object[] { lastRootNote.getPitch().getPitchClass(), h });
					h.setRoot(lastRootNote.getPitch().getPitchClass());
				}
			} catch (IM3Exception ex) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE, null, ex);
				throw new GrammarParseRuntimeException(ex);
			}

			// Logger.getLogger(KernImporter.class.getName()).log(Level.SEVERE,
			// "SIN ACABAR DE CONSTRUIR BIEN LA ARMON�A", ctx.getText());
		}
	}

	// @Override
	public ScoreSong importSong(File file) throws ImportException {
		ErrorListener errorListener = new ErrorListener();
		try {
			Logger.getLogger(KernImporter.class.getName()).log(Level.INFO, "Parsing {0}", file.getAbsoluteFile());
			InputStream is = new FileInputStream(file);
			kernLexer lexer = new kernLexer(new ANTLRInputStream(is));
			lexer.addErrorListener(errorListener);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			kernParser parser = new kernParser(tokens);
			parser.addErrorListener(errorListener);
			// parser.setErrorHandler(new BailErrorStrategy());
			// parser.setBuildParseTree(true); // tell ANTLR to build a parse
			// tree
			ParseTree tree = parser.song();
			ParseTreeWalker walker = new ParseTreeWalker();
			ScoreSong song = new ScoreSong();
			Loader loader = new Loader(song);
			walker.walk(loader, tree);
			if (errorListener.getNumberErrorsFound() != 0) {

				throw new ImportException(errorListener.getNumberErrorsFound() + " errors found in "
						+ file.getAbsolutePath() + "\n" + errorListener.toString());
			}
			// return song;

			// loader.setRootNotesToHarmonies();
			ScoreSong ssong;
			ssong = loader.scoreSong;
			ssong.invertPartAndVoiceNumbering(); // the kern is written from
													// bass to treble
			ssong.moveAnalysisPartToBottom();
			if (loader.rootPart != null) {
				ScoreLayer v = loader.spines.get(loader.rootSpine);
				if (v != null) {
					throw new UnsupportedOperationException("TODO refactorización");

					/*
					 * if (loader.rootPart.getStaves().isEmpty()) { throw new
					 * ImportException("The root part contains no staff"); } if
					 * (loader.rootPart.getStaves().size() > 1) { throw new
					 * ImportException("The root part contains > 1 staff"); }
					 * 
					 * replaceRootnotesForAnalysisHooks(loader.scoreSong);
					 */
				} else {
					Logger.getLogger(KernImporter.class.getName()).log(Level.WARNING,
							"No root spine to be imported as voice");
				}
			}
			return song;
		} catch (Throwable e) {
			// TODO Logs
			// TODO Logs
			e.printStackTrace();

			Logger.getLogger(KernImporter.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
			for (ParseError pe : errorListener.getErrors()) {
				Logger.getLogger(KernImporter.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
			}

			throw new ImportException(e.getMessage());
		}
	}

	/**
	 * Remove all notes in the root part and create an analysis hook for each
	 * possible subdivision (the minimum if each bar)
	 */
	/*2017 private void replaceRootnotesForAnalysisHooks(StaffAnalysisLayer staffLayer, ScoreSong song) throws IM3Exception {
		song.getAnalysisVoice().clearElementsWithRhythm();
		song.createAnalysisHooks(staffLayer);
	}*/

	public static void main(String[] args) throws ImportException, IM3Exception {
		/*
		 * Logger.getLogger(KernImporter.class.getName()).info(
		 * "Changing level to FINEST to the stderr"); // LOG this level to the
		 * log Logger.getLogger(KernImporter.class.getName()).setLevel(Level.
		 * FINESTST);
		 * 
		 * ConsoleHandler handler = new ConsoleHandler(); // PUBLISH this level
		 * handler.setLevel(Level.FINESTST);
		 * Logger.getLogger(KernImporter.class.getName()).addHandler(handler);
		 */

		// File file = new File("testdata/kern/base_tuplet.krn");
		// File file = new File("testdata/kern/harm-rep.krn");
		// File file = new File("/tmp/guide02-example2-1.krn");
		// File file = new File("/tmp/guide06-example6-2.krn");
		KernImporter instance = new KernImporter();
		// ScoreSong song = instance.importSong(new
		// File("/Users/drizo/cmg/investigacion/training_sets/sources/tonalanalysis/harmonizedchorals/KERN-SCORES/chor048.krn"));
		// System.out.println(song.getAllPitches());

		// ScoreSong expResult = new MusicXMLImporter().importSong(new
		// File("/Users/drizo/cmg/investigacion/training_sets/sources/tonalanalysis/harmonizedchorals/KERN-SCORES/chor048.xml"));
	}

	/**
	 * Remove all root notes and set analysis hooks with the smallest note
	 * figureAndDots of each bar
	 */
}
