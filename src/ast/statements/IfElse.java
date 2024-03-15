package ast.statements;

import ast.AbstractASTNode;
import ast.expressions.Expression;
import semantic.Visitor;

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
        StringBuilder sb = new StringBuilder();

        sb.append("if( ").
           append(condition).
           append(" ) {\n");

        ifStatements.forEach(stmt -> sb.append('\t').append(stmt).append('\n'));

        sb.append("}");

        if(!elseStatements.isEmpty()){
            sb.append("\nelse{\n");
            elseStatements.forEach(stmt -> sb.append('\t').append(stmt).append('\n'));
            sb.append("}");
        }


        return  sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
