package ast.expressions;

public class UnaryMinus extends AbstractUnaryExpression{


    public UnaryMinus(int line, int column, Expression operand) {
        super(line, column, operand);
    }


    @Override
    public String toString() {
        return "-" + getOperand();
    }
}
