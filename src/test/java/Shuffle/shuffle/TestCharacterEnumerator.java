package Shuffle.shuffle;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 文字列シャッフル機能の単体テストクラス
*/
public class TestCharacterEnumerator
    extends TestCase
{	
	/** テスト対象クラスのオブジェクト */
	private CharacterEnumerator testCS;
	
	/** シャッフル結果格納用リスト */
	List<String> retList;
    
    public TestCharacterEnumerator(String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestCharacterEnumerator.class );
    }
    
    protected void setUp() {
    	testCS = new CharacterEnumerator();
    }
    
    /**
     * 引数がnullのとき
     */
    public void testNullString() {
    	retList = testCS.shuffleString(null);
    	assertTrue(retList.isEmpty());
    }
    
    /**
     * 引数に半角英数字以外の文字が含まれるとき
     */
    public void testStringKind() {
    	retList = testCS.shuffleString("aあ");
    	assertTrue(retList.isEmpty());
    }
    
    /**
     * 引数が空文字のとき
     */
    public void testEmptyString() {
    	retList = testCS.shuffleString("");
    	assertTrue(retList.isEmpty());
    }
    
    /**
     * 引数が1文字のとき
     */
    public void testString1() {
    	retList = testCS.shuffleString("a");
    	assertThat(
				retList, 
				is(containsInAnyOrder("a")));
    }
    
    /**
     * 引数が2文字のとき
     */
    public void testString2() {
    	
    	/* 同一の文字のとき */
    	
    	retList = testCS.shuffleString("aa");
    	assertThat(
				retList, 
				is(containsInAnyOrder("aa")));
    	
    	/* 異なる文字のとき */
    	
    	retList = testCS.shuffleString("ab");
    	assertThat(
				retList, 
				is(containsInAnyOrder("ab", "ba")));
    	
    }
    
    /**
     * 引数が3文字のとき
     */
    public void testString3() {
    	
    	/* 全て同一の文字のとき */
    	
    	retList = testCS.shuffleString("aaa");
    	assertThat(
				retList, 
				is(containsInAnyOrder("aaa")));
    	
    	/* 異なる文字を1つだけ含むとき */
    	
    	retList = testCS.shuffleString("aab");
    	assertThat(
				retList, 
				is(containsInAnyOrder("aab", "aba", "baa")));
    	
    	/* 全て異なる文字のとき */
    	
    	retList = testCS.shuffleString("abc");
    	assertThat(
				retList, 
				is(containsInAnyOrder("abc", "acb", "bac", "bca", "cab", "cba")));
    }
   
    /**
     * 引数の文字数が最大値のとき
     */
    public void testStringMax() {
    	
    	/* 
    	 * abc...zの繰り返し文字列を作成(文字数 : MAX_INPUT_SIZE) 
    	 * MAX_INPUT_SIZE = 10なので、同一の文字は含まれない
    	 * */
    	
    	String inputStr = Constants.MakeABCString(CharacterEnumerator.MAX_INPUT_SIZE);
    	retList = testCS.shuffleString(inputStr);
    	
    	/* 同一の文字は含まれないので、リストサイズ = 文字数の階乗 */
    	
    	assertEquals(
    			Constants.factorial(CharacterEnumerator.MAX_INPUT_SIZE),
    			retList.size());	
    }
    
    /**
     * 引数の文字数が最大値 + 1のとき
     */
    public void testStringOverMax() {
    	
    	String inputStr = Constants.MakeABCString(CharacterEnumerator.MAX_INPUT_SIZE + 1);
    	retList = testCS.shuffleString(inputStr);
    	
    	/* 許容される文字数最大値を超えるので、空リストが返る */
    	
    	assertTrue(retList.isEmpty());
    	
    }  
    
}
