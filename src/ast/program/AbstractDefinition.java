package ast.program;

import ast.AbstractASTNode;
import ast.types.Type;

public class AbstractDefinition extends AbstractASTNode implements Definition{

	private final Type type;
	private final String name;


	public AbstractDefinition(int line, int column, Type type, String name) {
        super(line,column);
		this.type = type;
        this.name = name;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return super.toString() +
				", type=" + type +
				", name='" + name + '\'';
	}
}
