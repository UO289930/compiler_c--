package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    Type arithmetic(int line, int column, Type type);
    Type reminder(int line, int column, Type type);
    Type logical(int line, int column, Type type);
    Type unaryNot(int line, int column);
    Type comparison(int line, int column, Type type);
    Type unaryMinus(int line, int column);
    Type castTo(int line, int column, Type type);
    Type squareBrackets(int line, int column, Type type);
    Type dot(int line, int column, String fieldName);
    Type parenthesis(int line, int column, List<Type> types);
    void mustBeAssignableTo(int line, int column, Type type1);
    void mustBeBoolean(int line, int column);
    void mustBeReturnedAs(int line, int column, Type type);
    int numberOfBytes();
}
