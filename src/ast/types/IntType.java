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

        return type instanceof IntType ? this : new ErrorType(line, column, "Second arithmetic operand type must also be an integer");
    }

    @Override
    public Type reminder(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ?
                this :
                new ErrorType(line, column, "Second reminder operand type must also be an integer");
    }

    @Override
    public Type logical(int line, int column, Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ?
                this :
                new ErrorType(line, column, "Second logical operand type must also be an boolean (integer)");
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

        return type instanceof IntType ?
                this :
                new ErrorType(line, column, "Second comparison operand type must also be an integer");
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

        if(!super.voidFunctionReturnType(line, column, type)){
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
    public void promoteTo(int line, int column, int paramNumber, Type parameterType) {
        if(!(parameterType instanceof IntType)){
            new ErrorType(line, column, String.format("The type of the %s argument must be %s and not int", paramNumber, parameterType));
        }
    }


}
