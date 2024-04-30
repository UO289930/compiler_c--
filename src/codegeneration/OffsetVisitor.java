package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.types.FunctionType;
import ast.types.StructField;
import ast.types.StructType;
import semantic.AbstractVisitor;

import java.util.List;

/**
 *
 * (P) FunctionDefinition : definition -> type ID varDefinition* statement*
 * (R) int localsSumOfBytes = 0;
 *     for(VariableDefinition varDefinition: varDefinition*){
 *         varDefinition.offset = -localsSumOfBytes;
 *         localsSumOfBytes += definition.type.numberOfBytes();
 *     }
 *
 *
 * (P) VariableDefinition: definition -> type ID
 * (R) // globalsSumOfBytes is a global variable
 *      if( definition.scope == 0 ){
 *          definition.offset = globalsSumOfBytes;
 *          globalsSumOfBytes += definition.type.numberOfBytes();
 *      }
 *
 *
 * (P) FunctionType: type -> type varDefinition*
 * (R) int paramsSumOfBytes = 0;
 *     for(int i=varDefinition*.size()-1; i>=0 ; i--){
 *         varDefinition*.get(i).offset = 4 + paramsSumOfBytes;
 *         paramsSumOfBytes += varDefinition*.get(i).type.numberOfBytes();
 *     }
 *
 *
 * (P) StructType: definition -> field* ID
 * (R)  int fieldsSumOfBytes = 0;
 *      for(RecordField field: field*){
 *          field.offset = fieldsSumOfBytes;
 *          fieldsSumOfBytes += field.type.numberOfBytes();
 *      }
 *
 *
 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    private int globalsSumOfBytes = 0;

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {

        // params
        functionDefinition.getType().accept(this, null);

        // locals
        int localsSumOfBytes = 0;
        for (VariableDefinition varDefinition: functionDefinition.getVariableDefinitions()) {
            super.visit(varDefinition, null); // traversing children
            localsSumOfBytes += varDefinition.getType().numberOfBytes();
            varDefinition.setOffset(-localsSumOfBytes);
        }

        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {

        if( variableDefinition.getScope() == 0 ){
            variableDefinition.getType().accept(this, null);
            variableDefinition.setOffset( globalsSumOfBytes );
            globalsSumOfBytes += variableDefinition.getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        List<VariableDefinition> params = functionType.getParameters();
        int paramsSumOfBytes = 0;
        for(int i=params.size()-1; i>=0 ; i--) {
            params.get(i).accept(this, null);
            params.get(i).setOffset( 4 + paramsSumOfBytes );
            paramsSumOfBytes += params.get(i).getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(StructType structType, Void param) {
        int fieldsSumOfBytes = 0;
        for(StructField field: structType.getFields()){
            field.accept(this, null);
            field.setOffset(fieldsSumOfBytes);
            fieldsSumOfBytes += field.getType().numberOfBytes();
        }

        return null;
    }
}
