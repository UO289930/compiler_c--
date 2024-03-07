package ast.types;

import ast.AbstractASTNode;

import java.lang.reflect.Array;

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

    public void setSize(int size){
        if(type instanceof ArrayType){
            ((ArrayType)type).setSize(size);
        }
        else{
            this.type = new ArrayType(getLine(), getColumn(), this.type, size);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return type + "[" + size + "]";
    }
}
