package Shuffle.shuffle;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestValidator {

    final static private long MAX_INPUT_SIZE = 1;
    final private Validator sut = new Validator(MAX_INPUT_SIZE);

    /**
     * 引数がnullのとき
     */
    @Test(expected = IllegalArgumentException.class)
    public void inputIsNull() {
        sut.validate(null);
    }

    /**
     * 引数に半角英数字以外の文字が含まれるとき
     */
    @Test(expected = IllegalArgumentException.class)
    public void inputIsIllegalCharacters() {
        sut.validate("~");
    }

    /**
     * 引数が空文字のとき
     */
    @Test(expected = IllegalArgumentException.class)
    public void inputIsEmptyString() {
        sut.validate("");
    }

    /**
     * 引数が入力最大文字数を超えるとき
     */
    @Test(expected = IllegalArgumentException.class)
    public void inputExceedsMaxInputSize() {
        sut.validate("aa");
    }
}
