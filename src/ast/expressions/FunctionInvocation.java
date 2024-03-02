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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(variable.toString());
        sb.append("(");

        if(!arguments.isEmpty() && arguments.get(0)!=null){
            sb.append(arguments.get(0));
            arguments.forEach(arg -> sb.append(", ").append(arg));
        }

        sb.append(")");

        return sb.toString();
    }
}
