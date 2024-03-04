package ast.expressions;

import ast.AbstractASTNode;
import ast.types.Type;

public class Cast extends AbstractASTNode implements Expression {

    private final Type type;

    private final Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.type = type;
        this.expression = expression;
    }

    public Type getType() {
        return type;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return " (" + type + ") " + expression;
    }
}
