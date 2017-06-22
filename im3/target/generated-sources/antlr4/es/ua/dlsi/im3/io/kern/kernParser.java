// Generated from es\u005Cua\dlsi\im3\io\kern\kern.g4 by ANTLR 4.7
package es.ua.dlsi.im3.io.kern;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class kernParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, KERN=29, ROOT=30, HARM=31, INTERPRETATION=32, 
		SECTIONLABEL=33, INSTRUMENT=34, METRONOME=35, TANDEM_CLEF=36, TANDEM_KEY=37, 
		TANDEM_STAFF=38, TANDEM_MET=39, TANDEM_METER=40, ATONAL_PASSAGE=41, UNKNOWN_KEY=42, 
		ASTERISK=43, FIELDCOMMENT=44, EXCLAMATION_SIGN=45, NONFUNCTIONALCHORD=46, 
		QUESTIONMARK=47, EQUAL_SIGN=48, PIPE_SIGN=49, GRAVE_ACCENT=50, TILDE=51, 
		APOSTROPHE=52, BACKSLASH=53, UNDERSCORE=54, SPACE=55, TAB=56, DOT=57, 
		LEFTPAR=58, RIGHTPAR=59, LEFTBRACKET=60, RIGHTBRACKET=61, SLASH=62, OCTOTHORPE=63, 
		MINUS=64, COLON=65, SEMICOLON=66, PLUS=67, NEAPOLITAN_SIXTH=68, ITALIAN_SIXTH=69, 
		FRENCH_SIXTH=70, TRISTAN_CHORD=71, DEGREE_LOWERCASE=72, DEGREE_UPPERCASE=73, 
		G2=74, F4=75, C3=76, C4=77, G1=78, Gv2=79, LETTER=80, EOL=81, NUMBER=82, 
		LINE_COMMENT=83, EDITORIALSIGNIFIER=84;
	public static final int
		RULE_song = 0, RULE_header = 1, RULE_headerField = 2, RULE_headerKern = 3, 
		RULE_headerRoot = 4, RULE_headerHarm = 5, RULE_record = 6, RULE_field = 7, 
		RULE_token = 8, RULE_interpretation = 9, RULE_tandemInterpretation = 10, 
		RULE_keyChange = 11, RULE_keyAccidental = 12, RULE_minorKey = 13, RULE_majorKey = 14, 
		RULE_noteNameLowerCase = 15, RULE_noteNameUpperCase = 16, RULE_staff = 17, 
		RULE_clef = 18, RULE_keysignature = 19, RULE_keysignatureNote = 20, RULE_meter = 21, 
		RULE_meterKnown = 22, RULE_numerator = 23, RULE_denominator = 24, RULE_duration = 25, 
		RULE_augmentationDots = 26, RULE_noteRestChord = 27, RULE_harm = 28, RULE_chordIdentification = 29, 
		RULE_chord = 30, RULE_note = 31, RULE_beforeNote = 32, RULE_afterNote = 33, 
		RULE_tiestart = 34, RULE_slurstart = 35, RULE_slurend = 36, RULE_tiemiddle = 37, 
		RULE_tieend = 38, RULE_partialbeam = 39, RULE_tenuto = 40, RULE_alteration = 41, 
		RULE_stem = 42, RULE_beam = 43, RULE_mordent = 44, RULE_trill = 45, RULE_noteName = 46, 
		RULE_rest = 47, RULE_pause = 48, RULE_harmChord = 49, RULE_harmChordSpecification = 50, 
		RULE_harmMinorChord = 51, RULE_harmMajorChord = 52, RULE_harmAlteredRoot = 53, 
		RULE_harmDiminished = 54, RULE_harmAugmented = 55, RULE_harmInversion = 56, 
		RULE_harmExtendedTertianChord = 57, RULE_harmExtensionInterval = 58, RULE_barline = 59, 
		RULE_barlineWidth = 60, RULE_alternateMeasure = 61, RULE_partialBarLine = 62, 
		RULE_splineOperations = 63, RULE_splineTerminator = 64;
	public static final String[] ruleNames = {
		"song", "header", "headerField", "headerKern", "headerRoot", "headerHarm", 
		"record", "field", "token", "interpretation", "tandemInterpretation", 
		"keyChange", "keyAccidental", "minorKey", "majorKey", "noteNameLowerCase", 
		"noteNameUpperCase", "staff", "clef", "keysignature", "keysignatureNote", 
		"meter", "meterKnown", "numerator", "denominator", "duration", "augmentationDots", 
		"noteRestChord", "harm", "chordIdentification", "chord", "note", "beforeNote", 
		"afterNote", "tiestart", "slurstart", "slurend", "tiemiddle", "tieend", 
		"partialbeam", "tenuto", "alteration", "stem", "beam", "mordent", "trill", 
		"noteName", "rest", "pause", "harmChord", "harmChordSpecification", "harmMinorChord", 
		"harmMajorChord", "harmAlteredRoot", "harmDiminished", "harmAugmented", 
		"harmInversion", "harmExtendedTertianChord", "harmExtensionInterval", 
		"barline", "barlineWidth", "alternateMeasure", "partialBarLine", "splineOperations", 
		"splineTerminator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'C'", "'n'", "'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'A'", 
		"'B'", "'D'", "'E'", "'F'", "'G'", "'X'", "'k'", "'L'", "'J'", "'W'", 
		"'w'", "'T'", "'t'", "'r'", "'o'", "'M'", "'m'", "'P'", "'**kern'", "'**root'", 
		"'**harm'", null, null, null, null, "'*clef'", "'*k'", "'*staff'", "'*met'", 
		"'*M'", "'*X:'", "'*?:'", "'*'", null, "'!'", "'?-'", "'?'", "'='", "'|'", 
		"'`'", "'~'", "'''", "'\\'", "'_'", "' '", "'\t'", "'.'", "'('", "')'", 
		"'['", "']'", "'/'", "'#'", "'-'", "':'", "';'", "'+'", "'Nb'", "'Lt'", 
		"'Fr'", "'Tr'", null, null, "'G2'", "'F4'", "'C3'", "'C4'", "'G1'", "'Gv2'", 
		null, null, null, null, "'y'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "KERN", "ROOT", "HARM", "INTERPRETATION", 
		"SECTIONLABEL", "INSTRUMENT", "METRONOME", "TANDEM_CLEF", "TANDEM_KEY", 
		"TANDEM_STAFF", "TANDEM_MET", "TANDEM_METER", "ATONAL_PASSAGE", "UNKNOWN_KEY", 
		"ASTERISK", "FIELDCOMMENT", "EXCLAMATION_SIGN", "NONFUNCTIONALCHORD", 
		"QUESTIONMARK", "EQUAL_SIGN", "PIPE_SIGN", "GRAVE_ACCENT", "TILDE", "APOSTROPHE", 
		"BACKSLASH", "UNDERSCORE", "SPACE", "TAB", "DOT", "LEFTPAR", "RIGHTPAR", 
		"LEFTBRACKET", "RIGHTBRACKET", "SLASH", "OCTOTHORPE", "MINUS", "COLON", 
		"SEMICOLON", "PLUS", "NEAPOLITAN_SIXTH", "ITALIAN_SIXTH", "FRENCH_SIXTH", 
		"TRISTAN_CHORD", "DEGREE_LOWERCASE", "DEGREE_UPPERCASE", "G2", "F4", "C3", 
		"C4", "G1", "Gv2", "LETTER", "EOL", "NUMBER", "LINE_COMMENT", "EDITORIALSIGNIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "kern.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public kernParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SongContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(kernParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(kernParser.EOL, i);
		}
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
		}
		public SongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_song; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterSong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitSong(this);
		}
	}

	public final SongContext song() throws RecognitionException {
		SongContext _localctx = new SongContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_song);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			header();
			setState(133); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(131);
					match(EOL);
					setState(132);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(135); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(137);
				match(EOL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public List<HeaderFieldContext> headerField() {
			return getRuleContexts(HeaderFieldContext.class);
		}
		public HeaderFieldContext headerField(int i) {
			return getRuleContext(HeaderFieldContext.class,i);
		}
		public List<TerminalNode> TAB() { return getTokens(kernParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(kernParser.TAB, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			headerField();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB) {
				{
				{
				setState(141);
				match(TAB);
				setState(142);
				headerField();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderFieldContext extends ParserRuleContext {
		public HeaderKernContext headerKern() {
			return getRuleContext(HeaderKernContext.class,0);
		}
		public HeaderRootContext headerRoot() {
			return getRuleContext(HeaderRootContext.class,0);
		}
		public HeaderHarmContext headerHarm() {
			return getRuleContext(HeaderHarmContext.class,0);
		}
		public HeaderFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHeaderField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHeaderField(this);
		}
	}

	public final HeaderFieldContext headerField() throws RecognitionException {
		HeaderFieldContext _localctx = new HeaderFieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_headerField);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KERN:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				headerKern();
				}
				break;
			case ROOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				headerRoot();
				}
				break;
			case HARM:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				headerHarm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderKernContext extends ParserRuleContext {
		public TerminalNode KERN() { return getToken(kernParser.KERN, 0); }
		public HeaderKernContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerKern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHeaderKern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHeaderKern(this);
		}
	}

	public final HeaderKernContext headerKern() throws RecognitionException {
		HeaderKernContext _localctx = new HeaderKernContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_headerKern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(KERN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderRootContext extends ParserRuleContext {
		public TerminalNode ROOT() { return getToken(kernParser.ROOT, 0); }
		public HeaderRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHeaderRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHeaderRoot(this);
		}
	}

	public final HeaderRootContext headerRoot() throws RecognitionException {
		HeaderRootContext _localctx = new HeaderRootContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_headerRoot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(ROOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderHarmContext extends ParserRuleContext {
		public TerminalNode HARM() { return getToken(kernParser.HARM, 0); }
		public HeaderHarmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerHarm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHeaderHarm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHeaderHarm(this);
		}
	}

	public final HeaderHarmContext headerHarm() throws RecognitionException {
		HeaderHarmContext _localctx = new HeaderHarmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_headerHarm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(HARM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> TAB() { return getTokens(kernParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(kernParser.TAB, i);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitRecord(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_record);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(159);
			field();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB) {
				{
				{
				setState(160);
				match(TAB);
				setState(161);
				field();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public TerminalNode DOT() { return getToken(kernParser.DOT, 0); }
		public TerminalNode FIELDCOMMENT() { return getToken(kernParser.FIELDCOMMENT, 0); }
		public TerminalNode EXCLAMATION_SIGN() { return getToken(kernParser.EXCLAMATION_SIGN, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case INTERPRETATION:
			case SECTIONLABEL:
			case INSTRUMENT:
			case METRONOME:
			case TANDEM_CLEF:
			case TANDEM_KEY:
			case TANDEM_STAFF:
			case TANDEM_MET:
			case TANDEM_METER:
			case ATONAL_PASSAGE:
			case UNKNOWN_KEY:
			case ASTERISK:
			case NONFUNCTIONALCHORD:
			case EQUAL_SIGN:
			case TILDE:
			case LEFTPAR:
			case LEFTBRACKET:
			case OCTOTHORPE:
			case MINUS:
			case NEAPOLITAN_SIXTH:
			case ITALIAN_SIXTH:
			case FRENCH_SIXTH:
			case TRISTAN_CHORD:
			case DEGREE_LOWERCASE:
			case DEGREE_UPPERCASE:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				token();
				}
				break;
			case FIELDCOMMENT:
			case EXCLAMATION_SIGN:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELDCOMMENT) | (1L << EXCLAMATION_SIGN) | (1L << DOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public InterpretationContext interpretation() {
			return getRuleContext(InterpretationContext.class,0);
		}
		public TandemInterpretationContext tandemInterpretation() {
			return getRuleContext(TandemInterpretationContext.class,0);
		}
		public NoteRestChordContext noteRestChord() {
			return getRuleContext(NoteRestChordContext.class,0);
		}
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
		public SplineOperationsContext splineOperations() {
			return getRuleContext(SplineOperationsContext.class,0);
		}
		public HarmContext harm() {
			return getRuleContext(HarmContext.class,0);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitToken(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_token);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				interpretation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				tandemInterpretation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				noteRestChord();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				barline();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				splineOperations();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				harm();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterpretationContext extends ParserRuleContext {
		public TerminalNode INTERPRETATION() { return getToken(kernParser.INTERPRETATION, 0); }
		public InterpretationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpretation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitInterpretation(this);
		}
	}

	public final InterpretationContext interpretation() throws RecognitionException {
		InterpretationContext _localctx = new InterpretationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_interpretation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(INTERPRETATION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TandemInterpretationContext extends ParserRuleContext {
		public TerminalNode TANDEM_CLEF() { return getToken(kernParser.TANDEM_CLEF, 0); }
		public ClefContext clef() {
			return getRuleContext(ClefContext.class,0);
		}
		public TerminalNode TANDEM_KEY() { return getToken(kernParser.TANDEM_KEY, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(kernParser.LEFTBRACKET, 0); }
		public KeysignatureContext keysignature() {
			return getRuleContext(KeysignatureContext.class,0);
		}
		public TerminalNode RIGHTBRACKET() { return getToken(kernParser.RIGHTBRACKET, 0); }
		public TerminalNode TANDEM_METER() { return getToken(kernParser.TANDEM_METER, 0); }
		public MeterContext meter() {
			return getRuleContext(MeterContext.class,0);
		}
		public TerminalNode TANDEM_MET() { return getToken(kernParser.TANDEM_MET, 0); }
		public TerminalNode LEFTPAR() { return getToken(kernParser.LEFTPAR, 0); }
		public TerminalNode RIGHTPAR() { return getToken(kernParser.RIGHTPAR, 0); }
		public TerminalNode TANDEM_STAFF() { return getToken(kernParser.TANDEM_STAFF, 0); }
		public StaffContext staff() {
			return getRuleContext(StaffContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(kernParser.ASTERISK, 0); }
		public KeyChangeContext keyChange() {
			return getRuleContext(KeyChangeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(kernParser.COLON, 0); }
		public TerminalNode UNKNOWN_KEY() { return getToken(kernParser.UNKNOWN_KEY, 0); }
		public TerminalNode ATONAL_PASSAGE() { return getToken(kernParser.ATONAL_PASSAGE, 0); }
		public TerminalNode SECTIONLABEL() { return getToken(kernParser.SECTIONLABEL, 0); }
		public TerminalNode INSTRUMENT() { return getToken(kernParser.INSTRUMENT, 0); }
		public TerminalNode METRONOME() { return getToken(kernParser.METRONOME, 0); }
		public TandemInterpretationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tandemInterpretation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTandemInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTandemInterpretation(this);
		}
	}

	public final TandemInterpretationContext tandemInterpretation() throws RecognitionException {
		TandemInterpretationContext _localctx = new TandemInterpretationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tandemInterpretation);
		int _la;
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(181);
				match(TANDEM_CLEF);
				setState(182);
				clef();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(183);
				match(TANDEM_KEY);
				setState(184);
				match(LEFTBRACKET);
				setState(185);
				keysignature();
				setState(186);
				match(RIGHTBRACKET);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(188);
				match(TANDEM_METER);
				setState(189);
				meter();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(190);
				match(TANDEM_MET);
				setState(191);
				match(LEFTPAR);
				setState(192);
				match(T__0);
				setState(193);
				match(RIGHTPAR);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(194);
				match(TANDEM_STAFF);
				setState(195);
				staff();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(196);
				match(ASTERISK);
				setState(197);
				keyChange();
				setState(198);
				match(COLON);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SECTIONLABEL) | (1L << INSTRUMENT) | (1L << METRONOME) | (1L << ATONAL_PASSAGE) | (1L << UNKNOWN_KEY) | (1L << ASTERISK))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyChangeContext extends ParserRuleContext {
		public MinorKeyContext minorKey() {
			return getRuleContext(MinorKeyContext.class,0);
		}
		public MajorKeyContext majorKey() {
			return getRuleContext(MajorKeyContext.class,0);
		}
		public KeyAccidentalContext keyAccidental() {
			return getRuleContext(KeyAccidentalContext.class,0);
		}
		public KeyChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterKeyChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitKeyChange(this);
		}
	}

	public final KeyChangeContext keyChange() throws RecognitionException {
		KeyChangeContext _localctx = new KeyChangeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_keyChange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				{
				setState(203);
				minorKey();
				}
				break;
			case T__0:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				{
				setState(204);
				majorKey();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (OCTOTHORPE - 2)) | (1L << (MINUS - 2)))) != 0)) {
				{
				setState(207);
				keyAccidental();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyAccidentalContext extends ParserRuleContext {
		public TerminalNode OCTOTHORPE() { return getToken(kernParser.OCTOTHORPE, 0); }
		public TerminalNode MINUS() { return getToken(kernParser.MINUS, 0); }
		public KeyAccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyAccidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterKeyAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitKeyAccidental(this);
		}
	}

	public final KeyAccidentalContext keyAccidental() throws RecognitionException {
		KeyAccidentalContext _localctx = new KeyAccidentalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_keyAccidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (OCTOTHORPE - 2)) | (1L << (MINUS - 2)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinorKeyContext extends ParserRuleContext {
		public NoteNameLowerCaseContext noteNameLowerCase() {
			return getRuleContext(NoteNameLowerCaseContext.class,0);
		}
		public MinorKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minorKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterMinorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitMinorKey(this);
		}
	}

	public final MinorKeyContext minorKey() throws RecognitionException {
		MinorKeyContext _localctx = new MinorKeyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_minorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			noteNameLowerCase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MajorKeyContext extends ParserRuleContext {
		public NoteNameUpperCaseContext noteNameUpperCase() {
			return getRuleContext(NoteNameUpperCaseContext.class,0);
		}
		public MajorKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_majorKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterMajorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitMajorKey(this);
		}
	}

	public final MajorKeyContext majorKey() throws RecognitionException {
		MajorKeyContext _localctx = new MajorKeyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_majorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			noteNameUpperCase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteNameLowerCaseContext extends ParserRuleContext {
		public NoteNameLowerCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteNameLowerCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterNoteNameLowerCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitNoteNameLowerCase(this);
		}
	}

	public final NoteNameLowerCaseContext noteNameLowerCase() throws RecognitionException {
		NoteNameLowerCaseContext _localctx = new NoteNameLowerCaseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_noteNameLowerCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteNameUpperCaseContext extends ParserRuleContext {
		public NoteNameUpperCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteNameUpperCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterNoteNameUpperCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitNoteNameUpperCase(this);
		}
	}

	public final NoteNameUpperCaseContext noteNameUpperCase() throws RecognitionException {
		NoteNameUpperCaseContext _localctx = new NoteNameUpperCaseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_noteNameUpperCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaffContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(kernParser.NUMBER, 0); }
		public StaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitStaff(this);
		}
	}

	public final StaffContext staff() throws RecognitionException {
		StaffContext _localctx = new StaffContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_staff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClefContext extends ParserRuleContext {
		public TerminalNode G2() { return getToken(kernParser.G2, 0); }
		public TerminalNode F4() { return getToken(kernParser.F4, 0); }
		public TerminalNode C3() { return getToken(kernParser.C3, 0); }
		public TerminalNode C4() { return getToken(kernParser.C4, 0); }
		public TerminalNode G1() { return getToken(kernParser.G1, 0); }
		public TerminalNode Gv2() { return getToken(kernParser.Gv2, 0); }
		public ClefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterClef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitClef(this);
		}
	}

	public final ClefContext clef() throws RecognitionException {
		ClefContext _localctx = new ClefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_clef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (G2 - 74)) | (1L << (F4 - 74)) | (1L << (C3 - 74)) | (1L << (C4 - 74)) | (1L << (G1 - 74)) | (1L << (Gv2 - 74)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeysignatureContext extends ParserRuleContext {
		public List<KeysignatureNoteContext> keysignatureNote() {
			return getRuleContexts(KeysignatureNoteContext.class);
		}
		public KeysignatureNoteContext keysignatureNote(int i) {
			return getRuleContext(KeysignatureNoteContext.class,i);
		}
		public KeysignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keysignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterKeysignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitKeysignature(this);
		}
	}

	public final KeysignatureContext keysignature() throws RecognitionException {
		KeysignatureContext _localctx = new KeysignatureContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_keysignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
				{
				{
				setState(224);
				keysignatureNote();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeysignatureNoteContext extends ParserRuleContext {
		public NoteNameLowerCaseContext noteNameLowerCase() {
			return getRuleContext(NoteNameLowerCaseContext.class,0);
		}
		public KeyAccidentalContext keyAccidental() {
			return getRuleContext(KeyAccidentalContext.class,0);
		}
		public KeysignatureNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keysignatureNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterKeysignatureNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitKeysignatureNote(this);
		}
	}

	public final KeysignatureNoteContext keysignatureNote() throws RecognitionException {
		KeysignatureNoteContext _localctx = new KeysignatureNoteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_keysignatureNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			noteNameLowerCase();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (OCTOTHORPE - 2)) | (1L << (MINUS - 2)))) != 0)) {
				{
				setState(231);
				keyAccidental();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeterContext extends ParserRuleContext {
		public MeterKnownContext meterKnown() {
			return getRuleContext(MeterKnownContext.class,0);
		}
		public TerminalNode QUESTIONMARK() { return getToken(kernParser.QUESTIONMARK, 0); }
		public MeterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterMeter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitMeter(this);
		}
	}

	public final MeterContext meter() throws RecognitionException {
		MeterContext _localctx = new MeterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_meter);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				meterKnown();
				}
				break;
			case T__15:
			case QUESTIONMARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==QUESTIONMARK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeterKnownContext extends ParserRuleContext {
		public NumeratorContext numerator() {
			return getRuleContext(NumeratorContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(kernParser.SLASH, 0); }
		public DenominatorContext denominator() {
			return getRuleContext(DenominatorContext.class,0);
		}
		public MeterKnownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meterKnown; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterMeterKnown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitMeterKnown(this);
		}
	}

	public final MeterKnownContext meterKnown() throws RecognitionException {
		MeterKnownContext _localctx = new MeterKnownContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_meterKnown);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			numerator();
			setState(239);
			match(SLASH);
			setState(240);
			denominator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumeratorContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(kernParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(kernParser.NUMBER, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(kernParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(kernParser.PLUS, i);
		}
		public NumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterNumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitNumerator(this);
		}
	}

	public final NumeratorContext numerator() throws RecognitionException {
		NumeratorContext _localctx = new NumeratorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_numerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(NUMBER);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(243);
				match(PLUS);
				setState(244);
				match(NUMBER);
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DenominatorContext extends ParserRuleContext {
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public DenominatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_denominator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterDenominator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitDenominator(this);
		}
	}

	public final DenominatorContext denominator() throws RecognitionException {
		DenominatorContext _localctx = new DenominatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_denominator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			duration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DurationContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(kernParser.NUMBER, 0); }
		public AugmentationDotsContext augmentationDots() {
			return getRuleContext(AugmentationDotsContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitDuration(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(NUMBER);
			setState(253);
			augmentationDots();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AugmentationDotsContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(kernParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(kernParser.DOT, i);
		}
		public AugmentationDotsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augmentationDots; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterAugmentationDots(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitAugmentationDots(this);
		}
	}

	public final AugmentationDotsContext augmentationDots() throws RecognitionException {
		AugmentationDotsContext _localctx = new AugmentationDotsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_augmentationDots);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(255);
				match(DOT);
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteRestChordContext extends ParserRuleContext {
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public NoteRestChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteRestChord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterNoteRestChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitNoteRestChord(this);
		}
	}

	public final NoteRestChordContext noteRestChord() throws RecognitionException {
		NoteRestChordContext _localctx = new NoteRestChordContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_noteRestChord);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				chord();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				note();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				rest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmContext extends ParserRuleContext {
		public List<ChordIdentificationContext> chordIdentification() {
			return getRuleContexts(ChordIdentificationContext.class);
		}
		public ChordIdentificationContext chordIdentification(int i) {
			return getRuleContext(ChordIdentificationContext.class,i);
		}
		public TerminalNode LEFTPAR() { return getToken(kernParser.LEFTPAR, 0); }
		public TerminalNode RIGHTPAR() { return getToken(kernParser.RIGHTPAR, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(kernParser.LEFTBRACKET, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(kernParser.RIGHTBRACKET, 0); }
		public HarmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarm(this);
		}
	}

	public final HarmContext harm() throws RecognitionException {
		HarmContext _localctx = new HarmContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_harm);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				chordIdentification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(LEFTPAR);
				setState(268);
				chordIdentification();
				setState(269);
				match(RIGHTPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				chordIdentification();
				setState(272);
				match(LEFTBRACKET);
				setState(273);
				chordIdentification();
				setState(274);
				match(RIGHTBRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChordIdentificationContext extends ParserRuleContext {
		public List<HarmChordContext> harmChord() {
			return getRuleContexts(HarmChordContext.class);
		}
		public HarmChordContext harmChord(int i) {
			return getRuleContext(HarmChordContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(kernParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(kernParser.SLASH, i);
		}
		public PauseContext pause() {
			return getRuleContext(PauseContext.class,0);
		}
		public ChordIdentificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chordIdentification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterChordIdentification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitChordIdentification(this);
		}
	}

	public final ChordIdentificationContext chordIdentification() throws RecognitionException {
		ChordIdentificationContext _localctx = new ChordIdentificationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_chordIdentification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			harmChord();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(279);
				match(SLASH);
				setState(280);
				harmChord();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(286);
				pause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChordContext extends ParserRuleContext {
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(kernParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(kernParser.SPACE, i);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitChord(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			note();
			setState(292); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(290);
				match(SPACE);
				setState(291);
				note();
				}
				}
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteContext extends ParserRuleContext {
		public BeforeNoteContext beforeNote() {
			return getRuleContext(BeforeNoteContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public NoteNameContext noteName() {
			return getRuleContext(NoteNameContext.class,0);
		}
		public AfterNoteContext afterNote() {
			return getRuleContext(AfterNoteContext.class,0);
		}
		public AlterationContext alteration() {
			return getRuleContext(AlterationContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitNote(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			beforeNote();
			setState(297);
			duration();
			setState(298);
			noteName();
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (OCTOTHORPE - 2)) | (1L << (MINUS - 2)))) != 0)) {
				{
				setState(299);
				alteration();
				}
			}

			setState(302);
			afterNote();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeforeNoteContext extends ParserRuleContext {
		public List<SlurstartContext> slurstart() {
			return getRuleContexts(SlurstartContext.class);
		}
		public SlurstartContext slurstart(int i) {
			return getRuleContext(SlurstartContext.class,i);
		}
		public List<TiestartContext> tiestart() {
			return getRuleContexts(TiestartContext.class);
		}
		public TiestartContext tiestart(int i) {
			return getRuleContext(TiestartContext.class,i);
		}
		public BeforeNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterBeforeNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitBeforeNote(this);
		}
	}

	public final BeforeNoteContext beforeNote() throws RecognitionException {
		BeforeNoteContext _localctx = new BeforeNoteContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_beforeNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTPAR || _la==LEFTBRACKET) {
				{
				setState(306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFTPAR:
					{
					setState(304);
					slurstart();
					}
					break;
				case LEFTBRACKET:
					{
					setState(305);
					tiestart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AfterNoteContext extends ParserRuleContext {
		public List<SlurendContext> slurend() {
			return getRuleContexts(SlurendContext.class);
		}
		public SlurendContext slurend(int i) {
			return getRuleContext(SlurendContext.class,i);
		}
		public List<StemContext> stem() {
			return getRuleContexts(StemContext.class);
		}
		public StemContext stem(int i) {
			return getRuleContext(StemContext.class,i);
		}
		public List<TiemiddleContext> tiemiddle() {
			return getRuleContexts(TiemiddleContext.class);
		}
		public TiemiddleContext tiemiddle(int i) {
			return getRuleContext(TiemiddleContext.class,i);
		}
		public List<TieendContext> tieend() {
			return getRuleContexts(TieendContext.class);
		}
		public TieendContext tieend(int i) {
			return getRuleContext(TieendContext.class,i);
		}
		public List<MordentContext> mordent() {
			return getRuleContexts(MordentContext.class);
		}
		public MordentContext mordent(int i) {
			return getRuleContext(MordentContext.class,i);
		}
		public List<TrillContext> trill() {
			return getRuleContexts(TrillContext.class);
		}
		public TrillContext trill(int i) {
			return getRuleContext(TrillContext.class,i);
		}
		public List<BeamContext> beam() {
			return getRuleContexts(BeamContext.class);
		}
		public BeamContext beam(int i) {
			return getRuleContext(BeamContext.class,i);
		}
		public List<PauseContext> pause() {
			return getRuleContexts(PauseContext.class);
		}
		public PauseContext pause(int i) {
			return getRuleContext(PauseContext.class,i);
		}
		public List<PartialbeamContext> partialbeam() {
			return getRuleContexts(PartialbeamContext.class);
		}
		public PartialbeamContext partialbeam(int i) {
			return getRuleContext(PartialbeamContext.class,i);
		}
		public List<TenutoContext> tenuto() {
			return getRuleContexts(TenutoContext.class);
		}
		public TenutoContext tenuto(int i) {
			return getRuleContext(TenutoContext.class,i);
		}
		public AfterNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterAfterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitAfterNote(this);
		}
	}

	public final AfterNoteContext afterNote() throws RecognitionException {
		AfterNoteContext _localctx = new AfterNoteContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_afterNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__18 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (TILDE - 17)) | (1L << (BACKSLASH - 17)) | (1L << (UNDERSCORE - 17)) | (1L << (RIGHTPAR - 17)) | (1L << (RIGHTBRACKET - 17)) | (1L << (SLASH - 17)) | (1L << (SEMICOLON - 17)))) != 0)) {
				{
				setState(321);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RIGHTBRACKET:
					{
					setState(311);
					slurend();
					}
					break;
				case BACKSLASH:
				case SLASH:
					{
					setState(312);
					stem();
					}
					break;
				case UNDERSCORE:
					{
					setState(313);
					tiemiddle();
					}
					break;
				case RIGHTPAR:
					{
					setState(314);
					tieend();
					}
					break;
				case T__19:
					{
					setState(315);
					mordent();
					}
					break;
				case T__21:
				case T__22:
					{
					setState(316);
					trill();
					}
					break;
				case T__17:
				case T__18:
					{
					setState(317);
					beam();
					}
					break;
				case SEMICOLON:
					{
					setState(318);
					pause();
					}
					break;
				case T__16:
					{
					setState(319);
					partialbeam();
					}
					break;
				case TILDE:
					{
					setState(320);
					tenuto();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TiestartContext extends ParserRuleContext {
		public TerminalNode LEFTBRACKET() { return getToken(kernParser.LEFTBRACKET, 0); }
		public TiestartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tiestart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTiestart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTiestart(this);
		}
	}

	public final TiestartContext tiestart() throws RecognitionException {
		TiestartContext _localctx = new TiestartContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_tiestart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(LEFTBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlurstartContext extends ParserRuleContext {
		public TerminalNode LEFTPAR() { return getToken(kernParser.LEFTPAR, 0); }
		public SlurstartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurstart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterSlurstart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitSlurstart(this);
		}
	}

	public final SlurstartContext slurstart() throws RecognitionException {
		SlurstartContext _localctx = new SlurstartContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_slurstart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(LEFTPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlurendContext extends ParserRuleContext {
		public TerminalNode RIGHTBRACKET() { return getToken(kernParser.RIGHTBRACKET, 0); }
		public SlurendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterSlurend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitSlurend(this);
		}
	}

	public final SlurendContext slurend() throws RecognitionException {
		SlurendContext _localctx = new SlurendContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_slurend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(RIGHTBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TiemiddleContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(kernParser.UNDERSCORE, 0); }
		public TiemiddleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tiemiddle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTiemiddle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTiemiddle(this);
		}
	}

	public final TiemiddleContext tiemiddle() throws RecognitionException {
		TiemiddleContext _localctx = new TiemiddleContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tiemiddle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(UNDERSCORE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TieendContext extends ParserRuleContext {
		public TerminalNode RIGHTPAR() { return getToken(kernParser.RIGHTPAR, 0); }
		public TieendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tieend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTieend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTieend(this);
		}
	}

	public final TieendContext tieend() throws RecognitionException {
		TieendContext _localctx = new TieendContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tieend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(RIGHTPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartialbeamContext extends ParserRuleContext {
		public PartialbeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialbeam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterPartialbeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitPartialbeam(this);
		}
	}

	public final PartialbeamContext partialbeam() throws RecognitionException {
		PartialbeamContext _localctx = new PartialbeamContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_partialbeam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TenutoContext extends ParserRuleContext {
		public TerminalNode TILDE() { return getToken(kernParser.TILDE, 0); }
		public TenutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tenuto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTenuto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTenuto(this);
		}
	}

	public final TenutoContext tenuto() throws RecognitionException {
		TenutoContext _localctx = new TenutoContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tenuto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(TILDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterationContext extends ParserRuleContext {
		public List<TerminalNode> OCTOTHORPE() { return getTokens(kernParser.OCTOTHORPE); }
		public TerminalNode OCTOTHORPE(int i) {
			return getToken(kernParser.OCTOTHORPE, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(kernParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(kernParser.MINUS, i);
		}
		public AlterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterAlteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitAlteration(this);
		}
	}

	public final AlterationContext alteration() throws RecognitionException {
		AlterationContext _localctx = new AlterationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_alteration);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(OCTOTHORPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(341);
				match(OCTOTHORPE);
				setState(342);
				match(OCTOTHORPE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				match(MINUS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(344);
				match(MINUS);
				setState(345);
				match(MINUS);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StemContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(kernParser.SLASH, 0); }
		public TerminalNode BACKSLASH() { return getToken(kernParser.BACKSLASH, 0); }
		public StemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterStem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitStem(this);
		}
	}

	public final StemContext stem() throws RecognitionException {
		StemContext _localctx = new StemContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_stem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !(_la==BACKSLASH || _la==SLASH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeamContext extends ParserRuleContext {
		public BeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterBeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitBeam(this);
		}
	}

	public final BeamContext beam() throws RecognitionException {
		BeamContext _localctx = new BeamContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_beam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MordentContext extends ParserRuleContext {
		public MordentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mordent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterMordent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitMordent(this);
		}
	}

	public final MordentContext mordent() throws RecognitionException {
		MordentContext _localctx = new MordentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_mordent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(T__19);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(354);
				match(T__20);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrillContext extends ParserRuleContext {
		public TrillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trill; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTrill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTrill(this);
		}
	}

	public final TrillContext trill() throws RecognitionException {
		TrillContext _localctx = new TrillContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_trill);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteNameContext extends ParserRuleContext {
		public NoteNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteName; }
	 
		public NoteNameContext() { }
		public void copyFrom(NoteNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BassNotesContext extends NoteNameContext {
		public List<NoteNameUpperCaseContext> noteNameUpperCase() {
			return getRuleContexts(NoteNameUpperCaseContext.class);
		}
		public NoteNameUpperCaseContext noteNameUpperCase(int i) {
			return getRuleContext(NoteNameUpperCaseContext.class,i);
		}
		public BassNotesContext(NoteNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterBassNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitBassNotes(this);
		}
	}
	public static class TrebleNotesContext extends NoteNameContext {
		public List<NoteNameLowerCaseContext> noteNameLowerCase() {
			return getRuleContexts(NoteNameLowerCaseContext.class);
		}
		public NoteNameLowerCaseContext noteNameLowerCase(int i) {
			return getRuleContext(NoteNameLowerCaseContext.class,i);
		}
		public TrebleNotesContext(NoteNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterTrebleNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitTrebleNotes(this);
		}
	}

	public final NoteNameContext noteName() throws RecognitionException {
		NoteNameContext _localctx = new NoteNameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_noteName);
		int _la;
		try {
			setState(369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				_localctx = new BassNotesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(360); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(359);
					noteNameUpperCase();
					}
					}
					setState(362); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0) );
				}
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				_localctx = new TrebleNotesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(365); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(364);
					noteNameLowerCase();
					}
					}
					setState(367); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0) );
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestContext extends ParserRuleContext {
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public PauseContext pause() {
			return getRuleContext(PauseContext.class,0);
		}
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitRest(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			duration();
			{
			setState(372);
			match(T__23);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(373);
				match(T__23);
				}
			}

			}
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(376);
				pause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PauseContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(kernParser.SEMICOLON, 0); }
		public PauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterPause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitPause(this);
		}
	}

	public final PauseContext pause() throws RecognitionException {
		PauseContext _localctx = new PauseContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_pause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmChordContext extends ParserRuleContext {
		public HarmChordSpecificationContext harmChordSpecification() {
			return getRuleContext(HarmChordSpecificationContext.class,0);
		}
		public TerminalNode NONFUNCTIONALCHORD() { return getToken(kernParser.NONFUNCTIONALCHORD, 0); }
		public TerminalNode TILDE() { return getToken(kernParser.TILDE, 0); }
		public TerminalNode NEAPOLITAN_SIXTH() { return getToken(kernParser.NEAPOLITAN_SIXTH, 0); }
		public TerminalNode ITALIAN_SIXTH() { return getToken(kernParser.ITALIAN_SIXTH, 0); }
		public TerminalNode FRENCH_SIXTH() { return getToken(kernParser.FRENCH_SIXTH, 0); }
		public TerminalNode TRISTAN_CHORD() { return getToken(kernParser.TRISTAN_CHORD, 0); }
		public HarmChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmChord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmChord(this);
		}
	}

	public final HarmChordContext harmChord() throws RecognitionException {
		HarmChordContext _localctx = new HarmChordContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_harmChord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NONFUNCTIONALCHORD) {
				{
				setState(381);
				match(NONFUNCTIONALCHORD);
				}
			}

			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TILDE) {
				{
				setState(384);
				match(TILDE);
				}
			}

			setState(390);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCTOTHORPE:
			case MINUS:
			case DEGREE_LOWERCASE:
			case DEGREE_UPPERCASE:
				{
				setState(387);
				harmChordSpecification();
				}
				break;
			case NEAPOLITAN_SIXTH:
			case ITALIAN_SIXTH:
			case FRENCH_SIXTH:
			case TRISTAN_CHORD:
				{
				setState(388);
				_la = _input.LA(1);
				if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (NEAPOLITAN_SIXTH - 68)) | (1L << (ITALIAN_SIXTH - 68)) | (1L << (FRENCH_SIXTH - 68)) | (1L << (TRISTAN_CHORD - 68)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__23:
				{
				setState(389);
				match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmChordSpecificationContext extends ParserRuleContext {
		public HarmMajorChordContext harmMajorChord() {
			return getRuleContext(HarmMajorChordContext.class,0);
		}
		public HarmMinorChordContext harmMinorChord() {
			return getRuleContext(HarmMinorChordContext.class,0);
		}
		public HarmAlteredRootContext harmAlteredRoot() {
			return getRuleContext(HarmAlteredRootContext.class,0);
		}
		public HarmDiminishedContext harmDiminished() {
			return getRuleContext(HarmDiminishedContext.class,0);
		}
		public HarmAugmentedContext harmAugmented() {
			return getRuleContext(HarmAugmentedContext.class,0);
		}
		public HarmExtendedTertianChordContext harmExtendedTertianChord() {
			return getRuleContext(HarmExtendedTertianChordContext.class,0);
		}
		public HarmInversionContext harmInversion() {
			return getRuleContext(HarmInversionContext.class,0);
		}
		public HarmChordSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmChordSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmChordSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmChordSpecification(this);
		}
	}

	public final HarmChordSpecificationContext harmChordSpecification() throws RecognitionException {
		HarmChordSpecificationContext _localctx = new HarmChordSpecificationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_harmChordSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OCTOTHORPE || _la==MINUS) {
				{
				setState(392);
				harmAlteredRoot();
				}
			}

			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEGREE_UPPERCASE:
				{
				setState(395);
				harmMajorChord();
				}
				break;
			case DEGREE_LOWERCASE:
				{
				setState(396);
				harmMinorChord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				{
				setState(399);
				harmDiminished();
				}
				break;
			case PLUS:
				{
				setState(400);
				harmAugmented();
				}
				break;
			case EOF:
			case T__3:
			case T__4:
			case T__5:
			case T__7:
			case T__9:
			case T__11:
			case T__25:
			case T__26:
			case T__27:
			case TAB:
			case RIGHTPAR:
			case LEFTBRACKET:
			case RIGHTBRACKET:
			case SLASH:
			case SEMICOLON:
			case EOL:
			case NUMBER:
				break;
			default:
				break;
			}
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0) || _la==NUMBER) {
				{
				setState(403);
				harmExtendedTertianChord();
				}
			}

			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7))) != 0)) {
				{
				setState(406);
				harmInversion();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmMinorChordContext extends ParserRuleContext {
		public TerminalNode DEGREE_LOWERCASE() { return getToken(kernParser.DEGREE_LOWERCASE, 0); }
		public HarmMinorChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmMinorChord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmMinorChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmMinorChord(this);
		}
	}

	public final HarmMinorChordContext harmMinorChord() throws RecognitionException {
		HarmMinorChordContext _localctx = new HarmMinorChordContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_harmMinorChord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(DEGREE_LOWERCASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmMajorChordContext extends ParserRuleContext {
		public TerminalNode DEGREE_UPPERCASE() { return getToken(kernParser.DEGREE_UPPERCASE, 0); }
		public HarmMajorChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmMajorChord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmMajorChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmMajorChord(this);
		}
	}

	public final HarmMajorChordContext harmMajorChord() throws RecognitionException {
		HarmMajorChordContext _localctx = new HarmMajorChordContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_harmMajorChord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(DEGREE_UPPERCASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmAlteredRootContext extends ParserRuleContext {
		public TerminalNode OCTOTHORPE() { return getToken(kernParser.OCTOTHORPE, 0); }
		public TerminalNode MINUS() { return getToken(kernParser.MINUS, 0); }
		public HarmAlteredRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmAlteredRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmAlteredRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmAlteredRoot(this);
		}
	}

	public final HarmAlteredRootContext harmAlteredRoot() throws RecognitionException {
		HarmAlteredRootContext _localctx = new HarmAlteredRootContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_harmAlteredRoot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_la = _input.LA(1);
			if ( !(_la==OCTOTHORPE || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmDiminishedContext extends ParserRuleContext {
		public HarmDiminishedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmDiminished; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmDiminished(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmDiminished(this);
		}
	}

	public final HarmDiminishedContext harmDiminished() throws RecognitionException {
		HarmDiminishedContext _localctx = new HarmDiminishedContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_harmDiminished);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmAugmentedContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(kernParser.PLUS, 0); }
		public HarmAugmentedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmAugmented; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmAugmented(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmAugmented(this);
		}
	}

	public final HarmAugmentedContext harmAugmented() throws RecognitionException {
		HarmAugmentedContext _localctx = new HarmAugmentedContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_harmAugmented);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(PLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmInversionContext extends ParserRuleContext {
		public HarmInversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmInversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmInversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmInversion(this);
		}
	}

	public final HarmInversionContext harmInversion() throws RecognitionException {
		HarmInversionContext _localctx = new HarmInversionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_harmInversion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmExtendedTertianChordContext extends ParserRuleContext {
		public List<HarmExtensionIntervalContext> harmExtensionInterval() {
			return getRuleContexts(HarmExtensionIntervalContext.class);
		}
		public HarmExtensionIntervalContext harmExtensionInterval(int i) {
			return getRuleContext(HarmExtensionIntervalContext.class,i);
		}
		public HarmExtendedTertianChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmExtendedTertianChord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmExtendedTertianChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmExtendedTertianChord(this);
		}
	}

	public final HarmExtendedTertianChordContext harmExtendedTertianChord() throws RecognitionException {
		HarmExtendedTertianChordContext _localctx = new HarmExtendedTertianChordContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_harmExtendedTertianChord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(421);
				harmExtensionInterval();
				}
				}
				setState(424); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0) || _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HarmExtensionIntervalContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(kernParser.NUMBER, 0); }
		public HarmExtensionIntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_harmExtensionInterval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterHarmExtensionInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitHarmExtensionInterval(this);
		}
	}

	public final HarmExtensionIntervalContext harmExtensionInterval() throws RecognitionException {
		HarmExtensionIntervalContext _localctx = new HarmExtensionIntervalContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_harmExtensionInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
			case T__27:
				{
				setState(426);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__9:
				{
				{
				setState(427);
				match(T__9);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(428);
					match(T__9);
					}
				}

				}
				}
				break;
			case T__11:
				{
				{
				setState(431);
				match(T__11);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(432);
					match(T__11);
					}
				}

				}
				}
				break;
			case NUMBER:
				break;
			default:
				break;
			}
			setState(437);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BarlineContext extends ParserRuleContext {
		public List<TerminalNode> EQUAL_SIGN() { return getTokens(kernParser.EQUAL_SIGN); }
		public TerminalNode EQUAL_SIGN(int i) {
			return getToken(kernParser.EQUAL_SIGN, i);
		}
		public TerminalNode NUMBER() { return getToken(kernParser.NUMBER, 0); }
		public List<TerminalNode> COLON() { return getTokens(kernParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(kernParser.COLON, i);
		}
		public BarlineWidthContext barlineWidth() {
			return getRuleContext(BarlineWidthContext.class,0);
		}
		public PartialBarLineContext partialBarLine() {
			return getRuleContext(PartialBarLineContext.class,0);
		}
		public AlternateMeasureContext alternateMeasure() {
			return getRuleContext(AlternateMeasureContext.class,0);
		}
		public BarlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterBarline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitBarline(this);
		}
	}

	public final BarlineContext barline() throws RecognitionException {
		BarlineContext _localctx = new BarlineContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(439);
				match(EQUAL_SIGN);
				}
				}
				setState(442); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EQUAL_SIGN );
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(444);
				match(NUMBER);
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LETTER) {
					{
					setState(445);
					alternateMeasure();
					}
				}

				}
			}

			{
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(450);
				match(COLON);
				}
				break;
			}
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION_SIGN || _la==PIPE_SIGN) {
				{
				setState(453);
				barlineWidth();
				}
			}

			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & ((1L << (GRAVE_ACCENT - 50)) | (1L << (APOSTROPHE - 50)) | (1L << (MINUS - 50)))) != 0)) {
				{
				setState(456);
				partialBarLine();
				}
			}

			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(459);
				match(COLON);
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BarlineWidthContext extends ParserRuleContext {
		public TerminalNode PIPE_SIGN() { return getToken(kernParser.PIPE_SIGN, 0); }
		public List<TerminalNode> EXCLAMATION_SIGN() { return getTokens(kernParser.EXCLAMATION_SIGN); }
		public TerminalNode EXCLAMATION_SIGN(int i) {
			return getToken(kernParser.EXCLAMATION_SIGN, i);
		}
		public BarlineWidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barlineWidth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterBarlineWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitBarlineWidth(this);
		}
	}

	public final BarlineWidthContext barlineWidth() throws RecognitionException {
		BarlineWidthContext _localctx = new BarlineWidthContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_barlineWidth);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION_SIGN) {
				{
				setState(462);
				match(EXCLAMATION_SIGN);
				}
			}

			setState(465);
			match(PIPE_SIGN);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION_SIGN) {
				{
				setState(466);
				match(EXCLAMATION_SIGN);
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternateMeasureContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(kernParser.LETTER, 0); }
		public AlternateMeasureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternateMeasure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterAlternateMeasure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitAlternateMeasure(this);
		}
	}

	public final AlternateMeasureContext alternateMeasure() throws RecognitionException {
		AlternateMeasureContext _localctx = new AlternateMeasureContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_alternateMeasure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(LETTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartialBarLineContext extends ParserRuleContext {
		public TerminalNode GRAVE_ACCENT() { return getToken(kernParser.GRAVE_ACCENT, 0); }
		public TerminalNode APOSTROPHE() { return getToken(kernParser.APOSTROPHE, 0); }
		public TerminalNode MINUS() { return getToken(kernParser.MINUS, 0); }
		public PartialBarLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialBarLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterPartialBarLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitPartialBarLine(this);
		}
	}

	public final PartialBarLineContext partialBarLine() throws RecognitionException {
		PartialBarLineContext _localctx = new PartialBarLineContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_partialBarLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_la = _input.LA(1);
			if ( !(((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & ((1L << (GRAVE_ACCENT - 50)) | (1L << (APOSTROPHE - 50)) | (1L << (MINUS - 50)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplineOperationsContext extends ParserRuleContext {
		public SplineTerminatorContext splineTerminator() {
			return getRuleContext(SplineTerminatorContext.class,0);
		}
		public SplineOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splineOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterSplineOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitSplineOperations(this);
		}
	}

	public final SplineOperationsContext splineOperations() throws RecognitionException {
		SplineOperationsContext _localctx = new SplineOperationsContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_splineOperations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			splineTerminator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplineTerminatorContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(kernParser.ASTERISK, 0); }
		public TerminalNode MINUS() { return getToken(kernParser.MINUS, 0); }
		public SplineTerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splineTerminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).enterSplineTerminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof kernListener ) ((kernListener)listener).exitSplineTerminator(this);
		}
	}

	public final SplineTerminatorContext splineTerminator() throws RecognitionException {
		SplineTerminatorContext _localctx = new SplineTerminatorContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_splineTerminator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(ASTERISK);
			setState(476);
			match(MINUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3V\u01e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\6\2\u0088\n\2\r\2\16\2\u0089"+
		"\3\2\5\2\u008d\n\2\3\3\3\3\3\3\7\3\u0092\n\3\f\3\16\3\u0095\13\3\3\4\3"+
		"\4\3\4\5\4\u009a\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\u00a5\n\b"+
		"\f\b\16\b\u00a8\13\b\3\t\3\t\5\t\u00ac\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u00b4\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cc\n\f\3\r\3\r\5\r\u00d0\n\r\3\r"+
		"\5\r\u00d3\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\7\25\u00e4\n\25\f\25\16\25\u00e7\13\25\3\26\3\26"+
		"\5\26\u00eb\n\26\3\27\3\27\5\27\u00ef\n\27\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\7\31\u00f8\n\31\f\31\16\31\u00fb\13\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\7\34\u0103\n\34\f\34\16\34\u0106\13\34\3\35\3\35\3\35\5\35\u010b"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0117\n\36"+
		"\3\37\3\37\3\37\7\37\u011c\n\37\f\37\16\37\u011f\13\37\3\37\5\37\u0122"+
		"\n\37\3 \3 \3 \6 \u0127\n \r \16 \u0128\3!\3!\3!\3!\5!\u012f\n!\3!\3!"+
		"\3\"\3\"\7\"\u0135\n\"\f\"\16\"\u0138\13\"\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\7#\u0144\n#\f#\16#\u0147\13#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3*\3*\3+\3+\3+\3+\3+\3+\3+\5+\u015e\n+\3,\3,\3-\3-\3.\3.\5.\u0166\n"+
		".\3/\3/\3\60\6\60\u016b\n\60\r\60\16\60\u016c\3\60\6\60\u0170\n\60\r\60"+
		"\16\60\u0171\5\60\u0174\n\60\3\61\3\61\3\61\5\61\u0179\n\61\3\61\5\61"+
		"\u017c\n\61\3\62\3\62\3\63\5\63\u0181\n\63\3\63\5\63\u0184\n\63\3\63\3"+
		"\63\3\63\5\63\u0189\n\63\3\64\5\64\u018c\n\64\3\64\3\64\5\64\u0190\n\64"+
		"\3\64\3\64\5\64\u0194\n\64\3\64\5\64\u0197\n\64\3\64\5\64\u019a\n\64\3"+
		"\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\6;\u01a9\n;\r;\16;\u01aa"+
		"\3<\3<\3<\5<\u01b0\n<\3<\3<\5<\u01b4\n<\5<\u01b6\n<\3<\3<\3=\6=\u01bb"+
		"\n=\r=\16=\u01bc\3=\3=\5=\u01c1\n=\5=\u01c3\n=\3=\5=\u01c6\n=\3=\5=\u01c9"+
		"\n=\3=\5=\u01cc\n=\3=\5=\u01cf\n=\3>\5>\u01d2\n>\3>\3>\5>\u01d6\n>\3?"+
		"\3?\3@\3@\3A\3A\3B\3B\3B\3B\2\2C\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\2\21\4\2./;;\4\2#%+-\4\2\4\4AB\3\2\5\13\4\2\3\3\f\21\3\2LQ\4\2\22\22"+
		"\61\61\4\2\67\67@@\3\2\24\25\3\2\30\31\3\2FI\3\2AB\4\2\6\b\n\n\3\2\34"+
		"\36\5\2\64\64\66\66BB\2\u01ef\2\u0084\3\2\2\2\4\u008e\3\2\2\2\6\u0099"+
		"\3\2\2\2\b\u009b\3\2\2\2\n\u009d\3\2\2\2\f\u009f\3\2\2\2\16\u00a1\3\2"+
		"\2\2\20\u00ab\3\2\2\2\22\u00b3\3\2\2\2\24\u00b5\3\2\2\2\26\u00cb\3\2\2"+
		"\2\30\u00cf\3\2\2\2\32\u00d4\3\2\2\2\34\u00d6\3\2\2\2\36\u00d8\3\2\2\2"+
		" \u00da\3\2\2\2\"\u00dc\3\2\2\2$\u00de\3\2\2\2&\u00e0\3\2\2\2(\u00e5\3"+
		"\2\2\2*\u00e8\3\2\2\2,\u00ee\3\2\2\2.\u00f0\3\2\2\2\60\u00f4\3\2\2\2\62"+
		"\u00fc\3\2\2\2\64\u00fe\3\2\2\2\66\u0104\3\2\2\28\u010a\3\2\2\2:\u0116"+
		"\3\2\2\2<\u0118\3\2\2\2>\u0123\3\2\2\2@\u012a\3\2\2\2B\u0136\3\2\2\2D"+
		"\u0145\3\2\2\2F\u0148\3\2\2\2H\u014a\3\2\2\2J\u014c\3\2\2\2L\u014e\3\2"+
		"\2\2N\u0150\3\2\2\2P\u0152\3\2\2\2R\u0154\3\2\2\2T\u015d\3\2\2\2V\u015f"+
		"\3\2\2\2X\u0161\3\2\2\2Z\u0163\3\2\2\2\\\u0167\3\2\2\2^\u0173\3\2\2\2"+
		"`\u0175\3\2\2\2b\u017d\3\2\2\2d\u0180\3\2\2\2f\u018b\3\2\2\2h\u019b\3"+
		"\2\2\2j\u019d\3\2\2\2l\u019f\3\2\2\2n\u01a1\3\2\2\2p\u01a3\3\2\2\2r\u01a5"+
		"\3\2\2\2t\u01a8\3\2\2\2v\u01b5\3\2\2\2x\u01ba\3\2\2\2z\u01d1\3\2\2\2|"+
		"\u01d7\3\2\2\2~\u01d9\3\2\2\2\u0080\u01db\3\2\2\2\u0082\u01dd\3\2\2\2"+
		"\u0084\u0087\5\4\3\2\u0085\u0086\7S\2\2\u0086\u0088\5\16\b\2\u0087\u0085"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u008d\7S\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\3\3\2\2\2\u008e\u0093\5\6\4\2\u008f\u0090\7:\2\2\u0090\u0092"+
		"\5\6\4\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\5\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009a\5\b\5\2"+
		"\u0097\u009a\5\n\6\2\u0098\u009a\5\f\7\2\u0099\u0096\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u0098\3\2\2\2\u009a\7\3\2\2\2\u009b\u009c\7\37\2\2\u009c"+
		"\t\3\2\2\2\u009d\u009e\7 \2\2\u009e\13\3\2\2\2\u009f\u00a0\7!\2\2\u00a0"+
		"\r\3\2\2\2\u00a1\u00a6\5\20\t\2\u00a2\u00a3\7:\2\2\u00a3\u00a5\5\20\t"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\17\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\5\22\n\2\u00aa"+
		"\u00ac\t\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\21\3\2\2"+
		"\2\u00ad\u00b4\5\24\13\2\u00ae\u00b4\5\26\f\2\u00af\u00b4\58\35\2\u00b0"+
		"\u00b4\5x=\2\u00b1\u00b4\5\u0080A\2\u00b2\u00b4\5:\36\2\u00b3\u00ad\3"+
		"\2\2\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\23\3\2\2\2\u00b5\u00b6\7\"\2"+
		"\2\u00b6\25\3\2\2\2\u00b7\u00b8\7&\2\2\u00b8\u00cc\5&\24\2\u00b9\u00ba"+
		"\7\'\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bc\5(\25\2\u00bc\u00bd\7?\2\2\u00bd"+
		"\u00cc\3\2\2\2\u00be\u00bf\7*\2\2\u00bf\u00cc\5,\27\2\u00c0\u00c1\7)\2"+
		"\2\u00c1\u00c2\7<\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00cc\7=\2\2\u00c4\u00c5"+
		"\7(\2\2\u00c5\u00cc\5$\23\2\u00c6\u00c7\7-\2\2\u00c7\u00c8\5\30\r\2\u00c8"+
		"\u00c9\7C\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00cc\t\3\2\2\u00cb\u00b7\3\2"+
		"\2\2\u00cb\u00b9\3\2\2\2\u00cb\u00be\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb"+
		"\u00c4\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\27\3\2\2"+
		"\2\u00cd\u00d0\5\34\17\2\u00ce\u00d0\5\36\20\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00d3\5\32\16\2\u00d2\u00d1\3"+
		"\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\31\3\2\2\2\u00d4\u00d5\t\4\2\2\u00d5"+
		"\33\3\2\2\2\u00d6\u00d7\5 \21\2\u00d7\35\3\2\2\2\u00d8\u00d9\5\"\22\2"+
		"\u00d9\37\3\2\2\2\u00da\u00db\t\5\2\2\u00db!\3\2\2\2\u00dc\u00dd\t\6\2"+
		"\2\u00dd#\3\2\2\2\u00de\u00df\7T\2\2\u00df%\3\2\2\2\u00e0\u00e1\t\7\2"+
		"\2\u00e1\'\3\2\2\2\u00e2\u00e4\5*\26\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6)\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00ea\5 \21\2\u00e9\u00eb\5\32\16\2\u00ea\u00e9\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb+\3\2\2\2\u00ec\u00ef\5.\30\2\u00ed\u00ef"+
		"\t\b\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef-\3\2\2\2\u00f0"+
		"\u00f1\5\60\31\2\u00f1\u00f2\7@\2\2\u00f2\u00f3\5\62\32\2\u00f3/\3\2\2"+
		"\2\u00f4\u00f9\7T\2\2\u00f5\u00f6\7E\2\2\u00f6\u00f8\7T\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\61\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\5\64\33\2\u00fd\63\3\2\2\2"+
		"\u00fe\u00ff\7T\2\2\u00ff\u0100\5\66\34\2\u0100\65\3\2\2\2\u0101\u0103"+
		"\7;\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\67\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010b\5> \2"+
		"\u0108\u010b\5@!\2\u0109\u010b\5`\61\2\u010a\u0107\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010a\u0109\3\2\2\2\u010b9\3\2\2\2\u010c\u0117\5<\37\2\u010d"+
		"\u010e\7<\2\2\u010e\u010f\5<\37\2\u010f\u0110\7=\2\2\u0110\u0117\3\2\2"+
		"\2\u0111\u0112\5<\37\2\u0112\u0113\7>\2\2\u0113\u0114\5<\37\2\u0114\u0115"+
		"\7?\2\2\u0115\u0117\3\2\2\2\u0116\u010c\3\2\2\2\u0116\u010d\3\2\2\2\u0116"+
		"\u0111\3\2\2\2\u0117;\3\2\2\2\u0118\u011d\5d\63\2\u0119\u011a\7@\2\2\u011a"+
		"\u011c\5d\63\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0122\5b\62\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122=\3\2\2\2"+
		"\u0123\u0126\5@!\2\u0124\u0125\79\2\2\u0125\u0127\5@!\2\u0126\u0124\3"+
		"\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"?\3\2\2\2\u012a\u012b\5B\"\2\u012b\u012c\5\64\33\2\u012c\u012e\5^\60\2"+
		"\u012d\u012f\5T+\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u0131\5D#\2\u0131A\3\2\2\2\u0132\u0135\5H%\2\u0133\u0135"+
		"\5F$\2\u0134\u0132\3\2\2\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137C\3\2\2\2\u0138\u0136\3\2\2\2"+
		"\u0139\u0144\5J&\2\u013a\u0144\5V,\2\u013b\u0144\5L\'\2\u013c\u0144\5"+
		"N(\2\u013d\u0144\5Z.\2\u013e\u0144\5\\/\2\u013f\u0144\5X-\2\u0140\u0144"+
		"\5b\62\2\u0141\u0144\5P)\2\u0142\u0144\5R*\2\u0143\u0139\3\2\2\2\u0143"+
		"\u013a\3\2\2\2\u0143\u013b\3\2\2\2\u0143\u013c\3\2\2\2\u0143\u013d\3\2"+
		"\2\2\u0143\u013e\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0140\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2"+
		"\2\2\u0145\u0146\3\2\2\2\u0146E\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149"+
		"\7>\2\2\u0149G\3\2\2\2\u014a\u014b\7<\2\2\u014bI\3\2\2\2\u014c\u014d\7"+
		"?\2\2\u014dK\3\2\2\2\u014e\u014f\78\2\2\u014fM\3\2\2\2\u0150\u0151\7="+
		"\2\2\u0151O\3\2\2\2\u0152\u0153\7\23\2\2\u0153Q\3\2\2\2\u0154\u0155\7"+
		"\65\2\2\u0155S\3\2\2\2\u0156\u015e\7A\2\2\u0157\u0158\7A\2\2\u0158\u015e"+
		"\7A\2\2\u0159\u015e\7B\2\2\u015a\u015b\7B\2\2\u015b\u015e\7B\2\2\u015c"+
		"\u015e\7\4\2\2\u015d\u0156\3\2\2\2\u015d\u0157\3\2\2\2\u015d\u0159\3\2"+
		"\2\2\u015d\u015a\3\2\2\2\u015d\u015c\3\2\2\2\u015eU\3\2\2\2\u015f\u0160"+
		"\t\t\2\2\u0160W\3\2\2\2\u0161\u0162\t\n\2\2\u0162Y\3\2\2\2\u0163\u0165"+
		"\7\26\2\2\u0164\u0166\7\27\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2"+
		"\u0166[\3\2\2\2\u0167\u0168\t\13\2\2\u0168]\3\2\2\2\u0169\u016b\5\"\22"+
		"\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016d\u0174\3\2\2\2\u016e\u0170\5 \21\2\u016f\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2"+
		"\2\2\u0173\u016a\3\2\2\2\u0173\u016f\3\2\2\2\u0174_\3\2\2\2\u0175\u0176"+
		"\5\64\33\2\u0176\u0178\7\32\2\2\u0177\u0179\7\32\2\2\u0178\u0177\3\2\2"+
		"\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u017c\5b\62\2\u017b\u017a"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017ca\3\2\2\2\u017d\u017e\7D\2\2\u017ec"+
		"\3\2\2\2\u017f\u0181\7\60\2\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2"+
		"\u0181\u0183\3\2\2\2\u0182\u0184\7\65\2\2\u0183\u0182\3\2\2\2\u0183\u0184"+
		"\3\2\2\2\u0184\u0188\3\2\2\2\u0185\u0189\5f\64\2\u0186\u0189\t\f\2\2\u0187"+
		"\u0189\7\32\2\2\u0188\u0185\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0187\3"+
		"\2\2\2\u0189e\3\2\2\2\u018a\u018c\5l\67\2\u018b\u018a\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u0190\5j\66\2\u018e\u0190\5h\65\2\u018f"+
		"\u018d\3\2\2\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u0194\5n"+
		"8\2\u0192\u0194\5p9\2\u0193\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0193\u0194"+
		"\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0197\5t;\2\u0196\u0195\3\2\2\2\u0196"+
		"\u0197\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u019a\5r:\2\u0199\u0198\3\2\2"+
		"\2\u0199\u019a\3\2\2\2\u019ag\3\2\2\2\u019b\u019c\7J\2\2\u019ci\3\2\2"+
		"\2\u019d\u019e\7K\2\2\u019ek\3\2\2\2\u019f\u01a0\t\r\2\2\u01a0m\3\2\2"+
		"\2\u01a1\u01a2\7\33\2\2\u01a2o\3\2\2\2\u01a3\u01a4\7E\2\2\u01a4q\3\2\2"+
		"\2\u01a5\u01a6\t\16\2\2\u01a6s\3\2\2\2\u01a7\u01a9\5v<\2\u01a8\u01a7\3"+
		"\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"u\3\2\2\2\u01ac\u01b6\t\17\2\2\u01ad\u01af\7\f\2\2\u01ae\u01b0\7\f\2\2"+
		"\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b6\3\2\2\2\u01b1\u01b3"+
		"\7\16\2\2\u01b2\u01b4\7\16\2\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2"+
		"\u01b4\u01b6\3\2\2\2\u01b5\u01ac\3\2\2\2\u01b5\u01ad\3\2\2\2\u01b5\u01b1"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\7T\2\2\u01b8"+
		"w\3\2\2\2\u01b9\u01bb\7\62\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c2\3\2\2\2\u01be\u01c0"+
		"\7T\2\2\u01bf\u01c1\5|?\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c3\3\2\2\2\u01c2\u01be\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2"+
		"\2\2\u01c4\u01c6\7C\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c8\3\2\2\2\u01c7\u01c9\5z>\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2"+
		"\2\u01c9\u01cb\3\2\2\2\u01ca\u01cc\5~@\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cf\7C\2\2\u01ce\u01cd\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cfy\3\2\2\2\u01d0\u01d2\7/\2\2\u01d1\u01d0\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\7\63\2\2\u01d4\u01d6\7"+
		"/\2\2\u01d5\u01d4\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6{\3\2\2\2\u01d7\u01d8"+
		"\7R\2\2\u01d8}\3\2\2\2\u01d9\u01da\t\20\2\2\u01da\177\3\2\2\2\u01db\u01dc"+
		"\5\u0082B\2\u01dc\u0081\3\2\2\2\u01dd\u01de\7-\2\2\u01de\u01df\7B\2\2"+
		"\u01df\u0083\3\2\2\2\67\u0089\u008c\u0093\u0099\u00a6\u00ab\u00b3\u00cb"+
		"\u00cf\u00d2\u00e5\u00ea\u00ee\u00f9\u0104\u010a\u0116\u011d\u0121\u0128"+
		"\u012e\u0134\u0136\u0143\u0145\u015d\u0165\u016c\u0171\u0173\u0178\u017b"+
		"\u0180\u0183\u0188\u018b\u018f\u0193\u0196\u0199\u01aa\u01af\u01b3\u01b5"+
		"\u01bc\u01c0\u01c2\u01c5\u01c8\u01cb\u01ce\u01d1\u01d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}