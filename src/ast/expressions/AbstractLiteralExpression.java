package ast.expressions;

import ast.AbstractASTNode;

public class AbstractLiteralExpression<T> extends AbstractASTNode implements Expression{

    private final T value;

    public AbstractLiteralExpression(int line, int column, T value) {
        super(line, column);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
