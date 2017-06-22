package es.ua.dlsi.im3.core.score.io.kern;

import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.clefs.ClefF4;
import es.ua.dlsi.im3.core.score.clefs.ClefG2;
import es.ua.dlsi.im3.core.score.meters.FractionalTimeSignature;
import es.ua.dlsi.im3.core.score.staves.AnalysisStaff;
import es.ua.dlsi.im3.io.ExportException;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by drizo on 8/6/17.
 */
public class KernExporter {
    private ScoreSong song;
    protected StringBuilder sb;

    public void exportSong(File file, ScoreSong song) throws ExportException {
        PrintStream ps = null;
        try {
            ps = new PrintStream(file, "UTF-8");
            ps.print(exportSong(song));
        } catch (Exception e) {
            throw new ExportException(e);
        }
        if (ps != null) {
            ps.close();
        }
    }

    public String exportSong(ScoreSong song) throws ExportException, IM3Exception {
        sb = new StringBuilder();
        this.song = song;

        printHeader();
        printContent();

        return sb.toString();
    }

    private void printHeader() throws ExportException {
        // now export staves
        boolean first = true;
        for (Staff staff : song.getStaves()) {
            if (!first) {
                sb.append('\t');
            } else {
                first = false;
            }
            sb.append("**kern");
        }
        sb.append('\n');

        first = true;
        for (Staff staff : song.getStaves()) {
            if (!first) {
                sb.append('\t');
            } else {
                first = false;
            }

            //TODO Clef changes -- ordenar - hacer lo mismo que en la exportación de MEI
            Clef clef = staff.getClefAtTime(Time.TIME_ZERO);
            sb.append('*');
            sb.append(generateClef(clef));
        }
        sb.append('\n');

        first = true;
        for (Staff staff : song.getStaves()) {
            if (!first) {
                sb.append('\t');
            } else {
                first = false;
            }

            //TODO Key changes -- ordenar - hacer lo mismo que en la exportación de MEI
            KeySignature ks = staff.getKeySignatureWithOnset(Time.TIME_ZERO);
            sb.append('*');
            sb.append(generateKeySignature(ks));

        }
        sb.append('\n');

        first = true;
        for (Staff staff : song.getStaves()) {
            if (!first) {
                sb.append('\t');
            } else {
                first = false;
            }

            //TODO Meter changes -- ordenar - hacer lo mismo que en la exportación de MEI
            TimeSignature ts = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
            sb.append('*');
            sb.append(generateTimeSignature(ts));

        }
        sb.append('\n');
    }

    private String generateTimeSignature(TimeSignature ts) throws ExportException {
        if (ts instanceof FractionalTimeSignature) {
            FractionalTimeSignature meter = (FractionalTimeSignature) ts;
            StringBuilder sb = new StringBuilder();
            sb.append('M');
            sb.append(meter.getNumerator());
            sb.append('/');
            sb.append(meter.getDenominator());
            return sb.toString();
        } else {
            throw new ExportException("Unsupported time signature type: " + ts.getClass());
        }
    }

    private String generateKeySignature(KeySignature ks) throws ExportException {
        StringBuilder sb = new StringBuilder();
        sb.append('k');
        sb.append('[');
        for (KeySignatureAccidentalElement acc : ks.getAccidentals()) {
            sb.append(acc.getNoteName().name().toLowerCase());
            sb.append(generateAccidental(acc.getAccidental()));
        }
        sb.append(']');
        return sb.toString();
    }

    private String generateClef(Clef clef) throws ExportException {
        if (clef instanceof ClefG2) {
            return "clefG2";
        } else if (clef instanceof ClefF4) {
            return "clefF4";
        } else {
            throw new ExportException("Unimplemented export of clef " + clef.getClass());
        }
    }

