package ast.statements;

import ast.expressions.Expression;

public abstract class AbstractExpressionStatement extends AbstractStatement{
    private final Expression expression;

    public AbstractExpressionStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
