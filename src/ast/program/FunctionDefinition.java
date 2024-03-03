package ast.program;

import ast.types.Type;
import dto.FunctionBody;

public class FunctionDefinition extends AbstractDefinition {


	private final FunctionBody body;

	public FunctionDefinition(int line, int column, Type type, String name, FunctionBody body) {
		super(line, column, type, name);

		if(body==null){
			throw new IllegalStateException("A function definition must provide a function body");
		}

		this.body = body;
	}

	public FunctionBody getBody() {
		return body;
	}

	@Override
	public String toString() {
		return super.toString() + " {\n" + body + "\n}";
	}
}
