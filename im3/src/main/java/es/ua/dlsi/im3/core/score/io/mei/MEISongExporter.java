package es.ua.dlsi.im3.core.score.io.mei;

import java.io.File;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.IM3RuntimeException;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.Atom;
import es.ua.dlsi.im3.core.score.AtomFigure;
import es.ua.dlsi.im3.core.score.AtomPitch;
import es.ua.dlsi.im3.core.score.BeamGroup;
import es.ua.dlsi.im3.core.score.Clef;
import es.ua.dlsi.im3.core.score.DynamicMark;
import es.ua.dlsi.im3.core.score.Figures;
import es.ua.dlsi.im3.core.score.ISymbolWithConnectors;
import es.ua.dlsi.im3.core.score.ITimedElement;
import es.ua.dlsi.im3.core.score.ITimedElementInStaff;
import es.ua.dlsi.im3.core.score.IUniqueIDObject;
import es.ua.dlsi.im3.core.score.Interval;
import es.ua.dlsi.im3.core.score.Key;
import es.ua.dlsi.im3.core.score.KeySignature;
import es.ua.dlsi.im3.core.score.LedgerLines;
import es.ua.dlsi.im3.core.score.Measure;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.ScientificPitch;
import es.ua.dlsi.im3.core.score.ScoreLayer;
import es.ua.dlsi.im3.core.score.ScoreSong;
import es.ua.dlsi.im3.core.score.SimpleChord;
import es.ua.dlsi.im3.core.score.SimpleMeasureRest;
import es.ua.dlsi.im3.core.score.SimpleNote;
import es.ua.dlsi.im3.core.score.SimpleRest;
import es.ua.dlsi.im3.core.score.SimpleTuplet;
import es.ua.dlsi.im3.core.score.SingleFigureAtom;
import es.ua.dlsi.im3.core.score.Staff;
import es.ua.dlsi.im3.core.score.StaffMark;
import es.ua.dlsi.im3.core.score.Time;
import es.ua.dlsi.im3.core.score.TimeSignature;
import es.ua.dlsi.im3.core.score.io.ISongExporter;
import es.ua.dlsi.im3.core.score.io.XMLExporterHelper;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.score.mensural.meters.TimeSignatureMensural;
import es.ua.dlsi.im3.core.score.meters.FractionalTimeSignature;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCommonTime;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCutTime;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureProporcionMenor;
import es.ua.dlsi.im3.core.score.staves.AnalysisStaff;
import es.ua.dlsi.im3.io.ExportException;
import es.ua.dlsi.im3.metadata.Person;
/**
 * 
 * @author drizo
 *
 */
public class MEISongExporter implements ISongExporter {

	public static final String VERSION = "3.0.0";
	protected ScoreSong song;
	protected StringBuilder sb;
	//private KeySignature lastKeySignature;
	//private TimeSignature lastTimeSignature;
	private HashMap<Staff, Clef> lastClef;
	static DecimalFormat decimalFormat;
	private HashMap<Measure, HashMap<Staff, ArrayList<StaffMark>>> marksPerBar;
	private TimeSignature commonStartTimeSignature;
	//private ArrayList<ConnectorWithLayer> barConnectors;
	//private HashMap<Measure, HashMap<Staff, ArrayList<Attachment>>> attachmentsPerBar;
	private KeySignature commonStartKeySignature;
	
	/*FRACCIONES class ConnectorWithLayer {
		Connector<?,?> connector;
		ScoreLayer layer;
		public ConnectorWithLayer(Connector<?,?> connector, ScoreLayer layer) {
			super();
			this.connector = connector;
			this.layer = layer;
		}
		public Connector<?,?> getConnector() {
			return connector;
		}
		public ScoreLayer getLayer() {
			return layer;
		}
		
	}*/
	
	@Override
	public void exportSong(File file, ScoreSong song) throws ExportException {
		PrintStream ps = null;
		try {
			ps = new PrintStream(file, "UTF-8");
			this.song = song;
			//song.createVisualElementsIfNeeded(); // important (e.g. accidentals)
			System.err.println("TO-DO URGENT: song.createVisualElementsIfNeeded"); //TODO URGENT song.createVisualElementsIfNeeded
			preprocess();
			ps.print(exportSong());
		} catch (Exception e) {
			throw new ExportException(e);
		}
		if (ps != null) {
			ps.close();
		}
	}

	protected void preprocess() throws IM3Exception {
		marksPerBar = new HashMap<>();
		if (song.getStaves() != null) {
			for (Staff staff: song.getStaves()) {
				if (!(staff instanceof AnalysisStaff)) {
					for (StaffMark mark: staff.getMarks()) {
						Measure bar = song.getMeasureActiveAtTime(mark.getTime());
						HashMap<Staff, ArrayList<StaffMark>> barStaves = marksPerBar.get(bar);
						if (barStaves == null) {
							barStaves = new HashMap<>();
							marksPerBar.put(bar, barStaves);
						}
						ArrayList<StaffMark> marks = barStaves.get(staff);
						if (marks == null) {
							marks = new ArrayList<>();
							barStaves.put(staff, marks);
						}
						marks.add(mark);
					}
				}
			}
		}
		
		/*attachmentsPerBar = new HashMap<>();
		if (song.getStaves() != null) {
			for (Staff staff: song.getStaves()) {
				if (!(staff instanceof AnalysisStaff)) {
					for (Attachment attachment: staff.getAttachments()) {
						Measure bar = song.getBarActiveAtTime(attachment.getCoreSymbol().getgetTime());
						HashMap<Staff, ArrayList<StaffMark>> barStaves = marksPerBar.get(bar);
						if (barStaves == null) {
							barStaves = new HashMap<>();
							marksPerBar.put(bar, barStaves);
						}
						ArrayList<StaffMark> marks = barStaves.get(staff);
						if (marks == null) {
							marks = new ArrayList<>();
							barStaves.put(staff, marks);
						marks.add(mark);
					}
				}
			}
		}		*/
	}

