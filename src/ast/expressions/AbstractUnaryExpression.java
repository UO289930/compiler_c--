package ast.expressions;

public abstract class AbstractUnaryExpression extends AbstractExpression {
    private final Expression operand;

    public AbstractUnaryExpression(int line, int column, Expression operand) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

}
