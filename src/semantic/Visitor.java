package semantic;

import ast.expressions.*;
import ast.program.*;
import ast.statements.*;
import ast.types.*;

 public interface Visitor<TP, TR> {

     TR visit(Program program, TP param);

     TR visit(FunctionDefinition functionDefinition, TP param);

     TR visit(VariableDefinition variableDefinition, TP param);

     TR visit(Arithmetic arithmetic, TP param);

     TR visit(Cast cast, TP param);

     TR visit(CharLiteral charLiteral, TP param);

     TR visit(Comparison comparison, TP param);

     TR visit(FieldAccess fieldAccess, TP param);

     TR visit(FunctionInvocation functionInvocation, TP param);

     TR visit(Indexing indexing, TP param);

     TR visit(IntLiteral intLiteral, TP param);

     TR visit(Logical logical, TP param);

     TR visit(RealLiteral realLiteral, TP param);

     TR visit(Reminder reminder, TP param);

     TR visit(UnaryMinus unaryMinus, TP param);

     TR visit(UnaryNot unaryNot, TP param);

     TR visit(Variable variable, TP param);

     TR visit(Assignment assignment, TP param);

     TR visit(IfElse ifElse, TP param);

     TR visit(Read read, TP param);

     TR visit(Return returnS, TP param);

     TR visit(While whileS, TP param);

     TR visit(Write write, TP param);

     TR visit(ArrayType arrayType, TP param);

     TR visit(CharType charType, TP param);

     TR visit(DoubleType doubleType, TP param);

     TR visit(ErrorType errorType, TP param);

     TR visit(FunctionType functionType, TP param);

     TR visit(IntType intType, TP param);

     TR visit(StructType structType, TP param);

     TR visit(StructField structField, TP param);

     TR visit(VoidType voidType, TP param);
}