	public String exportSong() throws IM3Exception, ExportException {
		sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		sb.append("<mei xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"http://www.music-encoding.org/ns/mei\" meiversion=\""+VERSION+"\">\n");
		processHead(1);
		processBeforeMusic(1);
		processMusic(1);
		sb.append("</mei>\n");
		return sb.toString();
	}

	protected void processBeforeMusic(int tabs) throws ExportException {		
	}

	private void processHead(int tabs) {
		XMLExporterHelper.start(sb, tabs, "meiHead");
		processFileDesc(tabs+1);
		processEncodingDesc(tabs+1);
		processWorkDesc(tabs+1);
		XMLExporterHelper.end(sb, tabs, "meiHead");
	}
	

	private void processFileDesc(int tabs) {
		XMLExporterHelper.start(sb, tabs, "fileDesc");
		XMLExporterHelper.start(sb, tabs+1, "titleStmt");
		XMLExporterHelper.text(sb, tabs+2, "title", song.getTitle());
		XMLExporterHelper.end(sb, tabs+1, "titleStmt");
		XMLExporterHelper.end(sb, tabs, "fileDesc");		
	}

	
	private void processEncodingDesc(int tabs) {
		XMLExporterHelper.start(sb, tabs, "encodingDesc");
		XMLExporterHelper.start(sb, tabs+1, "appInfo");
		XMLExporterHelper.start(sb, tabs+2, "application");
		XMLExporterHelper.text(sb, tabs+3, "name", "imcore2");
		XMLExporterHelper.end(sb, tabs+2, "application");
		XMLExporterHelper.end(sb, tabs+1, "appInfo");
		XMLExporterHelper.end(sb, tabs, "encodingDesc");		
	}

	private void processWorkDesc(int tabs) {
		XMLExporterHelper.start(sb, tabs, "workDesc");
		XMLExporterHelper.start(sb, tabs+1, "work");
		XMLExporterHelper.start(sb, tabs+1, "titleStmt");
		XMLExporterHelper.text(sb, tabs+2, "title", song.getTitle());
		XMLExporterHelper.start(sb, tabs+2, "respStmt");
		List<Person> persons = song.getPersons();
		if (persons != null) {
			for (Person person: persons) {
				XMLExporterHelper.text(sb, tabs+3, "persName", person.getName(), "role", "composer");				
			}
		}
		
		XMLExporterHelper.end(sb, tabs+2, "respStmt");
		XMLExporterHelper.end(sb, tabs+1, "titleStmt");		
		XMLExporterHelper.end(sb, tabs+1, "work");
		XMLExporterHelper.end(sb, tabs, "workDesc");
		
	}
	
	private void processMusic(int tabs) throws IM3Exception, ExportException {
		XMLExporterHelper.start(sb, tabs, "music");
		XMLExporterHelper.start(sb, tabs+1, "body");
		XMLExporterHelper.start(sb, tabs+2, "mdiv");
		XMLExporterHelper.start(sb, tabs+3, "score");

		commonStartTimeSignature = findFirstTimeSignature();
		commonStartKeySignature = findFirstKeySignature();
		
		ArrayList<String> params = new ArrayList<>();
		Key commonKey;
		if (commonStartKeySignature != null) {
			commonKey = commonStartKeySignature.getConcertPitchKey();
		} else {
			commonKey = null;
		}
		processScoreDef(params, commonStartTimeSignature, commonKey, null);
		// nuevo
		XMLExporterHelper.start(sb, tabs+4, "scoreDef", params);
		processStaffDef(tabs+5);
		XMLExporterHelper.end(sb, tabs+4, "scoreDef");		
		// end nuevo
		
		processSections(tabs+4);		
		XMLExporterHelper.end(sb, tabs+3, "score");
		XMLExporterHelper.end(sb, tabs+2, "mdiv");
		XMLExporterHelper.end(sb, tabs+1, "body");
		XMLExporterHelper.end(sb, tabs, "music");
	}

	/**
	 * 
	 * @return null if two different key signatures
	 */
	private KeySignature findFirstKeySignature() {
		KeySignature ks = null;
		for (Staff staff: song.getStaves()) {
			KeySignature staffKS = staff.getKeySignatureWithOnset(Time.TIME_ZERO);
			if (ks == null) {
				ks = staffKS;
			} else if (!ks.getAccidentals().equals(staffKS.getAccidentals()) || ks.getInstrumentKey().getMode() != staffKS.getInstrumentKey().getMode()) {
				return null;
			}
		}
		return ks;
	}

	private TimeSignature findFirstTimeSignature() {
		TimeSignature ks = null;
		for (Staff staff: song.getStaves()) {
			TimeSignature staffKS = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);;
			if (ks == null) {
				ks = staffKS;
			} else if (!ks.equals(staffKS)) {
				return null;
			}
		}
		return ks;
	}

