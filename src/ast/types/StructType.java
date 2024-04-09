package ast.types;

import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractType {

    private final List<StructField> fields;

    public StructType(int line, int column, List<StructField> fields) {
        super(line, column);

        // ANTLR should have caught this before
        if(fields==null || fields.isEmpty()){
            throw new IllegalStateException("Struct must, at least, have one field");
        }

        this.fields = new ArrayList<>(fields);
    }

    public List<StructField> getFields() {
        return new ArrayList<>(fields);
    }

    @Override
    public String toString() {
        return "struct";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type dot(int line, int column, String fieldName) {

        List<StructField> matchingField = getFields().stream().filter( field -> field.getFieldName().contentEquals(fieldName) ).toList();

        if(matchingField.isEmpty()){
            return new ErrorType(line, column,
                    String.format("Field '%s' does not exist inside struct", fieldName));
        }

        return matchingField.get(0).getType();
    }

    @Override
    public int numberOfBytes() {
        return getFields().stream().mapToInt(field -> field.getType().numberOfBytes()).sum();
    }
}
