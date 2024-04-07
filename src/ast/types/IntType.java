package ast.types;

import semantic.Visitor;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ? this : super.arithmetic(type);
    }

    @Override
    public Type reminder(Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ? this : super.reminder(type);
    }

    @Override
    public Type logical(Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ? this : super.logical(type);
    }

    @Override
    public Type unaryNot() {
        return this;
    }

    @Override
    public Type comparison(Type type) {

        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof IntType ? this : super.comparison(type);
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public Type castTo(Type type) {
        return type;
    }

    @Override
    public void mustBeAssignableTo(Type type1) {


        if(!(type1 instanceof IntType || type1 instanceof ErrorType)){
            super.mustBeAssignableTo(type1);
        }
    }

    // No error
    @Override
    public void mustBeBoolean() {}

    @Override
    public void mustBeReturnedAs(Type type) {
        if(!(type instanceof IntType || type instanceof ErrorType)){
            super.mustBeReturnedAs(type);
        }
    }
}
