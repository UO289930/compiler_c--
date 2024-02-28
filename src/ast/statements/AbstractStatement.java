package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class AbstractStatement extends AbstractASTNode implements Statement{
    private final Expression expression;

    public AbstractStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", expression=" + expression;
    }
}
