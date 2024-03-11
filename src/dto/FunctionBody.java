package dto;

import ast.program.VariableDefinition;
import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionBody {

    private final List<Statement> statements;
    private final ArrayList<VariableDefinition> variableDefinitions;

    public FunctionBody() {
        this.statements =  new ArrayList<>();
        this.variableDefinitions = new ArrayList<>();
    }

    public List<VariableDefinition> getVariableDefinitions() {
        return new ArrayList<>(variableDefinitions);
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    public void addAllVariableDefinitions(List<VariableDefinition> variableDefinitions){
        if(variableDefinitions!=null){
            this.variableDefinitions.addAll(variableDefinitions);
        }
    }

    public void addAllStatements(List<Statement> statements){
        if(statements!=null){
            this.statements.addAll(statements);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        variableDefinitions.forEach(vardef -> sb.append('\t').append(vardef).append('\n'));
        statements.forEach(stmt -> sb.append('\t').append(stmt).append('\n'));

        return sb.toString();
    }
}
