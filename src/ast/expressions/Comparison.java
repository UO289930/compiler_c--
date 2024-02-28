package ast.expressions;

public class Comparison extends OperatorExpression{

    public Comparison(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column, operator, operand1, operand2);
    }

    @Override
    public String toString() {
        return "Comparison{" +
                super.toString() +
                "}";
    }
}
