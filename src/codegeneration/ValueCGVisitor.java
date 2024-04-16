package codegeneration;

/**
 * value[[IntLiteral: expression -> INT_CONSTANT]] =  <pushi> expression.value
 * value[[CharLiteral: expression -> CHAR_CONSTANT]] = <pushb> (int) expression.value
 * value[[RealLiteral: expression -> REAL_CONSTANT]] = <pushf> expression.value
 * value[[Variable: expression -> ID]] =
 * 	address[[expression]]
 * 	<load> expression.type.suffix()
 * value[[Arithmetic: expression1 -> expression2 (+ | - | * | /) expression3]] =
 * 	value[[expression2]]
 * 	expression2.type.convertTo(expression1.type)
 * 	value[[expression3]]
 * 	expression3.type.convertTo(expression1.type)
 *
 * 	switch(expression1.operator){
 * 		case "+": <add> expression1.type.suffix()
 * 			break;
 * 		case "-": <sub> expression1.type.suffix()
 * 			break;
 * 		case "*": <mul> expression1.type.suffix()
 * 			break;
 * 		case "/": <div> expression1.type.suffix()
 * 			break;
 * 		default assert false;
 *    }
 *
 * value[[Comparison: expression1 -> expression2 (> | < | >= | <= | == | !=) expression3]] =
 * 	Type superType = expression2.type.superType(expresssion1)
 * 	value[[expression2]]
 * 	expression2.type.convertTo(superType)
 * 	value[[expression3]]
 * 	expression3.convertTo(superType)
 *
 * 	switch(expression1.operator){
 * 		case ">": <gt> superType.type.suffix()
 * 			break;
 * 		case "<": <lt> superType.type.suffix()
 * 			break;
 * 		case ">=": <ge> superType.type.suffix()
 * 			break;
 * 		case "<=": <le> superType.type.suffix()
 * 			break;
 * 		case "==": <eq> superType.type.suffix()
 * 			break;
 * 		case "!=": <ne> superType.type.suffix()
 * 			break;
 * 		default assert false;
 *    }
 *
 * value[[Logical: expression1 -> expression2 (&& | ||) expression3]] =
 * 	value[[expression2]]
 * 	value[[expression3]]
 * 	switch (expression1.operator){
 * 		case "&&": <and>
 * 			break;
 * 		case "||": <or>
 * 			break;
 * 		default assert false;
 *
 *    }
 *
 * value[[Cast: expression1 -> type expression2]] =
 * 	value[[expression2]]
 * 	expression2.convertTo(type)
 *
 */
public class ValueCGVisitor {
}
