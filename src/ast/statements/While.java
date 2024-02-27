package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractASTNode implements Statement {

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
}
