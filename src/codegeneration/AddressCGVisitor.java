package codegeneration;


import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.StructField;
import ast.types.StructType;

/**
 * ADDRESS
 *
 * address[[Variable: expression -> ID]] =
 * 	 if(expression.definition.getScope()==0){
 * 		<pusha > expression.definition.offset
 *   } else {
 * 		<push bp>
 * 		<pushi > expression.definition.offset
 * 		<addi>
 *    }
 *
 *  address[[FieldAccess: expression1 -> expression2 ID]] =
 *      address[[expression2]]
 *      <pushi > expression2.type.getField(ID).offset
 *      <addi>
 *
 *  address[[Indexing: expression1 -> expression2 expression3]] =
 *      address[[expression2]]
 *      value[[expression3]]
 *      <pushi > expression1.type.numberOfBytes()
 *      <muli>
 *      <addi>
 *
 */
public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {


    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator codeGenerator) {
        super(codeGenerator);
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor){
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Variable variable, Void param) {

        if(variable.getDefinition().getScope()==0){
            cg.globalVariable(variable.getDefinition().getOffset());
        } else {
            cg.localVariable(variable.getDefinition().getOffset());
        }

        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getAccessed().accept(this, null);

        StructField structField = ((StructType) fieldAccess.getAccessed().getType()).getField(fieldAccess.getFieldName());
        cg.push("i", structField.getOffset());

        cg.add("i");
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {

        indexing.getAccessed().accept(this, null);
        indexing.getPosition().accept(valueCGVisitor, null);
        cg.push("i", indexing.getType().numberOfBytes());
        cg.mul("i");
        cg.add("i");

        return null;
    }
}
