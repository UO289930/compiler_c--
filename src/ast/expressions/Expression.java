package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    boolean isLvalue();
    void setLvalue(boolean lvalue);
    void setType(Type type);
    Type getType();

}
