package ast.expressions;

import semantic.Visitor;

public class CharLiteral extends AbstractExpression{

    private final char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
