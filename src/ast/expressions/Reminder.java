package ast.expressions;

import semantic.Visitor;

public class Reminder extends AbstractOperatorExpression{

    private static final String OPERATOR = "%";

    public Reminder(int line, int column, Expression operand1, Expression operand2) {
        super(line, column, OPERATOR, operand1 , operand2);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
