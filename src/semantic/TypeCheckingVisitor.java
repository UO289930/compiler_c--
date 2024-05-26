package semantic;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.statements.*;
import ast.types.*;

import java.util.List;


/**
 *  (P) Arithmetic: expression1 -> expression2 expression3
 *  (R) expression1.type = expression2.type.arithmetic( expressions3.type );
 *
 *  (P) Reminder: expression1 -> expression2 expression3
 *  (R) expression1.type = expression2.type.reminder( expression3.type );
 *
 *  (P) Logical: expression1 -> expression2 expression3
 *  (R) expression1.type = expression2.type.logical( expression3.type );
 *
 *  (P) UnaryNot: expression1 -> expression2
 *  (R) expression1.type = expression2.type.unaryNot();
 *
 *  (P) Comparison: expression1 -> expression2 expression3
 *  (R) expression1.type = expression2.type.comparison( expression3.type );
 *
 *  (P) UnaryMinus: expression1 -> expression2
 *  (R) expression1.type = expression2.type.unaryMinus();
 *
 *  (P) Cast : expression1 -> type expression2
 *  (R) expression1.type = expression2.type.castTo( type );
 *
 *  (P) Indexing: expression1 -> expression2 expression3
 *  (R) expression1.type = expression2.type.squareBrackets( expressions3.type );
 *
 *  (P) FieldAccess: expression1 -> expression2 ID
 *  (R) expression1.type = expression2.type.dot( ID );
 *
 *  (( FunctionInvocation: expression1 -> variable expression* )) -->> variable is useless!!!
 *  (P) FunctionInvocation: expression1 -> expression2 expression*
 *  (R) expression1.type = expression2.type.parenthesis( expression*.stream().map( exp -> exp.type ).toArray() );
 *
 *  (P) FunctionInvocation: statement -> expression expression*
 *  (R) expression.type.parenthesis( expression*.stream().map( exp -> exp.type ).toArray() );
 *
 *  (P) Assignment: statement -> expression1 expression2
 *  (R) expression2.type.mustBeAssignableTo( expression1.type );
 *
 *  (( Inherited attribute (pre-order): statement.returnType ))
 *  (P) While: statement -> expression statement*
 *  (R) statement*.forEach( st -> st.returnType = statement.returnType );
 *
 *  (P) While: statement -> expression statement*
 *  (R) expression.type.mustBeBoolean( );
 *
 *  (P) IfElse: statement -> expression statement1* statement2*
 *  (R) statement1*.forEach( st -> st.returnType = type.returnType );
 *      statement2*.forEach( st -> st.returnType = type.returnType );
 *
 *  (P) IfElse: statement -> expression statement1* statement2*
 *  (R) expression.type.mustBeBoolean( );
 *
 *  (P) FunctionDefinition: definition -> type ID definition* statement*
 *  (R) statement*.forEach( st -> st.returnType = type.returnType );
 *
 *  (P) Return: statement -> expression
 *  (R) expression.type.mustBeReturnedAs( statement.returnType );
 *
 */
public class TypeCheckingVisitor extends AbstractVisitor<Type, Void>{


