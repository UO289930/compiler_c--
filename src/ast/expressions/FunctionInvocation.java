package ast.expressions;

import ast.AbstractASTNode;
import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Expression, Statement {

    private final Variable variable;

    private final List<Expression> arguments;


    public FunctionInvocation(int line, int column, Variable variable, List<Expression> arguments) {
        super(line, column);
        this.variable = variable;
        this.arguments = arguments==null ? new ArrayList<>() : new ArrayList<>(arguments);
    }

    public Variable getVariable() {
        return variable;
    }

    public List<Expression> getArguments() {
        return new ArrayList<>(arguments);
    }
}
