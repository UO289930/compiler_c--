package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractASTNode implements Statement {

    private final Expression condition;

    private final List<Statement> ifStatements;

    private final List<Statement> elseStatements;

    public IfElse(int line, int column, Expression condition, List<Statement> ifStatements, List<Statement> elseStatements) {
        super(line, column);
        this.condition = condition;
        this.ifStatements = ifStatements==null ? new ArrayList<>() : new ArrayList<>(ifStatements);
        this.elseStatements = elseStatements==null ? new ArrayList<>() : new ArrayList<>(elseStatements);
    }

    public Expression getCondition() { return condition; }

    public List<Statement> getIfStatements() {
        return new ArrayList<>(ifStatements);
    }

    public List<Statement> getElseStatements() {
        return new ArrayList<>(elseStatements);
    }

    @Override
    public String toString() {
        return "IfElse{" +
                super.toString() +
                ", condition=" + condition +
                ", ifStatements=" + ifStatements +
                ", elseStatements=" + elseStatements +
                '}';
    }
}
