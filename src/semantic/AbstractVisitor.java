package semantic;


import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program program, TP param) {
        program.getDefinitions().forEach(def -> def.accept(this, param));
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        functionDefinition.getType().accept(this, param);
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, null));
        functionDefinition.getStatements().forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        variableDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getOperand1().accept(this, null);
        arithmetic.getOperand2().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.getType().accept(this, null);
        cast.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.getOperand1().accept(this, null);
        comparison.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getAccessed().accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.getVariable().accept(this, null);
        functionInvocation.getArguments().forEach(arg -> arg.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getAccessed().accept(this, null);
        indexing.getPosition().accept(this, null);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.getOperand1().accept(this, null);
        logical.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Reminder reminder, TP param) {
        reminder.getOperand1().accept(this, null);
        reminder.getOperand2().accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getOperand().accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.getOperand().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.getExpression1().accept(this, param);
        assignment.getExpression2().accept(this, param);

        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.getCondition().accept(this, null);
        ifElse.getIfStatements().forEach(stmt -> stmt.accept(this, null));
        ifElse.getElseStatements().forEach(stmt -> stmt.accept(this, null));

        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return returnS, TP param) {
        returnS.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(While whileS, TP param) {
        whileS.getCondition().accept(this, null);
        whileS.getWhileStatements().forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getElementType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.getReturnType().accept(this, null);
        functionType.getParameters().forEach(parameter -> parameter.accept(this, null));
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP param) {
        structType.getFields().forEach(field -> field.accept(this, null));
        return null;
    }

    @Override
    public TR visit(StructField structField, TP param) {
        structField.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
