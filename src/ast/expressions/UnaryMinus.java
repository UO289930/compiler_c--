package ast.expressions;

public class UnaryMinus extends UnaryExpression{


    public UnaryMinus(int line, int column, Expression operand) {
        super(line, column, operand);
    }


    @Override
    public String toString() {
        return "-" + getOperand();
    }
}
