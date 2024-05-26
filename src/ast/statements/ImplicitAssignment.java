package ast.statements;

import ast.expressions.AbstractExpression;
import ast.expressions.AbstractUnaryExpression;
import ast.expressions.Expression;
import ast.types.Type;
import semantic.Visitor;

public class ImplicitAssignment extends AbstractExpression implements Statement {

    public static final int PRE = 0;
    public static final int POST = 1;

    private final int order;
    private final Expression expression;

    private final String operator;

    private Type returnType;

    public ImplicitAssignment(int line, int column, int order, Expression expression, String operator) {
        super(line, column);
        this.order = order;
        this.expression = expression;
        this.operator = operator;
    }

    public int getOrder() {
        return order;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "Implicit Assignment";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    @Override
    public void setReturnType(Type type) {
        returnType = type;
    }
}
