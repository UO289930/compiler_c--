package codegeneration;


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
public class AddressCGVisitor {
}
