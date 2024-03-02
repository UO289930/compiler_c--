package ast.expressions;

public class IntLiteral extends AbstractLiteralExpression<Integer>{

    public IntLiteral(int line, int column, int value) {
        super(line, column, value);
    }
}
