package Shuffle.shuffle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestValidator {

    final static private long MAX_INPUT_SIZE = 1;
    final private Validator sut = new Validator(MAX_INPUT_SIZE);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * 引数がnullのとき
     */
    @Test
    public void inputIsNull() {
        thrown.expectMessage(Validator.ERROR_INPUT_NULL);
        sut.validate(null);
    }

    /**
     * 引数に半角英数字以外の文字が含まれるとき
     */
    @Test
    public void inputIsIllegalCharacters() {
        thrown.expectMessage(Validator.ERROR_ILLEGAL_CHARACTERS);
        sut.validate("~");
    }

    /**
     * 引数が空文字のとき
     */
    @Test
    public void inputIsEmptyString() {
        thrown.expectMessage(Validator.ERROR_EMPTY_STRING);
        sut.validate("");
    }

    /**
     * 引数が入力最大文字数を超えるとき
     */
    @Test
    public void inputExceedsMaxInputSize() {
        thrown.expectMessage(Validator.ERROR_INPUT_SIZE_OVER + MAX_INPUT_SIZE);
        sut.validate("aa");
    }
}
