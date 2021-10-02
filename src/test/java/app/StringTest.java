package app;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @BeforeAll
    @Disabled
    static void beforeAllFunc(){
        System.out.println("###TEST START");
    }

    @AfterAll
    @Disabled
    static void afterAllFunc(){
        System.out.println("###TEST END");
    }

    @BeforeEach
    void beforeEachFunc(){
        System.out.println("###CASE START");
    }

    @AfterEach
    void afterFunc(){
        System.out.println("###NEXT CASE");
    }

    /*
    요구사항 1
        1-1.
            "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        1-2.
            "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void requireFunc1(){
        String[] data = "1,2".split(",");
        // 순서, 중복 무시 & 원소값, 개수 검증
        assertThat(data).contains("2","1");
        // 순서 포함 검증
        assertThat(data).containsExactly("1", "2");

        data = "1".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1");
    }

    /*
    요구사항 2
        "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void requireFunc2(){
        String data[] = {"(1,2)"};
        data[0] = data[0].substring(1, data[0].length()-1);
        assertThat(data).containsExactly("1,2");
    }

    /*
    요구사항 3
        3-1.
            "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.
        3-2.
            String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
            StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        3-3.
            JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("특정 위치 문자 가져오기 & 예외처리 검증")
    void requireFunc3(){
        String data = "abc";
        int index = 3;
        assertThatThrownBy(() -> data.charAt(index))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("위치값이 벗어났습니다. (%d)", index);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> data.charAt(index))
            .withMessage("위치값이 벗어났습니다. (%d)", index);

    }


}
