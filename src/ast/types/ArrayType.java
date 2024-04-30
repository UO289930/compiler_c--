package ast.types;

import semantic.Visitor;

public class ArrayType extends AbstractType {

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
        return String.format("[%s, %s]", getSize(), getElementType().toString());
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

    @Override
    public Type squareBrackets(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }
        if(type instanceof IntType){
            return getElementType();
        }

        return new ErrorType(line, column, String.format("Arrays positions can only be accessed by means of Integer expressions, not by %s expressions", type));
    }

    @Override
    public int numberOfBytes() {
        int totalNumberOfBytes = getSize();
        Type nextType = getElementType();

        while(nextType instanceof ArrayType){
            totalNumberOfBytes *= ((ArrayType) nextType).getSize();
            nextType = ((ArrayType) nextType).getElementType();
        }

        // next type is IntType here
        return totalNumberOfBytes * nextType.numberOfBytes();
    }
}