	private void processScoreDef(ArrayList<String> params, TimeSignature ts, Key key, Interval transpositionInterval) throws IM3Exception, ExportException {
		if (ts != null) {
			//TODO symbol (C, C/...) meters
			if (ts instanceof FractionalTimeSignature) {
				FractionalTimeSignature fm = (FractionalTimeSignature) ts;
				params.add("meter.count");
				params.add(Integer.toString(fm.getNumerator()));
				params.add("meter.unit");
				params.add(Integer.toString(fm.getDenominator()));
			} else if (ts instanceof TimeSignatureMensural) {
				processMensuralTimeSignature(ts, params);				
			} else if (ts instanceof TimeSignatureCommonTime) {
				params.add("meter.sym");
				params.add("common");
			} else if (ts instanceof TimeSignatureCutTime) {
				params.add("meter.sym");
				params.add("cut");
			} else {
				throw new ExportException("Unknown time signature type: " + ts);
			}
		}
		if (key != null) {
			params.add("key.sig");
			if (key.getAccidental() == Accidentals.FLAT) {
				params.add((-key.getFifths()) + "f"); //TODO ¿b o f?
			} else if (key.getAccidental() == Accidentals.SHARP) {
				params.add(key.getFifths() + "s");
			} else if (key.getAccidental() == null || key.getAccidental() == Accidentals.NATURAL) {
				params.add("0");
			} else {
				throw new ExportException("Unsupported key accidental: " + key.getAccidental());
			}
			params.add("key.mode");
			params.add(key.getMode().name().toLowerCase());
		}		
		
		if (transpositionInterval != null) {
			params.add("trans.diat");
			params.add(Integer.toString(-(transpositionInterval.getName()-1)));
			params.add("trans.semi");
			params.add(Integer.toString(transpositionInterval.getSemitones()));
		}
	}
	private void processSections(int tabs) throws IM3Exception, ExportException {		
		XMLExporterHelper.start(sb, tabs, "section");
		processSongWithoutBars(tabs+1); // e.g. mensural
		processMeasures(tabs+1); // CWMN
		XMLExporterHelper.end(sb, tabs, "section");
	}

	private void processFirstClef(Clef clef, ArrayList<String> params) throws ExportException {
		processClef(clef, params, "clef.");
	}
	
	private void processClefChange(Clef clef, ArrayList<String> params) throws ExportException {
		processClef(clef, params, "");
	}

	private void processClef(Clef clef, ArrayList<String> params, String prefix) throws ExportException {
		if (clef == null) {
			throw new ExportException("Clef is null");
		}
		params.add(prefix + "line");
		params.add(Integer.toString(clef.getLine()));
		params.add(prefix + "shape");
		params.add(clef.getNote().name().toUpperCase()); //TODO percusion, tabs
		if (clef.getOctaveChange() != 0) {
			params.add(prefix + "dis");
			params.add(Integer.toString(Math.abs(clef.getOctaveChange()*8)));
			params.add(prefix + "dis.place");
			if (clef.getOctaveChange() < 0) {
				params.add("below");
			} else {
				params.add("above");
			}
		}
	}
	private void processStaffDef(int tabs) throws ExportException, IM3Exception {
		lastClef = new HashMap<>();
		XMLExporterHelper.start(sb, tabs, "staffGrp");
		for (Staff staff: song.getStaves()) {
			if (!(staff instanceof AnalysisStaff)) {
				ArrayList<String> params = new ArrayList<>();
				params.add("n");
				params.add(getNumber(staff));
				Clef clef = staff.getClefAtTime(Time.TIME_ZERO);
				lastClef.put(staff, clef);
				processFirstClef(clef, params);
				params.add("lines");
				params.add(Integer.toString(staff.getLineCount()));
				if (staff.getName() != null) {
					params.add("label");
					params.add(staff.getName());
				}
				
				TimeSignature staffTS;
				if (commonStartTimeSignature == null) {
					staffTS = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
				} else {
					staffTS = null; // do not repeat
				}
				
				KeySignature staffKS;
				if (commonStartKeySignature == null) {
					staffKS = staff.getKeySignatureWithOnset(Time.TIME_ZERO);
				} else {
					staffKS = null;
				}
				
				if (staffTS != null || staffKS != null) {
					processScoreDef(params, staffTS, staffKS.getInstrumentKey(), staffKS.getTranspositionInterval());
					//XMLExporterHelper.startEnd(sb, tabs, "scoreDef", scoreDefParams);
				} 
				
				XMLExporterHelper.startEnd(sb, tabs+1, "staffDef", params);
			}
		}
		XMLExporterHelper.end(sb, tabs, "staffGrp");
	}
		
