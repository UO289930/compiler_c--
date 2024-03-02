package dto;

import ast.program.VariableDefinition;
import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public record FunctionBody(List<VariableDefinition> varDefinitions, List<Statement> statements) {

    public FunctionBody(List<VariableDefinition> varDefinitions, List<Statement> statements) {
        this.statements = statements == null ? new ArrayList<>() : new ArrayList<>(statements);
        this.varDefinitions = varDefinitions == null ? new ArrayList<>() : new ArrayList<>(varDefinitions);
    }

    @Override
    public List<VariableDefinition> varDefinitions() {
        return new ArrayList<>(varDefinitions);
    }
    @Override
    public List<Statement> statements() {
        return new ArrayList<>(statements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        varDefinitions.forEach(vardef -> sb.append('\t').append(vardef).append('\n'));
        statements.forEach(stmt -> sb.append('\t').append(stmt).append('\n'));

        return sb.toString();
    }
}
