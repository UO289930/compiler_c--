package ast.program;

import semantic.Visitor;
import ast.types.Type;

public class VariableDefinition extends AbstractDefinition{

    public VariableDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
