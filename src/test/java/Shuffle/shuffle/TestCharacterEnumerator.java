package Shuffle.shuffle;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TestCharacterEnumerator {

    /**
     * 入出力値を検証しアサーションを行う。
     *
     * @param expected : 期待されるenumerateCombinationの出力
     * @param input    : enumerateCombinationへの入力
     */
    private void check(final List<String> expected, final String input) {
        assertThat(expected, is(equalTo(CharacterEnumerator.enumerateCombination(input))));
    }

    /**
     * nの階乗を計算する
     */
    private static int factorial(final int n) {
        return IntStream.range(1, n + 1).reduce((memo, next) -> next * memo).orElse(1);
    }

    @Test
    public void inputIsEmptyString() {
        check(Arrays.asList(""), "");
    }

    @Test
    public void inputHasSingleCharacter() {
        check(Arrays.asList("a"), "a");
    }

    @Test
    public void inputHasTwoDifferentCharacter() {
        check(Arrays.asList("ab", "ba"), "ab");
    }

    @Test
    public void inputHasTwoSameCharacter() {
        check(Arrays.asList("aa", "aa"), "aa");
    }

    @Test
    public void sizeOfOutputListIsFactorialOfNumberOfInputCharacters() {
        final String inputString = "12345";
        assertThat(
                factorial(inputString.length()),
                is(
                        equalTo(
                                CharacterEnumerator.enumerateCombination(inputString).size()
                        )
                )
        );
    }
}
