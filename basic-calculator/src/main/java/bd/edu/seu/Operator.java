package bd.edu.seu;

import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("x", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    Operator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double operate(double a, double b) {
        double result = operation.apply(a, b);
        return result;
    }

    public String getSymbol() {
        return symbol;
    }

    private String symbol;
    private BiFunction<Double, Double, Double> operation;
}
