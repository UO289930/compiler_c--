package ast.statements;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import semantic.Visitor;

import java.util.List;

public class For extends AbstractStatement {

    private final List<Statement> initializer;

    private final Expression condition;

    private final List<Statement> incremental;

    private final List<Statement> forStatements;

    public For(int line, int column, List<Statement> initializer, Expression condition, List<Statement> incremental, List<Statement> forStatements) {
        super(line, column);
        this.initializer = initializer;
        this.condition = condition;
        this.incremental = incremental;
        this.forStatements = forStatements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return super.accept(v, param);
    }
}
