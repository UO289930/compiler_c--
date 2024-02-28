package ast.expressions;

public class RealLiteral extends AbstractLiteralExpression<Double>{

    public RealLiteral(int line, int column, double value) {
        super(line, column, value);
    }

    @Override
    public String toString() {
        return "RealLiteral{" +
                super.toString() +
                "}";
    }
}
