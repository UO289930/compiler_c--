package ast.program;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {

	private final List<Definition> definitions;

	public Program(int line, int column, List<Definition> definitions) {
		super(line, column);

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
		return "Program{" +
				super.toString() +
				", definitions=" + definitions +
				'}';
	}
}
