package ast.types;

import ast.AbstractASTNode;

public class CharType extends AbstractASTNode implements Type {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "CharType{" +
                super.toString() +
                "}";
    }
}
