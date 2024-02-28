package ast.types;

import ast.AbstractASTNode;

public class VoidType extends AbstractASTNode implements Type {

    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "VoidType{" +
                super.toString() +
                "}";
    }
}
