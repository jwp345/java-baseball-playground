package study;

import StringCalculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
  @ParameterizedTest
  @DisplayName("문자열 계산기 테스트")
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  void operator(String input) {
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);

    String[] tokens = scanner.nextLine().split(" ");

    int sum = Integer.parseInt(tokens[0]);
    for(int idx = 1; idx < tokens.length; idx++) {
      if(tokens[idx].equals("+") || tokens[idx].equals("-") || tokens[idx].equals("*") || tokens[idx].equals("/")) {
        sum = Operator.calculate(tokens[idx], sum, Integer.parseInt(tokens[idx + 1]));
      }
    }
    assertThat(sum).isEqualTo(10);
  }
}