    //TODO URGENT Ahora sólo saco una voz!!! - luego habrá que sacar la figura mínima, etc....
    private void printContent() throws IM3Exception, ExportException {
        ArrayList<Measure> bars = song.getMeasuresSortedAsArray();
        Key lastKey = null;
        TimeSignature lastTimeSignature = null;
        boolean firstMeasure = true;

        sb.append("=-\n");
        for (int ibar = 0; ibar < bars.size(); ibar++) {
            Measure bar = bars.get(ibar);
            /*TODO
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
            firstMeasure = false;*/

            //FRACCIONES barConnectors = new ArrayList<>();

            //SymbolsInStavesAndLayers symbolsInBar = new SymbolsInStavesAndLayers();
            for (Staff staff : song.getStaves()) {
                for (ScoreLayer layer : staff.getLayers()) {
                    processBar(bar, staff, layer);
                }
            }

            if (ibar < bars.size() - 1) {
                sb.append("=\n");
            } else {
                sb.append("*-");
            }


            // connectors
            // all of theses should already be inserter for (Connector connector: song.getConnectors()) {

				/*FRACCIONES  for (ConnectorWithLayer connector: barConnectors) {
					generateConnector(tabs, bar, connector.getConnector(), connector.getLayer().getStaff(), connector.getLayer());
				}*/

            //lastKey = barKey;
            //lastTimeSignature = barTimeSignature;
        }
    }

    private void processBar(Measure bar, Staff staff, ScoreLayer layer) throws IM3Exception, ExportException {
        //TODO se podría optimizar más, pero no sé si vale la pena para 10 símbolos por compás...
        List<Atom> atoms = layer.getAtomsWithOnsetWithin(bar);
        for (Atom atom: atoms) {
            /*Clef clefForSymbol = staff.getRunningClefAt(atom.getTime());
            if (!lastClef.get(staff).equals(clefForSymbol)) {
                ArrayList<String> params = new ArrayList<>();
                processClefChange(clefForSymbol, params);
                //double timeStamp = (double) (bar.getTime() - clefForSymbol.getTime()) / (double) AbstractSong.DEFAULT_RESOLUTION;
                params.add("tstamp");
                params.add(generateTStamp(bar, clefForSymbol.getTime()));
                XMLExporterHelper.startEnd(sb, tabs, "clef", params);

                lastClef.put(staff, clefForSymbol);
            }*/
            processAtom(atom, staff); //TODO ¿Siempre vale?
        }

        // process non durational symbols
		/*FRACCIONES List<StaffTimedPlaceHolder> placeHolders = layer.getStaffPlaceHoldersWithOnsetWithin(bar);
		for (StaffTimedPlaceHolder staffTimedPlaceHolder : placeHolders) {
			addConnectors(staffTimedPlaceHolder, staffTimedPlaceHolder.getLayer());
		}*/

    }

    private String generateDuration(AtomFigure figure) {
        return Integer.toString(figure.getFigure().getMeterUnit()); //TODO puntillos
    }

    private String generatePitch(AtomPitch pitch) throws ExportException {
        StringBuilder sb = new StringBuilder();
        sb.append(pitch.getScientificPitch().getPitchClass().getNoteName().name().toLowerCase()); //TODO octavas
        if (pitch.getScientificPitch().getPitchClass().isAltered()) {
            sb.append(generateAccidental(pitch.getScientificPitch().getPitchClass().getAccidental()));
        }
        return sb.toString();
    }

    private char generateAccidental(Accidentals accidental) throws ExportException {
        if (accidental.equals(Accidentals.SHARP)) {
            return '#';
        } else if (accidental.equals(Accidentals.FLAT)) {
            return '-';
        } else {
            throw new ExportException("Unsupported accidental in key signature: " + accidental);
        }

    }

    private void processAtom(Atom atom, Staff staff) throws ExportException {
        //TODO - coger de MEIExporter
        if (atom instanceof SimpleNote) {
            sb.append(generateDuration(((SimpleNote) atom).getAtomFigure()));
            sb.append(generatePitch(((SimpleNote) atom).getAtomPitch()));
        } else if (atom instanceof SimpleRest) {
            sb.append(generateDuration(((SimpleRest) atom).getAtomFigure()));
            sb.append('r');
        } else {
            throw new ExportException("Unsupported atom type: " + atom.getClass().getName());
        }
        sb.append("/\n");
    }
}