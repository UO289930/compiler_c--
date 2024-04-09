package ast.types;

import ast.AbstractASTNode;
import semantic.Visitor;

public class StructField extends AbstractASTNode {
    private final Type type;
    private final String fieldName;

    private int offset;

    public StructField(int line, int column, Type type, String fieldName) {
        super(line, column);
        this.type = type;
        this.fieldName = fieldName;
    }

    public Type getType() {
        return type;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return type + " " + fieldName;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
