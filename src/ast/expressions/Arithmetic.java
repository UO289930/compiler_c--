package ast.expressions;

import semantic.Visitor;

public class Arithmetic extends AbstractOperatorExpression{

    public Arithmetic(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column, operator, operand1, operand2);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
