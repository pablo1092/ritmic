// Generated from es\u005Cua\dlsi\im3\io\kern\kern.g4 by ANTLR 4.7
package es.ua.dlsi.im3.io.kern;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link kernParser}.
 */
public interface kernListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link kernParser#song}.
	 * @param ctx the parse tree
	 */
	void enterSong(kernParser.SongContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#song}.
	 * @param ctx the parse tree
	 */
	void exitSong(kernParser.SongContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(kernParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(kernParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#headerField}.
	 * @param ctx the parse tree
	 */
	void enterHeaderField(kernParser.HeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#headerField}.
	 * @param ctx the parse tree
	 */
	void exitHeaderField(kernParser.HeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#headerKern}.
	 * @param ctx the parse tree
	 */
	void enterHeaderKern(kernParser.HeaderKernContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#headerKern}.
	 * @param ctx the parse tree
	 */
	void exitHeaderKern(kernParser.HeaderKernContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#headerRoot}.
	 * @param ctx the parse tree
	 */
	void enterHeaderRoot(kernParser.HeaderRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#headerRoot}.
	 * @param ctx the parse tree
	 */
	void exitHeaderRoot(kernParser.HeaderRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#headerHarm}.
	 * @param ctx the parse tree
	 */
	void enterHeaderHarm(kernParser.HeaderHarmContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#headerHarm}.
	 * @param ctx the parse tree
	 */
	void exitHeaderHarm(kernParser.HeaderHarmContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(kernParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(kernParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(kernParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(kernParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(kernParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(kernParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#interpretation}.
	 * @param ctx the parse tree
	 */
	void enterInterpretation(kernParser.InterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#interpretation}.
	 * @param ctx the parse tree
	 */
	void exitInterpretation(kernParser.InterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterTandemInterpretation(kernParser.TandemInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitTandemInterpretation(kernParser.TandemInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keyChange}.
	 * @param ctx the parse tree
	 */
	void enterKeyChange(kernParser.KeyChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keyChange}.
	 * @param ctx the parse tree
	 */
	void exitKeyChange(kernParser.KeyChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keyAccidental}.
	 * @param ctx the parse tree
	 */
	void enterKeyAccidental(kernParser.KeyAccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keyAccidental}.
	 * @param ctx the parse tree
	 */
	void exitKeyAccidental(kernParser.KeyAccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void enterMinorKey(kernParser.MinorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void exitMinorKey(kernParser.MinorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void enterMajorKey(kernParser.MajorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void exitMajorKey(kernParser.MajorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#noteNameLowerCase}.
	 * @param ctx the parse tree
	 */
	void enterNoteNameLowerCase(kernParser.NoteNameLowerCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#noteNameLowerCase}.
	 * @param ctx the parse tree
	 */
	void exitNoteNameLowerCase(kernParser.NoteNameLowerCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#noteNameUpperCase}.
	 * @param ctx the parse tree
	 */
	void enterNoteNameUpperCase(kernParser.NoteNameUpperCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#noteNameUpperCase}.
	 * @param ctx the parse tree
	 */
	void exitNoteNameUpperCase(kernParser.NoteNameUpperCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(kernParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(kernParser.StaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clef}.
	 * @param ctx the parse tree
	 */
	void enterClef(kernParser.ClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clef}.
	 * @param ctx the parse tree
	 */
	void exitClef(kernParser.ClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keysignature}.
	 * @param ctx the parse tree
	 */
	void enterKeysignature(kernParser.KeysignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keysignature}.
	 * @param ctx the parse tree
	 */
	void exitKeysignature(kernParser.KeysignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keysignatureNote}.
	 * @param ctx the parse tree
	 */
	void enterKeysignatureNote(kernParser.KeysignatureNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keysignatureNote}.
	 * @param ctx the parse tree
	 */
	void exitKeysignatureNote(kernParser.KeysignatureNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#meter}.
	 * @param ctx the parse tree
	 */
	void enterMeter(kernParser.MeterContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#meter}.
	 * @param ctx the parse tree
	 */
	void exitMeter(kernParser.MeterContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#meterKnown}.
	 * @param ctx the parse tree
	 */
	void enterMeterKnown(kernParser.MeterKnownContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#meterKnown}.
	 * @param ctx the parse tree
	 */
	void exitMeterKnown(kernParser.MeterKnownContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#numerator}.
	 * @param ctx the parse tree
	 */
	void enterNumerator(kernParser.NumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#numerator}.
	 * @param ctx the parse tree
	 */
	void exitNumerator(kernParser.NumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#denominator}.
	 * @param ctx the parse tree
	 */
	void enterDenominator(kernParser.DenominatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#denominator}.
	 * @param ctx the parse tree
	 */
	void exitDenominator(kernParser.DenominatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(kernParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(kernParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#augmentationDots}.
	 * @param ctx the parse tree
	 */
	void enterAugmentationDots(kernParser.AugmentationDotsContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#augmentationDots}.
	 * @param ctx the parse tree
	 */
	void exitAugmentationDots(kernParser.AugmentationDotsContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#noteRestChord}.
	 * @param ctx the parse tree
	 */
	void enterNoteRestChord(kernParser.NoteRestChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#noteRestChord}.
	 * @param ctx the parse tree
	 */
	void exitNoteRestChord(kernParser.NoteRestChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harm}.
	 * @param ctx the parse tree
	 */
	void enterHarm(kernParser.HarmContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harm}.
	 * @param ctx the parse tree
	 */
	void exitHarm(kernParser.HarmContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#chordIdentification}.
	 * @param ctx the parse tree
	 */
	void enterChordIdentification(kernParser.ChordIdentificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#chordIdentification}.
	 * @param ctx the parse tree
	 */
	void exitChordIdentification(kernParser.ChordIdentificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(kernParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(kernParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(kernParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(kernParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void enterBeforeNote(kernParser.BeforeNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void exitBeforeNote(kernParser.BeforeNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void enterAfterNote(kernParser.AfterNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void exitAfterNote(kernParser.AfterNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tiestart}.
	 * @param ctx the parse tree
	 */
	void enterTiestart(kernParser.TiestartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tiestart}.
	 * @param ctx the parse tree
	 */
	void exitTiestart(kernParser.TiestartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#slurstart}.
	 * @param ctx the parse tree
	 */
	void enterSlurstart(kernParser.SlurstartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#slurstart}.
	 * @param ctx the parse tree
	 */
	void exitSlurstart(kernParser.SlurstartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#slurend}.
	 * @param ctx the parse tree
	 */
	void enterSlurend(kernParser.SlurendContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#slurend}.
	 * @param ctx the parse tree
	 */
	void exitSlurend(kernParser.SlurendContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tiemiddle}.
	 * @param ctx the parse tree
	 */
	void enterTiemiddle(kernParser.TiemiddleContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tiemiddle}.
	 * @param ctx the parse tree
	 */
	void exitTiemiddle(kernParser.TiemiddleContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tieend}.
	 * @param ctx the parse tree
	 */
	void enterTieend(kernParser.TieendContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tieend}.
	 * @param ctx the parse tree
	 */
	void exitTieend(kernParser.TieendContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#partialbeam}.
	 * @param ctx the parse tree
	 */
	void enterPartialbeam(kernParser.PartialbeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#partialbeam}.
	 * @param ctx the parse tree
	 */
	void exitPartialbeam(kernParser.PartialbeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tenuto}.
	 * @param ctx the parse tree
	 */
	void enterTenuto(kernParser.TenutoContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tenuto}.
	 * @param ctx the parse tree
	 */
	void exitTenuto(kernParser.TenutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alteration}.
	 * @param ctx the parse tree
	 */
	void enterAlteration(kernParser.AlterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alteration}.
	 * @param ctx the parse tree
	 */
	void exitAlteration(kernParser.AlterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#stem}.
	 * @param ctx the parse tree
	 */
	void enterStem(kernParser.StemContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#stem}.
	 * @param ctx the parse tree
	 */
	void exitStem(kernParser.StemContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#beam}.
	 * @param ctx the parse tree
	 */
	void enterBeam(kernParser.BeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#beam}.
	 * @param ctx the parse tree
	 */
	void exitBeam(kernParser.BeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mordent}.
	 * @param ctx the parse tree
	 */
	void enterMordent(kernParser.MordentContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mordent}.
	 * @param ctx the parse tree
	 */
	void exitMordent(kernParser.MordentContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#trill}.
	 * @param ctx the parse tree
	 */
	void enterTrill(kernParser.TrillContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#trill}.
	 * @param ctx the parse tree
	 */
	void exitTrill(kernParser.TrillContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bassNotes}
	 * labeled alternative in {@link kernParser#noteName}.
	 * @param ctx the parse tree
	 */
	void enterBassNotes(kernParser.BassNotesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bassNotes}
	 * labeled alternative in {@link kernParser#noteName}.
	 * @param ctx the parse tree
	 */
	void exitBassNotes(kernParser.BassNotesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trebleNotes}
	 * labeled alternative in {@link kernParser#noteName}.
	 * @param ctx the parse tree
	 */
	void enterTrebleNotes(kernParser.TrebleNotesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trebleNotes}
	 * labeled alternative in {@link kernParser#noteName}.
	 * @param ctx the parse tree
	 */
	void exitTrebleNotes(kernParser.TrebleNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(kernParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(kernParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#pause}.
	 * @param ctx the parse tree
	 */
	void enterPause(kernParser.PauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#pause}.
	 * @param ctx the parse tree
	 */
	void exitPause(kernParser.PauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmChord}.
	 * @param ctx the parse tree
	 */
	void enterHarmChord(kernParser.HarmChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmChord}.
	 * @param ctx the parse tree
	 */
	void exitHarmChord(kernParser.HarmChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmChordSpecification}.
	 * @param ctx the parse tree
	 */
	void enterHarmChordSpecification(kernParser.HarmChordSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmChordSpecification}.
	 * @param ctx the parse tree
	 */
	void exitHarmChordSpecification(kernParser.HarmChordSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmMinorChord}.
	 * @param ctx the parse tree
	 */
	void enterHarmMinorChord(kernParser.HarmMinorChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmMinorChord}.
	 * @param ctx the parse tree
	 */
	void exitHarmMinorChord(kernParser.HarmMinorChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmMajorChord}.
	 * @param ctx the parse tree
	 */
	void enterHarmMajorChord(kernParser.HarmMajorChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmMajorChord}.
	 * @param ctx the parse tree
	 */
	void exitHarmMajorChord(kernParser.HarmMajorChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmAlteredRoot}.
	 * @param ctx the parse tree
	 */
	void enterHarmAlteredRoot(kernParser.HarmAlteredRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmAlteredRoot}.
	 * @param ctx the parse tree
	 */
	void exitHarmAlteredRoot(kernParser.HarmAlteredRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmDiminished}.
	 * @param ctx the parse tree
	 */
	void enterHarmDiminished(kernParser.HarmDiminishedContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmDiminished}.
	 * @param ctx the parse tree
	 */
	void exitHarmDiminished(kernParser.HarmDiminishedContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmAugmented}.
	 * @param ctx the parse tree
	 */
	void enterHarmAugmented(kernParser.HarmAugmentedContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmAugmented}.
	 * @param ctx the parse tree
	 */
	void exitHarmAugmented(kernParser.HarmAugmentedContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmInversion}.
	 * @param ctx the parse tree
	 */
	void enterHarmInversion(kernParser.HarmInversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmInversion}.
	 * @param ctx the parse tree
	 */
	void exitHarmInversion(kernParser.HarmInversionContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmExtendedTertianChord}.
	 * @param ctx the parse tree
	 */
	void enterHarmExtendedTertianChord(kernParser.HarmExtendedTertianChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmExtendedTertianChord}.
	 * @param ctx the parse tree
	 */
	void exitHarmExtendedTertianChord(kernParser.HarmExtendedTertianChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#harmExtensionInterval}.
	 * @param ctx the parse tree
	 */
	void enterHarmExtensionInterval(kernParser.HarmExtensionIntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#harmExtensionInterval}.
	 * @param ctx the parse tree
	 */
	void exitHarmExtensionInterval(kernParser.HarmExtensionIntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barline}.
	 * @param ctx the parse tree
	 */
	void enterBarline(kernParser.BarlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barline}.
	 * @param ctx the parse tree
	 */
	void exitBarline(kernParser.BarlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barlineWidth}.
	 * @param ctx the parse tree
	 */
	void enterBarlineWidth(kernParser.BarlineWidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barlineWidth}.
	 * @param ctx the parse tree
	 */
	void exitBarlineWidth(kernParser.BarlineWidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alternateMeasure}.
	 * @param ctx the parse tree
	 */
	void enterAlternateMeasure(kernParser.AlternateMeasureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alternateMeasure}.
	 * @param ctx the parse tree
	 */
	void exitAlternateMeasure(kernParser.AlternateMeasureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#partialBarLine}.
	 * @param ctx the parse tree
	 */
	void enterPartialBarLine(kernParser.PartialBarLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#partialBarLine}.
	 * @param ctx the parse tree
	 */
	void exitPartialBarLine(kernParser.PartialBarLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#splineOperations}.
	 * @param ctx the parse tree
	 */
	void enterSplineOperations(kernParser.SplineOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#splineOperations}.
	 * @param ctx the parse tree
	 */
	void exitSplineOperations(kernParser.SplineOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#splineTerminator}.
	 * @param ctx the parse tree
	 */
	void enterSplineTerminator(kernParser.SplineTerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#splineTerminator}.
	 * @param ctx the parse tree
	 */
	void exitSplineTerminator(kernParser.SplineTerminatorContext ctx);
}