package Shuffle.shuffle;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
* 文字列を処理するクラス<br>
* 指定された文字列をシャッフルしてできる文字列を重複なく全てリストアップすることを目的とする	<br>
* 例 : 入力がbabの場合 → abb, bab, bba をリストアップ								<br>
* 基本的には、並べ替え関数f(s) s:入力文字列　を以下のように再帰的に定義することで実行する		<br>
* 																				<br>
* f(s) s:入力文字列							<br>
* -sが1文字の場合-								<br>
*   終了										<br>
* -sが2文字以上の場合-							<br>
*   先頭1文字を固定し、残りの文字列を並べ替える	<br>
*      例：s = "abb"の場合					<br>
*      a + f("bb")							<br>
*      b + f("ab")							<br>
*/
public class ControlString {
	
	/** 入力最大文字数 */
	public static final int MAX_INPUT_SIZE = 10;	


	/**
	 * 任意の文字列に対し、その順序を入れ替えることでできる全ての文字列パターンを列挙する<br>
	 * 次のいずれかの場合は空リストが返る<br>
	 * -入力文字列に半角英数字でない文字が含まれるとき<br>
	 * -文字数が規定値を超えるとき<br>
	 * -文字数が0のとき<br>
	 * -引数がnullのとき
	 * @param inputStr 入力文字列
	 * @return 全ての文字列リスト
	 */
	public List<String> shuffleString(String inputStr){
		
		List<String> allShuffledList = new ArrayList<>();
		
		/* 入力文字列が適正でなければ終了 */
		
		if (!isInputRight(inputStr)) {return allShuffledList;}
		System.out.println(Message.TARGET_STR + inputStr);
		
		/* 文字列をシャッフルする */
		
		if (shuffleStringPart("", inputStr, allShuffledList)) {;}
		
		return allShuffledList;
	}
	
	/**
	 * ある文字列の後ろ部分だけシャッフルし、シャッフル結果をリストに追加する
	 * 	例  startStr : abc, targetStr : def　の場合、以下の文字列リストが引数resultに追加される
	 	-abcdef
	 	-abcdfe
	 	-abcfde
	 	-abcfed
	 	-abcedf
	 	-abcefd
	 * @param startStr 先頭文字列（固定）
	 * @param targetStr シャッフル対象文字列
	 * @param result シャッフル結果の文字列リスト
	 * @return 関数の結果(引数がnullのときfalse)
	 */
	private boolean shuffleStringPart(String startStr, String targetStr, List<String> result){
		
		/* 
		 * シャッフル対象文字列が1文字の場合、先頭文字列をつけてリストに追加して終了
		 * 例　startStr : abc, targetStr : x　の場合
		 * -> abcxをリストresultに追加して終了 
		 * */
		
		if (targetStr.length() <= 1) {
			result.add(startStr + targetStr);
			return true;
		}
		
		/* 
		 * シャッフル対象文字列をアスキーコード順に並べ替える 
		 * 例:"cabb1" -> "1abbc"
		 */
		
		char[] topCharList = targetStr.toCharArray();
		Arrays.sort(topCharList);							
		
		/*
		 * シャッフル対象文字列から先頭文字を指定し、残りの文字列をシャッフルする
		 */
		for (int i = 0; i < targetStr.length(); i++) {
			if (0 < i) {
				if (topCharList[0] == topCharList[i]) {continue;}
				else {
					char tmp = topCharList[0];
					topCharList[0] = topCharList[i];
					topCharList[i] = tmp;
				}
			}
			String startStrTmp = startStr + String.valueOf(topCharList[0]);
			String targetStrTmp = String.valueOf(topCharList);
			targetStrTmp = targetStrTmp.substring(1);
			if (!shuffleStringPart(startStrTmp, targetStrTmp, result)) {return false;}
		}
		
		return true;
	}
	
	/**
	 * ユーザの入力文字列が適切か判定
	 * @param[in] inputStr 入力文字列
	 * @return 文字列が適切か
	 */
	private boolean isInputRight(String inputStr) {
		
		/* 入力がnullならエラー */
		
		if (inputStr == null) {
			System.out.println(Message.ERROR_INPUT_NULL);
			return false;
		}
		
		/* 文字数が1以下、または最大値を超えていたらエラー */
		
		if (inputStr.length() < 1) {
			System.out.println(Message.ERROR_INPUT_0);
			return false;
		}
		if (MAX_INPUT_SIZE < inputStr.length()) {
			System.out.println(Message.ERROR_INPUT_SIZE_OVER + MAX_INPUT_SIZE);
			return false;
		}
		
		/* 半角英数字以外の文字が含まれていたらエラー */
		
		if (!(inputStr.matches("[0-9a-zA-Z]+"))) {
			System.out.println(Message.ERROR_INPUT_TYPE);
			return false;
		}
		
		/* それ以外ならエラーでない */
		
		return true;
	}
	
	/**
	 * 標準出力にリストを表示する
	 * @param 文字列リスト
	 * @return 関数の結果（true:正常終了、false:引数がnull）
	 */
	public boolean showList(List<String> list) {
		
		if (list == null) {return false;}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		return true;
	}
	
}

