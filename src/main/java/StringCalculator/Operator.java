package StringCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (a, b) -> a + b),
  MINUS("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> a / b);

  private String symbol;
  private BiFunction<Integer, Integer, Integer> expression;

  Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
    this.symbol = symbol;
    this.expression = expression;
  }

  public static int calculate(String symbol, int num1, int num2) {
    return Arrays.stream(values())
            .filter(w -> w.symbol.equals(symbol))
            .findAny()
            .orElseThrow(IllegalArgumentException::new)
            .expression.apply(num1, num2);
  }
}
