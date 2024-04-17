package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

public class Write extends AbstractExpressionStatement {


    public Write(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "Write";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