    @Override
    public Void visit(Arithmetic arithmetic, Type param) {
        super.visit(arithmetic, null);

        arithmetic.setLvalue(false);

        Type expressionType = arithmetic.getOperand1().getType().arithmetic(
                arithmetic.getLine(),
                arithmetic.getColumn(),
                arithmetic.getOperand2().getType()
        );
        arithmetic.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(Cast cast, Type param) {
        super.visit(cast,null);

        cast.setLvalue(false);

        Type expressionType = cast.getExpression().getType().castTo(
                cast.getLine(),
                cast.getColumn(),
                cast.getCastType()
        );
        cast.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Type param) {
        charLiteral.setLvalue(false);
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Type param) {
        super.visit(comparison,null);

        comparison.setLvalue(false);

        Type expressionType = comparison.getOperand1().getType().comparison(
                comparison.getLine(),
                comparison.getColumn(),
                comparison.getOperand2().getType()
        );
        comparison.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Type param) {
        super.visit(fieldAccess,null);

        fieldAccess.setLvalue(true);

        Type expressionType = fieldAccess.getAccessed().getType().dot(
                fieldAccess.getLine(),
                fieldAccess.getColumn(),
                fieldAccess.getFieldName()
        );
        fieldAccess.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Type param) {
        super.visit(functionInvocation,null);

        functionInvocation.setLvalue(false);

        List<Type> argumentsTypes =  functionInvocation.getArguments().stream().map(Expression::getType).toList();
        Type expressionType = functionInvocation.getVariable().getType().parenthesis(
                functionInvocation.getLine(),
                functionInvocation.getColumn(),
                argumentsTypes
        );
        functionInvocation.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        super.visit(indexing,null);

        indexing.setLvalue(true);

        Type expressionType = indexing.getAccessed().getType().squareBrackets(
                indexing.getLine(),
                indexing.getColumn(),
                indexing.getPosition().getType()
        );
        indexing.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type param) {
        intLiteral.setLvalue(false);
        intLiteral.setType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Logical logical, Type param) {
        super.visit(logical, null);

        logical.setLvalue(false);

        Type expressionType = logical.getOperand1().getType().logical(
                logical.getLine(),
                logical.getColumn(),
                logical.getOperand2().getType()
        );
        logical.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Type param) {
        realLiteral.setLvalue(false);
        realLiteral.setType(new DoubleType(realLiteral.getLine(), realLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(Reminder reminder, Type param) {
        super.visit(reminder,null);

        reminder.setLvalue(false);

        Type expressionType = reminder.getOperand1().getType().reminder(
                reminder.getLine(),
                reminder.getColumn(),
                reminder.getOperand2().getType()
        );
        reminder.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Type param) {
        super.visit(unaryMinus,null);

        unaryMinus.setLvalue(false);

        Type expressionType = unaryMinus.getOperand().getType().unaryMinus(unaryMinus.getLine(), unaryMinus.getColumn());
        unaryMinus.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Type param) {
        super.visit(unaryNot,null);

        unaryNot.setLvalue(false);

        Type expressionType = unaryNot.getOperand().getType().unaryNot(unaryNot.getLine(), unaryNot.getColumn());
        unaryNot.setType(expressionType);

        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        variable.setLvalue(true);
        variable.setType(variable.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param) {
        super.visit(assignment,null);

        if(!assignment.getExpression1().isLvalue()){
            new ErrorType(assignment.getExpression1().getLine(), assignment.getExpression1().getColumn(),
                    String.format("The left side of the assignment '%s' is not valid", assignment.getExpression1()));
        } else {
            assignment.getExpression2().getType().mustBeAssignableTo(
                    assignment.getExpression2().getLine(),
                    assignment.getExpression2().getColumn(),
                    assignment.getExpression1().getType()
            );
        }

        return null;
    }

    @Override
    public Void visit(While whileS, Type functionReturnType) {
        whileS.setReturnType(functionReturnType);

        super.visit(whileS, whileS.getReturnType());

        whileS.getCondition().getType().mustBeBoolean(whileS.getCondition().getLine(), whileS.getCondition().getColumn());
        whileS.getWhileStatements().forEach( st -> st.setReturnType( whileS.getReturnType() ) );

        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Type functionReturnType) {
        ifElse.setReturnType(functionReturnType);

        super.visit(ifElse, ifElse.getReturnType());

        ifElse.getCondition().getType().mustBeBoolean(ifElse.getCondition().getLine(), ifElse.getCondition().getColumn());
        ifElse.getIfStatements().forEach( st -> st.setReturnType( ifElse.getReturnType() ) );
        ifElse.getElseStatements().forEach( st -> st.setReturnType( ifElse.getReturnType() ) );

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Type param) {
        FunctionType functionType = (FunctionType)functionDefinition.getType();
        super.visit(functionDefinition, functionType.getReturnType());

        return null;
    }

    @Override
    public Void visit(Return returnS, Type functionReturnType) {
        returnS.setReturnType(functionReturnType);
        super.visit(returnS,null);

        returnS.getExpression().getType().mustBeReturnedAs(
                returnS.getExpression().getLine(),
                returnS.getExpression().getColumn(),
                returnS.getReturnType()
        );

        return null;
    }

    @Override
    public Void visit(Read read, Type functionReturnType) {
        read.setReturnType(functionReturnType);
        super.visit(read,null);

        if(!read.getExpression().isLvalue()){
            new ErrorType(read.getExpression().getLine(), read.getExpression().getColumn(),
                    String.format("The right side of the read operation '%s' is not valid", read.getExpression()));
        }

        return null;
    }

    @Override
    public Void visit(Write write, Type functionReturnType) {
        write.setReturnType(functionReturnType);
        super.visit(write, null);

        return null;
    }

    @Override
    public Void visit(For forS, Type functionReturnType) {
        forS.setReturnType(functionReturnType);
        super.visit(forS,functionReturnType);
        return null;
    }

    @Override
    public Void visit(MultipleAssignment multipleAssignment, Type functionReturnType) {
        multipleAssignment.setReturnType(functionReturnType);
        super.visit(multipleAssignment, null);

        List<Expression> leftExpressions = multipleAssignment.getLeftExpressions();
        List<Expression> rightExpressions = multipleAssignment.getRightExpressions();

        if(rightExpressions.size()==1){

            List<Type> leftTypes = leftExpressions.stream().map(Expression::getType).toList();
            leftTypes.stream().forEach(type -> rightExpressions.get(0).getType().mustBePromotable(
                    multipleAssignment.getLine(),
                    multipleAssignment.getColumn(),
                    type)
            );

        } else if(leftExpressions.size()!=rightExpressions.size()){

            new ErrorType(multipleAssignment.getLine(), multipleAssignment.getColumn(),
                    "The number of the left and right expressions of a multiple assignment must be the same");

        } else if(!leftExpressions.stream().allMatch(Expression::isLvalue)){

            new ErrorType(multipleAssignment.getLine(), multipleAssignment.getColumn(),
                    "All left hand-side expressions of an assignment should be l-value");

        } else {

            List<Type> leftTypes = leftExpressions.stream().map(Expression::getType).toList();
            List<Type> rightTypes = rightExpressions.stream().map(Expression::getType).toList();

            for (int i = 0; i < leftTypes.size(); i++) {
                Type type1 = leftTypes.get(i);
                Type type2 = rightTypes.get(i);
                type1.mustBeAssignableTo(multipleAssignment.getLine(), multipleAssignment.getColumn(), type2);
            }

        }

        return null;
    }

    @Override
    public Void visit(SwitchCase switchCase, Type param) {
        super.visit(switchCase, param);
        return null;
    }

    @Override
    public Void visit(Switch switchS, Type param) {
        switchS.getCases().forEach(casex -> switchS.getCaseExpression().getType().mustBeReturnedAs(casex.getLine(), casex.getColumn(), casex.getCaseElement().getType()));
        return null;
    }

    @Override
    public Void visit(ImplicitAssignment implicitAssignment, Type param) {
        //implicitAssignment.getType().mustBeBuiltIn();
        return null;
    }
}
