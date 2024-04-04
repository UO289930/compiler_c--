package ast.types;

import semantic.Visitor;

public class DoubleType extends AbstractType {

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
    public Type arithmetic(Type type) {

        return type instanceof DoubleType ? this : super.arithmetic(type);
    }

    @Override
    public Type comparison(Type type) {
        return type instanceof DoubleType ? new IntType(getLine(), getColumn()) : super.comparison(type);
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
        if(!(type1 instanceof DoubleType)){
            super.mustBeAssignableTo(type1);
        }
    }

    @Override
    public void mustBeReturnedAs(Type type) {
        if(!(type instanceof DoubleType)){
            super.mustBeReturnedAs(type);
        }
    }
}
