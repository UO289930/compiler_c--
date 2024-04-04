package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    Type arithmetic(Type type);
    Type reminder(Type type);
    Type logical(Type type);
    Type unaryNot();
    Type comparison(Type type);
    Type unaryMinus();
    Type castTo(Type type);
    Type squareBrackets(Type type);
    Type dot(String fieldName);
    Type parenthesis(List<Type> types);
    void mustBeAssignableTo(Type type1);
    void mustBeBoolean();
    void mustBeReturnedAs(Type type);
}
