package ast.expressions;

public class CharLiteral extends AbstractLiteralExpression<Character>{

    public CharLiteral(int line, int column, char value) {
        super(line, column, value);
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                super.toString() +
                "}";
    }
}
