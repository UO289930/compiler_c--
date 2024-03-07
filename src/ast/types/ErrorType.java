package ast.types;

import ast.AbstractASTNode;
import ast.errorhandler.ErrorHandler;
import examples.ast.ASTNode;

public class ErrorType extends AbstractASTNode implements Type {

    private final String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error (line: ").append(getLine()).append(", column: ").append(getColumn()).append("): ");
        sb.append(message);

        return sb.toString();
    }
}
