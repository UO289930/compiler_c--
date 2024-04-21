package codegeneration;

import ast.expressions.*;
import ast.types.Type;

/**
 * value[[IntLiteral: expression -> INT_CONSTANT]] =  <pushi> expression.value
 * value[[CharLiteral: expression -> CHAR_CONSTANT]] = <pushb> (int) expression.value
 * value[[RealLiteral: expression -> REAL_CONSTANT]] = <pushf> expression.value
 * value[[Variable: expression -> ID]] =
 * 	address[[expression]]
 * 	<load> expression.type.suffix()
 * value[[Arithmetic: expression1 -> expression2 (+ | - | * | /) expression3]] =
 * 	value[[expression2]]
 * 	expression2.type.convertTo(arithmetic.getType())
 * 	value[[expression3]]
 * 	expression3.type.convertTo(arithmetic.getType())
 *
 * 	switch(expression1.operator){
 * 		case "+": <add> arithmetic.getType().suffix()
 * 			break;
 * 		case "-": <sub> arithmetic.getType().suffix()
 * 			break;
 * 		case "*": <mul> arithmetic.getType().suffix()
 * 			break;
 * 		case "/": <div> arithmetic.getType().suffix()
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
 * 		case ">": <gt> superType.suffix()
 * 			break;
 * 		case "<": <lt> superType.suffix()
 * 			break;
 * 		case ">=": <ge> superType.suffix()
 * 			break;
 * 		case "<=": <le> superType.suffix()
 * 			break;
 * 		case "==": <eq> superType.suffix()
 * 			break;
 * 		case "!=": <ne> superType.suffix()
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
public class ValueCGVisitor extends AbstractCGVisitor {
    private final AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator codeGenerator, AddressCGVisitor addressCGVisitor) {
        super(codeGenerator);
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getOperand1().accept(this, null);
        codeGenerator.convert(arithmetic.getOperand1().getType(), arithmetic.getType());

        arithmetic.getOperand2().accept(this, null);
        codeGenerator.convert(arithmetic.getOperand2().getType(), arithmetic.getType());

        codeGenerator.arithmetic(arithmetic.getOperator(), arithmetic.getType().suffix());

        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {

        cast.getExpression().accept(this, null);
        codeGenerator.convert(cast.getExpression().getType(), cast.getCastType());

        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        codeGenerator.literal(charLiteral.getType().suffix(), (int)charLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        Type superType = comparison.getOperand1().getType().superType(comparison.getType());

        comparison.getOperand1().accept(this, null);
        codeGenerator.convert(comparison.getOperand1().getType(), superType);

        comparison.getOperand2().accept(this, null);
        codeGenerator.convert(comparison.getOperand2().getType(), superType);

        codeGenerator.comparison(comparison.getOperator(), superType.suffix());

        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        codeGenerator.literal(intLiteral.getType().suffix(), intLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getOperand1().accept(this, null);
        logical.getOperand2().accept(this, null);
        codeGenerator.logical(logical.getOperator());
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        codeGenerator.literal(realLiteral.getType().suffix(), realLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Reminder reminder, Void param) {
        reminder.getOperand1().accept(this, null);
        codeGenerator.convert(reminder.getOperand1().getType(), reminder.getType());

        reminder.getOperand2().accept(this, null);
        codeGenerator.convert(reminder.getOperand2().getType(), reminder.getType());

        codeGenerator.reminder();
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        codeGenerator.push(unaryMinus.getType().suffix(), "0");
        unaryMinus.getOperand().accept(this, null);
        codeGenerator.sub(unaryMinus.getType().suffix());

        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.getOperand().accept(this, null);
        codeGenerator.not();
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.accept(addressCGVisitor, null);
        codeGenerator.load(variable.getType().suffix());
        return null;
    }
}
