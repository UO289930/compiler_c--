grammar Cmm;

@header{
    import dto.*;
    import ast.types.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.program.*;
}

// PARSER
// ------

program returns [Program ast]
        locals[ List<Definition> defs = new ArrayList<>() ]:
          (di=definitions { $defs.addAll($di.ast); })* main=main_function_definition { $defs.add( $main.ast ); } EOF { $ast = new Program( $defs ); }
        ;

definitions returns [List<Definition> ast = new ArrayList<>()]:
            v=variable_definitions { $ast.addAll( $v.ast ); }
          | f=function_definition { $ast.add( $f.ast ); }
          ;

main_function_definition returns [FunctionDefinition ast]
                         locals[List<Statement> ss = new ArrayList<>(), List<VariableDefinition> vs = new ArrayList<>()]:
                          VOID='void' MAIN='main' '(' ')' body=function_body { $ast = ParserHelper.createFuncDef( $VOID.getLine(), $VOID.getCharPositionInLine()+1, null, $MAIN.text, null, $body.ast ); }
                        ;

function_definition returns [FunctionDefinition ast]:
                     t=return_type ID '(' params=parameters ')' body=function_body { $ast = ParserHelper.createFuncDef( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text, $params.ast, $body.ast ); }
                    ;

function_body returns [FunctionBody ast]
              locals[List<Statement> ss = new ArrayList<>(), List<VariableDefinition> vs = new ArrayList<>()]:
               '{' ( v=variable_definitions { $vs.addAll( $v.ast ); } )* ( s=statements { $ss.addAll( $s.ast ); } )* '}' { $ast = new FunctionBody($vs, $ss); }
              ;

variable_definitions returns [List<VariableDefinition> ast = new ArrayList<>()]:
                     t=type v1=ID { $ast.add( ParserHelper.createVarDef( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $v1.text ) ); } (',' vi=ID { $ast.add( ParserHelper.createVarDef( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $vi.text ) );  } )* ';'
                    ;

statements returns [List<Statement> ast = new ArrayList<>()]:
           fi=function_invocation ';'   { $ast.add( $fi.ast ); }
         | e1=expression '=' e2=expression ';'    { $ast.add( new Assignment( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast ) ); }
         | WHILE='while' '(' e=expression ')' b=block { $ast.add( new While( $WHILE.getLine(), $WHILE.getCharPositionInLine()+1, $e.ast, $b.ast ) ); }
         | IF='if' '(' e=expression ')' b=block    { $ast.add( new IfElse( $IF.getLine(), $IF.getCharPositionInLine()+1, $e.ast, $b.ast, null ) ); }
         | IF='if' '(' e=expression ')' b1=block 'else' b2=block { $ast.add( new IfElse( $IF.getLine(), $IF.getCharPositionInLine()+1, $e.ast, $b1.ast, $b2.ast ) ); }
         | WRITE='write' es=expressions ';' { $ast.addAll( ParserHelper.createWriteStatements($WRITE.getLine(), $WRITE.getCharPositionInLine()+1, $es.ast) ); }
         | READ='read' es=expressions ';' { $ast.addAll( ParserHelper.createReadStatements($READ.getLine(), $READ.getCharPositionInLine()+1, $es.ast) ); }
         | RET='return' e=expression ';'  { $ast.add( new Return( $RET.getLine(), $RET.getCharPositionInLine()+1, $e.ast ) ); }
         ;

