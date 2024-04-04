package ast.types;

import ast.errorhandler.ErrorHandler;
import semantic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    private final String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error (line: ").append(getLine()).append(", column: ").append(getColumn()).append("): ");
        sb.append(message);

        return sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    // Strategy for not repeating errors

    @Override
    public Type arithmetic(Type type) {
        return this;
    }

    @Override
    public Type reminder(Type type) {
        return this;
    }

    @Override
    public Type logical(Type type) {
        return this;
    }

    @Override
    public Type unaryNot() {
        return this;
    }

    @Override
    public Type comparison(Type type) {
        return this;
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public Type castTo(Type type) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type) {
        return this;
    }

    @Override
    public Type dot(String fieldName) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> type) {
        return this;
    }

    @Override
    public void mustBeAssignableTo(Type type1) {
    }

    @Override
    public void mustBeBoolean() {
    }

    @Override
    public void mustBeReturnedAs(Type type) {
    }
}
