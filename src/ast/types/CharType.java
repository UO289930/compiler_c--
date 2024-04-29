package ast.types;

import semantic.Visitor;

public class CharType extends AbstractType {

    private static final int NUMBER_OF_BYTES = 1;

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
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

        return type instanceof CharType ?
                new IntType(line, column) :
                new ErrorType(line, column, "Second arithmetic operand type must also be a character");
    }

    @Override
    public Type reminder(int line, int column, Type type) {
        if(type instanceof ErrorType || type instanceof IntType){
            return type;
        }
        if(type instanceof CharType){
            return new IntType(line, column);
        }

        return new ErrorType(line, column, "Second reminder operand type must be a character or an integer");
    }

    @Override
    public Type comparison(int line, int column, Type type) {
        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof CharType ?
                new IntType(line, column) :
                new ErrorType(line, column, "Second comparison operand type must also be a character");
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return new IntType(line, column);
    }

    @Override
    public void mustBeAssignableTo(int line, int column, Type type1) {
        if(!(type1 instanceof CharType || type1 instanceof ErrorType)){
            new ErrorType(line, column,
                    String.format("A character cannot be assigned to %s type variable", type1));
        }
    }

    @Override
    public void mustBeReturnedAs(int line, int column, Type type) {

        if(!super.isVoidReturnType(line, column, type)){
            if(!(type instanceof CharType || type instanceof ErrorType)){
                new ErrorType(line, column, String.format("Character does not match with the function return type (%s)", type));
            }
        }
    }

    @Override
    public int numberOfBytes() {
        return NUMBER_OF_BYTES;
    }

    @Override
    public void mustMatchWith(int line, int column, int paramNumber, Type parameterType) {
        if(!(parameterType instanceof CharType)){
            new ErrorType(line, column, String.format("The type of the %s argument must be %s and not char", paramNumber, parameterType));
        }
    }

    @Override
    public String convertTo(Type type1) {
        if (type1 instanceof DoubleType) {
            return super.doubleConversion(type1);
        } else if(type1 instanceof IntType){
            return super.simpleConversion(type1);
        }
        return super.convertTo(type1);
    }

    @Override
    public String suffix() {
        return "b";
    }

    @Override
    public Type superType(Type type) {
        if(type instanceof IntType){
            return type;
        }
        if(type instanceof CharType){
            return new IntType(type.getLine(), type.getColumn());
        }
        assert false;
        throw new UnsupportedOperationException("");
    }
}