expression returns [Expression ast]:
            fi=function_invocation   { $ast = $fi.ast; }
          | '(' e=expression ')'  { $ast = $e.ast; }
          | e1=expression '[' e2=expression ']'   { $ast = new Indexing( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast ); }
          | e=expression '.' ID   { $ast = new FieldAccess( $e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text ); }
          | P='(' t=type ')' e=expression   { $ast = new Cast( $P.getLine(), $P.getCharPositionInLine()+1, $t.ast, $e.ast ); }
          | MINUS='-' e=expression    { $ast = new UnaryMinus( $MINUS.getLine(), $MINUS.getCharPositionInLine()+1, $e.ast ); }
          | EXC='!' e=expression    { $ast = new UnaryNot( $EXC.getLine(), $EXC.getCharPositionInLine()+1, $e.ast ); }
          | e1=expression OP=('*' | '/' | '%') e2=expression    { $ast = ParserHelper.createArithmeticOrReminder( $e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('+' | '-') e2=expression  { $ast = ParserHelper.createArithmeticOrReminder( $e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('>' | '>=' | '<=' | '<' | '!='| '==') e2=expression   { $ast = new Comparison( $e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast ); }
          | e1=expression OP=('&&' | '||') e2=expression { $ast = new Logical( $e1.ast.getLine(), $e1.ast.getColumn(), $OP.text, $e1.ast, $e2.ast ); }
          | ID  { $ast = new Variable( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text ); }
          | IC=INT_CONSTANT { $ast = new IntLiteral( $IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text) ); }
          | CC=CHAR_CONSTANT { $ast = new CharLiteral( $CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text) ); }
          | RC=REAL_CONSTANT { $ast = new RealLiteral( $RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text) ); }
          ;

type returns [Type ast]:
      b=built_in_type { $ast = $b.ast; }
    | STRUCT='struct' '{' sf=struct_fields '}' { $ast = new StructType( $STRUCT.getLine(), $STRUCT.getCharPositionInLine()+1, $sf.ast ); }
    | t=type '[' IC=INT_CONSTANT ']' { $ast = ParserHelper.processArrayType( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, LexerHelper.lexemeToInt($IC.text) ); }
    ;

// Extra parser productions

return_type returns [Type ast]:
              b=built_in_type { $ast = $b.ast; }
            | VOID='void'    { $ast = new VoidType( $VOID.getLine(), $VOID.getCharPositionInLine()+1 ); }
            ;

parameters returns [List<VariableDefinition> ast = new ArrayList<>()]:
              b1=built_in_type ID { $ast.add( ParserHelper.createVarDef( $b1.ast.getLine(), $b1.ast.getColumn(), $b1.ast, $ID.text ) ); } (',' bi=built_in_type ID { $ast.add( ParserHelper.createVarDef( $bi.ast.getLine(), $bi.ast.getColumn(), $bi.ast, $ID.text ) ); } )*
            |
            ;

built_in_type returns [Type ast]:
               T='int' { $ast = new IntType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             | T='char' { $ast = new CharType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             | T='double' { $ast = new DoubleType( $T.getLine(), $T.getCharPositionInLine()+1 ); }
             ;

block returns [List<Statement> ast = new ArrayList<>()]:
       s1=statements    { $ast.addAll($s1.ast); }
     | '{' (si=statements { $ast.addAll($si.ast); } )* '}'
     ;

function_invocation returns [FunctionInvocation ast]:
                   ID '(' args=arguments ')' { $ast = ParserHelper.createFuncInvoc( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $args.ast ); }
                   ;

arguments returns [List<Expression> ast = new ArrayList<>()]:
             e1=expression { $ast.add( $e1.ast ); } (',' ei=expression { $ast.add( $ei.ast ); } )*
           |
           ;

expressions returns [List<Expression> ast = new ArrayList<>()]:
            e1=expression { $ast.add( $e1.ast );  } (',' ei=expression { $ast.add( $ei.ast ); } )*
          ;

struct_fields returns [List<StructField> ast = new ArrayList<>()]:
            (t=type ID ';' { $ast.add( new StructField( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text ) ); } )+
            ;

// LEXER
// -----

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

// Fragments

fragment
LETTER: [a-zA-Z]
      ;

fragment
DIGIT: [0-9];

fragment
FLOATING_POINT: INT_CONSTANT? '.' INT_CONSTANT
              | INT_CONSTANT '.' INT_CONSTANT?
              ;

fragment
MANTISSA_AND_EXPONENT: (FLOATING_POINT | INT_CONSTANT) ('E' | 'e') ('+' | '-')? (FLOATING_POINT |INT_CONSTANT)
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