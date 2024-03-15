package ast.expressions;

public abstract class AbstractLiteralExpression<T> extends AbstractExpression {

    private final T value;

    public AbstractLiteralExpression(int line, int column, T value) {
        super(line, column);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
