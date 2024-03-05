package ast.types;

import ast.AbstractASTNode;

public class ArrayType extends AbstractASTNode implements Type {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return type + "[" + size + "]";
    }

    @Override
    public int passSizeDown(int size) {

        // Take the input size and pass the current one to the next
        int prevSize = this.size;
        this.size = type.passSizeDown(size);
        return prevSize;
    }
}