	private void processMensuralTimeSignature(TimeSignature meter, ArrayList<String> params) {
		//lastTimeSignature = meter;
		TimeSignatureMensural mm = (TimeSignatureMensural) meter;
		
		if (mm instanceof TimeSignatureProporcionMenor) {
			params.add("meter.sym");
			params.add("cz"); //TODO David
		} else {
			if (mm.getModusMaior() != null) {
				params.add("modusmaior");
				params.add(mensuralTimeSignaturePerfectionToNumber(mm.getModusMaior()));
			}
			if (mm.getModusMinor() != null) {
				params.add("modusminor");
				params.add(mensuralTimeSignaturePerfectionToNumber(mm.getModusMinor()));
			}
			if (mm.getTempus() != null) {
				params.add("tempus");
				params.add(mensuralTimeSignaturePerfectionToNumber(mm.getTempus()));
			}
			if (mm.getProlatio() != null) {
				params.add("prolatio");
				params.add(mensuralTimeSignaturePerfectionToNumber(mm.getProlatio()));
			}
		}
	}

	private String mensuralTimeSignaturePerfectionToNumber(Perfection p) {
		if (p == Perfection.imperfectum) {
			return "2";
		} else if (p == Perfection.perfectum) {
			return "3";
		} else {
			throw new IM3RuntimeException("Invalid perfection: '" + p + "'");
		}
	}

	/*class SymbolsInStavesAndLayers {
		HashMap<Staff, HashMap<ScoreLayer, ArrayList<LayeredCoreSymbol>>> symbols;
		
		public SymbolsInStavesAndLayers() {
			symbols = new HashMap<>();
		}
		
		private ArrayList<LayeredCoreSymbol> getSymbolsInLayer(HashMap<ScoreLayer, ArrayList<LayeredCoreSymbol>> map, ScoreLayer layer) {
			ArrayList<LayeredCoreSymbol> result = map.get(layer);
			if (result == null) {
				result = new ArrayList<>();
				map.put(layer, result);
			}
			return result;			
		}
		public ArrayList<LayeredCoreSymbol> getSymbolsInLayer(Staff staff, ScoreLayer layer) {
			HashMap<ScoreLayer, ArrayList<LayeredCoreSymbol>> map = symbols.get(staff);
			if (map == null) {
				map = new HashMap<>();
				symbols.put(staff, map);
			}
			return getSymbolsInLayer(map, layer);			
		}

		public HashMap<Staff, HashMap<ScoreLayer, ArrayList<LayeredCoreSymbol>>> getSymbols() {
			return symbols;
		}
	}
	
	private int indexOfBarAtTime(Time time) throws ExportException, IM3Exception {
		Measure bar = song.getBarActiveAtTime(time);
		if (bar == null) {
			throw new ExportException("No bar found for time " + time);
		}
		return bar.getNumber();
	}*/
	
	private void processMeasures(int tabs) throws IM3Exception, ExportException {
		if (song.hasMeasures()) {
			ArrayList<Measure> bars = song.getMeasuresSortedAsArray();
			Key lastKey = null;
			TimeSignature lastTimeSignature = null;
			boolean firstMeasure = true;
			for (Measure bar : bars) {
				//TODO xmlid
				boolean processScoreDef = false;
				
				//boolean differentKeysInStaves = false;
				Key barKey = null;
				try {
					barKey = song.getUniqueKeyWithOnset(bar.getTime());
				} catch (IM3Exception e) {
					//differentKeysInStaves = true;
					throw new IM3Exception("Unsupported MEI exporting of staves with different concert pitch (sounded, not written) keys", e);
				}
				
				if (lastKey == null || barKey != null && !barKey.equals(lastKey)) {
					processScoreDef = true;
				}
				TimeSignature barTimeSignature = null;
				try {
					barTimeSignature = song.getUniqueMeterWithOnset(bar.getTime());
				} catch (IM3Exception e) {
					// when multimeter music
				}
				if (lastTimeSignature == null || barTimeSignature != null && !barTimeSignature.equals(lastTimeSignature)) {
					processScoreDef = true;
				}
				
				if (processScoreDef) {
					ArrayList<String> params = new ArrayList<>();
					processScoreDef(params, barTimeSignature, barKey, null);	
					if (!params.isEmpty()) {
						XMLExporterHelper.startEnd(sb, tabs, "scoreDef", params);
					}
				} 
				
				//TODO metcon is also used to express incomplete or exceeding duration measures
				if (song.isAnacrusis() && firstMeasure) {
					XMLExporterHelper.start(sb, tabs, "measure", "n", 
							Integer.toString(bar.getNumber()), "xml:id", 
							generateID(bar, false),  "metcon", "false");					
				} else {
					XMLExporterHelper.start(sb, tabs, "measure", "n", 
							Integer.toString(bar.getNumber()), "xml:id", 
							generateID(bar, false));
				}
				firstMeasure = false;
	
				//FRACCIONES barConnectors = new ArrayList<>();
				
				//SymbolsInStavesAndLayers symbolsInBar = new SymbolsInStavesAndLayers();
				for (Staff staff: song.getStaves()) {
					if (!(staff instanceof AnalysisStaff) && staff.getNotationType() == NotationType.eModern) { // && bar.contains(staff)) {
						XMLExporterHelper.start(sb, tabs+1, "staff", "n", getNumber(staff));
						for (ScoreLayer layer: staff.getLayers()) {
							XMLExporterHelper.start(sb, tabs+2, "layer", "n", getNumber(layer));
							processBarLayer(tabs+3, bar, staff, layer); //TODO que no salga si en la capa no hay nada
							XMLExporterHelper.end(sb, tabs+2, "layer");
						}
						processBar(tabs+2, bar, staff);
						XMLExporterHelper.end(sb, tabs+1, "staff");
					} 
				}
				
				// connectors
				// all of theses should already be inserter for (Connector connector: song.getConnectors()) {
				
				/*FRACCIONES  for (ConnectorWithLayer connector: barConnectors) {
					generateConnector(tabs, bar, connector.getConnector(), connector.getLayer().getStaff(), connector.getLayer());
				}*/
				
				XMLExporterHelper.end(sb, tabs, "measure");
				lastKey = barKey;
				lastTimeSignature = barTimeSignature;
			}
		}
	}

