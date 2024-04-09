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
    public Type arithmetic(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type reminder(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type logical(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type unaryNot(int line, int column) {
        return this;
    }

    @Override
    public Type comparison(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type unaryMinus(int line, int column) {
        return this;
    }

    @Override
    public Type castTo(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type squareBrackets(int line, int column, Type type) {
        return this;
    }

    @Override
    public Type dot(int line, int column, String fieldName) {
        return this;
    }

    @Override
    public Type parenthesis(int line, int column, List<Type> type) {
        return this;
    }

    @Override
    public void mustBeAssignableTo(int line, int column, Type type1) {
    }

    @Override
    public void mustBeBoolean(int line, int column) {
    }

    @Override
    public void mustBeReturnedAs(int line, int column, Type type) {
    }
}
