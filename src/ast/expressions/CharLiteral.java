package ast.expressions;

import semantic.Visitor;

public class CharLiteral extends AbstractLiteralExpression<Character>{

    public CharLiteral(int line, int column, char value) {
        super(line, column, value);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
