package ast.types;

import ast.AbstractASTNode;

public class StructField extends AbstractASTNode {
    private final Type type;
    private final String fieldName;

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
        return "StructField{" +
                super.toString() +
                ", type=" + type +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
