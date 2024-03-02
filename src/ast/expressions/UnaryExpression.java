package ast.expressions;

import ast.AbstractASTNode;

public class UnaryExpression extends AbstractASTNode implements Expression{
    private final Expression operand;

    public UnaryExpression(int line, int column, Expression operand) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

}
