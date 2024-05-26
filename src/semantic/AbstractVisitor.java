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
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, param));
        functionDefinition.getStatements().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        variableDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getOperand1().accept(this, param);
        arithmetic.getOperand2().accept(this, param);

        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.getCastType().accept(this, param);
        cast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.getOperand1().accept(this, param);
        comparison.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getAccessed().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.getVariable().accept(this, param);
        functionInvocation.getArguments().forEach(arg -> arg.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getAccessed().accept(this, param);
        indexing.getPosition().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.getOperand1().accept(this, param);
        logical.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Reminder reminder, TP param) {
        reminder.getOperand1().accept(this, param);
        reminder.getOperand2().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getOperand().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.getOperand().accept(this, param);
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
        ifElse.getCondition().accept(this, param);
        ifElse.getIfStatements().forEach(stmt -> stmt.accept(this, param));
        ifElse.getElseStatements().forEach(stmt -> stmt.accept(this, param));

        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return returnS, TP param) {
        returnS.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While whileS, TP param) {
        whileS.getCondition().accept(this, param);
        whileS.getWhileStatements().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getElementType().accept(this, param);
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
        functionType.getReturnType().accept(this, param);
        functionType.getParameters().forEach(parameter -> parameter.accept(this, param));
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP param) {
        structType.getFields().forEach(field -> field.accept(this, param));
        return null;
    }

    @Override
    public TR visit(StructField structField, TP param) {
        structField.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }

    @Override
    public TR visit(For forS, TP param) {
        if(forS.getInitializer()!=null){
            forS.getInitializer().accept(this, param);
        }
        forS.getCondition().accept(this, param);
        if(forS.getIncrement()!=null){
            forS.getIncrement().accept(this, param);
        }
        forS.getForStatements().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(MultipleAssignment multipleAssignment, TP param) {
        multipleAssignment.getLeftExpressions().forEach(expression -> expression.accept(this, param));
        multipleAssignment.getRightExpressions().forEach(expression -> expression.accept(this, param));
        return null;
    }

    @Override
    public TR visit(SwitchCase switchCase, TP param) {
        switchCase.getCaseElement().accept(this, param);
        switchCase.getStatements().forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Switch switchS, TP param) {
        switchS.getCaseExpression().accept(this, param);
        switchS.getCases().forEach(casex -> casex.accept(this, param));
        return null;
    }

    @Override
    public TR visit(ImplicitAssignment implicitAssignment, TP param) {
        implicitAssignment.getExpression().accept(this, param);
        return null;
    }
}
