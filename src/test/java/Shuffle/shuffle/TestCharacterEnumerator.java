package Shuffle.shuffle;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

/**
 * 文字列シャッフル機能の単体テストクラス
*/
public class TestCharacterEnumerator 
{	
	/**
	 * 入出力の検証を行う
	 * @param inputStr enumerateCombinationへの入力文字列
	 * @param expected 期待される文字列パターン
	 */
	private void check(final String inputStr, final String ... expected) {
		assertThat(
				CharacterEnumerator.enumerateCombination(inputStr),
				is(containsInAnyOrder(expected)));
	}
	
	/**
	 * nの階乗を求める
	 * @param n 正の整数
	 * @return nの階乗
	 */
	private static int factorial(final int n) {
		
		if (n <= 0) {return 1;}
		
		int result = 1;
		for (int i = 0; i < n; i++) {result = result * (i + 1);}
		return result;
		
	}
	
	/**
	 * 空文字列のとき
	 */
	@Test
    public void inputIsEmptyString() {
    	check("", "");
    }
    
    /**
     * 引数が1文字のとき
     */
	@Test
    public void inputHasSingleCharacter() {
    	check("a", "a");
    }
    
    /**
     * 引数が2文字でかつ異なる文字のとき
     */
	@Test
    public void inputHasTwoDifferentCharacter() {
    	check("ab", "ab", "ba");
    }
	
	/**
	 * 引数が2文字でかつ同一の文字のとき
	 */
	@Test
	public void inputHasTwoSameCharacter() {
		check("aa", "aa");
	}
    
    /**
     * 引数が3文字のとき
     */
	@Test
    public void inputHasThreeCharacter() {
    	
    	/* 全て同一の文字のとき */
    	
    	check("aaa", "aaa");
    	
    	/* 異なる文字を1つだけ含むとき */
    	
    	check(
    			"aab", 
    			"aab", "aba", "baa");
    	
    	/* 全て異なる文字のとき */
    	
    	check(
    			"abc",
    			"abc", "acb", "bac", "bca", "cab", "cba");
    	
    }
    
    /**
     * 重複する文字を含まない文字列を入力した場合のリストの数 = 文字列の階乗
     */
	@Test
    public void sizeOfOutputList() {
    	final String inputStr = "12345";
    	List<String> retBuffer = CharacterEnumerator.enumerateCombination(inputStr);
    	assertThat(
    			factorial(inputStr.length()),
    			is(equalTo(retBuffer.size())));
    }
   
    
}
