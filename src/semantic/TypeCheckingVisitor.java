package semantic;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;

public class TypeCheckingVisitor implements Visitor<Void, Void>{
    @Override
    public Void visit(Program program, Void param) {
        program.getDefinitions().forEach(def -> def.accept(this, param));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        functionDefinition.getType().accept(this, param);
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, null));
        functionDefinition.getStatements().forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        variableDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getOperand1().accept(this, null);
        arithmetic.getOperand2().accept(this, null);

        arithmetic.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getType().accept(this, null);
        cast.getExpression().accept(this, null);

        cast.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getOperand1().accept(this, null);
        comparison.getOperand2().accept(this, null);

        comparison.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getAccessed().accept(this, null);

        fieldAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.getVariable().accept(this, null);
        functionInvocation.getArguments().forEach(arg -> arg.accept(this, null));

        functionInvocation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getAccessed().accept(this, null);
        indexing.getPosition().accept(this, null);
        indexing.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getOperand1().accept(this, null);
        logical.getOperand2().accept(this, null);

        logical.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        realLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Reminder reminder, Void param) {
        reminder.getOperand1().accept(this, null);
        reminder.getOperand2().accept(this, null);

        reminder.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getOperand().accept(this, null);

        unaryMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.getOperand().accept(this, null);

        unaryNot.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.getExpression1().accept(this, param);
        assignment.getExpression2().accept(this, param);

        if(!assignment.getExpression1().isLvalue()){
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    String.format("The left side of the assignment '%s' is not valid", assignment.getExpression1()));
        }

        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void param) {
        ifElse.getCondition().accept(this, null);
        ifElse.getIfStatements().forEach(stmt -> stmt.accept(this, null));
        ifElse.getElseStatements().forEach(stmt -> stmt.accept(this, null));

        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        read.getExpression().accept(this, param);

        if(!read.getExpression().isLvalue()){
            new ErrorType(read.getLine(), read.getColumn(),
                    String.format("The right side of the read operation '%s' is not valid", read.getExpression()));
        }

        return null;
    }

    @Override
    public Void visit(Return returnS, Void param) {
        returnS.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(While whileS, Void param) {
        whileS.getCondition().accept(this, null);
        whileS.getWhileStatements().forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public Void visit(Write write, Void param) {
        write.getExpression().accept(this, null);
        return null;
    }

    @Override
    public Void visit(ArrayType arrayType, Void param) {
        arrayType.getElementType().accept(this, null);
        return null;
    }

    @Override
    public Void visit(CharType charType, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType doubleType, Void param) {
        return null;
    }

    @Override
    public Void visit(ErrorType errorType, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        functionType.getReturnType().accept(this, null);
        functionType.getParameters().forEach(parameter -> parameter.accept(this, null));
        return null;
    }

    @Override
    public Void visit(IntType intType, Void param) {
        return null;
    }

    @Override
    public Void visit(StructType structType, Void param) {
        structType.getFields().forEach(field -> field.accept(this, null));
        return null;
    }

    @Override
    public Void visit(StructField structField, Void param) {
        structField.getType().accept(this, null);
        return null;
    }

    @Override
    public Void visit(VoidType voidType, Void param) {
        return null;
    }
}
