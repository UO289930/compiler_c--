package ast.expressions;

import ast.AbstractASTNode;

public abstract class OperatorExpression extends AbstractASTNode implements Expression{
    private final String operator;

    private final Expression operand1;

    private final Expression operand2;

    public OperatorExpression(int line, int column, String operator, Expression operand1, Expression operand2) {
        super(line, column);
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getOperand1() {
        return operand1;
    }

    public Expression getOperand2() {
        return operand2;
    }
}
