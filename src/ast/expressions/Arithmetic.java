package ast.expressions;

public class Arithmetic extends OperatorExpression{

    public Arithmetic(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column, operator, operand1, operand2);
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                super.toString() +
                "}";
    }
}
