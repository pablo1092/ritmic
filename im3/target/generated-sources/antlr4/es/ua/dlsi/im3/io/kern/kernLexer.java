// Generated from es\u005Cua\dlsi\im3\io\kern\kern.g4 by ANTLR 4.7
package es.ua.dlsi.im3.io.kern;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class kernLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "KERN", "ROOT", "HARM", "INTERPRETATION", "SECTIONLABEL", 
		"INSTRUMENT", "METRONOME", "TANDEM_CLEF", "TANDEM_KEY", "TANDEM_STAFF", 
		"TANDEM_MET", "TANDEM_METER", "ATONAL_PASSAGE", "UNKNOWN_KEY", "ASTERISK", 
		"FIELDCOMMENT", "EXCLAMATION_SIGN", "NONFUNCTIONALCHORD", "QUESTIONMARK", 
		"EQUAL_SIGN", "PIPE_SIGN", "GRAVE_ACCENT", "TILDE", "APOSTROPHE", "BACKSLASH", 
		"UNDERSCORE", "SPACE", "TAB", "DOT", "LEFTPAR", "RIGHTPAR", "LEFTBRACKET", 
		"RIGHTBRACKET", "SLASH", "OCTOTHORPE", "MINUS", "COLON", "SEMICOLON", 
		"PLUS", "NEAPOLITAN_SIXTH", "ITALIAN_SIXTH", "FRENCH_SIXTH", "TRISTAN_CHORD", 
		"DEGREE_LOWERCASE", "DEGREE_UPPERCASE", "G2", "F4", "C3", "C4", "G1", 
		"Gv2", "LETTER", "EOL", "NUMBER", "LINE_COMMENT", "EDITORIALSIGNIFIER", 
		"TEXT", "COMMENTTEXT"
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


	public kernLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "kern.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2V\u01ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$"+
		"\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3-\3-\3-\3.\3."+
		"\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3"+
		"@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3I\3"+
		"I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u0180\nI\3J\3J\3J\3J\3J\3J\3"+
		"J\3J\3J\3J\3J\3J\3J\3J\5J\u0190\nJ\3K\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3"+
		"N\3O\3O\3O\3P\3P\3P\3P\3Q\3Q\3R\5R\u01a8\nR\3R\3R\3S\6S\u01ad\nS\rS\16"+
		"S\u01ae\3T\3T\3T\3T\7T\u01b5\nT\fT\16T\u01b8\13T\3T\5T\u01bb\nT\3T\3T"+
		"\3T\3T\3U\3U\3U\3U\3V\6V\u01c6\nV\rV\16V\u01c7\3W\6W\u01cb\nW\rW\16W\u01cc"+
		"\2\2X\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00ab\2\u00ad\2\3\2\6\4\2cy||\4\2\f\f\17"+
		"\17\4\2\13\f\17\17\6\2\13\f\17\17##~~\2\u01dd\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\3\u00af\3\2\2"+
		"\2\5\u00b1\3\2\2\2\7\u00b3\3\2\2\2\t\u00b5\3\2\2\2\13\u00b7\3\2\2\2\r"+
		"\u00b9\3\2\2\2\17\u00bb\3\2\2\2\21\u00bd\3\2\2\2\23\u00bf\3\2\2\2\25\u00c1"+
		"\3\2\2\2\27\u00c3\3\2\2\2\31\u00c5\3\2\2\2\33\u00c7\3\2\2\2\35\u00c9\3"+
		"\2\2\2\37\u00cb\3\2\2\2!\u00cd\3\2\2\2#\u00cf\3\2\2\2%\u00d1\3\2\2\2\'"+
		"\u00d3\3\2\2\2)\u00d5\3\2\2\2+\u00d7\3\2\2\2-\u00d9\3\2\2\2/\u00db\3\2"+
		"\2\2\61\u00dd\3\2\2\2\63\u00df\3\2\2\2\65\u00e1\3\2\2\2\67\u00e3\3\2\2"+
		"\29\u00e5\3\2\2\2;\u00e7\3\2\2\2=\u00ee\3\2\2\2?\u00f5\3\2\2\2A\u00fc"+
		"\3\2\2\2C\u0101\3\2\2\2E\u0106\3\2\2\2G\u010b\3\2\2\2I\u0111\3\2\2\2K"+
		"\u0117\3\2\2\2M\u011a\3\2\2\2O\u0121\3\2\2\2Q\u0126\3\2\2\2S\u0129\3\2"+
		"\2\2U\u012d\3\2\2\2W\u0131\3\2\2\2Y\u0133\3\2\2\2[\u0136\3\2\2\2]\u0138"+
		"\3\2\2\2_\u013b\3\2\2\2a\u013d\3\2\2\2c\u013f\3\2\2\2e\u0141\3\2\2\2g"+
		"\u0143\3\2\2\2i\u0145\3\2\2\2k\u0147\3\2\2\2m\u0149\3\2\2\2o\u014b\3\2"+
		"\2\2q\u014d\3\2\2\2s\u014f\3\2\2\2u\u0151\3\2\2\2w\u0153\3\2\2\2y\u0155"+
		"\3\2\2\2{\u0157\3\2\2\2}\u0159\3\2\2\2\177\u015b\3\2\2\2\u0081\u015d\3"+
		"\2\2\2\u0083\u015f\3\2\2\2\u0085\u0161\3\2\2\2\u0087\u0163\3\2\2\2\u0089"+
		"\u0165\3\2\2\2\u008b\u0168\3\2\2\2\u008d\u016b\3\2\2\2\u008f\u016e\3\2"+
		"\2\2\u0091\u017f\3\2\2\2\u0093\u018f\3\2\2\2\u0095\u0191\3\2\2\2\u0097"+
		"\u0194\3\2\2\2\u0099\u0197\3\2\2\2\u009b\u019a\3\2\2\2\u009d\u019d\3\2"+
		"\2\2\u009f\u01a0\3\2\2\2\u00a1\u01a4\3\2\2\2\u00a3\u01a7\3\2\2\2\u00a5"+
		"\u01ac\3\2\2\2\u00a7\u01b0\3\2\2\2\u00a9\u01c0\3\2\2\2\u00ab\u01c5\3\2"+
		"\2\2\u00ad\u01ca\3\2\2\2\u00af\u00b0\7E\2\2\u00b0\4\3\2\2\2\u00b1\u00b2"+
		"\7p\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7c\2\2\u00b4\b\3\2\2\2\u00b5\u00b6"+
		"\7d\2\2\u00b6\n\3\2\2\2\u00b7\u00b8\7e\2\2\u00b8\f\3\2\2\2\u00b9\u00ba"+
		"\7f\2\2\u00ba\16\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc\20\3\2\2\2\u00bd\u00be"+
		"\7h\2\2\u00be\22\3\2\2\2\u00bf\u00c0\7i\2\2\u00c0\24\3\2\2\2\u00c1\u00c2"+
		"\7C\2\2\u00c2\26\3\2\2\2\u00c3\u00c4\7D\2\2\u00c4\30\3\2\2\2\u00c5\u00c6"+
		"\7F\2\2\u00c6\32\3\2\2\2\u00c7\u00c8\7G\2\2\u00c8\34\3\2\2\2\u00c9\u00ca"+
		"\7H\2\2\u00ca\36\3\2\2\2\u00cb\u00cc\7I\2\2\u00cc \3\2\2\2\u00cd\u00ce"+
		"\7Z\2\2\u00ce\"\3\2\2\2\u00cf\u00d0\7m\2\2\u00d0$\3\2\2\2\u00d1\u00d2"+
		"\7N\2\2\u00d2&\3\2\2\2\u00d3\u00d4\7L\2\2\u00d4(\3\2\2\2\u00d5\u00d6\7"+
		"Y\2\2\u00d6*\3\2\2\2\u00d7\u00d8\7y\2\2\u00d8,\3\2\2\2\u00d9\u00da\7V"+
		"\2\2\u00da.\3\2\2\2\u00db\u00dc\7v\2\2\u00dc\60\3\2\2\2\u00dd\u00de\7"+
		"t\2\2\u00de\62\3\2\2\2\u00df\u00e0\7q\2\2\u00e0\64\3\2\2\2\u00e1\u00e2"+
		"\7O\2\2\u00e2\66\3\2\2\2\u00e3\u00e4\7o\2\2\u00e48\3\2\2\2\u00e5\u00e6"+
		"\7R\2\2\u00e6:\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8\u00e9\7,\2\2\u00e9\u00ea"+
		"\7m\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7p\2\2\u00ed"+
		"<\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f0\7,\2\2\u00f0\u00f1\7t\2\2\u00f1"+
		"\u00f2\7q\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7v\2\2\u00f4>\3\2\2\2\u00f5"+
		"\u00f6\7,\2\2\u00f6\u00f7\7,\2\2\u00f7\u00f8\7j\2\2\u00f8\u00f9\7c\2\2"+
		"\u00f9\u00fa\7t\2\2\u00fa\u00fb\7o\2\2\u00fb@\3\2\2\2\u00fc\u00fd\7,\2"+
		"\2\u00fd\u00fe\7,\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\5\u00abV\2\u0100"+
		"B\3\2\2\2\u0101\u0102\7,\2\2\u0102\u0103\7@\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\5\u00abV\2\u0105D\3\2\2\2\u0106\u0107\7,\2\2\u0107\u0108\7K\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u010a\5\u00abV\2\u010aF\3\2\2\2\u010b\u010c"+
		"\7,\2\2\u010c\u010d\7O\2\2\u010d\u010e\7O\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\5\u00a5S\2\u0110H\3\2\2\2\u0111\u0112\7,\2\2\u0112\u0113\7e\2\2"+
		"\u0113\u0114\7n\2\2\u0114\u0115\7g\2\2\u0115\u0116\7h\2\2\u0116J\3\2\2"+
		"\2\u0117\u0118\7,\2\2\u0118\u0119\7m\2\2\u0119L\3\2\2\2\u011a\u011b\7"+
		",\2\2\u011b\u011c\7u\2\2\u011c\u011d\7v\2\2\u011d\u011e\7c\2\2\u011e\u011f"+
		"\7h\2\2\u011f\u0120\7h\2\2\u0120N\3\2\2\2\u0121\u0122\7,\2\2\u0122\u0123"+
		"\7o\2\2\u0123\u0124\7g\2\2\u0124\u0125\7v\2\2\u0125P\3\2\2\2\u0126\u0127"+
		"\7,\2\2\u0127\u0128\7O\2\2\u0128R\3\2\2\2\u0129\u012a\7,\2\2\u012a\u012b"+
		"\7Z\2\2\u012b\u012c\7<\2\2\u012cT\3\2\2\2\u012d\u012e\7,\2\2\u012e\u012f"+
		"\7A\2\2\u012f\u0130\7<\2\2\u0130V\3\2\2\2\u0131\u0132\7,\2\2\u0132X\3"+
		"\2\2\2\u0133\u0134\5[.\2\u0134\u0135\5\u00adW\2\u0135Z\3\2\2\2\u0136\u0137"+
		"\7#\2\2\u0137\\\3\2\2\2\u0138\u0139\7A\2\2\u0139\u013a\7/\2\2\u013a^\3"+
		"\2\2\2\u013b\u013c\7A\2\2\u013c`\3\2\2\2\u013d\u013e\7?\2\2\u013eb\3\2"+
		"\2\2\u013f\u0140\7~\2\2\u0140d\3\2\2\2\u0141\u0142\7b\2\2\u0142f\3\2\2"+
		"\2\u0143\u0144\7\u0080\2\2\u0144h\3\2\2\2\u0145\u0146\7)\2\2\u0146j\3"+
		"\2\2\2\u0147\u0148\7^\2\2\u0148l\3\2\2\2\u0149\u014a\7a\2\2\u014an\3\2"+
		"\2\2\u014b\u014c\7\"\2\2\u014cp\3\2\2\2\u014d\u014e\7\13\2\2\u014er\3"+
		"\2\2\2\u014f\u0150\7\60\2\2\u0150t\3\2\2\2\u0151\u0152\7*\2\2\u0152v\3"+
		"\2\2\2\u0153\u0154\7+\2\2\u0154x\3\2\2\2\u0155\u0156\7]\2\2\u0156z\3\2"+
		"\2\2\u0157\u0158\7_\2\2\u0158|\3\2\2\2\u0159\u015a\7\61\2\2\u015a~\3\2"+
		"\2\2\u015b\u015c\7%\2\2\u015c\u0080\3\2\2\2\u015d\u015e\7/\2\2\u015e\u0082"+
		"\3\2\2\2\u015f\u0160\7<\2\2\u0160\u0084\3\2\2\2\u0161\u0162\7=\2\2\u0162"+
		"\u0086\3\2\2\2\u0163\u0164\7-\2\2\u0164\u0088\3\2\2\2\u0165\u0166\7P\2"+
		"\2\u0166\u0167\7d\2\2\u0167\u008a\3\2\2\2\u0168\u0169\7N\2\2\u0169\u016a"+
		"\7v\2\2\u016a\u008c\3\2\2\2\u016b\u016c\7H\2\2\u016c\u016d\7t\2\2\u016d"+
		"\u008e\3\2\2\2\u016e\u016f\7V\2\2\u016f\u0170\7t\2\2\u0170\u0090\3\2\2"+
		"\2\u0171\u0180\7k\2\2\u0172\u0173\7k\2\2\u0173\u0180\7k\2\2\u0174\u0175"+
		"\7k\2\2\u0175\u0176\7k\2\2\u0176\u0180\7k\2\2\u0177\u0178\7k\2\2\u0178"+
		"\u0180\7x\2\2\u0179\u0180\7x\2\2\u017a\u017b\7x\2\2\u017b\u0180\7k\2\2"+
		"\u017c\u017d\7x\2\2\u017d\u017e\7k\2\2\u017e\u0180\7k\2\2\u017f\u0171"+
		"\3\2\2\2\u017f\u0172\3\2\2\2\u017f\u0174\3\2\2\2\u017f\u0177\3\2\2\2\u017f"+
		"\u0179\3\2\2\2\u017f\u017a\3\2\2\2\u017f\u017c\3\2\2\2\u0180\u0092\3\2"+
		"\2\2\u0181\u0190\7K\2\2\u0182\u0183\7K\2\2\u0183\u0190\7K\2\2\u0184\u0185"+
		"\7K\2\2\u0185\u0186\7K\2\2\u0186\u0190\7K\2\2\u0187\u0188\7K\2\2\u0188"+
		"\u0190\7X\2\2\u0189\u0190\7X\2\2\u018a\u018b\7X\2\2\u018b\u0190\7K\2\2"+
		"\u018c\u018d\7X\2\2\u018d\u018e\7K\2\2\u018e\u0190\7K\2\2\u018f\u0181"+
		"\3\2\2\2\u018f\u0182\3\2\2\2\u018f\u0184\3\2\2\2\u018f\u0187\3\2\2\2\u018f"+
		"\u0189\3\2\2\2\u018f\u018a\3\2\2\2\u018f\u018c\3\2\2\2\u0190\u0094\3\2"+
		"\2\2\u0191\u0192\7I\2\2\u0192\u0193\7\64\2\2\u0193\u0096\3\2\2\2\u0194"+
		"\u0195\7H\2\2\u0195\u0196\7\66\2\2\u0196\u0098\3\2\2\2\u0197\u0198\7E"+
		"\2\2\u0198\u0199\7\65\2\2\u0199\u009a\3\2\2\2\u019a\u019b\7E\2\2\u019b"+
		"\u019c\7\66\2\2\u019c\u009c\3\2\2\2\u019d\u019e\7I\2\2\u019e\u019f\7\63"+
		"\2\2\u019f\u009e\3\2\2\2\u01a0\u01a1\7I\2\2\u01a1\u01a2\7x\2\2\u01a2\u01a3"+
		"\7\64\2\2\u01a3\u00a0\3\2\2\2\u01a4\u01a5\t\2\2\2\u01a5\u00a2\3\2\2\2"+
		"\u01a6\u01a8\7\17\2\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01aa\7\f\2\2\u01aa\u00a4\3\2\2\2\u01ab\u01ad\4\62;\2\u01ac"+
		"\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2"+
		"\2\2\u01af\u00a6\3\2\2\2\u01b0\u01b1\7#\2\2\u01b1\u01b2\7#\2\2\u01b2\u01b6"+
		"\3\2\2\2\u01b3\u01b5\n\3\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b9\u01bb\7\17\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\7\f\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\bT"+
		"\2\2\u01bf\u00a8\3\2\2\2\u01c0\u01c1\7{\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\bU\3\2\u01c3\u00aa\3\2\2\2\u01c4\u01c6\n\4\2\2\u01c5\u01c4\3\2"+
		"\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"\u00ac\3\2\2\2\u01c9\u01cb\n\5\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc\3\2"+
		"\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u00ae\3\2\2\2\13\2"+
		"\u017f\u018f\u01a7\u01ae\u01b6\u01ba\u01c7\u01cc\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}