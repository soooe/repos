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
public class AppTest 
    extends TestCase
{	
	private ControlString testCS;	//!<テスト対象クラスのオブジェクト
    
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    protected void setUp() {
    	testCS = new ControlString();
    }

    /**
     * 文字列シャッフルの入力文字列を変化させてテストする
     */
    public void testApp()
    {
    	/* 引数がnullのとき */
    	
    	List<String> retList = testCS.shuffleString(null);
    	assertTrue(retList.isEmpty());
    	
    	/* 引数が空文字列のとき */
    	
    	retList = testCS.shuffleString("");
    	assertTrue(retList.isEmpty());
    	
    	/* 引数に半角英数字以外の文字が含まれるとき */
    	
    	retList = testCS.shuffleString("aあ");
    	assertTrue(retList.isEmpty());
    	
    	/* 引数が1文字のとき */
    	
    	retList = testCS.shuffleString("a");
    	assertThat(
				retList, 
				is(containsInAnyOrder("a")));
    	
    	/* 同一の文字が複数個含まれるとき */
    	
    	retList = testCS.shuffleString("a11");
    	assertThat(
				retList, 
				is(containsInAnyOrder("a11", "11a", "1a1")));
    	
    	/* 引数の文字数が最大値(10)のとき */
    	
    	String inputStr = new String("");
    	char addChar = 'a';
    	int listNum = 1;
    	for (int i = 0; i < ControlString.MAX_INPUT_SIZE; i++) {
    		inputStr += String.valueOf(addChar);
    		addChar += 1;
    		listNum = listNum * (i + 1);
    	}
    	retList = testCS.shuffleString(inputStr);
    	assertEquals(listNum, retList.size());						
    	
    	/* 引数の文字数が最大値 + 1のとき */
    	
    	inputStr += String.valueOf(addChar);
    	retList = testCS.shuffleString(inputStr);
    	assertTrue(retList.isEmpty());
    	
    	
    }
}
