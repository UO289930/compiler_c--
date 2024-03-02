package ast.program;

import ast.types.Type;

public class VariableDefinition extends AbstractDefinition{

    public VariableDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }

}
