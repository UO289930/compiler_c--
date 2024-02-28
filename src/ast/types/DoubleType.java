package ast.types;

import ast.AbstractASTNode;

public class DoubleType extends AbstractASTNode implements Type {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "DoubleType{" +
                super.toString() +
                "}";
    }
}
