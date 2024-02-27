package ast.expressions;

public class UnaryNot extends UnaryExpression{
    public UnaryNot(int line, int column, Expression operand) {
        super(line, column, operand);
    }
}
