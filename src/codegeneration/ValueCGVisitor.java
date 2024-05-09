package codegeneration;

import ast.expressions.*;
import ast.types.Type;

/**
 * value[[IntLiteral: expression -> INT_CONSTANT]] =  <pushi > expression.value
 * value[[CharLiteral: expression -> CHAR_CONSTANT]] = <pushb > (int) expression.value
 * value[[RealLiteral: expression -> REAL_CONSTANT]] = <pushf > expression.value
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
 * 	Type superType = expression2.type.superType(expression1.type)
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
 * 	value[[UnaryMinus: expression1 -> expression2]] =
 * 	    <push> expression1.suffix 0
 * 	    <push> expression1.suffix expression1.value
 * 	    <sub> expression1.suffix
 *
 * 	value[[UnaryNot: expression1 -> expression2]] =
 * 	    <pushi > expression1.value
 * 	    <not>
 *
 * 	value[[Reminder: expression1 -> expression2 expression3]] =
 * 	    value[[expression2]]
 * 	    expression2.type.convertTo(expression1.type)
 *
 * 	value[[FieldAccess: expression1 -> expression2 ID]] =
 * 	    address[[expression1]]
 *      <load> expression1.type.suffix()
 *
 *  value[[Indexing: expression1 -> expression2 expression3]] =
 *      address[[expression1]]
 *      <load> expression1.type.suffix()
 *
 *  value[[FunctionInvocation: expression -> expression expression*]] =
 *      expression*.forEach(exp -> value[[exp]]);
 *      <call > expression.name
 *
 */
public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {
    private final AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg, AddressCGVisitor addressCGVisitor) {
        super(cg);
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getOperand1().accept(this, null);
        cg.convert(arithmetic.getOperand1().getType(), arithmetic.getType());

        arithmetic.getOperand2().accept(this, null);
        cg.convert(arithmetic.getOperand2().getType(), arithmetic.getType());

        cg.arithmetic(arithmetic.getOperator(), arithmetic.getType().suffix());

        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {

        cast.getExpression().accept(this, null);
        cg.convert(cast.getExpression().getType(), cast.getCastType());

        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        cg.literal(charLiteral.getType().suffix(), (int)charLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        Type superType = comparison.getOperand1().getType().superType(comparison.getType());

        comparison.getOperand1().accept(this, null);
        cg.convert(comparison.getOperand1().getType(), superType);

        comparison.getOperand2().accept(this, null);
        cg.convert(comparison.getOperand2().getType(), superType);

        cg.comparison(comparison.getOperator(), superType.suffix());

        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        cg.literal(intLiteral.getType().suffix(), intLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getOperand1().accept(this, null);
        logical.getOperand2().accept(this, null);
        cg.logical(logical.getOperator());
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        cg.literal(realLiteral.getType().suffix(), realLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Reminder reminder, Void param) {
        reminder.getOperand1().accept(this, null);
        cg.convert(reminder.getOperand1().getType(), reminder.getType());

        reminder.getOperand2().accept(this, null);
        cg.convert(reminder.getOperand2().getType(), reminder.getType());

        cg.reminder();
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        cg.push(unaryMinus.getType().suffix(), "0");
        unaryMinus.getOperand().accept(this, null);
        cg.sub(unaryMinus.getType().suffix());

        return null;
    }

    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.getOperand().accept(this, null);
        cg.not();
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.accept(addressCGVisitor, null);
        cg.load(variable.getType().suffix());
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.accept(addressCGVisitor, null);
        cg.load(fieldAccess.getType().suffix());
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.accept(addressCGVisitor, null);
        cg.load(indexing.getType().suffix());
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        functionInvocation.getArguments().forEach(arg -> arg.accept(this, null));
        cg.call(functionInvocation.getVariable().getName());
        return null;
    }
}
