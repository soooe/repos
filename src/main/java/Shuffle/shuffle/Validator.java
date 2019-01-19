package Shuffle.shuffle;

/**
 * ユーザー入力値のバリデーションを行うクラス。
 */
public class Validator {

    public static final String ERROR_INPUT_NULL = "エラー!入力がnullです";
    public static final String ERROR_EMPTY_STRING = "エラー!入力が空文字列です";
    public static final String ERROR_INPUT_SIZE_OVER = "エラー!入力文字数がオーバーしています。最大文字数:";
    public static final String ERROR_ILLEGAL_CHARACTERS = "エラー!入力に半角英数字以外の文字が含まれています";

    private long maxInputSize;

    /**
     * @param maxInputSize : 最大何文字までの入力を許可するか
     */
    public Validator(final long maxInputSize) {
        this.maxInputSize = maxInputSize;
    }

    /**
     * ユーザー入力値に対してバリデーションを行う。
     *
     * @param inputStr : ユーザー入力の文字列
     * @throws IllegalArgumentException : バリデーション失敗時
     */
    public void validate(String inputStr) throws IllegalArgumentException {
        if (inputStr == null) {
            fail(ERROR_INPUT_NULL);
        }
        if (inputStr.isEmpty()) {
            fail(ERROR_EMPTY_STRING);
        }
        if (maxInputSize < inputStr.length()) {
            fail(ERROR_INPUT_SIZE_OVER + maxInputSize);
        }
        if (!(inputStr.matches("[0-9a-zA-Z]+"))) {
            fail(ERROR_ILLEGAL_CHARACTERS);
        }
    }

    private void fail(final String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }
}
