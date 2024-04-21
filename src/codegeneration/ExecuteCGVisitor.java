package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;
import ast.types.FunctionType;

import java.io.IOException;

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
 * execute[[VariableDefinition: definition -> type ID]] =
 *  <'*> definition.type.toString()
 *
 * execute[[FunctionDefinition: definition -> type ID varDefinition* statement*]] =
 *  ID<:>
 *  execute[[type]]
 *  varDefinition*.forEach(varDefinition -> execute[[varDefinition]])
 *  <enter> -varDefinition*.get( varDefinition*.size()-1 ).offset
 *  statement*.forEach(stmt -> execute[[stmt]])
 *
 *  execute[[FunctionType: type1 -> type2 varDefinition*]] =
 *   varDefinition*.forEach(varDefinition -> execute[[varDefinition]])
 *
 * execute[[Program: program -> definition*]] =
 *  definition*.forEach(def -> execute[[def]])
 *
 */
public class ExecuteCGVisitor extends AbstractCGVisitor {

    private final AddressCGVisitor addressCGVisitor;
    private final ValueCGVisitor valueCGVisitor;


    public ExecuteCGVisitor(CodeGenerator codeGenerator, AddressCGVisitor addressCGVisitor, ValueCGVisitor valueCGVisitor) throws IOException {
        super(codeGenerator);
        this.addressCGVisitor = addressCGVisitor;
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Program program, Void param) {
        codeGenerator.callMain();
        codeGenerator.comment("Global variables:");
        program.getDefinitions().forEach(definition -> definition.accept(this, null));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        codeGenerator.line(functionDefinition.getLine());
        codeGenerator.functionName(functionDefinition.getName());
        functionDefinition.getType().accept(this, null);
        codeGenerator.comment("Local variables:");
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, null));
        codeGenerator.enter(functionDefinition.getVariableDefinitions());
        functionDefinition.getStatements().forEach(stmt -> {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, null);
        });
        codeGenerator.ret(functionDefinition);
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        if(!functionType.getParameters().isEmpty()){
            codeGenerator.comment("Parameters:");
        }
        functionType.getParameters().forEach(parameter -> parameter.accept(this, null));
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        codeGenerator.comment(variableDefinition.toString());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        codeGenerator.comment(assignment.toString());
        assignment.getExpression1().accept(addressCGVisitor, null);
        assignment.getExpression2().accept(valueCGVisitor, null);
        codeGenerator.store(assignment.getExpression1().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        codeGenerator.comment(read.toString());
        read.getExpression().accept(addressCGVisitor, null);
        codeGenerator.read(read.getExpression().getType().suffix());
        codeGenerator.store(read.getExpression().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Write write, Void param) {
        codeGenerator.comment(write.toString());
        write.getExpression().accept(valueCGVisitor, null);
        codeGenerator.write(write.getExpression().getType().suffix());
        return null;
    }
}
