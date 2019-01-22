package Shuffle.shuffle;

import java.util.Set;
import java.util.HashSet;

/**
* 文字列のパターンを求める機能を提供するクラス
*/
public class CharacterEnumerator {
	
	/**
	 * 任意の文字列に対し、その順序を入れ替えることでできる全ての文字列パターンを列挙する<br>
	 * @param inputStr 入力文字列
	 * @return 全ての文字列パターン
	 */
	public static Set<String> enumerateCombination(final String inputStr){
		
		final Set<String> buffer = new HashSet<String>();
		enumerateCombinationPart("", inputStr, buffer);
		return buffer;
	}
	
	/**
	 * ある文字列の後半部分を入れ替えてできる全ての文字列パターンを列挙する
	 * 例  fixed : abc, candidates : def　の場合、以下の文字列リストが引数resultに追加される
	 	-abcdef
	 	-abcdfe
	 	-abcfde
	 	-abcfed
	 	-abcedf
	 	-abcefd
	 * @param fixed 先頭文字列（固定）
	 * @param candidates 入れ替え候補となる後半の文字群 
	 * @param buffer 全ての文字列パターン
	 */
	private static void enumerateCombinationPart(final String fixed, final String candidates, final Set<String> buffer){
		
		/* 
		 * 入れ替え候補文字群に同一の文字が複数含まれる場合、入れ替え後の文字列パターンに重複が発生するが
		 * Set型に結果を格納することで重複する項目を取り除く
		 * */
		
		if (candidates.isEmpty()) {
			buffer.add(fixed);
		}
		
		/**
		 * 入れ替え候補文字群から1文字だけ固定文字列に付加し、残りの文字群を入れ替える
		 * 上記の処理を入れ替え候補文字群全てに適用する
		 */
		for (int i = 0; i < candidates.length(); i++) {
			enumerateCombinationPart(
					fixed + candidates.charAt(i),
					candidates.substring(0, i) + candidates.substring(i + 1),
					buffer);
		}
		
	}
	
}

