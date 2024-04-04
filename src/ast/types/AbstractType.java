package ast.types;

import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type{

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type type) {
        return new ErrorType(getLine(), getColumn(), 
                String.format("Arithmetic operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type reminder(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Reminder operator is not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type logical(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Logical operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type unaryNot() {
        return new ErrorType(getLine(), getColumn(),
                String.format("Unary not operator is not applicable for type %s", this));
    }

    @Override
    public Type comparison(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Comparison operators are not applicable for type %s and type %s", this, type));
    }

    @Override
    public Type unaryMinus() {
        return new ErrorType(getLine(), getColumn(),
                String.format("Unary minus operator is not applicable for type %s", this));
    }

    @Override
    public Type castTo(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Explicit casts to %s type are not allowed", type));
    }

    @Override
    public Type squareBrackets(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Indexing operator is not applicable for type %s", type));
    }

    @Override
    public Type dot(String fieldName) {
        return new ErrorType(getLine(), getColumn(),
                String.format("Type %s is not an struct and has no field called %s", this, fieldName));
    }

    @Override
    public Type parenthesis(List<Type> type) {
        return new ErrorType(getLine(), getColumn(), String.format("A function cannot be invoked for this type %s", this));
    }

    @Override
    public void mustBeAssignableTo(Type type1) {
        new ErrorType(getLine(), getColumn(),
                String.format("Right hand side of the statement (type %s) cannot be assigned to the left hand side (type %s)", this, type1));
    }

    @Override
    public void mustBeBoolean() {
        new ErrorType(getLine(), getColumn(), "Conditions and logical operators must be boolean");
    }

    @Override
    public void mustBeReturnedAs(Type type) {

        if(type instanceof VoidType){
            new ErrorType(getLine(), getColumn(),"There must be no return value");
        } else {
            new ErrorType(getLine(), getColumn(),
                    String.format("Type of returned expression must be %s and not %s", type, this));
        }

    }
}
