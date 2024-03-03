package ast.types;

import ast.ASTNode;

public interface Type extends ASTNode {

    int passSizeDown(int size);
}
