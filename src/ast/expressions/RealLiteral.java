package ast.expressions;

import semantic.Visitor;

public class RealLiteral extends AbstractLiteralExpression<Double>{

    public RealLiteral(int line, int column, double value) {
        super(line, column, value);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
