package semantic;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.*;

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
