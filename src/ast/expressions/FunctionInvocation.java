package ast.expressions;

import ast.types.Type;
import semantic.Visitor;
import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    private final Variable variable;

    private final List<Expression> arguments;

    private Type returnType;


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
        return String.format("Function invocation to %s", getVariable().getName());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    @Override
    public void setReturnType(Type type) {
        this.returnType = type;
    }
}
