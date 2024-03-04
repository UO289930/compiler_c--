package parser;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.statements.Statement;
import ast.types.ArrayType;
import ast.types.FunctionType;
import ast.types.Type;
import ast.types.VoidType;
import dto.FunctionBody;
import org.antlr.v4.codegen.model.ArgAction;

import java.sql.Array;
import java.util.*;

public class ParserHelper {

    private static LinkedList<Integer> arrayTypeSizes = new LinkedList<>();

    public static VariableDefinition createVarDef(int line,
                                                  int column,
                                                  Type type,
                                                  String name){

        return new VariableDefinition(line, column, type, name);
    }

    public static FunctionDefinition createFuncDef(int line,
                                                              int column,
                                                              Type returnType,
                                                              String name,
                                                              List<VariableDefinition> params,
                                                              FunctionBody body){

        returnType = returnType!=null ? returnType : new VoidType(line, column);

        FunctionType type = new FunctionType(line, column, returnType, params);
        return new FunctionDefinition(line, column, type, name, body);
    }

    public static Expression createArithmeticOrReminder(int line,
                                                        int column,
                                                        String operator,
                                                        Expression operand1,
                                                        Expression operand2){

        if(operator.contentEquals("%")){
            return new Reminder(line, column, operator, operand1, operand2);
        }

        return new Arithmetic(line, column, operator, operand1, operand2);
    }

    public static FunctionInvocation createFuncInvoc(int line,
                                                     int column,
                                                     String name,
                                                     List<Expression> arguments){

        Variable var = new Variable(line, column, name);
        return new FunctionInvocation(line, column, var, arguments);
    }

    public static Type processArrayType(int line,
                                         int column,
                                         Type type,
                                         int size) {

        return new ArrayType(line, column, type, type.passSizeDown(size));
    }


}
