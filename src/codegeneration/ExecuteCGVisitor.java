package codegeneration;

import ast.expressions.Expression;
import ast.expressions.FunctionInvocation;
import ast.program.Definition;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;
import dto.StackMemoryState;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * execute[[Read: statement -> expression]](int bytesRet, int bytesLocals, int bytesArgs) =
 * 	address[[expression]]
 * 	<in> expression.type.suffix()
 * 	<store> expression.type.suffix()
 *
 * execute[[Write: statement -> expression]](int bytesRet, int bytesLocals, int bytesArgs) =
 * 	value[[expression]]
 * 	<out> expression.type.suffix()
 *
 * execute[[Assignment: statement -> expression1 expression2]](int bytesRet, int bytesLocals, int bytesArgs) =
 * 	address[[expression1]]
 * 	value[[expression2]]
 * 	<store> expression1.type.suffix()
 *
 * 	execute[[While: statement -> expression statement*]](int bytesRet, int bytesLocals, int bytesArgs) =
 * 	    String condLabel = cg.nextLabel(),
 * 	           exitLabel = cg.nextLabel();
 * 	    condLabel<:>
 * 	    value[[expression]]
 * 	    <jz > exitLabel
 * 	    statement*.forEach(stmt -> execute[[stmt]](bytesReturn, bytesLocals, bytesArgs))
 * 	    <jmp > condLabel
 * 	    exitLabel<:>
 *
 * 	execute[[IfElse: statement -> expression statement1* statement2*]](int bytesRet, int bytesLocals, int bytesArgs) =
 *      String elseLabel = cg.nextLabel(),
 *             exitLabel = cg.nextLabel();
 *      value[[expression]]
 *      <jz > elseLabel
 *      statement1*.forEach(stmt -> execute[[stmt]](bytesReturn, bytesLocals, bytesArgs))
 *      <jmp > exitLabel
 *      elseLabel<:>
 *      statement2*.forEach(stmt -> execute[[stmt]](bytesReturn, bytesLocals, bytesArgs))
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
 *  statement*.forEach(stmt -> execute[[stmt]](bytesReturn, bytesLocals, bytesArgs))
 *  if(type.returnType instanceof VoidType){
 *      <ret > type.returnType.numberOfBytes() <, > type.varDefinition*.size() == 0 ? 0 : -type.varDefinition*.get(type.parameters.size()-1).offset <,> type.parameters.size()==0 ? 0 : type.parameters.get(1).offset - 4 + type.parameters.get(1).type.numberOfBytes()
 *  }
 *
 *
 *  execute[[FunctionType: type1 -> type2 varDefinition*]] =
 *   varDefinition*.forEach(varDefinition -> execute[[varDefinition]])
 *
 * execute[[Program: program -> definition*]] =
 *  definition*.forEach(def -> execute[[def]])
 *
 * execute[[Return: statement -> exp]](int bytesRet, int bytesLocals, int bytesArgs) =
 *  value[[exp]]
 *  <ret > bytesRet <, > bytesLocals <, > bytesArgs
 *
 * execute[[FunctionInvocation: statement -> expression expression*]](int bytesRet, int bytesLocals, int bytesArgs) =
 *  expression*.forEach(exp -> value[[exp]])
 *  <call > expression.name
 *  if(!expression.definition.type.returnType instanceof VoidType){
 *      <pop> expression.definition.type.returnType.suffix()
 *  }
 *
 */
public class ExecuteCGVisitor extends AbstractCGVisitor<StackMemoryState, Void> {

    private final AddressCGVisitor addressCGVisitor;
    private final ValueCGVisitor valueCGVisitor;