	private void processBar(int tabs, Measure bar, Staff staff) throws IM3Exception, ExportException {
		// now add all marks
		HashMap<Staff, ArrayList<StaffMark>> mpb = marksPerBar.get(bar);
		if (mpb != null) { // not all bars have marks
			ArrayList<StaffMark> marks = mpb.get(staff);
			if (marks != null) {
				for (StaffMark staffMark: marks) {
					String text = generateTextForStaffMark(staffMark);
					if (text != null) {
						XMLExporterHelper.text(sb, tabs, "dynam", text, "staff", getNumber(staff), "tstamp", generateTStamp(bar, staffMark.getTime()));
					} // else ledger lines... that we don't export
				}
			}
		}
		//barConnectors
	}

	
	private String getNumber(Staff staff) {
		return Integer.toString(staff.getNumberIdentifier());
	}

	private String getNumber(ScoreLayer layer) {
		return Integer.toString(layer.getNumber());
	}
	
	/*FRACCIONES private void generateConnector(int tabs, Measure bar, Connector<?,?> connector, Staff staff, ScoreLayer layer) throws ExportException, IM3Exception {
		if (connector instanceof Slur) {
			if (!(connector.getFrom() instanceof ITimedElement)) {
				throw new ExportException("Cannot export a slur linked to a non timed element");
			}
			if (!(connector.getTo() instanceof ITimedElement)) {
				throw new ExportException("Cannot export a slur linked to a non timed element");
			}
			ArrayList<String> params = new ArrayList<>();
			params.add("staff");
			params.add(getNumber(staff));
			params.add("layer");
			params.add(getNumber(layer));
			//String tstamp = generateTStamp(bar, ((ITimedElement)connector.getFrom()).getTime());
			//String tstamp2 = generateTStamp2(bar, ((ITimedElement)connector.getTo()).getTime()); //TODO ¿end time?
			//params.add("tstamp");
			//params.add(tstamp);
			//params.add("tstamp2");
			p//arams.add(tstamp2);
			params.add("startid");
			params.add(generateID(connector.getFrom()));
			params.add("endid");
			params.add(generateID(connector.getTo()));
			XMLExporterHelper.startEnd(sb, tabs, "slur", params);
		} else if (connector instanceof Tie) {
			//TODO TIE
			System.err.println("TO-DO Tie");
		} else if (connector instanceof Wedge) {
			String tstamp = generateTStamp(bar, ((ITimedElement)connector.getFrom()).getTime());
			String tstamp2 = generateTStamp2(bar, ((ITimedElement)connector.getTo()).getTime());
			ArrayList<String> params = new ArrayList<>();
			params.add("staff");
			params.add(getNumber(staff));
			params.add("layer");
			params.add(getNumber(layer));			
			params.add("tstamp");
			params.add(tstamp);
			params.add("tstamp2");
			params.add(tstamp2);
			params.add("form");
			if (connector instanceof DynamicCrescendo) {
				params.add("cres");
			} else if (connector instanceof DynamicDiminuendo) {
				params.add("dim");
			} else {
				throw new ExportException("Cannot export class: " + connector.getClass());
			}
			XMLExporterHelper.startEnd(sb, tabs, "hairpin", params);
			
		} else if (!(connector instanceof Beam)) {
			throw new UnsupportedOperationException("Unsupported exporting " + connector.getClass());
		} 
	}*/

	private String generateID(IUniqueIDObject symbol, boolean reference) {
		if (reference) {
			return "#" + song.getIdManager().getID(symbol);
		} else {
			return song.getIdManager().getID(symbol);
		}
	}
	
