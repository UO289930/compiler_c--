package ast.types;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class StructType extends AbstractASTNode implements Type {

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
        return "StructType{" +
                super.toString() +
                ", fields=" + fields +
                '}';
    }
}
