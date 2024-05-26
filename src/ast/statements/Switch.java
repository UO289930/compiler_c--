package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Switch extends AbstractStatement{

    private final List<SwitchCase> cases;

    private final Expression caseExpression;

    public Switch(int line, int column, Expression caseExpression, List<SwitchCase> cases) {
        super(line, column);
        this.cases = cases==null || cases.isEmpty() ? new ArrayList<>() : new ArrayList<>(cases);
        this.caseExpression = caseExpression;
    }

    public List<SwitchCase> getCases() {
        return new ArrayList<>(cases);
    }

    public Expression getCaseExpression() {
        return caseExpression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Switch";
    }
}
