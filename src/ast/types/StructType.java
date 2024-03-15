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
        StringBuilder sb = new StringBuilder("struct{\n");

        fields.forEach(field -> sb.append('\t').append(field.toString()).append('\n'));

        sb.append("} ");

        return sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
