package codegeneration;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;
import semantic.Visitor;

import java.io.IOException;

public class AbstractCGVisitor implements Visitor<Void, Void> {

    protected final CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public Void visit(Program program, Void param) {
        assert false;
        throw new UnsupportedOperationException("Programs cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        assert false;
        throw new UnsupportedOperationException("Function definitions cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        assert false;
        throw new UnsupportedOperationException("Variable definitions cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        assert false;
        throw new UnsupportedOperationException("Arithmetic operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Cast cast, Void param) {
        assert false;
        throw new UnsupportedOperationException("Cast operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        assert false;
        throw new UnsupportedOperationException("Character literals cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        assert false;
        throw new UnsupportedOperationException("Comparison operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        assert false;
        throw new UnsupportedOperationException("Field accesses cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        assert false;
        throw new UnsupportedOperationException("Function invocations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        assert false;
        throw new UnsupportedOperationException("Indexing operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        assert false;
        throw new UnsupportedOperationException("Integer literals cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Logical logical, Void param) {
        assert false;
        throw new UnsupportedOperationException("Logical operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        assert false;
        throw new UnsupportedOperationException("Real literals cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Reminder reminder, Void param) {
        assert false;
        throw new UnsupportedOperationException("Modulus operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        assert false;
        throw new UnsupportedOperationException("Minus operations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        assert false;
        throw new UnsupportedOperationException("Negations cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Variable variable, Void param) {
        assert false;
        throw new UnsupportedOperationException("Variables cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        assert false;
        throw new UnsupportedOperationException("Assignments cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(IfElse ifElse, Void param) {
        assert false;
        throw new UnsupportedOperationException("If-Else statements cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Read read, Void param) {
        assert false;
        throw new UnsupportedOperationException("Read statements cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Return returnS, Void param) {
        assert false;
        throw new UnsupportedOperationException("Write statements cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(While whileS, Void param) {
        assert false;
        throw new UnsupportedOperationException("While statements cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(Write write, Void param) {
        assert false;
        throw new UnsupportedOperationException("Write statements cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(ArrayType arrayType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Array types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(CharType charType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Character types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(DoubleType doubleType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Double types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(ErrorType errorType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Errors cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Function types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(IntType intType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Integer types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(StructType structType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Struct types cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(StructField structField, Void param) {
        assert false;
        throw new UnsupportedOperationException("Struct fields cannot be visited by this code generation visitor");
    }

    @Override
    public Void visit(VoidType voidType, Void param) {
        assert false;
        throw new UnsupportedOperationException("Void type cannot be visited by this code generation visitor");
    }
}
