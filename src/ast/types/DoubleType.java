package ast.types;

import semantic.Visitor;

public class DoubleType extends AbstractType {

    private static final int NUMBER_OF_BYTES = 4;

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Double";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof DoubleType ?
                this :
                new ErrorType(line, column, "Second arithmetic operand type must also be a double");
    }

    @Override
    public Type comparison(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof DoubleType ?
                new IntType(line, column) :
                new ErrorType(line, column, "Second comparison operand type must also be a double");
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return this;
    }

    @Override
    public void mustBeAssignableTo(int line, int column, Type type1) {
        if(!(type1 instanceof DoubleType || type1 instanceof ErrorType)){
            new ErrorType(line, column,
                    String.format("A double cannot be assigned to %s type variable", type1));
        }
    }

    @Override
    public void mustBeReturnedAs(int line, int column, Type type) {
        if(!(type instanceof DoubleType || type instanceof ErrorType)){
            new ErrorType(line, column, String.format("Double does not match with the function return type (%s)", type));
        }
    }

    @Override
    public int numberOfBytes() {
        return NUMBER_OF_BYTES;
    }
}
