package semantic;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;


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
 *  (( FunctionInvocation: expression1 -> variable expression* )) -->> variable is useless!!!
 *  (P) FunctionInvocation: expression1 -> expression2 expression*
 *  (R) expression1.type = expression2.type.parenthesis( expression*.stream().map( exp -> exp.type ).toArray() );
 *
 *  (P) FunctionInvocation: statement -> expression expression*
 *  (R) expression.type.parenthesis( expression*.stream().map( exp -> exp.type ).toArray() );
 *
 *  (P) Assignment: statement -> expression1 expression2
 *  (R) expression2.type.mustBeAssignableTo( expression1 );
 *
 *  (( Inherited attribute (pre-order): statement.returnType ))
 *  (P) While: statement -> expression statement*
 *  (R) statement*.forEach( st -> st.returnType = statement.returnType );
 *
 *  (P) While: statement -> expression statement*
 *  (R) expression.type.mustBeBoolean( );
 *
 *  (P) IfElse: statement -> expression statement*
 *  (R) statement*.forEach( st -> st.returnType = type.returnType );
 *
 *  (P) IfElse: statement -> expression statement1* statement2*
 *  (R) expression.type.mustBeBoolean( );
 *
 *  (P) FunctionDefinition: definition -> type ID vardefinition* statement*
 *  (R) statement*.forEach( st -> st.returnType = type.returnType );
 *
 *  (P) Return: statement -> expression
 *  (R) expression.type.mustBeReturnableAs( statement.returnType );
 *
 */
public class TypeCheckingVisitor extends AbstractVisitor<Void, Void>{


    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        super.visit(arithmetic,param);

        arithmetic.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        super.visit(cast,param);

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
        super.visit(comparison,param);

        comparison.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        super.visit(fieldAccess,param);

        fieldAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        super.visit(functionInvocation,param);

        functionInvocation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        super.visit(indexing,param);
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
        super.visit(logical,param);

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
        super.visit(reminder,param);

        reminder.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        super.visit(unaryMinus,param);

        unaryMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        super.visit(unaryNot,param);

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
        super.visit(assignment,param);

        if(!assignment.getExpression1().isLvalue()){
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    String.format("The left side of the assignment '%s' is not valid", assignment.getExpression1()));
        }

        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        super.visit(read,param);

        if(!read.getExpression().isLvalue()){
            new ErrorType(read.getLine(), read.getColumn(),
                    String.format("The right side of the read operation '%s' is not valid", read.getExpression()));
        }

        return null;
    }
}
