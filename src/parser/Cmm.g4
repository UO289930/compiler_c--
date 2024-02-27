grammar Cmm;

@header{
    import ast.types.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.program.*;
}

// Program, statement, expression, type

program: // returns [Program ast]
        //locals[ List<Definition> defs = new ArrayList<>() ]:
          (di=definition )* main=main_function_definition (dj=definition )* EOF
        ;

definition : //returns [Defintiion ast]:
            v=variable_definition //{ $ast = $v.ast; }
          | f=function_definition //{ $ast = $f.ast; }
          ;

main_function_definition: // returns [Definition ast]:
                          'void' 'main' '(' ')' '{' (statement | variable_definition)* '}'
                        ;

function_definition: // returns [Definition ast]:
                     t=function_return_type ID '(' params=parameters ')' '{' (statement | variable_definition)* '}'
                     //{ $ast = new FunctionDefinition( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text, $params.ast, $b.ast); }
                   ;

variable_definition: // returns [Definition ast]:
                     // { $ast = new VariableDefinition( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, new Variable( $v1.text ) ); }
                     t=type v1=ID (',' vi=ID )* ';'
                   ;

statement returns [Statement ast]:
           e1=expression '=' e2=expression ';'    { $ast = new Assignment( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast ); }
         | fi=function_invocation ';'   { $ast = $fi.ast; }
         | WHILE='while' '(' e=expression ')' b=block { $ast = new While( $WHILE.getLine(), $WHILE.getCharPositionInLine()+1, $e.ast, $b.ast ); }
         | IF='if' '(' e=expression ')' b=block    { $ast = new IfElse( $IF.getLine(), $IF.getCharPositionInLine()+1, $e.ast, $b.ast, null ); }
         | IF='if' '(' e=expression ')' b1=block 'else' b2=block { $ast = new IfElse( $IF.getLine(), $IF.getCharPositionInLine()+1, $e.ast, $b1.ast, $b2.ast ); }
         | 'write' expression (',' expression)* ';'
         | 'read' expression (',' expression)* ';'
         | RET='return' e=expression ';'  { $ast = new Return( $RET.getLine(), $RET.getCharPositionInLine()+1, $e.ast ); }
         ;

expression returns [Expression ast]:
            fi=function_invocation   { $ast = $fi.ast; }
          | '(' e=expression ')'  { $ast = $e.ast; }
          | e1=expression '[' e2=expression ']'   { $ast = new Indexing( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast ); }
          | e=expression '.' ID   { $ast = new FieldAccess( $e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text ); }
          | P='(' t=type ')' e=expression   { $ast = new Cast( $P.getLine(), $P.getCharPositionInLine()+1, $t.ast, $e.ast ); }
          | MINUS='-' e=expression    { $ast = new UnaryMinus( $MINUS.getLine(), $MINUS.getCharPositionInLine()+1, $e.ast ); }
          | EXC='!' e=expression    { $ast = new UnaryNot( $EXC.getLine(), $EXC.getCharPositionInLine()+1, $e.ast ); }
          | e1=expression OP=('*' | '/' | '%') e2=expression    { $ast = new Arithmetic( $e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('+' | '-') e2=expression { $ast = new Arithmetic( $e1.ast.getLine(), $e1.ast.getColumn(),
                                                         $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('>' | '>=' | '<=' | '<' | '!='| '==') e2=expression   { $ast = new Comparison( $e1.ast.getLine(), $e1.ast.getColumn(),
                                                                                      $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('&&' | '||') e2=expression { $ast = new Logical( $e1.ast.getLine(), $e1.ast.getColumn(),
                                                           $OP.text, $e1.ast, $e2.ast ); }
          | ID  { $ast = new Variable( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text ); }
          | IC=INT_CONSTANT { $ast = new IntLiteral( $IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text) ); }
          | CC=CHAR_CONSTANT { $ast = new CharLiteral( $IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($IC.text) ); }
          | REAL_CONSTANT { $ast = new RealLiteral( $IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($IC.text) ); }
          ;

type returns [Type ast]:
      b=built_in_type { $ast = $b.ast; }
    | STRUCT='struct' '{' sf=struct_fields '}' { $ast = new StructType( $STRUCT.getLine(), $STRUCT.getCharPositionInLine()+1, $sf.ast ); }
    | t=type '[' IC=INT_CONSTANT ']' { $ast = new ArrayType( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, LexerHelper.lexemeToInt($IC.text) ); }
    ;

// Extra parser productions

function_return_type returns [Type ast]:
                      b=built_in_type { $ast = $b.ast; }
                    | VOID='void'    { $ast = new VoidType( $VOID.getLine(), $VOID.getCharPositionInLine()+1 ); }
                    ;

parameters returns [List<VariableDefinition> ast = new ArrayList<>()]:
            b1=built_in_type ID { $ast.add( new VariableDefinition( $b1.ast.getLine(), $b1.ast.getColumn(), $b1.ast, $ID.text ) ); }
             (',' bi=built_in_type ID { $ast.add( new VariableDefinition( $bi.ast.getLine(), $bi.ast.getColumn(), $bi.ast, $ID.text ) ); } )*
          ;

built_in_type returns [Type ast]:
               T='int' { $ast = new IntType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             | T='char' { $ast = new CharType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             | T='double' { $ast = new DoubleType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             ;

block returns [List<Statement> ast = new ArrayList<>()]:
       s1=statement    { $ast.add($s1.ast); }
     | '{' (si=statement { $ast.add($si.ast); } )* '}'
     ;

function_invocation returns [FunctionInvocation ast]:
                   | ID '(' args=arguments ')' { $ast = new FunctionInvocation( $ID.getLine(), $ID.getCharPositionInLine()+1,
                                                 new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text),
                                                 $args.ast); }
                   ;

arguments returns [List<Expression> ast = new ArrayList<>()]:
               e1=expression { $ast.add( $e1.ast ); } (',' ei=expression { $ast.add( $ei.ast ); } )*
               |
               ;

struct_fields returns [List<StructField> ast = new ArrayList<>()]:
            (t=type ID ';' { $ast.add( new StructField( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text ) ); } )+
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



