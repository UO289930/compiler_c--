package parser;

import ast.expressions.*;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.statements.For;
import ast.statements.Read;
import ast.statements.Statement;
import ast.statements.Write;
import ast.types.*;
import dto.FunctionBody;

import javax.swing.plaf.nimbus.State;
import java.util.*;

public class ParserHelper {

    public static For createFor(int line,
                                int column,
                                List<Statement> initializer,
                                Expression exp,
                                List<Statement> incremental,
                                List<Statement> block){



    }

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
        return new FunctionDefinition(line, column, type, name, body.getVariableDefinitions(), body.getStatements());
    }

    public static Expression createArithmeticOrReminder(int line,
                                                        int column,
                                                        String operator,
                                                        Expression operand1,
                                                        Expression operand2){

        if(operator.contentEquals("%")){
            return new Reminder(line, column, operand1, operand2);
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


    public static ArrayType createArrayType(int line, int column, Type previousType, int size){
        if(!(previousType instanceof ArrayType currentType)){

            return new ArrayType(line, column, previousType, size);
        }

        while(currentType.getElementType() instanceof ArrayType){
            currentType = (ArrayType) currentType.getElementType();
        }

        ArrayType newArrayType = new ArrayType(line, column, currentType.getElementType(), size);
        currentType.setElementType(newArrayType);

        return (ArrayType) previousType;
    }

    public static StructType createStructType(int line, int column, List<StructField> fields){

        Map<String, StructField> structFields = new HashMap<>();

        for (StructField field: fields){
            if(structFields.containsKey(field.getFieldName())){
                new ErrorType(field.getLine(), field.getColumn(), "Field '" + field.getFieldName() + "' cannot be duplicated");
            } else{
                structFields.put(field.getFieldName(), field);
            }
        }

        return new StructType(line, column, fields);

    }

    public static List<Write> createWriteStatements(int line,
                                             int column,
                                             List<Expression> expressions){

        List<Write> writeStatements = new ArrayList<>();
        expressions.forEach(e ->  writeStatements.add(new Write(line, column, e)));
        return writeStatements;
    }

    public static List<Read> createReadStatements(int line,
                                             int column,
                                             List<Expression> expressions){

        List<Read> readStatements = new ArrayList<>();
        expressions.forEach(e ->  readStatements.add(new Read(line, column, e)));
        return readStatements;
    }


}
