package ast.errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler handler = null;

    private final List<ErrorType> errors = new ArrayList<>();

    private ErrorHandler(){}

    public static ErrorHandler getInstance(){
        if(handler==null){
            handler = new ErrorHandler();
        }

        return handler;
    }

    public boolean anyErrors(){
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream out){
        errors.forEach(out::println);
    }

    public void addError(ErrorType error){
        errors.add(error);
    }
}
