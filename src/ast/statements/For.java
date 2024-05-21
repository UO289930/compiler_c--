package ast.statements;

import ast.expressions.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class For extends AbstractStatement {

    private final Statement initializer;

    private final Expression condition;

    private final Statement increment;

    private final List<Statement> forStatements;

    public For(int line, int column, Statement initializer, Expression condition, Statement increment, List<Statement> forStatements) {
        super(line, column);
        this.initializer = initializer;
        this.condition = condition;
        this.increment = increment;
        this.forStatements = new ArrayList<>(forStatements);
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getInitializer() {
        return initializer;
    }

    public Statement getIncrement() {
        return increment;
    }

    public List<Statement> getForStatements() {
        return new ArrayList<>(forStatements);
    }

    @Override
    public String toString() {
        return "for";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
