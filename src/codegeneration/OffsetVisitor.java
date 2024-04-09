package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.types.FunctionType;
import ast.types.StructType;
import semantic.AbstractVisitor;

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
 *     for(int i=varDefinition*.size(); i>=0 ; i--){
 *         varDefinition*.get(i).offset = 4 + paramsSumOfBytes;
 *         paramsSumOfBytes += varDefinition*.get(i).type.numberOfBytes();
 *     }
 *
 *
 * (P) StructType: definition -> field* ID
 * (R)  int fieldsSumOfBytes = 0;
 *      for(RecordField field: field*){
 *          field.type.offset = fieldsSumOfBytes;
 *          fieldsSumOfBytes += field.type.numberOfBytes();
 *      }
 *
 *
 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {


    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {

        int localsSumOfBytes = 0;
        for (VariableDefinition varDefintion: functionDefinition.getVariableDefinitions()) {
            varDefintion.setOffset(localsSumOfBytes);
            localsSumOfBytes += varDefintion.getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        return super.visit(variableDefinition, param);
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        return super.visit(functionType, param);
    }

    @Override
    public Void visit(StructType structType, Void param) {
        return super.visit(structType, param);
    }
}
