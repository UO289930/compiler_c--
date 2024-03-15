package ast.expressions;

import ast.ASTNode;

public interface Expression extends ASTNode {

    boolean isLvalue();
    void setLvalue(boolean lvalue);

}
