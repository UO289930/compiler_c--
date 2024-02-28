package ast.types;

import ast.AbstractASTNode;

public class IntType extends AbstractASTNode implements Type {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntType{" +
                super.toString() +
                "}";
    }
}
