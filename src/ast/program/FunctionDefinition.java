package ast.program;

import ast.statements.Statement;
import ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {


	private final List<VariableDefinition> parameters;

	private final List<Statement> statements;
	
	private final List<VariableDefinition> varDefinitions;

	public FunctionDefinition(int line, int column, Type type, String name, List<VariableDefinition> parameters, List<Statement> statements, List<VariableDefinition> varDefinitions) {
		super(line, column, type, name);

		this.parameters = parameters==null ? new ArrayList<>() : new ArrayList<>(parameters);
		this.statements = statements==null ? new ArrayList<>() : new ArrayList<>(statements);
		this.varDefinitions = varDefinitions==null ? new ArrayList<>() : new ArrayList<>(varDefinitions);
	}

	public List<VariableDefinition> getParameters() { return parameters; }
	public List<Statement> getStatements() {
		return new ArrayList<>(statements);
	}

	public List<VariableDefinition> getVarDefinitions() {
		return new ArrayList<>(varDefinitions);
	}
}
