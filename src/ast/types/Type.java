package ast.types;

import ast.ASTNode;

public interface Type extends ASTNode {

    public boolean isBuiltin();

    public boolean isStruct();

}
