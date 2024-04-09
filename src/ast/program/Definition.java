package ast.program;

import ast.ASTNode;
import ast.types.Type;

public interface Definition extends ASTNode {

    String getName();
    Type getType();

    int getScope();

    void setScope(int scope);

    int getOffset();

    void setOffset(int offset);
}
