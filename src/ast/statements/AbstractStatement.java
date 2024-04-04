package ast.statements;

import ast.AbstractASTNode;
import ast.types.Type;
import semantic.Visitor;

public class AbstractStatement extends AbstractASTNode implements Statement{

    private Type returnType;

    public AbstractStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return null;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    @Override
    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }
}
