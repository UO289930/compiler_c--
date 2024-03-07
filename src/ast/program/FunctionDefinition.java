package ast.program;

import ast.statements.Statement;
import ast.types.Type;
import dto.FunctionBody;

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

		StringBuilder sb = new StringBuilder(super.toString());

		sb.append(" {\n");
		variableDefinitions.forEach(v -> sb.append('\t').append(v.toString()).append('\n'));
		statements.forEach(s -> sb.append('\t').append(s.toString()).append('\n'));
		sb.append("\n}");

		return  sb.toString();
	}
}
