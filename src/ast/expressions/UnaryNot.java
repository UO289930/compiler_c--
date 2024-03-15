package ast.expressions;

import semantic.Visitor;

public class UnaryNot extends AbstractUnaryExpression{
    public UnaryNot(int line, int column, Expression operand) {
        super(line, column, operand);
    }

    @Override
    public String toString() {
        return "!" + getOperand();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
