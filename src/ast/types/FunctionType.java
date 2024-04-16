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
        return "Function";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type parenthesis(int line, int column, List<Type> argumentsTypes) {

        List<Type> filteredArgumentTypes = argumentsTypes.stream().filter( type -> type instanceof ErrorType ).toList();
        if(!filteredArgumentTypes.isEmpty()){
            return filteredArgumentTypes.get(0);
        }

        List<VariableDefinition> parameters = getParameters();
        if(argumentsTypes.size()!=parameters.size()){
            return new ErrorType(line, column, "Wrong number of arguments");
        }

        for(int i=0; i<argumentsTypes.size(); i++){

            Type parameterType = parameters.get(i).getType();
            Type argumentType = argumentsTypes.get(i);

            argumentType.promoteTo(line, column, i+1, parameterType);

        }

        return this.getReturnType();
    }

}
