package ast.types;

import ast.AbstractASTNode;

public class VoidType extends AbstractType {

    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "void";
    }
}