	private void processSongWithoutBars(int tabs) throws ExportException, IM3Exception {
		// order notes, key changes and meter changes, then process them		
		for (int il=0; il<song.getStaves().size(); il++) {
			Staff staff = song.getStaves().get(il);
			//TODO En processWithBars hemos preguntado por si el staff está entre los staves del bar
			if (staff.getNotationType() == NotationType.eMensural) { 
				boolean firstLayer = true;
				if (!(staff instanceof AnalysisStaff)) {
					List<ITimedElementInStaff> staffSymbols = new ArrayList<>();
					for (Clef clef: staff.getClefs()) {
						if (!clef.getTime().isZero()) {
							staffSymbols.add(clef);
						}
					}
					for (TimeSignature ts: staff.getTimeSignatures()) {
						if (commonStartTimeSignature != null && !ts.getTime().isZero()) {
							staffSymbols.add(ts); // the first one is exported in staffDef or scoreDef
						}
					}
					for (KeySignature ks: staff.getKeySignatures()) {
						if (commonStartKeySignature != null && !ks.getTime().isZero()) {
							staffSymbols.add(ks); // the first one is exported in staffDef or scoreDef
						}
					}
					
					XMLExporterHelper.start(sb, tabs, "staff", "n", getNumber(staff));
					for (ScoreLayer layer: staff.getLayers()) {
						List<ITimedElement> symbols = new ArrayList<>();
						for (int i=0; i<layer.size(); i++) {
							symbols.add(layer.getAtom(i));
						}
						XMLExporterHelper.start(sb, tabs+1, "layer", "n", getNumber(layer));
						if (firstLayer) { 
							firstLayer = false;
							symbols.addAll(staffSymbols);
						}					
						Collections.sort(symbols, ITimedElement.TIMED_ELEMENT_COMPARATOR);
						for (ITimedElement slr : symbols) {
							if (slr instanceof Clef) { 
								ArrayList<String> params = new ArrayList<>();
								processClefChange((Clef) slr, params);
								XMLExporterHelper.startEnd(sb, tabs+2, "clef", params);							
								lastClef.put(staff, (Clef) slr);
							} else if (slr instanceof TimeSignature) {
								//TODO ¿habrá que mejor coger el TimeSignature por el @sign...
								processTimeSignature(tabs+2, (TimeSignature) slr);
							} else if (slr instanceof KeySignature) {
								throw new UnsupportedOperationException("TO-DO Key change");
							} else if (slr instanceof Atom) {
								processAtom(tabs+2, (Atom) slr, staff);								
							} else {
								throw new ExportException("Unsupported symbol type for export: '" + slr.getClass() + "'");
							}
						}
						XMLExporterHelper.end(sb, tabs+1, "layer");
					}
					XMLExporterHelper.end(sb, tabs, "staff");
				}
			}
		}
	}


	private void processTimeSignature(int tabs, TimeSignature timeSignature) {
		if (timeSignature instanceof TimeSignatureMensural) {
			ArrayList<String> params = new ArrayList<>();
			processMensuralTimeSignature(timeSignature, params);
			XMLExporterHelper.startEnd(sb, tabs, "mensur", params);
		} else {
			throw new UnsupportedOperationException("TO-DO Modern meter change");
		}
	}

	private void processBarLayer(int tabs, Measure bar, Staff staff, ScoreLayer layer) throws ExportException, IM3Exception {		
		//TODO se podría optimizar más, pero no sé si vale la pena para 10 símbolos por compás...
		List<Atom> atoms = layer.getAtomsWithOnsetWithin(bar);
		for (Atom atom: atoms) {
			Clef clefForSymbol = staff.getRunningClefAt(atom.getTime());
			if (!lastClef.get(staff).equals(clefForSymbol)) {
				ArrayList<String> params = new ArrayList<>();
				processClefChange(clefForSymbol, params);					
				//double timeStamp = (double) (bar.getTime() - clefForSymbol.getTime()) / (double) AbstractSong.DEFAULT_RESOLUTION;
				params.add("tstamp");
				params.add(generateTStamp(bar, clefForSymbol.getTime()));
				XMLExporterHelper.startEnd(sb, tabs, "clef", params);
				
				lastClef.put(staff, clefForSymbol);
			}
			processAtom(tabs, atom, staff); //TODO ¿Siempre vale?				
		}
		
		// process non durational symbols
		/*FRACCIONES List<StaffTimedPlaceHolder> placeHolders = layer.getStaffPlaceHoldersWithOnsetWithin(bar);
		for (StaffTimedPlaceHolder staffTimedPlaceHolder : placeHolders) {
			addConnectors(staffTimedPlaceHolder, staffTimedPlaceHolder.getLayer());
		}*/
	}
	
	private String generateTextForStaffMark(StaffMark staffMark) {
		if (staffMark instanceof DynamicMark) {
			return ((DynamicMark)staffMark).getText();
		} else if (!(staffMark instanceof LedgerLines)) {
			throw new UnsupportedOperationException("TO-DO: text for dynamics for class " + staffMark.getClass());
		} else {
			return null;
		}
	}

	public static String generateTStamp(Measure bar, Time time) throws IM3Exception, ExportException {
		double tstamp = time.substract(bar.getTime()).getComputedTime(); 
		if (tstamp < 0) {
			throw new ExportException("Invalid negative tstamp: " + tstamp + ", from time=" + time + " in bar " + bar + " of time " + bar.getTime());
		}
		if (decimalFormat == null) {
			decimalFormat = new DecimalFormat();
			decimalFormat.setMinimumFractionDigits(0);
			decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
		}
		return decimalFormat.format(tstamp+1);
	}

