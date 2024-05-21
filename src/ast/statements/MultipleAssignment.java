package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class MultipleAssignment extends AbstractStatement {

    private final List<Expression> leftExpressions;

    private final List<Expression> rightExpressions;

    public MultipleAssignment(int line, int column, List<Expression> leftExpressions, List<Expression> rightExpressions) {
        super(line, column);
        this.leftExpressions = new ArrayList<>(leftExpressions);
        this.rightExpressions = new ArrayList<>(rightExpressions);
    }

    public List<Expression> getLeftExpressions() {
        return new ArrayList<>(leftExpressions);
    }

    public List<Expression> getRightExpressions() {
        return new ArrayList<>(rightExpressions);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Multiple Assignment";
    }
}
