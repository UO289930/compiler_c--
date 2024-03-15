package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

public class Read extends AbstractExpressionStatement {


    public Read(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "read " + getExpression();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
