package ast.types;

import ast.AbstractASTNode;

public class AbstractType extends AbstractASTNode implements Type{

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public boolean isStruct() {
        return false;
    }
}
