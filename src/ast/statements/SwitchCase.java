package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SwitchCase extends AbstractASTNode {

    private final Expression caseElement;
    private final List<Statement> statements;

    public SwitchCase(int line, int column, Expression caseElement, List<Statement> statements) {
        super(line, column);
        this.caseElement = caseElement;
        this.statements = statements==null|| statements.isEmpty() ? new ArrayList<>() : new ArrayList<>(statements);
    }

    public Expression getCaseElement() {
        return caseElement;
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    @Override
    public String toString() {
        return "SwitchCase";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
