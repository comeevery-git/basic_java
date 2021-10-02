package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1:\n" +
            "Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void requireFunc1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints={1, 2, 3})
    @DisplayName("요구사항 2:\n" +
            "Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.\n" +
            "구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.\n" +
            "JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
//    @Test
//    void contains() {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
//    }
    void requireFunc2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "true:false", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3:\n" +
            "요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.\n" +
            "입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현한다.\n" +
            "예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true,\n" +
            "4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.")
    void requireFunc3(String input, boolean result){
        String regex = "^[1-3]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(input);
        if(m.find()) {
            assertEquals(numbers.contains(Integer.parseInt(input)), result);
        }
    }

}
