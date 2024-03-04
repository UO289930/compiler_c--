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
            arguments.forEach(arg -> sb.append(arg).append(", "));

            if(sb.toString().contains(", ")){
                sb.replace(sb.length()-2, sb.length(), "");
            }

        }

        sb.append(")");

        return sb.toString();
    }
}