    public ExecuteCGVisitor(CodeGenerator cg, AddressCGVisitor addressCGVisitor, ValueCGVisitor valueCGVisitor) {
        super(cg);
        this.addressCGVisitor = addressCGVisitor;
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Program program, StackMemoryState param) {
        cg.callMain();
        cg.comment("Global variables:");
        List<Definition> noVarDefinitions = new ArrayList<>();
        program.getDefinitions().forEach(definition -> {
            if(definition instanceof VariableDefinition){
                definition.accept(this, null);
            } else {
                noVarDefinitions.add(definition);
            }

        });
        noVarDefinitions.forEach(def -> def.accept(this, null));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, StackMemoryState param) {
        cg.line(functionDefinition.getLine());

        cg.label(functionDefinition.getName());

        functionDefinition.getType().accept(this, null);
        if(!functionDefinition.getVariableDefinitions().isEmpty()){
            cg.comment("Local variables:");
        }
        functionDefinition.getVariableDefinitions().forEach(varDef -> varDef.accept(this, null));

        cg.enter(functionDefinition.getVariableDefinitions());

        StackMemoryState state = createStackMemoryState(functionDefinition);
        functionDefinition.getStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, state);
        });

        if(state.bytesReturn()==0){
            cg.ret(state);
        }

        return null;
    }

    private StackMemoryState createStackMemoryState(FunctionDefinition functionDefinition) {
        FunctionType funcType = (FunctionType) functionDefinition.getType();

        List<VariableDefinition> params = funcType.getParameters();
        List<VariableDefinition> locals = functionDefinition.getVariableDefinitions();

        int returnedBytes = funcType.getReturnType().numberOfBytes();
        int bytesLocals = locals.isEmpty() ? 0 : -locals.get(locals.size()-1).getOffset();
        int bytesArgs = params.isEmpty() ? 0 : params.get(0).getOffset() - 4 + params.get(0).getType().numberOfBytes();

        return new StackMemoryState(returnedBytes, bytesLocals, bytesArgs);
    }

    @Override
    public Void visit(FunctionType functionType, StackMemoryState param) {
        if(!functionType.getParameters().isEmpty()){
            cg.comment("Parameters:");
        }
        functionType.getParameters().forEach(parameter -> parameter.accept(this, null));
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, StackMemoryState param) {
        cg.comment(variableDefinition.toString());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, StackMemoryState param) {
        cg.comment(assignment.toString());

        assignment.getExpression1().accept(addressCGVisitor, null);

        assignment.getExpression2().accept(valueCGVisitor, null);

        cg.store(assignment.getExpression1().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Read read, StackMemoryState param) {
        cg.comment(read.toString());

        read.getExpression().accept(addressCGVisitor, null);

        cg.read(read.getExpression().getType().suffix());

        cg.store(read.getExpression().getType().suffix());
        return null;
    }

    @Override
    public Void visit(Write write, StackMemoryState param) {
        cg.comment(write.toString());

        write.getExpression().accept(valueCGVisitor, null);

        cg.write(write.getExpression().getType().suffix());
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, StackMemoryState state) {

        cg.comment(ifElse.toString());

        String elseLabel = cg.nextLabel(),
                exitLabel = cg.nextLabel();

        ifElse.getCondition().accept(valueCGVisitor, null);
        cg.jump("jz", elseLabel);

        ifElse.getIfStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, state);
        });
        cg.jump("jmp", exitLabel);

        cg.label(elseLabel);
        ifElse.getElseStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, state);
        });

        cg.label(exitLabel);
        return null;
    }

    @Override
    public Void visit(While whileS, StackMemoryState state) {
        cg.comment(whileS.toString());

        String condLabel = cg.nextLabel(),
                exitLabel = cg.nextLabel();

        cg.label(condLabel);
        whileS.getCondition().accept(valueCGVisitor, null);
        cg.jump("jz", exitLabel);

        whileS.getWhileStatements().forEach(stmt -> {
            cg.line(stmt.getLine());
            stmt.accept(this, state);
        });

        cg.jump("jmp", condLabel);

        cg.label(exitLabel);

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, StackMemoryState param) {

        cg.comment(functionInvocation.toString());

        functionInvocation.getArguments().forEach(arg -> arg.accept(valueCGVisitor, null));
        cg.call(functionInvocation.getVariable().getName());

        FunctionType funcType = (FunctionType) functionInvocation.getVariable().getType();
        if(!(funcType.getReturnType() instanceof VoidType)){
            cg.pop(funcType.getReturnType().suffix());
        }
        return null;
    }

    @Override
    public Void visit(Return returnS, StackMemoryState state) {

        cg.comment(returnS.toString());

        returnS.getExpression().accept(valueCGVisitor, null);

        cg.ret(state);

        return null;
    }

    @Override
    public Void visit(For forS, StackMemoryState state) {

        String condLabel = cg.nextLabel(), exitLabel = cg.nextLabel();

        cg.comment(forS.toString());

        if(forS.getInitializer()!=null){
            forS.getInitializer().accept(this, state);
        }

        cg.label(condLabel);

        forS.getCondition().accept(valueCGVisitor, null);
        cg.jump("jz", exitLabel);

        forS.getForStatements().forEach(stmt -> stmt.accept(this, state));

        if(forS.getIncrement()!=null){
            forS.getIncrement().accept(this, state);
        }

        cg.jump("jmp", condLabel);

        cg.label(exitLabel);

        return null;
    }

    @Override
    public Void visit(MultipleAssignment multipleAssignment, StackMemoryState param) {

        cg.comment(multipleAssignment.toString());

        List<Expression> leftExpressions = multipleAssignment.getLeftExpressions();
        List<Expression> rightExpressions = multipleAssignment.getRightExpressions();

        if (rightExpressions.size() == 1) {

            Expression expression2 = rightExpressions.get(0);

            for (Expression expression1 : leftExpressions) {
                expression1.accept(addressCGVisitor, null);
                expression2.accept(valueCGVisitor, null);
                cg.convert(expression2.getType(), expression1.getType());
                cg.store(expression1.getType().suffix());
            }

        } else {

            for (int i = 0; i < leftExpressions.size(); i++) {
                Expression expression1 = leftExpressions.get(i);
                Expression expression2 = rightExpressions.get(i);

                expression1.accept(addressCGVisitor, null);
                expression2.accept(valueCGVisitor, null);
                cg.store(expression1.getType().suffix());
            }

        }

        return null;
    }

    @Override
    public Void visit(Switch switchS, StackMemoryState state) {
        switchS.getCases().forEach(caseX -> {

            String label = cg.nextLabel();

            switchS.getCaseExpression().accept(valueCGVisitor, null);
            caseX.getCaseElement().accept(valueCGVisitor, null);
            cg.comparison("eq", switchS.getCaseExpression().getType().suffix());
            cg.jump("jz", cg.potentialNextLabel());

            caseX.getStatements().forEach(stmt -> stmt.accept(this, state));
        });
        return null;
    }
}
