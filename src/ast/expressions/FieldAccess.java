package ast.expressions;

import ast.AbstractASTNode;

public class FieldAccess extends AbstractASTNode implements Expression{

    private final Expression accessed;

    private final String fieldName;


    public FieldAccess(int line, int column, Expression accessed, String fieldName) {
        super(line, column);
        this.accessed = accessed;
        this.fieldName = fieldName;
    }

    public Expression getAccessed() {
        return accessed;
    }

    public String getFieldName() {
        return fieldName;
    }
}
