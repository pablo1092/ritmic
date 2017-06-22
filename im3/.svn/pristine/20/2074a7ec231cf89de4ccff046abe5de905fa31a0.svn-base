grammar kern;
/*
Don't use rules for lexer literals based on letters ('a'...) because they are ambiguos and
depend on the parser
*/
@lexer::header {
}

@parser::header {
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

song: header (EOL record)+ EOL?;

//TODO Comentarios de varias líneas en la cabecera, mejor hacer como los comentarios de java, quitarlos en el lexico

// with the number of elements we can initialize the number of spines
header: headerField (TAB headerField)*; //TODO Habilitar aqui las comprobaciones semanticas

headerField: headerKern | headerRoot | headerHarm;

headerKern: KERN;

//TODO ¿Para qué valía?
headerRoot: ROOT;

headerHarm: HARM;

record: (field (TAB field)*); 

//field: (token editorialToken?) | '.';
field: token 
     | (DOT // nothing is done, it is just a placeholder
     | FIELDCOMMENT 
     | EXCLAMATION_SIGN // empty comment
       )
     ;

//repeatToken: 

//token: interpretation | tandemInterpretation | splineOperations | localComment | note | rest | barline;
token: interpretation | tandemInterpretation | noteRestChord | barline | splineOperations | harm;

interpretation: INTERPRETATION;


tandemInterpretation:
    (TANDEM_CLEF clef) //| meter | key | metronome | instrument | instrumentClass | instrumentGroup;
    | (TANDEM_KEY LEFTBRACKET keysignature RIGHTBRACKET)
    | (TANDEM_METER meter)
    | (TANDEM_MET LEFTPAR 'C' RIGHTPAR) // not found in documentation, e.g. met(C) for common time
    | (TANDEM_STAFF staff)
    | (ASTERISK keyChange COLON)
    | (UNKNOWN_KEY  // unknown key
    | ATONAL_PASSAGE // atonal passage
    | SECTIONLABEL // section labels
    | INSTRUMENT //TODO Add a ScorePart for each instrument
    | METRONOME
    | ASTERISK) // a null interpretation (placeholder) will have just an asterisk
    ;

keyChange: (minorKey | majorKey) keyAccidental?;

//keyAccidental: (LETTER_n | OCTOTHORPE | MINUS);
keyAccidental: ('n' | OCTOTHORPE | MINUS);

//minorKey: LETTER_NOTES_LOWERCASE;
//minorKey: LETTER_NOTES_LOWERCASE; // 'a' | 'b' | 'c' | 'd' |'e' | 'f' | 'g'; //TODO ÀPor qu no va usando la regla esta?
minorKey: noteNameLowerCase;
//majorKey: LETTER_NOTES_UPPERCASE;
majorKey: noteNameUpperCase;

noteNameLowerCase: ('a'|'b'|'c'|'d'|'e'|'f'|'g');
noteNameUpperCase: ('A'|'B'|'C'|'D'|'E'|'F'|'G');

staff: NUMBER;

//TODO change C1....
clef: G2 | F4 | C3 | C4 | G1 | Gv2;

keysignature: keysignatureNote*; // natural, sharp, flat

//keysignatureNote: LETTER_NOTES_LOWERCASE keyAccidental?;
keysignatureNote: noteNameLowerCase keyAccidental?;

meter:
       meterKnown
       |
       (QUESTIONMARK // meterUknown
       |
       //LETER_X) //meterAmetric
	'X') //meterAmetric
       ;

meterKnown: numerator SLASH denominator;
//numerator: NUMBER ('+' NUMBER)*;
numerator: NUMBER (PLUS NUMBER)*;

denominator: duration;

//duration: figure editorialTokenSignifier? ('.'* editorialTokenSignifier?);
duration: NUMBER augmentationDots;
augmentationDots: (DOT)*;


noteRestChord: chord | note | rest;


//see http://humdrum.org/Humdrum/representations/harm.rep.html
//Chord identifications may be characterized as (1) explicit, (2) implied, or (3) alternate
harm: chordIdentification //  explicit
       | LEFTPAR chordIdentification RIGHTPAR // implied
       | chordIdentification LEFTBRACKET chordIdentification RIGHTBRACKET; // alternate (2nd value)	 

chordIdentification:      
    harmChord 
      (SLASH harmChord)* // shifting keys -modulations and secondary dominants - V/V/V/V/V/I is syntactically legal.
      pause?;


//note: duration pitch editorialTokenSignifier?;
chord: note (SPACE note)+;

note:  beforeNote duration noteName alteration? afterNote;

beforeNote:  //TODO Regla semantica (boolean) para que no se repitan
    (slurstart
    | tiestart)*
    ;

afterNote://TODO Regla semantica (boolean) para que no se repitan
	     (slurend | stem| tiemiddle | tieend| mordent| trill | beam| pause| partialbeam | tenuto)*;

tiestart: LEFTBRACKET;
slurstart: LEFTPAR;
slurend: RIGHTBRACKET;
tiemiddle: UNDERSCORE;
tieend: RIGHTPAR;
//partialbeam: LETTER_k;
partialbeam: 'k';
tenuto: TILDE;

//alteration: OCTOTHORPE | (OCTOTHORPE OCTOTHORPE) | MINUS | (MINUS MINUS) | LETTER_n;
alteration: OCTOTHORPE | (OCTOTHORPE OCTOTHORPE) | MINUS | (MINUS MINUS) | 'n';

stem:
    SLASH  // STEM_UP
    |
    BACKSLASH // STEM_DOWN;
    ;

beam:
    //LETTER_L //BEAM_START
	'L'
    |
    //LETTER_J; // BEAM_END
    'J';

mordent:
    //LETTER_W // MORDENT_INVERTED_TONE
	   'W'
    //LETTER_w?; // MORDENT_INVERTED_SEMITONE
       'w'?;

trill:
	 'T'
     |
     't';

noteName:  // todo - comprobar con semantico que todas las letras son iguales
    //(LETTER_NOTES_UPPERCASE+)  // BASS
	    (noteNameUpperCase+)	#bassNotes
    |
    //(LETTER_NOTES_LOWERCASE+)
	(noteNameLowerCase+)    #trebleNotes
	; // TREBLE

//rest: duration (LETTER_r LETTER_r?) pause?; // TODO the rr is used to denote whole measure rest
rest: duration ('r' 'r'?) pause?; // TODO the rr is used to denote whole measure rest

pause: SEMICOLON; // fermata


harmChord: 
	     NONFUNCTIONALCHORD? // non-functional chord (descriptive)
	     TILDE? //enharmonically equivalent spelling
	(harmChordSpecification 
	// antlrv4 prefers to have the TERMINALS grouped this way
	| (NEAPOLITAN_SIXTH //Neopolitan sixth chord (equivalent to "-IIb")       
	| ITALIAN_SIXTH//Italian augmented sixth chord
	| FRENCH_SIXTH//French augmented sixth chord
	//TODO| 'Gn' //German augmented sixth chord - use literal instead of lexer rule to avoid confusion with natural G
	| TRISTAN_CHORD)// "Tristan chord" (A4m7m10 above bass pitch) 
    | 'r' // for rest
    )
    	 ;
	 
harmChordSpecification: harmAlteredRoot? (harmMajorChord | harmMinorChord) (harmDiminished | harmAugmented)? harmExtendedTertianChord?  harmInversion?;
harmMinorChord: DEGREE_LOWERCASE;
harmMajorChord: DEGREE_UPPERCASE;
harmAlteredRoot: OCTOTHORPE | MINUS;
//harmDiminished: LETTER_o;
harmDiminished: 'o';
harmAugmented: PLUS;
/*harmInversion: LETTER_b // first inversion
	     | LETTER_c // second inversion
	 | LETTER_d // third inversion
     | LETTER_f; // hypothetical 6th inversion of a 13th chord is signified by the letter "f".*/

harmInversion: 'b' // first inversion
	     | 'c' // second inversion
	 | 'd' // third inversion
     | 'f'; // hypothetical 6th inversion of a 13th chord is signified by the letter "f".


harmExtendedTertianChord: harmExtensionInterval+;
//harmExtensionInterval: ((LETTER_M | LETTER_m | LETTER_P) | (LETTER_A LETTER_A?) | (LETTER_D LETTER_D?))? NUMBER; // usually 7,9,11,13, but for '?-'? non-functional chord (descriptive) all values must be possible
harmExtensionInterval: (('M' | 'm' | 'P') | ('A' 'A'?) | ('D' 'D'?))? NUMBER; // usually 7,9,11,13, but for '?-'? non-functional chord (descriptive) all values must be possible



barline: EQUAL_SIGN+ (NUMBER alternateMeasure?)? (COLON? barlineWidth? partialBarLine? COLON?) ; // COLON = repetition mark
//barlineWidth: (EXCLAMATION_SIGN PIPE_SIGN) | (PIPE_SIGN EXCLAMATION_SIGN) | (EXCLAMATION_SIGN | PIPE_SIGN);
barlineWidth: (EXCLAMATION_SIGN? PIPE_SIGN EXCLAMATION_SIGN?);
alternateMeasure: LETTER;
//alternateMeasure: ('a'..'z');
//repetitionMark: COLON;
partialBarLine:  
    GRAVE_ACCENT // partialBarLineTop 
    | APOSTROPHE // partialBarLineMid 
    | MINUS // no bar line;
	      ;


//globalComment: GLOBALCOMMENT;

splineOperations: splineTerminator; // terminator
splineTerminator: ASTERISK MINUS;


/// Lexer

KERN: '**kern';
ROOT: '**root';
HARM: '**harm';
INTERPRETATION: '**'TEXT;
SECTIONLABEL: '*>'TEXT;
INSTRUMENT: '*I'TEXT;
METRONOME: '*MM'NUMBER;
TANDEM_CLEF: '*clef';
TANDEM_KEY: '*k';
TANDEM_STAFF: '*staff';
TANDEM_MET: '*met';
TANDEM_METER: '*M';
ATONAL_PASSAGE: '*X:';
UNKNOWN_KEY: '*?:';
ASTERISK: '*';

FIELDCOMMENT: EXCLAMATION_SIGN COMMENTTEXT;

EXCLAMATION_SIGN: '!';


//GLOBALCOMMENT: '!!' ~[\n\r];
NONFUNCTIONALCHORD: '?-';
QUESTIONMARK: '?';
EQUAL_SIGN: '=';
PIPE_SIGN: '|';
GRAVE_ACCENT: '`'; 
TILDE: '~'; 
APOSTROPHE: '\'';
BACKSLASH: '\\';
UNDERSCORE: '_';
SPACE: ' ';
TAB: '\t';
DOT: '.';
LEFTPAR: '(';
RIGHTPAR: ')';
LEFTBRACKET: '[';
RIGHTBRACKET: ']';
SLASH: '/';
OCTOTHORPE: '#';
MINUS: '-';
COLON: ':';
SEMICOLON: ';';
PLUS: '+';


NEAPOLITAN_SIXTH:'Nb';
ITALIAN_SIXTH:'Lt';
FRENCH_SIXTH:'Fr';
//GERMAN_SIXTH:'Gn';
TRISTAN_CHORD:'Tr';
DEGREE_LOWERCASE:'i' | 'ii' | 'iii' | 'iv' | 'v' | 'vi' | 'vii';
DEGREE_UPPERCASE: 'I' | 'II' | 'III' |'IV' | 'V' | 'VI' | 'VII';
G2:'G2';
F4:'F4';
C3:'C3';
C4:'C4';
G1:'G1';
Gv2: 'Gv2';

LETTER: ('a'..'w'| 'z'); // 'x' and 'y' are editorial signifiers
/*LETTER: LETTER_NOTES_LOWERCASE | 'j'
      | LETTER_k | '' | LETTER_m | LETTER_n | LETTER_o | ('p'..'q') | LETTER_r 
      | ('s'..'v') | LETTER_w | ('x'..'z');
	  //('a'..'z');
LETTER_NOTES_LOWERCASE: ('a'|LETTER_b|LETTER_c|LETTER_d|'e'|LETTER_f|'g');


LETTER_b: 'b';
LETTER_c: 'c';
LETTER_d: 'd';
LETTER_f: 'f';
LETTER_k: 'k';
LETTER_m: 'm';
LETTER_n: 'n';
LETTER_o: 'o';
LETTER_r: 'r';
LETTER_w: 'w';

LETTER_NOTES_UPPERCASE: LETTER_A | ('B'..'C') | LETTER_D | ('E'..'G');

LETTER_A: 'A';
LETTER_D: 'D';
LETTER_J: 'J';
LETTER_L: 'L';
LETTER_M: 'M';
LETTER_P: 'P';
LETTER_W: 'W';
LETER_X: 'X';*/


EOL : '\r'?'\n';

NUMBER: ('0'..'9')+;


// discard comments
LINE_COMMENT
    :   ('!!' ~('\n'|'\r')* '\r'? '\n')
	-> channel(HIDDEN) // or  -> skip
    ;

EDITORIALSIGNIFIER
    :
	'y' -> skip //TODO 'X' que es tambin sin Mtrica
    ;
//	('y'Ê| 'Y' | 'x') -> skip //TODO 'X' que es tambin sin Mtrica



fragment
TEXT : ~[\t\n\r]+ ; 


fragment
COMMENTTEXT: ~[\t\n\r!|]+ ; // | and ! to avoid confusing a comment with a bar line


// TODO Repetitions
// Pag. 378 Beyonjd Midi Codes, Staff Lining, Staff Possition
// Pag. 381 Pitch transposition
// Pag. 382 Octave transposition
// TODO Comprobar que todos los barlines - meter - key  ..... estanáalineados, eso lo podemos hacer con una regla de repeticion

 