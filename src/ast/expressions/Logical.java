package ast.expressions;

public class Logical extends AbstractOperatorExpression{


    public Logical(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column, operator, operand1, operand2);
    }
}
