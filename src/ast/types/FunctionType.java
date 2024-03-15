package ast.types;

import ast.program.VariableDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(returnType.toString()).append(" (");
        parameters.forEach(p -> sb.append(p).append(", "));

        if(sb.toString().contains(", ")){
            sb.replace(sb.length()-2, sb.length(), "");
        }

        sb.append(") ");

        return sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
