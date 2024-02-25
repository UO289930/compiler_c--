grammar Cmm;

// Program, statement, expression, type

program: definition* main_function_definition definition* EOF;

definition: variable_definition
          | function_definition
          ;

main_function_definition: 'void' 'main' '(' ')' function_body
                        ;

function_definition: function_return_type ID '(' ')' function_body
                   | function_return_type ID '(' parameters ')' function_body
                   ;

variable_definition: type ID (',' ID)* ';'
                   ;

statement: expression '=' expression ';'
         | function_invocation ';'
         | 'while' '(' expression ')' block
         | 'if' '(' expression ')' block
         | 'if' '(' expression ')' block 'else' block
         | 'write' arguments ';'
         | 'read' arguments ';'
         | 'return' expression ';'
         ;

expression: function_invocation
          | '(' expression ')'
          | expression '[' expression ']'
          | expression '.' ID
          | '(' type ')' expression
          | '-' expression
          | '!' expression
          | expression ('*' | '/' | '%') expression
          | expression ('+' | '-') expression
          | expression ('>' | '>=' | '<=' | '<' | '!='| '==') expression
          | expression ('&&' | '||') expression
          | ID
          | INT_CONSTANT
          | CHAR_CONSTANT
          | REAL_CONSTANT
          ;

type: built_in_type
    | 'struct' '{' struct_field+ '}'
    | 'void'
    | built_in_type ('[' INT_CONSTANT ']')+
    ;

// Extra parser productions

function_return_type: built_in_type
                    | 'void'
                    ;

function_body: '{' (statement | variable_definition)* '}'
             ;

parameters: built_in_type ID (',' built_in_type ID)*
          ;

built_in_type: 'int'
             | 'char'
             | 'double'
             ;

block: statement
     | '{' statement* '}'
     ;

function_invocation: ID '(' ')'
                   | ID '(' arguments ')'
                   ;

arguments: expression (',' expression)*
         ;

struct_field: type ID ';'
            ;

// LEXER
// -----

fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9];

fragment
FLOATING_POINT: INT_CONSTANT* '.' INT_CONSTANT+
              | INT_CONSTANT+ '.' INT_CONSTANT*
              ;

fragment
MANTISSA_AND_EXPONENT: (FLOATING_POINT | INT_CONSTANT+) ('E' | 'e') ('+' | '-')? (FLOATING_POINT |INT_CONSTANT+)
                     ;

fragment
SPECIAL_CHAR: '\\n'
            | '\\t'
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

fragment
BLANKS: ' '
      | '\t'
      ;


ID: ('_' | LETTER) ('_' | LETTER | DIGIT)*
  ;

INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

REAL_CONSTANT: FLOATING_POINT
             | MANTISSA_AND_EXPONENT
             ;

CHAR_CONSTANT: '\'' . '\''
             | '\'' '\\' INT_CONSTANT '\''
             | '\'' SPECIAL_CHAR '\''
             ;


COMMENT: (ONE_LINE_COMMENT | MULTIPLE_LINE_COMMENT) -> skip
       ;

WHITESPACE: (BLANKS | NEW_LINE)+ -> skip
          ;



