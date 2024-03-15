package ast.expressions;

import semantic.Visitor;

public class FieldAccess extends AbstractExpression{

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

    @Override
    public String toString() {
        return accessed + "." + fieldName;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
