package Shuffle.shuffle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ユーザ入力バリデーションの単体テストクラス
 */
public class TestValidator {
	
	/** 入力文字数最大値 */
	final static private int MAX_INPUT_SIZE = 1;
	
	/** テスト対象クラスのオブジェクト */
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
	 * 引数が空文字のとき
	 */
	@Test
	public void inputIsEmptyString() {
		thrown.expectMessage(Validator.ERROR_INPUT_EMPTY);
		sut.validate("");
	}
	
	/**
	 * 引数が最大入力文字を超えているとき
	 */
	@Test
	public void inputIsSizeOver() {
		thrown.expectMessage(Validator.ERROR_INPUT_SIZE_OVER + MAX_INPUT_SIZE);
		sut.validate("aa");
	}
	
	/**
	 * 引数に半角英数字以外の文字が含まれるとき
	 */
	@Test
	public void inputIsIllegalCharacters() {
		thrown.expectMessage(Validator.ERROR_ILLEGAL_CHARACTERS);
		sut.validate("~");
	}
}
