package ast;

public class AbstractASTNode implements ASTNode{

    private final int line;
    private final int column;

    public AbstractASTNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "line=" + line +
                ", column=" + column ;
    }
}
