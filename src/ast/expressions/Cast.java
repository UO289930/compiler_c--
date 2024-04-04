package ast.expressions;


import semantic.Visitor;
import ast.types.Type;

public class Cast extends AbstractExpression{

    private final Type castType;

    private final Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.castType = type;
        this.expression = expression;
    }

    public Type getCastType() {
        return castType;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return " (" + castType + ") " + expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
