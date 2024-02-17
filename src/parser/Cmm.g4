grammar Cmm;	

program: (INT_CONSTANT | REAL_CONSTANT | ID | CHAR_CONSTANT)+
       ;

fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9];

ID: ('_' | LETTER) ('_' | LETTER | DIGIT)*
  ;
  		 
INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

fragment
FLOATING_POINT: INT_CONSTANT* '.' INT_CONSTANT+
              | INT_CONSTANT+ '.' INT_CONSTANT*
              ;

fragment
MANTISSA_AND_EXPONENT: (FLOATING_POINT | INT_CONSTANT+) ('E' | 'e') ('+' | '-')? (FLOATING_POINT |INT_CONSTANT+)
                     ;

REAL_CONSTANT: FLOATING_POINT
             | MANTISSA_AND_EXPONENT
             ;

fragment
SPECIAL_CHAR: '\\n'
            | '\\t'
            ;

CHAR_CONSTANT: '\'' . '\''
             | '\'' '\\' INT_CONSTANT '\''
             | '\'' SPECIAL_CHAR '\''
             ;

fragment
NEW_LINE: '\n'
        | '\r'
        | '\n\r'
        | '\r\n'
        ;
fragment
ONE_LINE_COMMENT: '//' .*? (NEW_LINE | EOF)
                ;
fragment
MULTIPLE_LINE_COMMENT: '/*' .*? '*/'
                     ;

COMMENT: (ONE_LINE_COMMENT | MULTIPLE_LINE_COMMENT) -> skip
       ;

fragment
BLANKS: ' '
      | '\t'
      ;

WHITESPACE: (BLANKS | NEW_LINE)+ -> skip
          ;