	public static String generateTStamp2(Measure bar, Time time) throws IM3Exception, ExportException {
		Measure destBar = bar.getSong().getMeasureActiveAtTime(time);
		int barsCrossed = destBar.getNumber() - bar.getNumber();
		StringBuilder sb = new StringBuilder();
		sb.append(barsCrossed);
		sb.append('m');
		sb.append('+');
		sb.append(generateTStamp(destBar, time));
		return sb.toString();
	}

	// could be more ellegant !!
	private String getFigureMEIDur(Figures figure) throws ExportException {
		switch (figure) {
			case MAXIMA: return "maxima";
			case LONGA: return "longa"; 
			case BREVE: return "brevis";
			case SEMIBREVE: return "semibrevis";
			case MINIMA: return "minima";
			case SEMINIMA: return "semiminima";
			case FUSA: return "fusa";
			case SEMIFUSA: return "semifusa";
			case QUADRUPLE_WHOLE: return "long";
			case DOUBLE_WHOLE: return "breve";
			case WHOLE: return "1";
			case HALF: return "2";
			case QUARTER: return "4";
			case EIGHTH: return "8";
			case EIGTHEEN: return "16";
			case THIRTY_SECOND: return "32";
			case SIXTY_FOURTH: return "64";
			case TWO_HUNDRED_FIFTY_SIX: return "128";
			default: 
				throw new ExportException("Unsupported figure: " + figure);
			
		}
	}
	
	
	private void fillDurationParams(AtomFigure atomFigure, ArrayList<String> params) throws ExportException {
		params.add("dur");
		if (atomFigure.getFigure() == null) {
			throw new ExportException("Durational symbol has not a figure: " + atomFigure);
		}
		params.add(getFigureMEIDur(atomFigure.getFigure()));
		if (atomFigure.getDots() > 0) {
			params.add("dots");
			params.add(Integer.toString(atomFigure.getDots()));
		}
		if (atomFigure.getIrregularGroupActualFigures() != null) {
			params.add("num");
			params.add(atomFigure.getIrregularGroupActualFigures().toString());
		}
		if (atomFigure.getIrregularGroupInSpaceOfFigures() != null) {
			params.add("numbase");
			params.add(atomFigure.getIrregularGroupInSpaceOfFigures().toString());
		}
		if (atomFigure.hasColoration()) {
			params.add("colored");
			params.add(Boolean.toString(atomFigure.isColored()));			
		}
	}
	
	private void processAtom(int tabs, Atom atom, Staff defaultStaff) throws ExportException, IM3Exception {
		ArrayList<String> params = new ArrayList<>();
		params.add("xml:id");
		params.add(generateID(atom, false));
		
		if (defaultStaff == null) {
			throw new IM3RuntimeException("The defaultStaff is null");
		}
		if (atom.getStaff() == null) {
			throw new IM3RuntimeException("The staff of " + atom + "  is null");
		}
		if (atom.getStaff() != defaultStaff) {
			params.add("staff");
			params.add(getNumber(atom.getStaff()));
		}

		//TODO URGENT Tuplets
		if (atom instanceof SingleFigureAtom) {
			if (atom instanceof SimpleMeasureRest) {			
				SimpleMeasureRest mrest = (SimpleMeasureRest) atom;
				if (mrest.getAtomFigure().getFigure() != Figures.WHOLE) { // e.g. for anacrusis
					SingleFigureAtom sfatom = (SingleFigureAtom) atom;
					fillDurationParams(sfatom.getAtomFigure(), params);
				} 
				XMLExporterHelper.startEnd(sb, tabs, "mRest", params); //TODO Multimeasure rest
			} else {
				SingleFigureAtom sfatom = (SingleFigureAtom) atom;
				fillDurationParams(sfatom.getAtomFigure(), params);
				if (atom instanceof SimpleRest) {			
					XMLExporterHelper.startEnd(sb, tabs, "rest", params); 
				} else if (atom instanceof SimpleChord) {
					XMLExporterHelper.start(sb, tabs, "chord", params);
					processPitches(sb, tabs, sfatom.getAtomFigure(), atom.getAtomPitches(), params);
					//TODO Ties en chords
					XMLExporterHelper.end(sb, tabs, "chord");
				} else if (atom instanceof SimpleNote) {
					processPitches(sb, tabs-1, sfatom.getAtomFigure(), atom.getAtomPitches(), params); // -1 because process pitches adds 1
				} else {
					throw new UnsupportedOperationException("Unsupported yet: " + atom.getClass());
				}
			}
		} else if (atom instanceof BeamGroup) {
				XMLExporterHelper.start(sb, tabs, "beam", params);
				BeamGroup beam = (BeamGroup) atom;
				for (Atom beamAtom: beam.getAtoms()) {
					processAtom(tabs, beamAtom, defaultStaff);
				}
				XMLExporterHelper.end(sb, tabs, "beam");				
		} else if (atom instanceof SimpleTuplet) {
				SimpleTuplet tuplet = (SimpleTuplet) atom;
				params.add("num");
				params.add(Integer.toString(tuplet.getNumAtoms()));
				params.add("numbase");
				params.add(Integer.toString(tuplet.getInSpaceOfAtoms()));
				XMLExporterHelper.start(sb, tabs, "tuplet", params);
				for (Atom tupletAtom: tuplet.getAtoms()) {
					processAtom(tabs+1, tupletAtom, defaultStaff);
				}
				XMLExporterHelper.end(sb, tabs, "tuplet");				
		} else {
			throw new UnsupportedOperationException("Unsupported yet: " + atom.getClass());
		}
		
		//TODO Beams...

		
	}

