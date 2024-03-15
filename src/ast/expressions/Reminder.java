package ast.expressions;

import semantic.Visitor;

public class Reminder extends AbstractExpression{

    private final Expression operand1;

    private final Expression operand2;


    public Reminder(int line, int column, Expression operand1, Expression operand2) {
        super(line, column);
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Expression getOperand1() {
        return operand1;
    }

    public Expression getOperand2() {
        return operand2;
    }

    @Override
    public String toString() {
        return operand1 + "%" + operand2;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
