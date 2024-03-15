package ast.expressions;

import semantic.Visitor;

public class Indexing extends AbstractExpression{

    private final Expression accessed;

    private final Expression position;

    public Indexing(int line, int column, Expression accessed, Expression position) {
        super(line, column);
        this.accessed = accessed;
        this.position = position;
    }

    public Expression getAccessed() {
        return accessed;
    }

    public Expression getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return accessed + "[" + position + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
