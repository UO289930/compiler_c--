package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.FunctionType;

/**
 *
 * execute[[Read: statement -> expression]] =
 * 	address[[expression]]
 * 	<in> expression.type.suffix()
 * 	<store> expression.type.suffix()
 *
 * execute[[Write: statement -> expression]] =
 * 	value[[expression]]
 * 	<out> expression.type.suffix()
 *
 * execute[[Assignment: statement -> expression1 expression2]] =
 * 	address[[expression1]]
 * 	value[[expression2]]
 * 	<store> expression1.type.suffix()
 *
 * 	execute[[While: statement -> expression statement*]] =
 * 	    String condLabel = cg.nextLabel(),
 * 	           exitLabel = cg.nextLabel();
 * 	    condLabel<:>
 * 	    value[[expression]]
 * 	    <jz > exitLabel
 * 	    statement*.forEach(stmt -> execute[[stmt]])
 * 	    <jmp > condLabel
 * 	    exitLabel<:>
 *
 * 	execute[[IfElse: statement -> expression statement1* statement2*]] =
 *      String elseLabel = cg.nextLabel(),
 *             exitLabel = cg.nextLabel();
 *      value[[expression]]
 *      <jz > elseLabel
 *      statement1*.forEach(stmt -> execute[[stmt]])
 *      <jmp > exitLabel
 *      elseLabel<:>
 *      statement2*.forEach(stmt -> execute[[stmt]])
 *      exitLabel<:>
 *
 *
 * execute[[VariableDefinition: definition -> type ID]] =
 *  <'* > definition.type.toString()
 *
 * execute[[FunctionDefinition: definition -> type ID varDefinition* statement*]] =
 *  ID<:>
 *  execute[[type]]
 *  varDefinition*.forEach(varDefinition -> execute[[varDefinition]])
 *  <enter > -varDefinition*.get( varDefinition*.size()-1 ).offset
 *  statement*.forEach(stmt -> execute[[stmt]])
 *
 *  execute[[FunctionType: type1 -> type2 varDefinition*]] =
 *   varDefinition*.forEach(varDefinition -> execute[[varDefinition]])
 *
 * execute[[Program: program -> definition*]] =
 *  definition*.forEach(def -> execute[[def]])
 *
 */
public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    private final AddressCGVisitor addressCGVisitor;
    private final ValueCGVisitor valueCGVisitor;


    public ExecuteCGVisitor(CodeGenerator cg, AddressCGVisitor addressCGVisitor, ValueCGVisitor valueCGVisitor) {
        super(cg);
        this.addressCGVisitor = addressCGVisitor;
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Program program, Void param) {
        cg.callMain();
        cg.comment("Global variables:");
        program.getDefinitions().forEach(definition -> definition.accept(this, null));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        cg.line(functionDefinition.getLine());

        cg.label(functionDefinition.getName());
        functionDefinition.getType().accept(this, null);
        if(!functionDefinition.getVariableDefinitions().isEmpty()){
            cg.comment("Local variables:");
        }
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, null));

        cg.enter(functionDefinition.getVariableDefinitions());
        functionDefinition.getStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, null);
        });
        cg.ret(functionDefinition);
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        if(!functionType.getParameters().isEmpty()){
            cg.comment("Parameters:");
        }
        functionType.getParameters().forEach(parameter -> parameter.accept(this, null));
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        cg.comment(variableDefinition.toString());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        cg.comment(assignment.toString());
        assignment.getExpression1().accept(addressCGVisitor, null);
        assignment.getExpression2().accept(valueCGVisitor, null);
        cg.store(assignment.getExpression1().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        cg.comment(read.toString());
        read.getExpression().accept(addressCGVisitor, null);
        cg.read(read.getExpression().getType().suffix());
        cg.store(read.getExpression().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Write write, Void param) {
        cg.comment(write.toString());
        write.getExpression().accept(valueCGVisitor, null);
        cg.write(write.getExpression().getType().suffix());
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void param) {
        String elseLabel = cg.nextLabel(),
                exitLabel = cg.nextLabel();

        ifElse.getCondition().accept(valueCGVisitor, null);
        cg.jump("jz", elseLabel);

        ifElse.getIfStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, null);
        });
        cg.jump("jmp", exitLabel);

        cg.label(elseLabel);
        ifElse.getElseStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, null);
        });

        cg.label(exitLabel);
        return null;
    }

    @Override
    public Void visit(While whileS, Void param) {
        String condLabel = cg.nextLabel(),
                exitLabel = cg.nextLabel();

        cg.label(condLabel);
        whileS.getCondition().accept(valueCGVisitor, null);
        cg.jump("jz", exitLabel);
        whileS.getWhileStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, null);
        });
        cg.jump("jmp", condLabel);
        cg.label(exitLabel);

        return null;
    }
}
