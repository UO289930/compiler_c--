package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class Assignment extends AbstractASTNode implements Statement {

    private final Expression expression1;

    private final Expression expression2;

    public Assignment(int line, int column, Expression expression1, Expression expression2) {
        super(line, column);
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    @Override
    public String toString() {
        return expression1 + " = " + expression2;
    }
}
