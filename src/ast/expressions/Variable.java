package ast.expressions;

import ast.AbstractASTNode;

public class Variable extends AbstractASTNode implements Expression{

    private final String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
