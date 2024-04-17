package ast.types;

import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type{

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(int line, int column, Type type) {
        return new ErrorType(line, column, 
                String.format("Arithmetic operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type reminder(int line, int column, Type type) {
        return new ErrorType(line, column,
                String.format("Reminder operator is not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type logical(int line, int column, Type type) {
        return new ErrorType(line, column,
                String.format("Logical operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type unaryNot(int line, int column) {
        return new ErrorType(line, column,
                String.format("Unary not operator is not applicable for type %s", this));
    }

    @Override
    public Type comparison(int line, int column, Type type) {
        return new ErrorType(line, column,
                String.format("Comparison operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return new ErrorType(line, column, String.format("Unary minus operator is not applicable for type %s", this));
    }

    @Override
    public Type castTo(int line, int column, Type type) {

        if(!(type instanceof IntType || type instanceof CharType || type instanceof DoubleType)){
            return new ErrorType(line, column, String.format("Explicit casts to %s type are not allowed", type));
        }

        return type;
    }

    @Override
    public Type squareBrackets(int line, int column, Type type) {
        return new ErrorType(line, column,
                String.format("Indexing operator is not applicable for type %s", type));
    }

    @Override
    public Type dot(int line, int column, String fieldName) {
        return new ErrorType(line, column,
                String.format("Type %s is not an struct and has no field called %s", this, fieldName));
    }

    @Override
    public Type parenthesis(int line, int column, List<Type> type) {
        return new ErrorType(line, column, String.format("A function cannot be invoked for this type %s", this));
    }

    @Override
    public void mustBeAssignableTo(int line, int column, Type type1) {
        new ErrorType(line, column,
                String.format("Right hand side of the statement (type %s) cannot be assigned to the left hand side (type %s)", this, type1));
    }

    @Override
    public void mustBeBoolean(int line, int column) {
        new ErrorType(line, column, "Conditions and logical operators must be boolean (integer)");
    }

    @Override
    public void mustBeReturnedAs(int line, int column, Type type) {
        new ErrorType(line, column, String.format("%s cannot be used as a return type", type));
    }
    @Override
    public void mustMatchWith(int line, int column, int paramNumber, Type paramType) {
        new ErrorType(line, column, String.format("The type of the %s argument (%s) is not valid for parameters", paramNumber, this));
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    protected boolean voidFunctionReturnType(int line, int column, Type type){
        if(type instanceof VoidType){
            new ErrorType(line, column,"There must be no return value");
            return true;
        }

        return false;
    }

    @Override
    public String convertTo(Type type1) {
        assert false;
        throw new UnsupportedOperationException(String.format("No conversions for %s type", this));
    }

    @Override
    public String suffix() {
        assert false;
        throw new UnsupportedOperationException(String.format("No suffix for %s type", this));
    }

    @Override
    public Type superType(Type type) {
        assert false;
        throw new UnsupportedOperationException(String.format("No super type for %s type", this));
    }

    protected String simpleConversion(Type type1){
        return String.format("%s2%s", this.suffix(), type1.suffix());
    }

    protected String doubleConversion(Type type1) {
        IntType intT = new IntType(this.getLine(),this.getColumn());
        return String.format("%s\n%s", this.convertTo(intT), intT.convertTo(type1));
    }
}
