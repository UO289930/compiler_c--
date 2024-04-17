package codegeneration;


import ast.expressions.Variable;

import java.io.IOException;

/**
 * ADDRESS
 *
 * address[[Variable: expression -> ID]] =
 * 	if(expression.definition.getScope()==0){
 * 		<pusha> expression.definition.offset
 *        } else {
 * 		<push bp>
 * 		<pushi> expression.definition.offset
 * 		<addi>
 *    }
 *
 */
public class AddressCGVisitor extends AbstractCGVisitor {


    public AddressCGVisitor(CodeGenerator codeGenerator) throws IOException {
        super(codeGenerator);
    }

    @Override
    public Void visit(Variable variable, Void param) {

        if(variable.getDefinition().getScope()==0){
            codeGenerator.globalVariable(variable.getDefinition().getOffset());
        } else {
            codeGenerator.localVariable(variable.getDefinition().getOffset());
        }

        return null;
    }
}
