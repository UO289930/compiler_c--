package ast.types;

import semantic.Visitor;

public class IntType extends AbstractType {

    private static final int NUMBER_OF_BYTES = 2;

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int";
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

        return type instanceof IntType ? this : new ErrorType(line, column, "Arithmetic operand types must also be integer");
    }

    @Override
    public Type reminder(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        if(type instanceof IntType || type instanceof CharType){
            return this;
        }

        return new ErrorType(line, column, "Reminder operand types must be integer or character");
    }

    @Override
    public Type logical(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ?
                this :
                new ErrorType(line, column, "Logical operand types must be boolean (integer)");
    }

    @Override
    public Type unaryNot(int line, int column) {
        return this;
    }

    @Override
    public Type comparison(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        if(type instanceof IntType){
            return this;
        }

        return new ErrorType(line, column, "Comparison operand types must be the same");
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return this;
    }

    @Override
    public void mustBeAssignableTo(int line, int column, Type type1) {


        if(!(type1 instanceof IntType || type1 instanceof ErrorType)){
            new ErrorType(line, column,
                    String.format("An integer cannot be assigned to %s type variable", type1));
        }
    }

    // No error
    @Override
    public void mustBeBoolean(int line, int column) {}

    @Override
    public void mustBeReturnedAs(int line, int column, Type type) {

        if(!super.isVoidReturnType(line, column, type)){
            if(!(type instanceof IntType || type instanceof ErrorType)){
                new ErrorType(line, column, String.format("Integer does not match with the function return type (%s)", type));
            }
        }


    }

    @Override
    public int numberOfBytes() {
        return NUMBER_OF_BYTES;
    }

    @Override
    public void mustMatchWith(int line, int column, int paramNumber, Type parameterType) {
        if(!(parameterType instanceof IntType)){
            new ErrorType(line, column, String.format("The type of the %s argument must be %s and not int", paramNumber, parameterType));
        }
    }

    @Override
    public String convertTo(Type type1) {
        return super.simpleConversion(type1);
    }

    @Override
    public String suffix() {
        return "i";
    }

    @Override
    public Type superType(Type type) {
        if(type instanceof IntType){
            return this;
        }
        assert false;
        throw new UnsupportedOperationException();
    }

    @Override
    public void mustBePromotable(int line, int column, Type type) {
        if(!(type instanceof IntType || type instanceof DoubleType)){
            super.mustBePromotable(line, column, type); // error
        }
    }

}
