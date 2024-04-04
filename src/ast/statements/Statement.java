package ast.statements;

import ast.ASTNode;
import ast.types.Type;

public interface Statement extends ASTNode {
    Type getReturnType();
    void setReturnType(Type type);
}
