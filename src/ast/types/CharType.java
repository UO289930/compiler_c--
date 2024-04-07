package ast.types;

import semantic.Visitor;

public class CharType extends AbstractType {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Char";
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

        return type instanceof CharType ? new IntType(getLine(), getColumn()) : super.arithmetic(type);
    }

    @Override
    public Type reminder(Type type) {
        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof CharType ? new IntType(getLine(), getColumn()) : super.reminder(type);
    }

    @Override
    public Type comparison(Type type) {
        if(type instanceof ErrorType){
            return type;
        }

        return type instanceof CharType ? new IntType(getLine(), getColumn()) : super.comparison(type);
    }

    @Override
    public Type unaryMinus() {
        return new IntType(getLine(), getColumn());
    }

    @Override
    public Type castTo(Type type) {
        return type;
    }

    @Override
    public void mustBeAssignableTo(Type type1) {
        if(!(type1 instanceof CharType || type1 instanceof ErrorType)){
            super.mustBeAssignableTo(type1);
        }
    }

    @Override
    public void mustBeReturnedAs(Type type) {
        if(!(type instanceof CharType || type instanceof ErrorType)){
            super.mustBeReturnedAs(type);
        }
    }
}
