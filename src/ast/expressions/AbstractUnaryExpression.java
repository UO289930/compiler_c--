package ast.expressions;

import ast.AbstractASTNode;

public class AbstractUnaryExpression extends AbstractASTNode implements Expression{
    private final Expression operand;

    public AbstractUnaryExpression(int line, int column, Expression operand) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

}
