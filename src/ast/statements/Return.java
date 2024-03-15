package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

public class Return extends AbstractExpressionStatement {


    public Return(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "return " + getExpression();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
