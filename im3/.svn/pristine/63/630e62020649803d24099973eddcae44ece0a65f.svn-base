package es.ua.dlsi.im3.core.score.io.kern;

import com.sun.org.apache.xpath.internal.operations.Equals;
import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.TestFileUtils;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.clefs.ClefG2;
import es.ua.dlsi.im3.core.score.io.XMLExporterImporterTest;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.core.score.io.musicxml.MusicXMLImporter;
import es.ua.dlsi.im3.core.score.meters.FractionalTimeSignature;
import es.ua.dlsi.im3.io.ImportException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.function.Function;

/**
 * TODO Exportación hacer lo mismo que con MusicXML + MEI
 * @author drizo
 */
public class KernImporterTest {
    boolean testExportImport = true;

    private ScoreSong importMusicXML(File file) throws ImportException {
        MusicXMLImporter importer = new MusicXMLImporter();
        ScoreSong song = importer.importSong(file);
        return song;
    }

    private ScoreSong importKern(File file) throws ImportException {
        KernImporter importer = new KernImporter();
        ScoreSong song = importer.importSong(file);
        return song;
    }

    private void doTest(Function<ScoreSong, Void> validationFunction, ScoreSong song) throws Exception {
        validationFunction.apply(song);
        KernExporter exporter = new KernExporter();
        //File file = File.createTempFile("export", "mei");
        File file = new File("/tmp/aa.krn");
        exporter.exportSong(file, song);

        if (testExportImport) {
            ScoreSong importedSong = importKern(file);
            validationFunction.apply(importedSong);
        }
    }

    // ------------------------------------------------------------------------------------------
    private static Void assertGuideExample2_1(ScoreSong song) {
        try {
            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.F.getPitchClass(), ks.getPitchClass());
            //assertEquals(Mode.MAJOR, ks.getMode()); The krn does not specify it

            assertEquals(1, song.getStaves().size());
            Staff staff = song.getStaves().get(0);
            assertTrue(staff.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);

            TimeSignature ts = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
            assertTrue(ts instanceof FractionalTimeSignature);
            FractionalTimeSignature meter = (FractionalTimeSignature) ts;
            assertEquals(2, meter.getNumerator());
            assertEquals(2, meter.getDenominator());
            List<Atom> atoms = staff.getAtoms();
            assertEquals(9, atoms.size());

            assertEquals(4, song.getMeaureCount());

            assertTrue(atoms.get(8) instanceof SimpleRest);

            SimpleNote n0 = (SimpleNote) atoms.get(0);
            assertEquals(PitchClasses.D.getPitchClass(), n0.getPitch().getPitchClass());
            assertEquals(4, n0.getPitch().getOctave());
            assertEquals(Figures.HALF, n0.getAtomFigure().getFigure());
            assertEquals(0, n0.getAtomFigure().getDots());
            assertEquals(0.0, n0.getTime().getComputedTime(), 0.0001);

            assertEquals(2.0, atoms.get(1).getTime().getComputedTime(), 0.0001);

            SimpleNote n4 = (SimpleNote) atoms.get(4);
            assertEquals(PitchClasses.C_SHARP.getPitchClass(), n4.getPitch().getPitchClass());
            assertEquals(4, n4.getPitch().getOctave());

            SimpleNote n5 = (SimpleNote) atoms.get(5);
            assertEquals(PitchClasses.D.getPitchClass(), n5.getPitch().getPitchClass());
            assertEquals(4, n5.getPitch().getOctave());
            assertEquals(Figures.QUARTER, n5.getAtomFigure().getFigure());
            assertEquals(0, n5.getAtomFigure().getDots());


        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
        return null;
    }


    @Test
    public void testGuideExample2_1() throws Exception {
        doTest(KernImporterTest::assertGuideExample2_1, importMusicXML(TestFileUtils.getFile("/testdata/score/io/kern/guide02-example2-1.xml")));
        doTest(KernImporterTest::assertGuideExample2_1, importKern(TestFileUtils.getFile("/testdata/score/io/kern/guide02-example2-1.krn")));
    }

}