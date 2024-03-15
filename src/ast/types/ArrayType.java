package ast.types;

import ast.AbstractASTNode;
import semantic.Visitor;

public class ArrayType extends AbstractASTNode implements Type {

    private Type elementType;
    private final int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.elementType = type;
        this.size = size;
    }

    public Type getElementType() {
        return elementType;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return elementType + "[" + size + "]";
    }

    public void setElementType(Type newArrayType) {
        if(!(newArrayType instanceof ArrayType)){
            throw new IllegalArgumentException("The array type must be composed by other arrays. Primitive types are allowed at the constructor");
        }

        this.elementType = newArrayType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
