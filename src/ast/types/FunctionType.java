package ast.types;

import ast.AbstractASTNode;
import ast.program.VariableDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    private final Type returnType;
    private final List<VariableDefinition> parameters;


    public FunctionType(int line, int column, Type returnType, List<VariableDefinition> parameters) {
        super(line, column);
        this.returnType = returnType;
        this.parameters = parameters==null ? new ArrayList<>() : new ArrayList<>(parameters);
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VariableDefinition> getParameters() {
        return new ArrayList<>(parameters);
    }
}
