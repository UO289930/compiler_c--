package ast.program;

import ast.types.FunctionType;
import semantic.Visitor;
import ast.statements.Statement;
import ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {


	private final List<VariableDefinition> variableDefinitions;
	private final List<Statement> statements;

	public FunctionDefinition(int line, int column, Type type, String name, List<VariableDefinition> variableDefinitions, List<Statement> statements) {
		super(line, column, type, name);

		this.variableDefinitions = variableDefinitions;
		this.statements = statements;
	}

	

	@Override
	public String toString() {

		return String.format("Function: %s %s", ((FunctionType)getType()).getReturnType(), getName());
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
		return v.visit(this, param);
	}

	public List<VariableDefinition> getVariableDefinitions() {
		return new ArrayList<>(variableDefinitions);
	}

	public List<Statement> getStatements() {
		return new ArrayList<>(statements);
	}
}
