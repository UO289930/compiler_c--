package ast.expressions;

import ast.AbstractASTNode;

public class Indexing extends AbstractASTNode implements Expression{

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
        return "Indexing{" +
                super.toString() +
                ", accessed=" + accessed +
                ", position=" + position +
                '}';
    }
}
