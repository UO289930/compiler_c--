package ast.expressions;

public class Reminder extends AbstractOperatorExpression{
    public Reminder(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column, operator, operand1, operand2);
    }
}
