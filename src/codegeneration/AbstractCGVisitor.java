package codegeneration;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;
import semantic.Visitor;

public class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {

    protected final CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public TR visit(Program program, TP param) {
        assert false;
        throw new UnsupportedOperationException("Programs cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        assert false;
        throw new UnsupportedOperationException("Function definitions cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        assert false;
        throw new UnsupportedOperationException("Variable definitions cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        assert false;
        throw new UnsupportedOperationException("Arithmetic operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Cast cast, TP param) {
        assert false;
        throw new UnsupportedOperationException("Cast operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        assert false;
        throw new UnsupportedOperationException("Character literals cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        assert false;
        throw new UnsupportedOperationException("Comparison operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        assert false;
        throw new UnsupportedOperationException("Field accesses cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        assert false;
        throw new UnsupportedOperationException("Function invocations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        assert false;
        throw new UnsupportedOperationException("Indexing operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        assert false;
        throw new UnsupportedOperationException("Integer literals cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Logical logical, TP param) {
        assert false;
        throw new UnsupportedOperationException("Logical operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        assert false;
        throw new UnsupportedOperationException("Real literals cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Reminder reminder, TP param) {
        assert false;
        throw new UnsupportedOperationException("Modulus operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        assert false;
        throw new UnsupportedOperationException("Minus operations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        assert false;
        throw new UnsupportedOperationException("Negations cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Variable variable, TP param) {
        assert false;
        throw new UnsupportedOperationException("Variables cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assert false;
        throw new UnsupportedOperationException("Assignments cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        assert false;
        throw new UnsupportedOperationException("If-Else statements cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Read read, TP param) {
        assert false;
        throw new UnsupportedOperationException("Read statements cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Return returnS, TP param) {
        assert false;
        throw new UnsupportedOperationException("Write statements cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(While whileS, TP param) {
        assert false;
        throw new UnsupportedOperationException("While statements cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(Write write, TP param) {
        assert false;
        throw new UnsupportedOperationException("Write statements cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Array types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(CharType charType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Character types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Double types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Errors cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Function types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(IntType intType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Integer types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(StructType structType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Struct types cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(StructField structField, TP param) {
        assert false;
        throw new UnsupportedOperationException("Struct fields cannot be visited by this code generation visitor");
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        assert false;
        throw new UnsupportedOperationException("Void type cannot be visited by this code generation visitor");
    }
}
