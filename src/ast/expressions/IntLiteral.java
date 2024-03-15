package ast.expressions;

import semantic.Visitor;

public class IntLiteral extends AbstractLiteralExpression<Integer>{

    public IntLiteral(int line, int column, int value) {
        super(line, column, value);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
