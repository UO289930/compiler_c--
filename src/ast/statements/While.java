package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractStatement {

    private final Expression condition;

    private final List<Statement> whileStatements;

    public While(int line, int column, Expression condition, List<Statement> whileStatements) {
        super(line, column);
        this.condition = condition;
        this.whileStatements = whileStatements==null ? new ArrayList<>() : new ArrayList<>(whileStatements);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getWhileStatements() {
        return new ArrayList<>(whileStatements);
    }

    @Override
    public String toString() {

        return "While";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