	private void processPitches(StringBuilder sb, int tabs, AtomFigure atomFigure, List<AtomPitch> atomPitches, ArrayList<String> params) throws ExportException {
		if (atomPitches != null) {
			boolean multiplePitches = atomPitches.size() > 1;
			for (AtomPitch atomPitch: atomPitches) {
				ArrayList<String> noteParams = new ArrayList<>();
				if (multiplePitches) {
					noteParams.add("xml:id");
					noteParams.add(generateID(atomPitch, false));
				}
				for (int i=0; i<params.size()-1; i+=2) {
					if (!params.get(i).equals("xml:id") || !multiplePitches) {
						noteParams.add(params.get(i));
						noteParams.add(params.get(i+1));
					}
				}
				
				/*if (!multiplePitches) {
					fillDurationParams(atomFigure, noteParams);
				}*/
				processPitchesParams(atomPitch, noteParams, atomFigure.getLayer());
				XMLExporterHelper.startEnd(sb, tabs+1, "note", noteParams);				
			}
		}
		/*if (atomPitches.getContinuationPitches() != null) {
			for (AtomContinuationPitch atomContPitch: atomPitches.getContinuationPitches()) {
				ArrayList<String> noteParams = new ArrayList<>();
				noteParams.add("xml:id");
				noteParams.add(generateID(atomContPitch));
				if (generateDurations) {
					fillDurationParams(atomPitches, noteParams);
				}				
				processPitchesParams(atomContPitch.getFromPitch(), false, true, noteParams, atomPitches.getLayer());
				XMLExporterHelper.startEnd(sb, tabs+1, "note", noteParams);				
			}
		}
		addConnectors(atomPitches, atomPitches.getLayer()); //TODO*/ 
	}

	/*FRACTIONS private void addNoteTies(AtomFigure note, ArrayList<String> params) {
		//TODO esto es con los acordes, con las notas estamos repitiendo lo mismo (ver processPitchesParams)
		if (note.getTiedToNext() != null) {
			params.add("tie");
			params.add("i");
		} else if (note.getTiedFrom() != null) {
			params.add("tie");
			params.add("t"); //TO-DO from + to --> "m"			
		}
	}*/

	private void addConnectors(ISymbolWithConnectors symbol, ScoreLayer layer) {
		//System.out.println("Adding: " + symbol + "---" + symbol.getConnectors());
		/*FRACCIONES if (symbol.getConnectors() != null) {
			for (Connector<?,?> connector: symbol.getConnectors()) {
				//System.out.println("\t" + connector.getClass());
				if (connector.getFrom() == symbol) {				
					barConnectors.add(new ConnectorWithLayer(connector, layer));
				}
			}
		}*/
		
	}
	private void processPitchesParams(AtomPitch atomPitch, ArrayList<String> params, ScoreLayer layer) throws ExportException {
		//TODO addConnectors(atomPitch.getAtomFigure(), layer);
		
		if (atomPitch.getStaffChange() != null) {
			params.add("staff");
			params.add(getNumber(atomPitch.getStaffChange()));
		}
		
		ScientificPitch scorePitch = atomPitch.getScientificPitch();
		params.add("pname");
		params.add(scorePitch.getPitchClass().getNoteName().name().toLowerCase());
		params.add("oct");
		params.add(Integer.toString(scorePitch.getOctave()));
		if (scorePitch.getPitchClass().getAccidental() != null &&
				scorePitch.getPitchClass().getAccidental() != Accidentals.NATURAL
				) {
				//(atomPitch.isForcePaintAccidental() || scorePitch != null)) {
			params.add("accid.ges");
			params.add(generateAccidental(scorePitch.getPitchClass().getAccidental()));
		}
		
		if (atomPitch.getWrittenExplicitAccidental() != null) {
			params.add("accid");
			params.add(generateAccidental(atomPitch.getWrittenExplicitAccidental()));			
		}
		//TODO esto es con los acordes, con las notas estamos repitiendo lo mismo ? ¿Lo dejamos así?
		if (atomPitch.isTiedToNext() && atomPitch.isTiedFromPrevious()) {
			params.add("tie");
			params.add("m");			
		} else if (atomPitch.isTiedToNext()) {
			params.add("tie");
			params.add("i");
		} else if (atomPitch.isTiedFromPrevious()) {
			params.add("tie");
			params.add("t"); //TO-DO from + to --> "m"			
		}
	}

	private String generateAccidental(Accidentals accidental) throws ExportException {
		switch (accidental) {
		case DOUBLE_FLAT: 
			return "ff"; 
		case FLAT: 
			return "f";
		case NATURAL: 
			return "n"; 
		case SHARP:
			return "s";
		case DOUBLE_SHARP:
			return "ss";
		case TRIPLE_FLAT:
			return "tf";
		default:
				throw new ExportException("Unsupported accidental: "+ accidental);
		}
	}

	public ScoreSong getSong() {
		return song;
	}

	

}
