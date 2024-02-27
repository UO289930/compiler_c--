package ast.types;

import ast.AbstractASTNode;

public class ArrayType extends AbstractASTNode implements Type {

    private final Type type;

    private final int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
