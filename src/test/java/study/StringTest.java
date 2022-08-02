package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split1() {
        String[] arr = "1,2".split(",");
        assertThat(arr).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] arr = "1".split(",");
        assertThat(arr).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        actual = "(1,2)".substring(1, actual.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스 에러 테스트")
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
        try {
            actual.charAt(3);
        } catch(StringIndexOutOfBoundsException e) {
            assertThat(e).hasMessage("String index out of range: 3");
        }
    }
}
