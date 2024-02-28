package ast.statements;

import ast.expressions.Expression;

public class Return extends AbstractStatement {


    public Return(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "Return{" +
                super.toString() +
                "}";
    }
}
