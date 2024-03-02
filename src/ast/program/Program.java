package ast.program;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {

	private static final int COLUMN = 1;
	private static final int LINE = 1;
	private final List<Definition> definitions;

	public Program(List<Definition> definitions) {
		super(LINE, COLUMN);

		// ANTLR should have caught this before
		if(definitions== null || definitions.isEmpty()){
			throw new IllegalStateException("The program must have at least one main function definition");
		}

		this.definitions = new ArrayList<>(definitions);
	}

	public List<Definition> getDefinitions() {
		return new ArrayList<>(definitions);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		definitions.forEach(definition -> sb.append(definition.toString()).append("\n"));
		return sb.toString();
	}
}
