package ast.statements;

import ast.expressions.Expression;

public class Read extends AbstractStatement {


    public Read(int line, int column, Expression expression) {
        super(line, column, expression);
    }
}
