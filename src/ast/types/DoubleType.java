package ast.types;

import semantic.Visitor;

public class DoubleType extends AbstractType {

    private static final int NUMBER_OF_BYTES = 4;

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double";
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
                new ErrorType(line, column, "Arithmetic operand types must be double");
    }

    @Override
    public Type comparison(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof DoubleType ?
                new IntType(line, column) :
                new ErrorType(line, column, "Comparison operand types must be double");
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
        if(!super.isVoidReturnType(line, column, type)){
            if(!(type instanceof DoubleType || type instanceof ErrorType)){
                new ErrorType(line, column, String.format("Double does not match with the function return type (%s)", type));
            }
        }
    }

    @Override
    public int numberOfBytes() {
        return NUMBER_OF_BYTES;
    }

    @Override
    public void mustMatchWith(int line, int column, int paramNumber, Type parameterType) {
        if(!(parameterType instanceof DoubleType)){
            new ErrorType(line, column, String.format("The type of the %s argument must be %s and not double", paramNumber, parameterType));
        }
    }

    @Override
    public String convertTo(Type type1) {
        if (type1 instanceof CharType) {
            return super.doubleConversion(type1);
        } else if(type1 instanceof IntType){
            return super.simpleConversion(type1);
        }
        return super.convertTo(type1);
    }

    @Override
    public String suffix() {
        return "f";
    }

    @Override
    public Type superType(Type type) {
        if(type instanceof DoubleType){
            return this;
        }
        assert false;
        throw new UnsupportedOperationException();
    }
}
