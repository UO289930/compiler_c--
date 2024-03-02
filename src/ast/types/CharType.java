package ast.types;

import ast.AbstractASTNode;

public class CharType extends AbstractType {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
    }
}
