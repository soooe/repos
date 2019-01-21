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
public class TestControlStringShuffleString 
    extends TestCase
{	
	/** テスト対象クラスのオブジェクト */
	private ControlString testCS;	
	
	/** シャッフル結果格納用リスト */
	List<String> retList;
    
    public TestControlStringShuffleString( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestControlStringShuffleString.class );
    }
    
    protected void setUp() {
    	testCS = new ControlString();
    }
    
    /**
     * 引数が空文字のとき
     */
    public void testEmptyString() {
    	retList = testCS.shuffleString("");
    	assertThat(
				retList, 
				is(containsInAnyOrder("")));
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
   
    
}
