package Shuffle.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* 文字列のパターンを求める機能を提供するクラス
*/
public class CharacterEnumerator {
	
	/**
	 * 任意の文字列に対し、その順序を入れ替えることでできる全ての文字列パターンを列挙する<br>
	 * @param inputStr 入力文字列
	 * @return 全ての文字列パターン
	 */
	public static List<String> enumerateCombination(final String inputStr){
		
		final List<String> buffer = new ArrayList<String>();
		
		/** 入力文字列をアスキーコード順にソート（同一の文字が複数含まれる場合の対策）*/
		
		char[] inputArray = inputStr.toCharArray();
		Arrays.sort(inputArray);
		
		enumerateCombinationPart("", String.valueOf(inputArray), buffer);
		return buffer;
		
	}
	
	/**
	 * ある文字列の後半部分を入れ替えてできる全ての文字列パターンを列挙する
	 * 例  fixed : "abc", candidates : "def"　の場合、以下の文字列リストが引数bufferに追加される
	 * -"abcdef"
	 * -"abcdfe"
	 * -"abcfde"
	 * -"abcfed"
	 * -"abcedf"
	 * -"abcefd"
	 *
	 * candidatesがソートされていない状態で呼び出すと、同一の文字が複数含まれる場合に重複する文字列が出力されてしまうので注意
	 * 例　fixed : "", candidates : aba(未ソート) の場合、以下のように重複する文字列がbufferに追加されてしまう
	 * -"aba"
	 * -"aab"
	 * -"baa"
	 * -"aba" ←重複
	 * -"aab" ←重複
	 * @param fixed 先頭文字列（固定）
	 * @param candidates 入れ替え候補となる後半の文字群(ASCIIコード順にソート済み) 
	 * @param buffer 全ての文字列パターン
	 */
	private static void enumerateCombinationPart(final String fixed, final String candidates, final List<String> buffer){
		
		char previousChar = '\0';
				
		if (candidates.isEmpty()) {
			buffer.add(fixed);
		}
		
		/**
		 * 入れ替え候補文字群から1文字だけ固定文字列に付加し、残りの文字群を入れ替える
		 * 上記の処理を入れ替え候補文字群全てに適用する
		 * 既に列挙済みの文字ならスキップする
		 */
		for (int i = 0; i < candidates.length(); i++) {
			
			char nextChar = candidates.charAt(i);
			if (nextChar == previousChar) {continue;}
			previousChar = nextChar;
			
			enumerateCombinationPart(
					fixed + nextChar,
					candidates.substring(0, i) + candidates.substring(i + 1),
					buffer);
		}
		
	}
	
}
