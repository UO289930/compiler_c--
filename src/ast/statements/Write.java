package ast.statements;

import ast.expressions.Expression;

public class Write extends AbstractStatement {


    public Write(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "write " + getExpression() ;
    }
}
