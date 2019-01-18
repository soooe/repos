package Shuffle.shuffle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * リスト表示機能の単体テストクラス
*/
public class TestCharacterEnumeratorShowList
    extends TestCase{
	
	private static final String TEST_STRING = "Hello";
	
	/** テスト対象クラスのオブジェクト */
	private CharacterEnumerator testCS;
	
	/** showListメソッドに渡すリスト */
	private List<String> list;	
	
	/** 標準出力チェック用ストリーム */
	ByteArrayOutputStream out;
	
	/** 正しい出力内容 */
	String expected;
    
    public TestCharacterEnumeratorShowList(String testName ){
        super( testName );
    }

    public static Test suite(){
        return new TestSuite( TestCharacterEnumeratorShowList.class );
    }
    
    protected void setUp() {
    	testCS = new CharacterEnumerator();
    	list = new ArrayList<>();
    	out = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(out));
    	expected = "";
    }
    
    /**
     * リストがnullのとき
     */
    public void testNullList() {
    	assertEquals(false, testCS.showList(null));
    }
    
    /**
     * 空リストのとき
     */
    public void testEmptyList(){
    	assertEquals(true, testCS.showList(list));
    	assertThat(out.toString(), is(""));
    }
    
    /**
     * リスト数 : 1のとき
     */
    public void testOneList(){
    	
    	list.add(TEST_STRING);
    	assertEquals(true, testCS.showList(list));
    	assertThat(out.toString(), is(TEST_STRING + System.lineSeparator()));
    	
    }
    
    /**
     * リスト数 : 入力文字数最大値から規定される表示リスト数最大値のとき
     */
    public void testMaxList(){
    	
    	/* 入力文字数がxのときの表示リスト数はMAX! (MAXの階乗)*/
    	
    	int listNum = Constants.factorial(CharacterEnumerator.MAX_INPUT_SIZE);
    	
    	for (int i = 0; i < listNum; i++) {
    		list.add(TEST_STRING);
    		expected += TEST_STRING + System.lineSeparator();
    	}
    	assertEquals(true, testCS.showList(list));
    	assertThat(out.toString(), is(expected));
    	
    }
    
    /**
     * リスト数 : 入力文字数最大値から規定される表示リスト数最大値 + 1のとき
     */
    public void testOverMaxList(){
    	
    	/* リスト表示メソッドshowListに表示上限はないので、正常に表示される */
    	
    	int listNum = Constants.factorial(CharacterEnumerator.MAX_INPUT_SIZE) + 1;
    	for (int i = 0; i < listNum; i++) {
    		list.add(TEST_STRING);
    		expected += TEST_STRING + System.lineSeparator();
    	}
    	assertEquals(true, testCS.showList(list));
    	assertThat(out.toString(), is(expected));
    	
    }
    
    /**
     * 表示文字列種別のテスト
     */
    public void testStringKind() {
    	
    	/* 空文字列のとき */
    	
    	list.add("");
    	
    	/* 1文字のとき */
    	
    	list.add("a");
    	
    	/* 入力文字数最大値のとき(abcde...の繰り返しをMAX_INPUT_SIZE文字) */
    	
    	list.add(Constants.MakeABCString(CharacterEnumerator.MAX_INPUT_SIZE));
    	
    	/* 入力文字数最大値 + 1のとき(abcde...の繰り返しを(MAX_INPUT_SIZE + 1)文字) */
    	
    	list.add(Constants.MakeABCString(CharacterEnumerator.MAX_INPUT_SIZE));
    	
    	/* 半角英数字以外の文字が含まれるとき */
    	
    	list.add("aあ");
    	
    	for (int i = 0; i < list.size(); i++) {
    		expected += list.get(i) + System.lineSeparator();
    	}
    	
    	assertEquals(true, testCS.showList(list));
    	assertThat(out.toString(), is(expected));
    	
    }
    
}
    
